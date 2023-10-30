package com.wallisonlemos.produtosdemo.infrastructure.client;

import com.wallisonlemos.produtosdemo.apiv1.dto.ProdutoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "fake-api", url = "${fake-api.url:#{null}}")
public interface ApiClient {

    @GetMapping("/products")
    List<ProdutoDTO> buscarProdutos();
}
