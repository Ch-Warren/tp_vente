package com.defi.tp_vente.service;

import com.defi.tp_vente.model.Approvisionnement;
import com.defi.tp_vente.repository.ApprovisionnementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprovisionnementService {
    @Autowired
    private ApprovisionnementRepository approvisionnementRepository;

    public void saveAppro(Approvisionnement approvisionnement){
        approvisionnementRepository.save(approvisionnement);
    }

    public List<Approvisionnement> showAllAppro(){ return approvisionnementRepository.findAll();}

    public Approvisionnement showOneAppro(int id){
        return approvisionnementRepository.findById(id).get();
    }

    public void deleteAppro(int id){ approvisionnementRepository.deleteById(id);}
}
