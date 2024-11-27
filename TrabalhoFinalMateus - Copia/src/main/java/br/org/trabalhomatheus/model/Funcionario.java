package br.org.trabalhomatheus.model;


import javax.persistence.*;

@Entity
@Table(name = "FUNCIONARIO")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE , generator = "funcionario_generator")
    @TableGenerator(name = "funcionario_generator",
            table = "chave",
            pkColumnName = "id",
            valueColumnName = "valor",
    allocationSize = 100)
    @Column(name = "id")
    private Integer id;

    @Column(name = "nome")
    private String nome;



}
