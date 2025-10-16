package dev.Daniel.CadastroDeFuncionarios.Cargos;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Column (name = "id")
    String id;

    @Column (name = "cargo")
    String Cargo;

    @Column (name = "salario")
    int Salario;

    @OneToMany(mappedBy = "cargosModel")
    @JsonIgnore
    private List<FuncionarioModel> Funcionarios;

}
