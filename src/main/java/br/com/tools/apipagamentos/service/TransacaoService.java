package br.com.tools.apipagamentos.service;

import br.com.tools.apipagamentos.dto.TransacaoDTO;
import br.com.tools.apipagamentos.mapper.TransacaoMapper;
import br.com.tools.apipagamentos.model.StatusTransacao;
import br.com.tools.apipagamentos.model.Transacao;
import br.com.tools.apipagamentos.repository.TransacaoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

    public List<TransacaoDTO> getTodasTransacoes() {
        List<Transacao> transacoes = transacaoRepository.findAll();
        return transacaoMapper.converterParaListaDTO(transacoes);

    }

    public TransacaoDTO getTransacao(String id) {
        Optional<Transacao> optionalTransacao = transacaoRepository.findById(id);
        if (optionalTransacao.isPresent())
            return transacaoMapper.converterParaDTO(optionalTransacao.get());

        return null;
    }

    public TransacaoDTO estornarPagamento(String id) {
        Optional<Transacao> optionalTransacao = transacaoRepository.findById(id);
        if (optionalTransacao.isPresent()) {
            Transacao transacao = optionalTransacao.get();
            transacao.getDescricao().setStatus(StatusTransacao.NEGADO);

            transacaoRepository.save(transacao);
            return transacaoMapper.converterParaDTO(transacao);
        }

        return null;
    }
}
