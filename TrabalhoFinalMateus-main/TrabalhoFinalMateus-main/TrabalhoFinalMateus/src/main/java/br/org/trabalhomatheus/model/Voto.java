package br.org.trabalhomatheus.model;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

//Marca a classe como uma entidade jpa(Uma classe que será mapeada para uma tabela no banco de dados).
@Entity
//Nome da tabela.
@Table (name = "VOTO")
public class Voto {

    //Chave primaria da tabela.
    @Id
    //Mostra como o valor da chave primaria será gerado (Estratégia é TABLE).
    @GeneratedValue(strategy = GenerationType.TABLE , generator ="voto_generator")
    //Define os detalhes do gerador de valores da chave primária usando TABLE. //name: nome do gerador.
    @TableGenerator(name = "voto_generator",
            //table: Nome da tabela.
            table = "chave",
            //Coluna que armazeará a chave.
            pkColumnName = "id",
            //Coluna que armazena o próximo valor disponível para a chave.
            valueColumnName = "valor",
            //Número de valores que serão armazenados por vez.
            allocationSize = 1)
    //Define o mapeamento de um campo na classe para uma coluna no banco de dados. // Define que o campo id será mapeado para a coluna id.
    @Column(name = "id")
    private Integer id;


    @Column(name = "data")//Mostra que o campo data será armazeado na coluna data
    @Temporal(TemporalType.DATE)//Mostra como um capo de data e hora deve ser mapeado no banco de dados.
    private Calendar data;


    //Muitos para um.
    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)//Só vai carregar o relacionamento com funcionario, quando o campo funcionario for acessado.
    @JoinColumn(name = "id_funcionario", referencedColumnName = "id")//Associação etre as duas tabelas, a coluna id da tabela funcionario é a coluna que o id_funcionario irá apontar.
    private Funcionario funcionario;

    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)//Só vai carregar o relacionamento com funcionario, quando o campo funcionario for acessado.
    @JoinColumn(name = "id_restaurante", referencedColumnName = "id")//Associação etre as duas tabelas, a coluna id da tabela restaurante é a coluna que o id_restaurante irá apontar.
    private Restaurante restaurante;

    public Voto(){

    }

    //Permite criar uma instância da classe Voto e inicializar o atributo data, funcionario e restaurante.
    public Voto(Calendar data, Funcionario funcionario, Restaurante restaurante) {
        this.data = data;
        this.funcionario = funcionario;
        this.restaurante = restaurante;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }





    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    //O metodo equals serve para comparar dois objetos e verificar se eles são iguais.
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Voto voto = (Voto) o;
        //Compara os atributos id e nome dos quatro objetos (this e that) usando o metodo object.equals.
        return Objects.equals(id, voto.id) && Objects.equals(data, voto.data) && Objects.equals(funcionario, voto.funcionario) && Objects.equals(restaurante, voto.restaurante);
    }

    //Define onde  um objeto será posto em uma tabela de Hash.
    @Override
    public int hashCode() {
        return Objects.hash(id, data, funcionario, restaurante);
    }

    //O método toString é usado para uma representação em texto de um obejeto.
    @Override
    public String toString() {
        return "Voto{" +
                "id=" + id +
                ", data=" + data +
                ", funcionario=" + funcionario +
                ", restaurante=" + restaurante +
                '}';
    }
}
