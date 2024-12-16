package br.org.trabalhomatheus.controller;

import br.org.trabalhomatheus.exception.AplicacaoException;
import br.org.trabalhomatheus.model.Funcionario;
import br.org.trabalhomatheus.model.Restaurante;
import br.org.trabalhomatheus.model.TotalFuncionariosRestaurante;
import br.org.trabalhomatheus.model.Voto;
import br.org.trabalhomatheus.repository.FuncionarioRepository;
import br.org.trabalhomatheus.repository.RestauranteRepository;
import br.org.trabalhomatheus.repository.VotoRepository;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

public class SistemaController {

    private FuncionarioRepository funcionarioRepository;
    private RestauranteRepository restauranteRepository;
    private VotoRepository votoRepository;

    public SistemaController(){

        this.funcionarioRepository = new FuncionarioRepository();
        this.restauranteRepository = new RestauranteRepository();
        this.votoRepository = new VotoRepository();
    }

    public void inserirFuncionario(String nomeFuncionario) throws AplicacaoException {
        try{
            Funcionario funcionario = funcionarioRepository.buscarFuncionario(nomeFuncionario);

            if(funcionario == null){
                funcionario = new Funcionario(nomeFuncionario);
                funcionarioRepository.inserirFuncionario(funcionario);
            }



        } catch (PersistenceException e) {
                e.printStackTrace();
                throw new AplicacaoException("Falha ao inserir funcionario");
        }
    }

    public void inserirRestaurante(String nomeRestaurante) throws AplicacaoException {
            try{
                Restaurante restaurante = restauranteRepository.buscarPorNome(nomeRestaurante);

                if(restaurante  ==  null){
                    restaurante = new Restaurante(nomeRestaurante);
                    restauranteRepository.inserirRestaurante(restaurante);
                }


            }catch(PersistenceException e){
                e.printStackTrace();
                throw new AplicacaoException("Falha ao inserir restaurante");
            }
    }

    public List<Funcionario> listarFuncionarios() throws AplicacaoException{
        try{
            return funcionarioRepository.buscar();
        } catch (PersistenceException e) {
            throw new AplicacaoException("Falha ao listar Funcionario! ");
        }
    }


    public void removerRestaurante(String nomeRestaurante) throws AplicacaoException {
        try{
            Restaurante restaurante = restauranteRepository.buscarPorNome(nomeRestaurante);

            if(restaurante  !=  null){
                restauranteRepository.removerRestaurante(restaurante);
            }


        }catch(PersistenceException e){
            e.printStackTrace();
            throw new AplicacaoException("Falha ao remover restaurante");
        }
    }


    public void removerFuncionario(String nomeFuncionario) throws AplicacaoException {
        try{
            Funcionario funcionario = funcionarioRepository.buscarFuncionario(nomeFuncionario);

            if(funcionario  !=  null){
                funcionarioRepository.removerFuncionario(funcionario);
            }else{
                System.out.println("Falha ao remover um funcionario! ");
            }


        }catch(PersistenceException e){
            throw new AplicacaoException("Falha ao remover funcionario");
        }
    }

    public List<Restaurante> listarRestaurantes() throws AplicacaoException{
        try{
            return restauranteRepository.buscar();
        } catch (PersistenceException e) {
            throw new AplicacaoException("Falha ao inserir Restaurante! ");
        }
    }

    public List<Restaurante> listarRestaurantes(String nome) throws AplicacaoException{
        try{
            return restauranteRepository.buscarRestaurantes(nome);
        }catch (PersistenceException e){
            throw new AplicacaoException("Falha ao inserir Funcionario! ");
        }
    }


    public void votar(Integer idFuncionario, String nomeRestaurante, Calendar dia){

            Funcionario funcionario = funcionarioRepository.buscarFuncionario(idFuncionario);

            if(funcionario == null){
                System.out.println("Funcionario não encontrado");
            }else{
                Restaurante restaurante = restauranteRepository.buscarPorNome(nomeRestaurante);

                if(restaurante == null){
                    System.out.println("Restaurante não encontrado");
                }else{

                    Calendar calendar = Calendar.getInstance();

                    boolean votar = true;

                    List<Voto> votos = votoRepository.buscarVoto();
                    for(Voto voto : votos){
                        if(calendar.get(Calendar.DAY_OF_MONTH) == voto.getData().get(Calendar.DAY_OF_MONTH) && calendar.get(Calendar.MONTH) == voto.getData().get(Calendar.MONTH) && calendar.get(Calendar.YEAR) == voto.getData().get(Calendar.YEAR) && voto.getFuncionario().getId() == (idFuncionario)){
                            votar = false;
                        }





                    }

                    if(votar == false ){
                        System.out.println("Ja votou!!! ");
                    }else{
                        Voto voto = new Voto(dia, funcionario, restaurante);
                        votoRepository.inserirVoto(voto);
                        System.out.println("Voto feito com sucesso!!!");
                    }




                }
            }
    }

    public List<TotalFuncionariosRestaurante> apurarVotos() throws AplicacaoException{
        try{
            return votoRepository.TotalFuncionariosRestaurante();
        } catch (PersistenceException e) {
            throw new AplicacaoException("Falha ao inserir Restaurante! ");
        }
    }

}
