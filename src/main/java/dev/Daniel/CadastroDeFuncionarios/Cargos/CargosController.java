package dev.Daniel.CadastroDeFuncionarios.Cargos;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/cargos")
@Tag(name = "Cargos", description = "Endpoints para o gerenciamento de cargos")
public class CargosController {

    private final CargosService cargosService;

    public CargosController(CargosService cargosService) {
        this.cargosService = cargosService;
    }

    @Operation(summary = "Cria um novo cargo", description = "Cadastra um novo cargo no sistema.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Cargo criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos")
    })
    @PostMapping("/criar")
    public ResponseEntity<String> criarCargos(@RequestBody CargosDTO cargosDTO) {
        CargosDTO novoCargo = cargosService.criarCargos(cargosDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Cargo criado com sucesso! Nome: " + novoCargo.getCargo() + " (ID: " + novoCargo.getId() + ")");
    }

    @Operation(summary = "Busca um cargo por ID", description = "Retorna os detalhes de um cargo específico.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cargo encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Cargo não encontrado")
    })
    @GetMapping("/listar/{id}")
    public ResponseEntity<String> listarCargosID(
            @Parameter(description = "ID do cargo a ser buscado", required = true)
            @PathVariable Long id) {
        CargosDTO cargo = cargosService.listarCargosID(id);
        if (cargo != null) {
            return ResponseEntity.ok("Cargo encontrado: " + cargo.getCargo() + " | Salário: " + cargo.getSalario());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Cargo com ID " + id + " não foi encontrado.");
        }
    }

    @Operation(summary = "Lista todos os cargos", description = "Retorna uma lista com todos os cargos cadastrados.")
    @ApiResponse(responseCode = "200", description = "Lista de cargos retornada com sucesso")
    @GetMapping("/listar")
    public ResponseEntity<List<CargosDTO>> listarcargos() {
        List<CargosDTO> cargos = cargosService.listarCargos();
        return ResponseEntity.ok(cargos);
    }

    @Operation(summary = "Atualiza um cargo existente", description = "Altera os dados de um cargo com base no seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cargo atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Cargo não encontrado")
    })
    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> alterarCargoID(
            @Parameter(description = "ID do cargo a ser atualizado", required = true)
            @PathVariable Long id,
            @RequestBody CargosDTO cargosDTO) {
        CargosDTO cargoAtualizado = cargosService.atualizarCargo(id, cargosDTO);
        if (cargoAtualizado != null) {
            return ResponseEntity.ok("Cargo de ID " + id + " alterado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O cargo com ID " + id + " não foi encontrado.");
        }
    }

    @Operation(summary = "Deleta um cargo", description = "Remove um cargo do sistema com base no seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Cargo deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Cargo não encontrado")
    })
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarCargosID(
            @Parameter(description = "ID do cargo a ser deletado", required = true)
            @PathVariable Long id) {
        if (cargosService.listarCargosID(id) != null) {
            cargosService.deletarCargosID(id);
            return ResponseEntity.ok("Cargo de ID " + id + " deletado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O cargo com ID " + id + " não foi encontrado para deleção.");
        }
    }
}