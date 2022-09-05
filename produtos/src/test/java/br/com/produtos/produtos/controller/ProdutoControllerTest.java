package br.com.produtos.produtos.controller;

import br.com.produtos.produtos.dto.ProdutoDTO;
import br.com.produtos.produtos.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;

@ExtendWith(SpringExtension.class)
@WebMvcTest(ProdutoController.class)
class ProdutoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProdutoService mockProdutoService;

    @Test
    void testCreate() throws Exception {
        final ProdutoDTO produtoDTO = new ProdutoDTO("id", "content".getBytes(), "titulo", "descricao",
                new BigDecimal("0.00"), "URL");
        when(mockProdutoService.create(eq("titulo"), eq("descricao"), any(MultipartFile.class),
                eq(new BigDecimal("0.00")), any(UriComponentsBuilder.class))).thenReturn(produtoDTO);

        final MockHttpServletResponse response = mockMvc.perform(multipart("/produtos")
                        .file(new MockMultipartFile("imagem", "originalFilename", MediaType.APPLICATION_JSON_VALUE,
                                "content".getBytes()))
                        .param("titulo", "titulo")
                        .param("descricao", "descricao")
                        .param("preco", "0")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
    }

}
