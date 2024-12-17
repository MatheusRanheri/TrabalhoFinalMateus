package br.org.trabalhomatheus.util;

import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * Classe TecladoUtil que funciona para leitura de Strings e inteiros
 * @author Matheus Ranheri
 * @data 03/12/2024
 */
public class TecladoUtil {


    /**
     * @param mensagem String
     * try catch = Se for inserido algo que nao eh string retorna null
     * @return retorna a mensagem feita pelo usuario
     */
public static String lerString(String mensagem){
    try {
        return inicializaTeclado(mensagem).nextLine();
    }catch (InputMismatchException e){
        return null;
    }

}


    /**
     * @param mensagem String
     * try catch = Se for inserido algo que nao eh numero inteiro retorna null
     * @return retorna um inteiro que foi fornecido pelo usuario
     */
public static Integer lerInteiro(String mensagem){
    try {
        return inicializaTeclado(mensagem).nextInt();
    }catch (InputMismatchException e){
        return 0;
    }

}


    /**
     * @param mensagem String
     * @return retorna um objeto da classe scanner
     */
    private static Scanner inicializaTeclado (String mensagem){
    System.out.println(mensagem);
    return new Scanner(System.in);
}

}
