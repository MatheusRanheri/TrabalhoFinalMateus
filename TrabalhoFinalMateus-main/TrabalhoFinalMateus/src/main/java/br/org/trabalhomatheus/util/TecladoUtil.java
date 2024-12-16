package br.org.trabalhomatheus.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TecladoUtil {

public static String lerString(String mensagem){
    try {
        return inicializaTeclado(mensagem).nextLine();
    }catch (InputMismatchException e){
        return null;
    }

}

public static Integer lerInteiro(String mensagem){
    try {
        return inicializaTeclado(mensagem).nextInt();
    }catch (InputMismatchException e){
        return null;
    }

}

private static Scanner inicializaTeclado (String mensagem){
    System.out.println(mensagem);
    return new Scanner(System.in);
}

}
