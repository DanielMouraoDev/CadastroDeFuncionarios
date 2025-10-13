package dev.Daniel.CadastroDeFuncionarios.Cargos;

import dev.Daniel.CadastroDeFuncionarios.Funcionarios.FuncionarioModel;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Cargos_tb")
public class CargosModel {

    @Id
    @GeneratedValue
    String id;

    String Cargo;

    int Salario;

    @OneToMany(mappedBy = "Cargo")
    private List<FuncionarioModel> Funcionarios;

}
