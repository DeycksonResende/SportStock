package com.fiap.SportStock.adapter.http.exception;

import com.fiap.SportStock.adapter.http.dto.erros.ResponseErrors;
import com.fiap.SportStock.domain.exception.ProdutoNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class HttpExceptionHandler {

        @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<Object> tratarErrosDeValidacaoFisica(MethodArgumentNotValidException exception){

            List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();

            List<ResponseErrors> listaDeErro = new ArrayList<>();

            for (FieldError fieldError : fieldErrors){

                String campo = fieldError.getField();
                String mensagemDeErro = fieldError.getDefaultMessage();

                ResponseErrors responseErro = new ResponseErrors();
                responseErro.setCampo(campo);
                responseErro.setMensagem(mensagemDeErro);

                listaDeErro.add(responseErro);

            }

            return ResponseEntity.badRequest().body(listaDeErro);
        }

    @ExceptionHandler(ProdutoNotFoundException.class)
    public ResponseEntity<Object> tratarProdutoNotFoundException(ProdutoNotFoundException produtoNotFoundException) {
        ResponseErrors responseErro = new ResponseErrors();
        responseErro.setMensagem(produtoNotFoundException.getMessage());
        return ResponseEntity.status(produtoNotFoundException.HTTP_STATUS_CODE).body(responseErro);
    }
}