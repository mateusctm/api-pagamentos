package br.com.tools.apipagamentos.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;

@Data
@Embeddable
public class FormaPagamento {
    @Enumerated(EnumType.STRING)
    private TipoPagamento tipo;
    private String parcelas;
}
