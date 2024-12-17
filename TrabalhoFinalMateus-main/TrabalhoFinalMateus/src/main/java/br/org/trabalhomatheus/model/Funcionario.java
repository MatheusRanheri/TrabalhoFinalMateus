package br.org.trabalhomatheus.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Classe Funcionario que representa uma tabela no banco de dados
 * @author Matheus Ranheri
 * @data 03/12/2024
 */

//Marca a classe como uma entidade jpa(Uma classe que será mapeada para uma tabela no banco de dados).
@Entity
//Nome da tabela.
@Table(name = "FUNCIONARIO")
public class Funcionario {

    /**
     * @id = chave primaria
     * @GeneratedValue mostra como o valorda chave primaria será gerado
     * @TableGenerator Define os detalhes do gerador de valores da chave primária usando TABLE.
     * name = nome do gerador
     * table = nome tabela
     * pkColumnName = Coluna que armazeará a chave
     * valueColumnName = Coluna que armazena o próximo valor disponível para a chave
     */

    //Chave primaria da tabela.
    @Id
    //Mostra como o valor da chave primaria será gerado (Estratégia é TABLE).
    @GeneratedValue(strategy = GenerationType.TABLE , generator = "funcionario_generator")
    //Define os detalhes do gerador de valores da chave primária usando TABLE. //name: nome do gerador.
    @TableGenerator(name = "funcionario_generator",
            //table: Nome da tabela.
            table = "chave",
            //Coluna que armazeará a chave.
            pkColumnName = "id",
            //Coluna que armazena o próximo valor disponível para a chave.
            valueColumnName = "valor",
    //Número de valores que serão armazenados por vez.
    allocationSize = 1)
    //Define o mapeamento de um campo na classe para uma coluna no banco de dados. // Define que o campo id será mapeado para a coluna id.

    /**
     * Define que o campo id será mapeado para a coluna id.
     */
    @Column(name = "id")
    private Integer id;

    //Define o mapeamento de um campo na classe para uma coluna no banco de dados. // Define que o campo nome será mapeado para a coluna nome.

    /**
     * Define que o campo nome será mapeado para a coluna nome
     */
    @Column(name = "nome")
    private String nome;

    //Mapeia um relacionamento de um-para-muitos entre a entidade Funcionario e outra entidade (Voto). FetchType.EAGER: Especifica que os votos associados ao funcionário serão carregados imediatamente quando o funcionário for buscado. CascadeType.ALL: Aplica todas as operações em cascata.

    /**
     * Mapeia um relacionamento de um-para-muitos entre a entidade Funcionario e outra entidade (Voto)
     * FetchType.EAGER: Especifica que os votos associados ao funcionário serão carregados imediatamente quando o funcionário for buscado
     * CascadeType.ALL: Aplica todas as operações em cascata
     */
    @OneToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "funcionario")
    private List<Voto> votos;

    public Funcionario(){

    }

    //Permite criar uma instância da classe Funcionario e inicializar o atributo nome.

    /**
     * @param nome String
     * Permite criar uma instância da classe Funcionario e inicializar o atributo nome
     */
    public Funcionario(String nome){
        super();
        this.nome =  nome;
    }

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    //O metodo equals serve para comparar dois objetos e verificar se eles são iguais.

    /**
     * @param o Object
     * O metodo equals serve para comparar objetos e verificar se eles são iguais.
     * @return A comparação entre os atributos id e nome
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        //Compara os atributos id e nome dos dois objetos (this e that) usando o metodo object.equals.
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome);
    }

    public List<Voto> getVotos(){
        return votos;
    }

    public void setVotos(List<Voto> votos){
        this.votos = votos;
    }

    /**
     * Define onde  um objeto será posto em uma tabela de Hash.
     * @return Retorna um inteiro que representa um objeto
     */
    @Override
    //Define onde  um objeto será posto em uma tabela de Hash.
    public int hashCode() {
        return Objects.hash(id, nome);
    }


    //O método toString é usado para uma representação em texto de um obejeto.

    /**
     * ToString é usado para uma representação em texto de um obejeto
     * @return retorna o nome da classe e os valores dos atributos
     */
    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }


}
