package br.org.trabalhomatheus.view;

import br.org.trabalhomatheus.exception.AplicacaoException;
import br.org.trabalhomatheus.util.TecladoUtil;

public class Sistema {

    private static boolean sair = false;

    public static void main(String[] args) {

    while(!sair) {
        menu();
        int opcao = TecladoUtil.lerInteiro("Informe uma opcao");
        executaAcao(opcao);
      }
    }

private static void executaAcao(int opcao){
try{
    switch (opcao){
        case 1:
            //cadastrarVoto();
            break;
        case 2:
            //inserirFuncionarios();
            break;
        case 3:
            //listarFuncionarios();
            break;
        case 4:
            //inserirRestaurantes();
            break;
        case 5:
            //listarRestaurantes();
            break;
        case 6:
            //apurarVocacoDoDia();
            break;
        case 7:
            sair = true;
            break;
        default:
            System.out.println("Opcao Invalida!!!");
            break;
    }
}catch(AplicacaoException e){
    System.out.println(e.getMessage());
}
}

        private static void menu() {
            System.out.println("---------------------------");
            System.out.println("[1] - Cadastrar voto       ");
            System.out.println("[2] - Inserir funcionario  ");
            System.out.println("[3] - Listar funcionarios  ");
            System.out.println("[4] - Inserir restaurantes ");
            System.out.println("[5] - Listar restaurantes  ");
            System.out.println("[6] - Apurar votacao do dia");
            System.out.println("---------------------------");
        }

}