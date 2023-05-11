package br.com.tools.apipagamentos.dto;

import br.com.tools.apipagamentos.model.TipoPagamento;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class FormaPagamentoDTO {

    public static final String TIPO = "tipo";
    @JsonProperty(TIPO)
    @NotNull
    private TipoPagamento tipo;

    public static final String PARCELAS = "parcelas";
    @JsonProperty(PARCELAS)
    @NotEmpty
    private String parcelas;

}
