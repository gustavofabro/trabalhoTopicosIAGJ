package br.unesc.topicos.grc.exceptions;

public class SistemaException extends Exception {

    public SistemaException() {
        super("Erro interno no sistema!");
    }

    public SistemaException(String msg) {
        super(msg);
    }
}
