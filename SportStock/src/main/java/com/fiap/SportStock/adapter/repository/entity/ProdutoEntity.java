package com.fiap.SportStock.adapter.repository.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "TDS_TB_Produtos")
@Data
public class ProdutoEntity{

    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private String id;

    @Column(name = "nome", nullable = false)
    private String nome;
    @Column(name = "tipo", nullable = false)
    private String tipo;
    @Column(name = "classificacao", nullable = false)
    private String classificacao;
    @Column(name = "tamanho", nullable = false)
    private String tamanho;
    @Column(name = "preco", nullable = false)
    private BigDecimal preco;

}
