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


/**
 * Classe SistemaController que controla o sistema
 * @author Matheus Ranheri
 * @data 03/12/2024
 */
public class SistemaController {


    /**
     * Declaram atriutos da instancia do tipo FuncionarioRepository, RestauranteRepository e VotoRepository
     */
    private FuncionarioRepository funcionarioRepository;
    private RestauranteRepository restauranteRepository;
    private VotoRepository votoRepository;


    /**
     * Inicializa os repostorios
     */
    public SistemaController(){

        this.funcionarioRepository = new FuncionarioRepository();
        this.restauranteRepository = new RestauranteRepository();
        this.votoRepository = new VotoRepository();
    }


    /**
     * @param nomeFuncionario String
     * busca um funcionario ja existente no banco de dados
     * se o funcionario existir ele sera armazenado na variavel
     * se o funcionario nao existir um novo funcionario sera adicionado no banco de dados
     * @throws AplicacaoException Caso ocorra falhas na persistencia
     */
    public void inserirFuncionario(String nomeFuncionario) throws AplicacaoException {
        try{
            Funcionario funcionario = funcionarioRepository.buscarFuncionario(nomeFuncionario);

            if(funcionario == null){
                funcionario = new Funcionario(nomeFuncionario);
                funcionarioRepository.inserirFuncionario(funcionario);
            }



        } catch (PersistenceException e) {
                e.printStackTrace(); //exibe os detalhes da excecao no console
                throw new AplicacaoException("Falha ao inserir funcionario");
        }
    }


    /**
     * @param nomeRestaurante String
     * busca um restaurante ja existente no banco de dados
     * se o restaurante existir ele sera armazenado na variavel
     * se o restaurante nao existir um novo restaurante sera adicionado no banco de dados
     * @throws AplicacaoException Caso ocorra falhas na persistencia
     */
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


    /**
     * Tenta buscar os funcionarios no banco de dados pelo metodo buscar
     * @return retorna uma lsita de objetos do tipo funcionario
     * @throws AplicacaoException Caso ocorra falhas de consulta
     */
    public List<Funcionario> listarFuncionarios() throws AplicacaoException{
        try{
            return funcionarioRepository.buscar();
        } catch (PersistenceException e) {
            throw new AplicacaoException("Falha ao listar Funcionario! ");
        }
    }



    /**
     * @param nomeRestaurante String
     * busca um restaurante ja existente no banco de dados
     * se o retaurante existir ele sera removido do banco de dados
     * se o restaurate nao existir falha ao remover o restaurante
     * @throws AplicacaoException Caso ocorra falhas na persistencia
     */
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



    /**
     * @param nomeFuncionario String
     * busca um funcionario ja existente no banco de dados
     * se o funcionario existir ele sera removido do banco de dados
     * se o funcionario nao existir falha ao remover o funcionario
     * @throws AplicacaoException Caso ocorra falhas na persistencia
     */
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


    /**
     * Tenta buscar os restaurantes no banco de dados pelo metodo buscar
     * @return retorna uma lsita de objetos do tipo restaurante
     * @throws AplicacaoException Caso ocorra falhas de consulta
     */
    public List<Restaurante> listarRestaurantes() throws AplicacaoException{
        try{
            return restauranteRepository.buscar();
        } catch (PersistenceException e) {
            throw new AplicacaoException("Falha ao inserir Restaurante! ");
        }
    }


    /**
     * @param idFuncionario Integer
     * @param nomeRestaurante String
     * @param dia Calendar
     * O metodo comeca verificando se o funcionario e restaurante existem
     * Com o calendar o metodo faz a verificação para saber se o funcionario ja votou naquele dia, se ele votou: você ja votou!
     * Se o funcionario não votou adiciona um novo voto e: Voto feito com sucesso!!!
     */
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


    /**
     * Apura os votos dos funcionarios em relação aos restaurantes
     * @return retorna uma lista de objetos com o nome do restaurante e o numero de votos que ele possui
     * @throws AplicacaoException Caso ocorra problemas com o baco e etc
     */
    public List<TotalFuncionariosRestaurante> apurarVotos() throws AplicacaoException{
        try{
            return votoRepository.TotalFuncionariosRestaurante();
        } catch (PersistenceException e) {
            throw new AplicacaoException("Falha ao apurar votos Restaurante! ");
        }
    }

}
