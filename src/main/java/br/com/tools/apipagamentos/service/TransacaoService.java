package br.com.tools.apipagamentos.service;

import br.com.tools.apipagamentos.dto.TransacaoDTO;
import br.com.tools.apipagamentos.mapper.TransacaoMapper;
import br.com.tools.apipagamentos.model.StatusTransacao;
import br.com.tools.apipagamentos.model.Transacao;
import br.com.tools.apipagamentos.repository.TransacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
@RequiredArgsConstructor
@Service
public class TransacaoService {

    private final TransacaoRepository transacaoRepository;
    private final TransacaoMapper transacaoMapper;

    public TransacaoDTO criarNovoPagamento(TransacaoDTO transacaoDTO) {
        Transacao transacao = transacaoMapper.converterParaEntidade(transacaoDTO);

        transacao.setId(UUID.randomUUID().toString());
        transacao.getDescricao().setNsu(UUID.randomUUID().toString());
        transacao.getDescricao().setCodigoAutorizacao(UUID.randomUUID().toString());
        transacao.getDescricao().setStatus(StatusTransacao.AUTORIZADO);

        transacaoRepository.save(transacao);

        return transacaoMapper.converterParaDTO(transacao);
    }
}
