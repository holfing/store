package br.com.produtos.produtos.service;

import br.com.produtos.produtos.domain.Produto;
import br.com.produtos.produtos.dto.ProdutoDTO;
import br.com.produtos.produtos.repository.ProdutoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URI;
import java.util.Objects;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    private ModelMapper modelMapper;


    public ProdutoDTO create(String titulo, String descricao, MultipartFile imagem, BigDecimal preco, UriComponentsBuilder uriBuilder) throws IOException {

        String url = buildURL(uriBuilder,titulo,descricao,imagem,preco);

        ProdutoDTO produtoDTO = ProdutoDTO.builder().titulo(titulo).
                descricao(descricao).preco(preco).URL(url).
                descricao(descricao).imagem(imagem.getBytes()).build();

        Produto produto = modelMapper.map(produtoDTO, Produto.class);

        produtoRepository.save(produto);

        return modelMapper.map(produto, ProdutoDTO.class);
    }

    private String buildURL(UriComponentsBuilder uriBuilder, String titulo, String descricao, MultipartFile imagem, BigDecimal preco) {
        String fileName = null;
        if (Objects.nonNull(imagem)) {
           fileName = imagem.getOriginalFilename();
        }
        URI endereco = uriBuilder.path("/pagamentos/{titulo}/{descricao}/"+fileName+"/{preco}").buildAndExpand(titulo, descricao, preco).toUri();
        return endereco.toString();
    }


}
