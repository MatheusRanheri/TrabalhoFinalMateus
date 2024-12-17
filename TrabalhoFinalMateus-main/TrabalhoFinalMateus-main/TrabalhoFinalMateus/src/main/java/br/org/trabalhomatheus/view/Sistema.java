package br.org.trabalhomatheus.view;

import br.org.trabalhomatheus.controller.SistemaController;
import br.org.trabalhomatheus.exception.AplicacaoException;
import br.org.trabalhomatheus.util.TecladoUtil;

import java.util.Calendar;


/**
 * Classe Sistema é o que executa esse trbalho
 * @author Matheus Ranheri
 * @data 03/12/2024
 */
public class Sistema {


    /**
     * Variavel booleana como falsa vai ser usada para controlar um loop
     * Instacia da classe SistemaController
     */
    private static boolean sair = false;
    private static SistemaController controller = new SistemaController();


    /**
     * main: controla a execucao do programa
     * Enquanto sair for false o loop continua, se ele for true o loop se encerra
     * O meunu é chamado para mostrar as opcoes ao usuario
     * Dependendo do numero em opcao o metodo executa acao é chamado
     * @param args String
     */
    public static void main(String[] args) {

    while(!sair) {
        menu();
        int opcao = TecladoUtil.lerInteiro("Informe uma opcao");
        executaAcao(opcao);
      }
    }


    /**
     * Executa uma acao com base na opcao fornecida por parametro
     * Se a opcao fornecida nao for valida, opcao invalida!
     * @param opcao Integer
     */
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


    /**
     * Pede para usuario informar o nome do funcionario
     * chama o metodo inserir funcionario no sistemaController e passa esse nome como parametro
     * @throws AplicacaoException se houver uma falha na persistencia
     */
    private static void inserirFuncionario()throws AplicacaoException{
    String nomeFuncionario = TecladoUtil.lerString("Informe o nome do funcionario: ");

    controller.inserirFuncionario(nomeFuncionario);

}


    /**
     * Gerencia o processo de votacao
     * Cria um calendar com a data e hora atuais para referencia da dataVoto
     * listarFuncionarios eh chamado para exibir a lista de funcionarios
     * O id do funcionario eh pedido
     * listraRestaurantes eh chamado para listar os restaurantes
     * O nome do restaurante eh informado para saber qual o restaurante escolhido para o voto do funcionario
     * O metodo controller.Votar é chamado passando o idFuncionario, retaurante e o calendar como parametro
     * @throws AplicacaoException se houver uma falha na persistencia
     */
    private static void votar() throws AplicacaoException{
    Calendar calendar = Calendar.getInstance();
    listarFuncionario();
    Integer idFuncionario = TecladoUtil.lerInteiro("Informe seu id: ");
    listarRestaurante();
    String restaurante = TecladoUtil.lerString("Informe o nome do restaurante que deseja votar: ");

    controller.votar(idFuncionario, restaurante, calendar);
}



    /**
     * Pede para usuario informar o nome do restaurante
     * chama o metodo inserir restaurante no sistemaController e passa esse nome como parametro
     * @throws AplicacaoException se houver uma falha na persistencia
     */
private static void inserirRestaurante()throws AplicacaoException{
        String nomeRestaurante = TecladoUtil.lerString("Informe o nome do Restaurante: ");

        controller.inserirRestaurante(nomeRestaurante);

    }


    /**
     * Esse metodo exibe o metodo apurarVotos que é responsavel por mostrar a apuracao de votos no sistema
     * @throws AplicacaoException se houver uma falha na persistencia
     */
    private static void apurarVotacao() throws AplicacaoException{
        System.out.println(controller.apurarVotos());
    }


    /**
     * Remove um funcionario do sistema
     * O metodo pede o nome do funcionario que o usuario deseja remover
     * Chama o metodo removerFuncionario do sistemaCotroller  passando o nome informado como  parametro
     * @throws AplicacaoException se houver uma falha na persistencia
     */
    private static void removerFuncionario()throws AplicacaoException{
        String nomeFuncionario = TecladoUtil.lerString("Informe o nome do funcionario para remover: ");

        controller.removerFuncionario(nomeFuncionario);
    }


    /**
     * Remove um restaurante do sistema
     * O metodo pede o nome do restaurante que o usuario deseja remover
     * Chama o metodo removerRestaurante do sistemaCotroller  passando o nome informado como  parametro
     * @throws AplicacaoException se houver uma falha na persistencia
     */
    private static void removerRestaurante()throws AplicacaoException{
        String nomeRestaurante = TecladoUtil.lerString("Informe o nome do restaurante para remover: ");

        controller.removerRestaurante(nomeRestaurante);
    }


    /**
     * Exibe uma Lista com os funcionarios do sistema
     * @throws AplicacaoException se houver uma falha na persistencia
     */
    private static void listarFuncionario() throws  AplicacaoException{
        System.out.println(controller.listarFuncionarios());
    }


    /**
     * Exibe uma Lista com os restaurantes do sistema
     * @throws AplicacaoException se houver uma falha na persistencia
     */
    private static void listarRestaurante() throws  AplicacaoException{
        System.out.println(controller.listarRestaurantes());
    }


    /**
     * Exibe um menu funcional
     */
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