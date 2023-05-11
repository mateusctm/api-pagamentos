package br.com.tools.apipagamentos.aop;

import br.com.tools.apipagamentos.dto.ErroDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ErrosControllerAdvice {
    @ExceptionHandler
    public ResponseEntity<List<ErroDTO>> handle(MethodArgumentNotValidException exception){

        List<ErroDTO> erros = new ArrayList<>();

         for (FieldError fieldError : exception.getBindingResult().getFieldErrors()) {
             ErroDTO erroDTO = new ErroDTO();
             erroDTO.setNomeCampo(fieldError.getField());
             erroDTO.setMensagem(fieldError.getDefaultMessage());
             erros.add(erroDTO);
        }
        return ResponseEntity.badRequest().body(erros);

    }

    @ExceptionHandler
    public ResponseEntity<ErroDTO> handle(HttpMessageNotReadableException exception){

             ErroDTO erroDTO = new ErroDTO();
             erroDTO.setMensagem(exception.getMessage());

        return ResponseEntity.badRequest().body(erroDTO);

    }
}
