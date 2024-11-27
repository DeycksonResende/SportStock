package com.fiap.SportStock.adapter.http.dto.request;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ProdutoPutRequest {

    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 100, message = "O nome não pode ter mais que 100 caracteres")
    private String nome;

    @NotBlank(message = "O tipo é obrigatório")
    @Size(max = 50, message = "O tipo não pode ter mais que 50 caracteres")
    private String tipo;

    @NotBlank(message = "A classificação é obrigatória")
    @Size(max = 50, message = "A classificação não pode ter mais que 50 caracteres")
    private String classificacao;

    @NotBlank(message = "O tamanho é obrigatório")
    @Size(max = 10, message = "O tamanho não pode ter mais que 10 caracteres")
    private String tamanho;

    @DecimalMin(value = "0.0", inclusive = false, message = "O preço deve ser maior que zero")
    @DecimalMax(value = "999999.99", message = "O preço não pode ser maior que 999999.99")
    private BigDecimal preco;
}
