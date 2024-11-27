package com.fiap.SportStock.domain.exception;

import org.springframework.http.HttpStatus;

public class ProdutoNotFoundException extends RuntimeException {

    private static final String DEFAULT_MENSAGEM = "Não existe um produto com este ID";

    public static final int HTTP_STATUS_CODE = HttpStatus.NOT_FOUND.value();

    public ProdutoNotFoundException() {
        super(DEFAULT_MENSAGEM);
    }
}
