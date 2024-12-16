package br.org.trabalhomatheus.view;

import br.org.trabalhomatheus.controller.SistemaController;
import br.org.trabalhomatheus.exception.AplicacaoException;
import br.org.trabalhomatheus.util.TecladoUtil;

import java.util.Calendar;

public class Sistema {

    private static boolean sair = false;
    private static SistemaController controller = new SistemaController();

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
            votar();
            break;
        case 2:
            inserirFuncionario();
            break;
        case 3:
            listarFuncionario();
            break;
        case 4:
            inserirRestaurante();
            break;
        case 5:
            listarRestaurante();
            break;
        case 6:
            removerFuncionario();
            break;
        case 7:
            removerRestaurante();
            break;
        case 8:
            apurarVotacao();
            break;
        case 9:
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

private static void inserirFuncionario()throws AplicacaoException{
    String nomeFuncionario = TecladoUtil.lerString("Informe o nome do funcionario: ");

    controller.inserirFuncionario(nomeFuncionario);

}

private static void votar() throws AplicacaoException{
    Calendar calendar = Calendar.getInstance();
    listarFuncionario();
    Integer idFuncionario = TecladoUtil.lerInteiro("Informe seu id: ");
    listarRestaurante();
    String restaurante = TecladoUtil.lerString("Informe o nome do restaurante que deseja votar: ");

    controller.votar(idFuncionario, restaurante, calendar);
}


    private static void inserirRestaurante()throws AplicacaoException{
        String nomeRestaurante = TecladoUtil.lerString("Informe o nome do Restaurante: ");

        controller.inserirRestaurante(nomeRestaurante);

    }

    private static void apurarVotacao() throws AplicacaoException{
        System.out.println(controller.apurarVotos());
    }

    private static void removerFuncionario()throws AplicacaoException{
        String nomeFuncionario = TecladoUtil.lerString("Informe o nome do funcionario para remover: ");

        controller.removerFuncionario(nomeFuncionario);
    }

    private static void removerRestaurante()throws AplicacaoException{
        String nomeRestaurante = TecladoUtil.lerString("Informe o nome do restaurante para remover: ");

        controller.removerRestaurante(nomeRestaurante);
    }

    private static void listarFuncionario() throws  AplicacaoException{
        System.out.println(controller.listarFuncionarios());
    }

    private static void listarRestaurante() throws  AplicacaoException{
        System.out.println(controller.listarRestaurantes());
    }

        private static void menu() {
            System.out.println("---------------------------");
            System.out.println("[1] - Cadastrar voto       ");
            System.out.println("[2] - Inserir funcionario  ");
            System.out.println("[3] - Listar funcionarios  ");
            System.out.println("[4] - Inserir restaurantes ");
            System.out.println("[5] - Listar restaurantes  ");
            System.out.println("[6] - Remover funcionario  ");
            System.out.println("[7] - Remover Restaurante  ");
            System.out.println("[8] - Apurar votacao       ");
            System.out.println("[9] - Sair                 ");
            System.out.println("---------------------------");
        }

}