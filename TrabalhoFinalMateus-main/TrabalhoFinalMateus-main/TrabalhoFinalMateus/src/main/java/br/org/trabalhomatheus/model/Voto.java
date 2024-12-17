package br.org.trabalhomatheus.model;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

//Marca a classe como uma entidade jpa(Uma classe que será mapeada para uma tabela no banco de dados).

/**
 * Classe Voto que representa uma tabela no banco de dados
 * @author Matheus Ranheri
 * @data 03/12/2024
 */
@Entity
//Nome da tabela.
@Table (name = "VOTO")
public class Voto {


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
    @GeneratedValue(strategy = GenerationType.TABLE , generator ="voto_generator")
    @TableGenerator(name = "voto_generator",
            table = "chave",
            pkColumnName = "id",
            valueColumnName = "valor",
            allocationSize = 1)

    /**
     * Define que o campo id será mapeado para a coluna id.
     */
    @Column(name = "id")
    private Integer id;



    /**
     * Define que o campo nome será mapeado para a coluna nome.
     */
    @Column(name = "data")
    @Temporal(TemporalType.DATE)
    private Calendar data;



    /**
     * @ManyToOne = Muitos para um
     * FetchType.LAZY = Só vai carregar o relacionamento com funcionario, quando o campo funcionario for acessado
     * @JoinColumn = Associação etre as duas tabelas, a coluna id da tabela funcionario é a coluna que o id_funcionario irá apontar
     */
    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_funcionario", referencedColumnName = "id")
    private Funcionario funcionario;

    @ManyToOne (fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_restaurante", referencedColumnName = "id")
    private Restaurante restaurante;

    public Voto(){

    }


    /**
     * @param data Calendar
     * @param funcionario Funcionario
     * @param restaurante Restaurante
     * Permite criar uma instância da classe Voto e inicializar o atributo data, funcionario e restaurante.
     */
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


    /**
     * @param o Object
     * O metodo equals serve para comparar objetos e verificar se eles são iguais
     * @return A comparação entre os atributos id, data, funcionario e restaurante
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Voto voto = (Voto) o;
        return Objects.equals(id, voto.id) && Objects.equals(data, voto.data) && Objects.equals(funcionario, voto.funcionario) && Objects.equals(restaurante, voto.restaurante);
    }


    /**
     * Define onde  um objeto será posto em uma tabela de Hash.
     * @return Retorna um inteiro que representa um objeto
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, data, funcionario, restaurante);
    }


    /**
     * ToString é usado para uma representação em texto de um obejeto
     * @return retorna o nome da classe e os valores dos atributos
     */
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
