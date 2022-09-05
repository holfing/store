package br.com.produtos.produtos.repository;

import br.com.produtos.produtos.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Optional<Produto> findByTitulo(String titulo);
}
