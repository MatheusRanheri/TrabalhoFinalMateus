package br.org.trabalhomatheus.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

//Marca a classe como uma entidade jpa(Uma classe que será mapeada para uma tabela no banco de dados).
@Entity
//Nome da tabela.
@Table(name = "RESTAURANTE")

public class Restaurante {

  //Chave primaria da tabela.
  @Id
  //Mostra como o valor da chave primaria será gerado (Estratégia é TABLE).
  @GeneratedValue(strategy = GenerationType.TABLE , generator = "restaurante_generator")
  //Define os detalhes do gerador de valores da chave primária usando TABLE. //name: nome do gerador.
  @TableGenerator(name = "restaurante_generator",
          //table: Nome da tabela.
          table="chave",
          //Coluna que armazeará a chave.
          pkColumnName="id",
          //Coluna que armazena o próximo valor disponível para a chave.
          valueColumnName="valor",
          //Número de valores que serão armazenados por vez.
          allocationSize = 1)
  //Define o mapeamento de um campo na classe para uma coluna no banco de dados. // Define que o campo id será mapeado para a coluna id.
  @Column(name = "id")
  private Integer id;

  //Define o mapeamento de um campo na classe para uma coluna no banco de dados. // Define que o campo nome será mapeado para a coluna nome.
  @Column(name = "nome")
  private String nome;



  //Um restaurante que pode ter muitos votos, com uma lista de objetos voto.
  @OneToMany(mappedBy = "restaurante")
  private List<Voto> votos;

  public Restaurante(){

  }

  //Permite criar uma instância da classe Restaurante e inicializar o atributo nome.
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

  //O metodo equals serve para comparar dois objetos e verificar se eles são iguais.
  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) return false;
    Restaurante that = (Restaurante) o;
    //Compara os atributos id e nome dos dois objetos (this e that) usando o metodo object.equals.
    return Objects.equals(id, that.id) && Objects.equals(nome, that.nome);
  }

  //Define onde  um objeto será posto em uma tabela de Hash.
  @Override
  public int hashCode() {
    return Objects.hash(id, nome);
  }

  //O método toString é usado para uma representação em texto de um obejeto.
  @Override
  public String toString() {
    return "Restaurante{" +
            "id=" + id +
            ", nome='" + nome + '\'' +
            '}';
  }
}
