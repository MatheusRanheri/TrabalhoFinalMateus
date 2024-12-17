package br.org.trabalhomatheus.model;


/**
 * Classe TotalFuncionariosRestaurante que possui nomeRestaurante e qntVotos
 * @author Matheus Ranheri
 * @data 03/12/2024
 */
public class TotalFuncionariosRestaurante {


    /**
     * Uma variavel do tipo texto que está privada
     * Uma variavel de tipo numerico que esta privado
     */
    private String nomeRestaurante;//Uma variavel do tipo texto que está privada.
    private Long qntVotos;//Uma variavel de tipo numerico que está privado.

    //Permite criar uma instância da classe TotalFuncionariosRestaurante e inicializar o atributo nomeRestaurante e qntVotos.

    /**
     * @param nomeRestaurante String
     * @param qntVotos Long
     * Permite criar uma instância da classe TotalFuncionariosRestaurante e inicializar o atributo nomeRestaurante e qntVotos
     */
    public TotalFuncionariosRestaurante(String nomeRestaurante, Long qntVotos){
        this.nomeRestaurante = nomeRestaurante;
        this.qntVotos = qntVotos;
    }

    //O método toString é usado para uma representação em texto de um obejeto.

    /**
     * ToString é usado para uma representação em texto de um obejeto
     * @return retorna o nome da classe e os valores dos atributos
     */
    @Override
    public String toString() {
        return "TotalFuncionariosRestaurante{" +
                "restaurante='" + nomeRestaurante + '\'' +
                ", qntVotos=" + qntVotos +
                '}';
    }
}
