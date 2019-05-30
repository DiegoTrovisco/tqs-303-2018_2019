package com.tqs303.clouddeliveries.repository;

import com.tqs303.clouddeliveries.entities.Produto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface ProdutoRepo extends CrudRepository<Produto, Long> {
    List<Produto> findAllByTipo(String tipo);
    Produto findByTipoAndQuantidade(String tipo, int quantidade);
    List<Produto> findAllByTipoAndQuantidade(String tipo, int quantidade);
}
