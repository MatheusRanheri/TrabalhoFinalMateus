package br.org.trabalhomatheus.exception;


/**
 * Classe AplicacaoException classe com uma excecao verificada
 * @author Matheus Ranheri
 * @data 03/12/2024
 */
public class AplicacaoException extends Exception{


    /**
     * @param message String
     * Construror que recebe uma mensagem que descreve o erro
     */
    public AplicacaoException (String message){
        super(message);
    }
}