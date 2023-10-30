package com.wallisonlemos.produtosdemo.business.service;

import com.wallisonlemos.produtosdemo.apiv1.dto.ProdutoDTO;
import com.wallisonlemos.produtosdemo.business.converter.ProdutoConverter;
import com.wallisonlemos.produtosdemo.infrastructure.client.ApiClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApiService {

    private final ApiClient cliente;
    private final ProdutoConverter converter;
    private final ProdutoService service;

    public List<ProdutoDTO> buscarProdutos() {
        try {
            List<ProdutoDTO> dtos = cliente.buscarProdutos();
            dtos.forEach(produto -> {
                if(!service.existsPorNome(produto.getNome())) {
                    service.salvarProduto(converter.toEntity(produto));
                }
            });
            return service.buscarTodosProdutos();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar e salvar produtos no banco de dados");
        }
    }
}
