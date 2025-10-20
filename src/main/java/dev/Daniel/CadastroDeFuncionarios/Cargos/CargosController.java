package dev.Daniel.CadastroDeFuncionarios.Cargos;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("cargos")
public class CargosController {

    private final CargosService cargosService;

    public CargosController(CargosService cargosService) {
        this.cargosService = cargosService;
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarCargos(@RequestBody CargosDTO cargosDTO) {
        CargosDTO novoCargo = cargosService.criarCargos(cargosDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Cargo criado com sucesso! Nome: " + novoCargo.getCargo() + " (ID: " + novoCargo.getId() + ")");
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<String> listarCargosID(@PathVariable Long id) {
        CargosDTO cargo = cargosService.listarCargosID(id);
        if (cargo != null) {
            return ResponseEntity.ok("Cargo encontrado: " + cargo.getCargo() + " | Salário: " + cargo.getSalario());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cargo com ID " + id + " não foi encontrado.");
        }
    }

    @GetMapping("/listar")
    public ResponseEntity<List<CargosDTO>> listarcargos() {
        List<CargosDTO> cargos = cargosService.listarCargos();
        return ResponseEntity.ok(cargos);
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> alterarCargoID(@PathVariable Long id, @RequestBody CargosDTO cargosDTO) {
        CargosDTO cargoAtualizado = cargosService.atualizarCargo(id, cargosDTO);
        if (cargoAtualizado != null) {
            return ResponseEntity.ok("Cargo de ID " + id + " alterado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O cargo com ID " + id + " não foi encontrado.");
        }
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarCargosID(@PathVariable Long id) {
        // Verifica se o cargo existe antes de tentar deletar
        if (cargosService.listarCargosID(id) != null) {
            cargosService.deletarCargosID(id);
            return ResponseEntity.ok("Cargo de ID " + id + " deletado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O cargo com ID " + id + " não foi encontrado para deleção.");
        }
    }
}