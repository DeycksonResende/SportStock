package com.fiap.SportStock.adapter.repository.mapper;

import com.fiap.SportStock.adapter.repository.entity.ProdutoEntity;
import com.fiap.SportStock.domain.model.ProdutoModel;
import org.springframework.stereotype.Component;

@Component
public class ProdutoEntityMapper {

    public ProdutoModel toModel(ProdutoEntity entity) {
        if (entity == null) {
            return null;
        }

        ProdutoModel model = new ProdutoModel();
        model.setId(entity.getId());
        model.setNome(entity.getNome());
        model.setTipo(entity.getTipo());
        model.setClassificacao(entity.getClassificacao());
        model.setTamanho(entity.getTamanho());
        model.setPreco(entity.getPreco());
        return model;
    }

    public ProdutoEntity toEntity(ProdutoModel model) {
        if (model == null) {
            return null;
        }

        ProdutoEntity entity = new ProdutoEntity();
        entity.setId(model.getId());
        entity.setNome(model.getNome());
        entity.setTipo(model.getTipo());
        entity.setClassificacao(model.getClassificacao());
        entity.setTamanho(model.getTamanho());
        entity.setPreco(model.getPreco());
        return entity;
    }
}
