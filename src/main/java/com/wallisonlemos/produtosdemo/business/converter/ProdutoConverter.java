package com.wallisonlemos.produtosdemo.business.converter;


import com.wallisonlemos.produtosdemo.apiv1.dto.ProdutoDTO;
import com.wallisonlemos.produtosdemo.infrastructure.entities.Produto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProdutoConverter {

    public Produto toEntity(ProdutoDTO dto) {
        return Produto.builder()
                .nome(dto.getNome())
                .categoria(dto.getCategoria())
                .descricao(dto.getDescricao())
                .preco(dto.getPreco())
                .imagem(dto.getImagem())
                .build();
    }

    public Produto toEntityUpdate(Produto produto, ProdutoDTO dto, Long id) {
        return Produto.builder()
                .id(id)
                .nome(dto.getNome() != null ? dto.getNome() : produto.getNome())
                .categoria(dto.getCategoria() != null ? dto.getCategoria() : produto.getCategoria())
                .descricao(dto.getDescricao() != null ? dto.getDescricao() : produto.getDescricao())
                .preco(dto.getPreco() != null ? dto.getPreco() : produto.getPreco())
                .imagem(dto.getImagem() != null ? dto.getImagem() : produto.getImagem())
                .createdAt(produto.getCreatedAt())
                .build();
    }

    public ProdutoDTO toDTO(Produto produto) {
        return ProdutoDTO.builder()
                .id(produto.getId())
                .nome(produto.getNome())
                .categoria(produto.getCategoria())
                .descricao(produto.getDescricao())
                .preco(produto.getPreco())
                .imagem(produto.getImagem())
                .build();
    }

    public List<ProdutoDTO> toListDTO(List<Produto> produtos) {
        return produtos
                .stream()
                .map(this::toDTO)
                .toList();
    }
}
