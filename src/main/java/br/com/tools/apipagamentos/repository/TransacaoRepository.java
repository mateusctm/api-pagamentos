package br.com.tools.apipagamentos.repository;

import br.com.tools.apipagamentos.model.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, String> {
}
