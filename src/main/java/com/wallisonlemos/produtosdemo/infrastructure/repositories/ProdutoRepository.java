package com.wallisonlemos.produtosdemo.infrastructure.repositories;

import com.wallisonlemos.produtosdemo.infrastructure.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Boolean existsByNome(String nome);

    Produto findByNome(String nome);
}
