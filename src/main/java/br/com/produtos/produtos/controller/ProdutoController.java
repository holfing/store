package br.com.produtos.produtos.controller;

import br.com.produtos.produtos.dto.ProdutoDTO;
import br.com.produtos.produtos.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;


@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;


    @PostMapping
    public ResponseEntity<ProdutoDTO> create(String titulo,String descricao,
                                   MultipartFile imagem, BigDecimal preco,
                                    UriComponentsBuilder uriBuilder) throws IOException {
        ProdutoDTO produto = produtoService.create(titulo,descricao,imagem,preco,uriBuilder);
        return ResponseEntity.ok().body(produto);
    }
}
