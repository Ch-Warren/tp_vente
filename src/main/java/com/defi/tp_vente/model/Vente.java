package com.defi.tp_vente.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private LocalDate dateVente;
    private int qteVente;
    @ManyToOne
    @JoinColumn(name = "article_id", insertable = false, updatable = false)
    private Article article;
    private int article_id;
}
