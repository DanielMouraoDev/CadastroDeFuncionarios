package dev.Daniel.CadastroDeFuncionarios.Cargos;

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
    public CargosDTO criarCargos(@RequestBody CargosDTO cargosDTO) {
        return cargosService.criarCargos(cargosDTO);
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<CargosDTO> listarCargosID(@PathVariable Long id) {
        CargosDTO cargo = cargosService.listarCargosID(id);
        if (cargo != null) {
            return ResponseEntity.ok(cargo);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/listar")
    public List<CargosDTO> listarcargos() {
        return cargosService.listarCargos();
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<CargosDTO> alterarCargoID(@PathVariable Long id, @RequestBody CargosDTO cargosDTO) {
        CargosDTO cargoAtualizado = cargosService.atualizarCargo(id, cargosDTO);
        if (cargoAtualizado != null) {
            return ResponseEntity.ok(cargoAtualizado);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarCargosID(@PathVariable Long id) {
        cargosService.deletarCargosID(id);
        return ResponseEntity.noContent().build();
    }
}