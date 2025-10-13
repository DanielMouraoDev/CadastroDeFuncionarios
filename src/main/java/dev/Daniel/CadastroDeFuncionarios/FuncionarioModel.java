package dev.Daniel.CadastroDeFuncionarios;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_cadastro")
public class FuncionarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
    String email;
    int idade;
}
