package br.org.trabalhomatheus.model;

public class TotalFuncionariosRestaurante {

    private String restaurante;
    private Long qntVotos;

    public TotalFuncionariosRestaurante(String restaurante, Long qntVotos){
        this.restaurante = restaurante;
        this.qntVotos = qntVotos;
    }

    @Override
    public String toString() {
        return "TotalFuncionariosRestaurante{" +
                "restaurante='" + restaurante + '\'' +
                ", qntVotos=" + qntVotos +
                '}';
    }
}
