package br.unesc.topicos.grc.exceptions;

public class SistemaException extends Exception {

    public SistemaException() {
        super("Erro ao realizar venda");
    }

    public SistemaException(String msg) {
        super(msg);
    }
}
