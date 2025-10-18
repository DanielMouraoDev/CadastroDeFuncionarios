package dev.Daniel.CadastroDeFuncionarios.Cargos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CargosDTO {

    private Long id;
    private String Cargo;
    private int salario;
}
