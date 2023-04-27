package br.com.sisnema.musica.controllers.exceptions;

import br.com.sisnema.musica.services.exceptions.IntegridadeBD;
import br.com.sisnema.musica.services.exceptions.RecursoNaoEncontrado;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@ControllerAdvice
public class ManipuladorDeExcecoes {

    @ExceptionHandler(RecursoNaoEncontrado.class)
    public ResponseEntity<ErroPadrao> entidadeNaoEncontrada(RecursoNaoEncontrado e, HttpServletRequest r) {
        HttpStatus status = HttpStatus.NOT_FOUND; // 404
        ErroPadrao erro = new ErroPadrao();
        erro.setTimestamp(Instant.now());
        erro.setStatus(status.value()); // 404
        erro.setErro("ERRO! ID NÃO EXISTENTE - 404.");
        erro.setMessage(e.getMessage());
        erro.setPath(r.getRequestURI());
        return ResponseEntity.status(status).body(erro);
    }

    @ExceptionHandler(IntegridadeBD.class)
    public ResponseEntity<ErroPadrao> integridadeBD(IntegridadeBD e, HttpServletRequest r) {
        HttpStatus status = HttpStatus.BAD_REQUEST; // 400
        ErroPadrao erro = new ErroPadrao();
        erro.setTimestamp(Instant.now());
        erro.setStatus(status.value()); //
        erro.setErro("ERRO! VIOLAÇÂO DE INTEGRIDADE.");
        erro.setMessage(e.getMessage());
        erro.setPath(r.getRequestURI());
        return ResponseEntity.status(status).body(erro);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroDeValidacao> validacao(MethodArgumentNotValidException e, HttpServletRequest r) {
        HttpStatus status = HttpStatus.UNPROCESSABLE_ENTITY; // 422
        ErroDeValidacao err = new ErroDeValidacao();
        err.setTimestamp(Instant.now());
        err.setStatus(status.value());
        err.setErro("Beans validation - Exceção de validação");
        err.setMessage(e.getMessage());
        err.setPath(r.getRequestURI());

        for (FieldError f : e.getBindingResult().getFieldErrors()) {
            err.addErro(f.getField(), f.getDefaultMessage());
        }

        return ResponseEntity.status(status).body(err);
    }
}
