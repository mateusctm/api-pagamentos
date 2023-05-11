package br.com.tools.apipagamentos.dto;

import br.com.tools.apipagamentos.model.StatusTransacao;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Null;
import lombok.Data;

@Data
public class DescricaoDTO {

    public static final String VALOR = "valor";
    @JsonProperty(VALOR)
    @NotEmpty
    private String valor;

    public static final String DATA_HORA = "dataHora";
    @JsonProperty(DATA_HORA)
    @NotEmpty
    private String dataHora;

    public static final String ESTABELECIMENTO = "estabelecimento";
    @JsonProperty(ESTABELECIMENTO)
    @NotEmpty
    private String estabelecimento;

    public static final String NSU = "nsu";
    @JsonProperty(NSU)
    @Null
    private String nsu;

    public static final String CODIGO_AUTORIZACAO = "codigoAutorizacao";
    @JsonProperty(CODIGO_AUTORIZACAO)
    @Null
    private String codigoAutorizacao;

    public static final String STATUS = "status";
    @JsonProperty(STATUS)
    @Null
    private StatusTransacao status;

}
