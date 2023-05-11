package br.com.tools.apipagamentos.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Data;

@Data
public class TransacaoDTO {

    public static final String ID = "id";
    @JsonProperty(ID)
    @Null
    private String id;

    public static final String CARTAO = "cartao";
    @JsonProperty(CARTAO)
    @NotEmpty
    private String cartao;

    public static final String DESCRICAO = "descricao";
    @JsonProperty(DESCRICAO)
    @NotNull
    @Valid
    private DescricaoDTO descricao;

    public static final String FORMA_PAGAMENTO = "formaPagamento";
    @JsonProperty(FORMA_PAGAMENTO)
    @NotNull
    @Valid
    private FormaPagamentoDTO formaPagamento;

}
