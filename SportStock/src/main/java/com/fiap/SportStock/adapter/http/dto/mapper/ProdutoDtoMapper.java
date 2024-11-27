package com.fiap.SportStock.adapter.http.dto.mapper;

import com.fiap.SportStock.adapter.http.dto.request.ProdutoPostRequest;
import com.fiap.SportStock.adapter.http.dto.request.ProdutoPutRequest;
import com.fiap.SportStock.domain.model.ProdutoModel;
import org.springframework.stereotype.Component;

@Component
public class ProdutoDtoMapper {


    public ProdutoModel toModel(ProdutoPostRequest request) {
        if (request == null) {
            return null;
        }

        ProdutoModel model = new ProdutoModel();
        model.setNome(request.getNome());
        model.setTipo(request.getTipo());
        model.setClassificacao(request.getClassificacao());
        model.setTamanho(request.getTamanho());
        model.setPreco(request.getPreco());
        return model;
    }


    public void updateModelFromPutRequest(ProdutoPutRequest request, ProdutoModel model) {
        if (request == null || model == null) {
            return;
        }

        if (request.getNome() != null) {
            model.setNome(request.getNome());
        }
        if (request.getTipo() != null) {
            model.setTipo(request.getTipo());
        }
        if (request.getClassificacao() != null) {
            model.setClassificacao(request.getClassificacao());
        }
        if (request.getTamanho() != null) {
            model.setTamanho(request.getTamanho());
        }
        if (request.getPreco() != null) {
            model.setPreco(request.getPreco());
        }
    }


}
