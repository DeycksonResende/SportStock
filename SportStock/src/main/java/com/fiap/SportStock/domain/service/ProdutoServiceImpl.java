package com.fiap.SportStock.domain.service;

import com.fiap.SportStock.adapter.repository.mapper.ProdutoEntityMapper;
import com.fiap.SportStock.domain.exception.ProdutoNotFoundException;
import com.fiap.SportStock.domain.model.ProdutoModel;
import com.fiap.SportStock.domain.ports.out.ProdutoPortOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    private ProdutoEntityMapper produtoEntityMapper;

    @Autowired
    private ProdutoPortOut produtoPortOut;


    public ProdutoModel cadastrarProduto(ProdutoModel produto) {
        var produtoEntity = produtoEntityMapper.toEntity(produto);
        var savedEntity = produtoPortOut.save(produtoEntity);
        return produtoEntityMapper.toModel(savedEntity);
    }

    public List<ProdutoModel> listarProdutos() {
        return produtoPortOut.findAll().stream()
                .map(produtoEntityMapper::toModel)
                .collect(Collectors.toList());
    }

    public Optional<ProdutoModel> atualizarProduto(String id, ProdutoModel produto) {
        return produtoPortOut.findById(id)
                .map(existingEntity -> {
                    var updatedEntity = produtoEntityMapper.toEntity(produto);
                    var savedEntity = produtoPortOut.save(updatedEntity);
                    return produtoEntityMapper.toModel(savedEntity);
                });
    }

    public boolean excluirProduto(String id) {
        if (produtoPortOut.existsById(id)) {
            produtoPortOut.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<ProdutoModel> buscarProduto(String id) {
        return Optional.of(
                produtoPortOut.findById(id)
                        .map(produtoEntityMapper::toModel)
                        .orElseThrow(ProdutoNotFoundException::new)
        );
    }

    public Optional<ProdutoModel> detalharProduto(String id) {
        return Optional.of(
                produtoPortOut.findById(id)
                        .map(produtoEntityMapper::toModel)
                        .orElseThrow(ProdutoNotFoundException::new)
        );
    }
}
