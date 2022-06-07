package com.defi.tp_vente.controlleur;

import com.defi.tp_vente.model.Vente;
import com.defi.tp_vente.service.ArticleService;
import com.defi.tp_vente.service.VenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class VenteController {
    @Autowired
    private VenteService venteService;
    @Autowired
    private ArticleService articleService;
    @GetMapping("/venteshow")
    public String showAllVente(Model model){
        model.addAttribute("listeVente", venteService.showAllVente());
        return "Arsha/ListVente";
    }
    @GetMapping("/venteForm")
    public String showFormVente(Model model){
        model.addAttribute("listeArticles",articleService.showAllArticles());
        return "Arsha/FormVente";
    }
    @PostMapping("/vente/save")
    public String saveVente(Vente vente){
        vente.setQteVente(vente.getQteVente());
        vente.setDateVente(LocalDate.now());
        venteService.saveVente(vente);
        return "redirect:/venteshow";
    }
    @GetMapping("/venteedite{id}")
    public String formEditer(@PathVariable("id")int id, Model model){
        model.addAttribute("une_Vente",venteService.showOneVente(id));
        model.addAttribute("listeArticles",articleService.showAllArticles());
        return "Arsha/FormEditVente";
    }
    @PostMapping("/vente/update")
    public String updateVente(@ModelAttribute("vente")Vente vente){
        venteService.saveVente(vente);
        return "redirect:/venteshow";
    }
    @GetMapping("/ventedel{id}")
    public  String deleteArticle(@PathVariable("id") int id){
        venteService.deleteVente(id);
        return "redirect:/venteshow";
    }
}
