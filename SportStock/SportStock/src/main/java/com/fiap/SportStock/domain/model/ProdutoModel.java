package com.fiap.SportStock.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoModel {

    private String id;
    private String nome;
    private String tipo;
    private String classificacao;
    private String tamanho;
    private BigDecimal preco;
}
