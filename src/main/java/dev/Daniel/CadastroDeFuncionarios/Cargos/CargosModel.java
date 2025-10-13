package dev.Daniel.CadastroDeFuncionarios.Cargos;

import dev.Daniel.CadastroDeFuncionarios.Funcionarios.FuncionarioModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Cargos_tb")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CargosModel {

    @Id
    @GeneratedValue
    String id;

    String Cargo;

    int Salario;

    @OneToMany(mappedBy = "Cargo")
    private List<FuncionarioModel> Funcionarios;

}
