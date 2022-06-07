package com.defi.tp_vente.controlleur;

import com.defi.tp_vente.model.Approvisionnement;
import com.defi.tp_vente.service.ApprovisionnementService;
import com.defi.tp_vente.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
public class ApprovisionnementController {
    @Autowired
    private ArticleService articleService;
    @Autowired
    private ApprovisionnementService approvisionnementService;

    @GetMapping("/approshow")
    public String showAllAppro(Model model){
        model.addAttribute("Liste_Appro",approvisionnementService.showAllAppro());
        return "Arsha/ListAppro";
    }
    @GetMapping("/approForm")
    public String showForm(Model model){
        model.addAttribute("listeArticles",articleService.showAllArticles());
        return "Arsha/FormAppro";
    }
    @PostMapping("/Appro/Save")
    public String saveAppro(Approvisionnement approvisionnement){
        approvisionnement.setQteAppro(approvisionnement.getQteAppro());
        approvisionnement.setDateAppro(LocalDate.now());
        approvisionnementService.saveAppro(approvisionnement);
        articleService.updateStockArticle(approvisionnement.getQteAppro(),approvisionnement.getArticle_id());
        return "redirect:/approshow";
    }
    
    @GetMapping("/approedite{id}")
    public String formEditer(@PathVariable ("id") int id, Model model){
        model.addAttribute("un_Appro", approvisionnementService.showOneAppro(id));
        model.addAttribute("listeArticles",articleService.showAllArticles());
        return "Arsha/FromEditAppro";
    }
    @PostMapping("/Appro/update")
    public String updateAppro(@ModelAttribute("Appro") Approvisionnement approvisionnement){
        approvisionnementService.saveAppro(approvisionnement);
        return "redirect:/approshow";
    }
    @GetMapping("/approdel{id}")
    public String deleteAppro(@PathVariable("id") int id ){
        approvisionnementService.deleteAppro(id);
        return "redirect:/approshow";
    }
}
