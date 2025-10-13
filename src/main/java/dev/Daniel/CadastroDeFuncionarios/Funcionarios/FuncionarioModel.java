package dev.Daniel.CadastroDeFuncionarios.Funcionarios;

import dev.Daniel.CadastroDeFuncionarios.Cargos.CargosModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_cadastro")
public class FuncionarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String nome;

    private String email;

    private int idade;

    @ManyToOne
    @JoinColumn(name = "cargos_Id") // foreign key
    private CargosModel cargosModel;
}
