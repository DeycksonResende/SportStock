package com.fiap.SportStock.adapter.http.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProdutoDetailResponse {

    @JsonProperty("id")
    private String id;

    @JsonProperty("nome")
    private String nome;

    @JsonProperty("tipo")
    private String tipo;

    @JsonProperty("classificacao")
    private String classificacao;

    @JsonProperty("tamanho")
    private String tamanho;

    @JsonProperty("preco")
    private BigDecimal preco;

}
