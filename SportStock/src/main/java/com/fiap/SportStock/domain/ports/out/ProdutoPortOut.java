package com.fiap.SportStock.domain.ports.out;

import com.fiap.SportStock.adapter.repository.entity.ProdutoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoPortOut  extends JpaRepository<ProdutoEntity, String> {

}
