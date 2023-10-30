package com.wallisonlemos.produtosdemo.apiv1.dto;

import com.wallisonlemos.produtosdemo.business.service.ApiService;
import com.wallisonlemos.produtosdemo.business.service.ProdutoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
@RequiredArgsConstructor
@Tag(name = "produtos-api")
public class ApiController {

    private final ApiService service;
    private final ProdutoService produtoService;

    @Operation(summary = "Busca produtos na API externa e salva novos produtos", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao realizar busca de produtos")
    })
    @PostMapping("/api")
    public ResponseEntity<List<ProdutoDTO>> salvarProdutosApi() {
        return ResponseEntity.ok(service.buscarProdutos());
    }

    @Operation(summary = "Salva novo produto", method = "POST")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto salvo com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao salvar o produto")
    })
    @PostMapping("/")
    public ResponseEntity<ProdutoDTO> salvarProduto(@RequestBody ProdutoDTO dto) {
        return ResponseEntity.ok(produtoService.salvarProdutoDTO(dto));
    }

    @Operation(summary = "Edita um produto", method = "PUT")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto editado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao editar o produto")
    })
    @PutMapping("/")
    public ResponseEntity<ProdutoDTO> editarProduto(@RequestParam ("id") Long id, @RequestBody ProdutoDTO dto) {
        return ResponseEntity.ok(produtoService.editarProduto(id, dto));
    }

    @Operation(summary = "Deleta um produto", method = "DELETE")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Produto deletado com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao deletar o produto")
    })
    @DeleteMapping("/")
    public ResponseEntity<Void> deletarProduto(@RequestParam ("id") Long id) {
        produtoService.deletarPorId(id);
        return ResponseEntity.accepted().build();
    }

    @Operation(summary = "Busca todos os produtos", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao buscar produtos")
    })
    @GetMapping("/")
    public ResponseEntity<List<ProdutoDTO>> buscarTodosProdutos() {
        return ResponseEntity.ok(produtoService.buscarTodosProdutos());
    }

    @Operation(summary = "Busca produto por nome", method = "GET")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Busca realizada com sucesso"),
            @ApiResponse(responseCode = "500", description = "Erro ao buscar produto")
    })
    @GetMapping("/{nome}")
    public ResponseEntity<ProdutoDTO> buscarProdutoPorNome(@PathVariable ("nome") String nome) {
        return ResponseEntity.ok(produtoService.buscarPorNome(nome));
    }
}
