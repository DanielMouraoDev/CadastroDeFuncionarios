package dev.Daniel.CadastroDeFuncionarios.Cargos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.Daniel.CadastroDeFuncionarios.Funcionarios.FuncionarioModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "cargos_tb")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CargosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cargo")
    private String cargo;

    @Column(name = "salario")
    private int salario;

    @OneToMany(mappedBy = "cargosModel")
    @JsonIgnore
    private List<FuncionarioModel> funcionarios;
}