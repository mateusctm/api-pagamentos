package br.com.tools.apipagamentos.mapper;

import br.com.tools.apipagamentos.dto.TransacaoDTO;
import br.com.tools.apipagamentos.model.Transacao;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransacaoMapper {
    Transacao converterParaEntidade(TransacaoDTO transacaoDTO);
    TransacaoDTO converterParaDTO(Transacao transacao);


    List<TransacaoDTO> converterParaListaDTO(List<Transacao> transacoes);
}
