package br.org.trabalhomatheus.model;

public class TotalFuncionariosRestaurante {

    private String nomeRestaurante;//Uma variavel do tipo texto que está privada.
    private Long qntVotos;//Uma variavel de tipo numerico que está privado.

    //Permite criar uma instância da classe TotalFuncionariosRestaurante e inicializar o atributo nomeRestaurante e qntVotos.
    public TotalFuncionariosRestaurante(String nomeRestaurante, Long qntVotos){
        this.nomeRestaurante = nomeRestaurante;
        this.qntVotos = qntVotos;
    }

    //O método toString é usado para uma representação em texto de um obejeto.
    @Override
    public String toString() {
        return "TotalFuncionariosRestaurante{" +
                "restaurante='" + nomeRestaurante + '\'' +
                ", qntVotos=" + qntVotos +
                '}';
    }
}
