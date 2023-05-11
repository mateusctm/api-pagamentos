package br.com.tools.apipagamentos.dto;

import lombok.Data;

@Data
public class ErroDTO {
    private String nomeCampo;
    private String mensagem;
}