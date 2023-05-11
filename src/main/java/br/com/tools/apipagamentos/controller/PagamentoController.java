package br.com.tools.apipagamentos.controller;

import br.com.tools.apipagamentos.dto.TransacaoDTO;
import br.com.tools.apipagamentos.service.TransacaoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {


    private final TransacaoService transacaoService;

    @PostMapping
    public ResponseEntity<TransacaoDTO> criarNovoPagamento(@RequestBody @Valid TransacaoDTO transacaoDTO) {

        TransacaoDTO transacaoDTO1 = transacaoService.criarNovoPagamento(transacaoDTO);
        if(transacaoDTO1 == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.status(HttpStatus.CREATED).body(transacaoDTO1);
    }

}
