package br.org.trabalhomatheus.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table (name = "VOTO")
public class Voto {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE , generator ="voto_generator")
    @TableGenerator(name = "voto_generator",
            table = "chave",
            pkColumnName = "id",
            valueColumnName = "valor",
            allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "data")
    private Date data;

    @Column(name = "id_funcionario")
    private Integer id_funcionario;

    @Column(name = "id_restaurante")
    private Integer id_restaurante;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "id_funcionario", referencedColumnName = "id")
    private Funcionario funcionario;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "id_restaurante", referencedColumnName = "id")
    private Restaurante restaurante;

    public Voto(){

    }

    public Voto(Integer id, Restaurante restaurante){
        super();

        this.id = id;
        this.restaurante = restaurante;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Integer getId_funcionario() {
        return id_funcionario;
    }

    public void setId_funcionario(Integer id_funcionario) {
        this.id_funcionario = id_funcionario;
    }

    public Integer getId_restaurante() {
        return id_restaurante;
    }

    public void setId_restaurante(Integer id_restaurante) {
        this.id_restaurante = id_restaurante;
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Voto voto = (Voto) o;
        return Objects.equals(id, voto.id) && Objects.equals(data, voto.data) && Objects.equals(id_funcionario, voto.id_funcionario) && Objects.equals(id_restaurante, voto.id_restaurante) && Objects.equals(funcionario, voto.funcionario) && Objects.equals(restaurante, voto.restaurante);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data, id_funcionario, id_restaurante, funcionario, restaurante);
    }

    @Override
    public String toString() {
        return "Voto{" +
                "id=" + id +
                ", data=" + data +
                ", id_funcionario=" + id_funcionario +
                ", id_restaurante=" + id_restaurante +
                ", funcionario=" + funcionario +
                ", restaurante=" + restaurante +
                '}';
    }
}
