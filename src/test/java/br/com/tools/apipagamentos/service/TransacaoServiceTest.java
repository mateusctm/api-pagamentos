package br.com.tools.apipagamentos.service;

import br.com.tools.apipagamentos.dto.DescricaoDTO;
import br.com.tools.apipagamentos.dto.FormaPagamentoDTO;
import br.com.tools.apipagamentos.dto.TransacaoDTO;
import br.com.tools.apipagamentos.mapper.TransacaoMapper;
import br.com.tools.apipagamentos.model.Descricao;
import br.com.tools.apipagamentos.model.FormaPagamento;
import br.com.tools.apipagamentos.model.StatusTransacao;
import br.com.tools.apipagamentos.model.Transacao;
import br.com.tools.apipagamentos.repository.TransacaoRepository;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TransacaoServiceTest {

    @Mock
    TransacaoRepository transacaoRepository;
    @Mock
    TransacaoMapper transacaoMapper;
    @InjectMocks
    TransacaoService transacaoService;


    @Test
    void criarNovoPagamentoTeste() {
        Transacao transacao = mock(Transacao.class);
        Descricao descricao = mock(Descricao.class);

        TransacaoDTO transacaoDTO = new TransacaoDTO();
        DescricaoDTO descricaoDTO = new DescricaoDTO();
        descricaoDTO.setStatus(StatusTransacao.AUTORIZADO);
        transacaoDTO.setId("");
        transacaoDTO.setCartao("");
        transacaoDTO.setDescricao(descricaoDTO);
        transacaoDTO.setFormaPagamento(new FormaPagamentoDTO());

        doReturn(transacao).when(transacaoMapper).converterParaEntidade(transacaoDTO);
        doReturn(descricao).when(transacao).getDescricao();
        doReturn(transacaoDTO).when(transacaoMapper).converterParaDTO(transacao);

        TransacaoDTO transacaoDTO1 = transacaoService.criarNovoPagamento(transacaoDTO);


        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(transacaoDTO1).isNotNull().hasFieldOrProperty("descricao");
        softAssertions.assertThat(transacaoDTO1.getDescricao().getStatus()).isEqualTo(StatusTransacao.AUTORIZADO.toString());
    }


    @Test
    void estornarPagamentoTeste() {

        Transacao transacao = mock(Transacao.class);
        Descricao descricao = mock(Descricao.class);

        TransacaoDTO transacaoDTO = new TransacaoDTO();
        DescricaoDTO descricaoDTO = new DescricaoDTO();
        descricaoDTO.setStatus(StatusTransacao.NEGADO);
        transacaoDTO.setId("");
        transacaoDTO.setCartao("");
        transacaoDTO.setDescricao(descricaoDTO);
        transacaoDTO.setFormaPagamento(new FormaPagamentoDTO());

        transacao.setId("");
        transacao.setCartao("");
        transacao.setDescricao(descricao);
        transacao.setFormaPagamento(new FormaPagamento());

        Mockito.when(transacaoRepository.findById("")).thenReturn(Optional.of(transacao));
        doReturn(descricao).when(transacao).getDescricao();
        doReturn(transacaoDTO).when(transacaoMapper).converterParaDTO(transacao);

        TransacaoDTO transacaoDTO1 = transacaoService.estornarPagamento(anyString());

        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(transacaoDTO1).isNotNull().hasFieldOrProperty("descricao");
        softAssertions.assertThat(transacaoDTO1.getDescricao().getStatus()).isEqualTo(StatusTransacao.NEGADO.toString());

    }

}