package dev.Daniel.CadastroDeFuncionarios.Funcionarios;

import dev.Daniel.CadastroDeFuncionarios.Cargos.CargosModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioDTO {

    private Long id; // <-- ALTERADO DE 'long' PARA 'Long'
    private String nome;
    private String email;
    private int idade;
    private String senioridade;
    private CargosModel cargo;

}