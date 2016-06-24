/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unesc.topicos.grc.exceptions;

/**
 *
 * @author gustavo
 */
public class ReferenciaInvalidaException extends Exception {

    public ReferenciaInvalidaException() {
        super("Erro ao realizar venda");
    }

    public ReferenciaInvalidaException(String msg) {
        super(msg);
    }
}
