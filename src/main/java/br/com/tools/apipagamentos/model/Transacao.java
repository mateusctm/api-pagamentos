package br.com.tools.apipagamentos.model;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
public class Transacao {
    @Id
    private String id;
    private String cartao;
    @Embedded
    private Descricao descricao;
    @Embedded
    private FormaPagamento formaPagamento;
}
