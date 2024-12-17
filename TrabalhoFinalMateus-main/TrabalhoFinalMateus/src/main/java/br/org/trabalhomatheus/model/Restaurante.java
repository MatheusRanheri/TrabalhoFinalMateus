package br.org.trabalhomatheus.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

//Marca a classe como uma entidade jpa(Uma classe que será mapeada para uma tabela no banco de dados).

/**
 * Classe Restaurante que representa uma tabela no banco de dados
 * @author Matheus Ranheri
 * @data 03/12/2024
 */
@Entity
//Nome da tabela.
@Table(name = "RESTAURANTE")

public class Restaurante {


  /**
   * @id = chave primaria
   * @GeneratedValue mostra como o valorda chave primaria será gerado
   * @TableGenerator Define os detalhes do gerador de valores da chave primária usando TABLE.
   * name = nome do gerador
   * table = nome tabela
   * pkColumnName = Coluna que armazeará a chave
   * valueColumnName = Coluna que armazena o próximo valor disponível para a chave
   */
  @Id
  @GeneratedValue(strategy = GenerationType.TABLE , generator = "restaurante_generator")
  @TableGenerator(name = "restaurante_generator",
          table="chave",
          pkColumnName="id",
          valueColumnName="valor",
          allocationSize = 1)

  /**
   * Define que o campo id será mapeado para a coluna id.
   */
  @Column(name = "id")
  private Integer id;


  /**
   * Define que o campo nome será mapeado para a coluna nome.
   */
  @Column(name = "nome")
  private String nome;




  /**
   * Um restaurante que pode ter muitos votos, com uma lista de objetos voto
   */
  @OneToMany(mappedBy = "restaurante")
  private List<Voto> votos;

  public Restaurante(){

  }


  /**
   * @param nome String
   * Permite criar uma instância da classe Restaurante e inicializar o atributo nome.
   */
  public Restaurante(String nome){
    super();
    this.nome = nome;
  }

  public List<Voto> getVotos() {
    return votos;
  }

  public void setVotos(List<Voto> votos) {
    this.votos = votos;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }


  /**
   * @param o Object
   * O metodo equals serve para comparar objetos e verificar se eles são iguais.
   * @return Retorna a comparação entre os atributos id e nome
   */
  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Restaurante that = (Restaurante) o;
    //Compara os atributos id e nome dos dois objetos (this e that) usando o metodo object.equals.
    return Objects.equals(id, that.id) && Objects.equals(nome, that.nome);
  }



  /**
   * Define onde  um objeto será posto em uma tabela de Hash.
   * @return Retorna um inteiro que representa um objeto
   */
  @Override
  public int hashCode() {
    return Objects.hash(id, nome);
  }


  /**
   * ToString é usado para uma representação em texto de um obejeto
   * @return retorna o nome da classe e os valores dos atributos
   */
  @Override
  public String toString() {
    return "Restaurante{" +
            "id=" + id +
            ", nome='" + nome + '\'' +
            '}';
  }
}
