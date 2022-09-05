package br.com.produtos.produtos.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {

    private String id;

    private byte [] imagem;

    private String titulo;

    private String descricao;

    private BigDecimal preco;

    private String URL;
}
