package com.fiap.SportStock.domain.service;

import com.fiap.SportStock.domain.model.ProdutoModel;

import java.util.List;
import java.util.Optional;

public interface ProdutoService {

    ProdutoModel cadastrarProduto(ProdutoModel produto);

    List<ProdutoModel> listarProdutos();

    Optional<ProdutoModel> atualizarProduto(String id, ProdutoModel produto);

    boolean excluirProduto(String id);

    Optional<ProdutoModel> buscarProduto(String id);

    Optional<ProdutoModel> detalharProduto(String id);
}