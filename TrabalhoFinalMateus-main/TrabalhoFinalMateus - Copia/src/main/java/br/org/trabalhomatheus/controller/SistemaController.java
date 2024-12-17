package br.org.trabalhomatheus.controller;

import br.org.trabalhomatheus.repository.FuncionarioRepository;
import br.org.trabalhomatheus.repository.RestauranteRepository;

public class SistemaController {

    private FuncionarioRepository funcionarioRepository;
    private RestauranteRepository restauranteRepository;

    public SistemaController(){
        this.funcionarioRepository = new FuncionarioRepository();
        this.restauranteRepository = new RestauranteRepository();
    }



}
