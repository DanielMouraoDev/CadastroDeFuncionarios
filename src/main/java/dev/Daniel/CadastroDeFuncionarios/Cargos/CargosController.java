package dev.Daniel.CadastroDeFuncionarios.Cargos;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("cargos")
public class CargosController {

    @GetMapping("/listar")
    public String listarCargos() {
        return "cargos retornados com sucesso";
    }

    @PostMapping("/criar")
    public String criarCargos() {
        return "cargos criados com sucesso";
    }

    @PutMapping("/alterar")
    public String alterarCargos() {
        return "cargos alterado com sucesso";
    }

    @DeleteMapping("/delete")
    public String deletarCargos() {
        return "cargos deletados com sucesso";
    }
}
