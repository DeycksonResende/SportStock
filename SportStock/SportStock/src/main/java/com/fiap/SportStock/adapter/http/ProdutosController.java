package com.fiap.SportStock.adapter.http;

import com.fasterxml.jackson.annotation.JsonView;
import com.fiap.SportStock.adapter.http.dto.mapper.ProdutoDtoMapper;
import com.fiap.SportStock.adapter.http.dto.request.ProdutoPostRequest;
import com.fiap.SportStock.adapter.http.dto.request.ProdutoPutRequest;
import com.fiap.SportStock.domain.model.ProdutoModel;
import com.fiap.SportStock.domain.service.ProdutoServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {

    @Autowired
    private ProdutoServiceImpl produtoService;

    @Autowired
    private ProdutoDtoMapper produtoDtoMapper;

    @PostMapping
    public ResponseEntity<ProdutoModel> cadastrarProduto(@RequestBody @Valid ProdutoPostRequest request) {
        ProdutoModel produtoModel = produtoDtoMapper.toModel(request);
        ProdutoModel produtoCadastrado = produtoService.cadastrarProduto(produtoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(produtoCadastrado);
    }

    @GetMapping("/listar")
    public ResponseEntity<CollectionModel<EntityModel<ProdutoModel>>> listarProdutos() {
        List<ProdutoModel> produtos = produtoService.listarProdutos();

        List<EntityModel<ProdutoModel>> produtoModels = produtos.stream()
                .map(produtoModel -> EntityModel.of(produtoModel,
                        linkTo(methodOn(ProdutosController.class).listarProdutos()).withSelfRel()))
                .collect(Collectors.toList());

        CollectionModel<EntityModel<ProdutoModel>> response = CollectionModel.of(
                produtoModels,
                linkTo(methodOn(ProdutosController.class).listarProdutos()).withSelfRel()
        );

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/detalhes")
    public ResponseEntity<ProdutoModel> detalharProduto(@PathVariable String id) {
        ProdutoModel produto = produtoService.detalharProduto(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        return ResponseEntity.ok(produto);
    }

    @PutMapping("/{id}/atualizar")
    public ResponseEntity<ProdutoModel> atualizarProduto(
            @PathVariable String id,
            @RequestBody @Valid ProdutoPutRequest request) {
        ProdutoModel produtoExistente = produtoService.buscarProduto(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        produtoDtoMapper.updateModelFromPutRequest(request, produtoExistente);

        ProdutoModel produtoAtualizado = produtoService.atualizarProduto(id, produtoExistente)
                .orElseThrow(() -> new RuntimeException("Erro ao atualizar o produto"));

        return ResponseEntity.ok(produtoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirProduto(@PathVariable String id) {
        boolean removido = produtoService.excluirProduto(id);
        if (!removido) {
            throw new RuntimeException("Produto não encontrado");
        }
        return ResponseEntity.noContent().build();
    }
}
