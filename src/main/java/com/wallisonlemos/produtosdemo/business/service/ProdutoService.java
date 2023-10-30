package com.wallisonlemos.produtosdemo.business.service;

import com.wallisonlemos.produtosdemo.apiv1.dto.ProdutoDTO;
import com.wallisonlemos.produtosdemo.business.converter.ProdutoConverter;
import com.wallisonlemos.produtosdemo.infrastructure.entities.Produto;
import com.wallisonlemos.produtosdemo.infrastructure.repositories.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;
    private final ProdutoConverter converter;

    public Produto salvarProduto(Produto produto) {
        try {
            return repository.save(produto);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar produto " + e);
        }
    }

    public ProdutoDTO salvarProdutoDTO(ProdutoDTO dto) {
        try {
            Produto produto = converter.toEntity(dto);
            return converter.toDTO(repository.save(produto));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar produto " + e);
        }
    }

    public Boolean existsPorNome(String nome) {
        try {
            return repository.existsByNome(nome);
        } catch (Exception e) {
            throw new RuntimeException(String.format("Erro ao buscar produto %s ", nome) + e);
        }
    }

    public ProdutoDTO buscarPorNome(String nome) {
        try {
            return converter.toDTO(repository.findByNome(nome));
        } catch (Exception e) {
            throw new RuntimeException(String.format("Erro ao buscar produto %s ", nome) + e);
        }
    }

    public List<ProdutoDTO> buscarTodosProdutos() {
        try {
            return converter.toListDTO(repository.findAll());
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar produtos" + e);
        }
    }

    public void deletarPorId(Long id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deletar produto %s " + e);
        }
    }

    public ProdutoDTO editarProduto(Long id, ProdutoDTO dto) {
        try {
            Produto produto = repository.findById(id).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
            salvarProduto(converter.toEntityUpdate(produto, dto, id));
            return converter.toDTO(repository.findByNome(produto.getNome()));
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar produto " + e);
        }
    }
}
