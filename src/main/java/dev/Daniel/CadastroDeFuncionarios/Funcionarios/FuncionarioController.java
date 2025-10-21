package dev.Daniel.CadastroDeFuncionarios.Funcionarios;

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
@RequestMapping("/funcionarios")
@Tag(name = "Funcionários", description = "Endpoints para o gerenciamento de funcionários")
public class FuncionarioController {

    private final FuncionariosService funcionariosService;

    public FuncionarioController(FuncionariosService funcionariosService) {
        this.funcionariosService = funcionariosService;
    }

    @Operation(summary = "Exibe uma mensagem de boas-vindas", description = "Endpoint de teste para verificar se a API de funcionários está funcionando.")
    @ApiResponse(responseCode = "200", description = "Mensagem retornada com sucesso")
    @GetMapping("/boasvindas")
    public String boasvindas() {
        return "Essa é a minha primeira mensagem na rota";
    }

    @Operation(summary = "Busca um funcionário por ID", description = "Retorna os detalhes de um funcionário específico com base no seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Funcionário encontrado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Funcionário não encontrado com o ID fornecido")
    })
    @GetMapping("/listar/{id}")
    public ResponseEntity<?> mostrarFuncionariosId(
            @Parameter(description = "ID do funcionário a ser buscado", required = true)
            @PathVariable Long id) {
        FuncionarioDTO funcionario = funcionariosService.listarFuncionariosID(id);
        if (funcionario != null) {
            return ResponseEntity.ok(funcionario);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Funcionário com ID " + id + " não encontrado.");
        }
    }

    @Operation(summary = "Lista todos os funcionários", description = "Retorna uma lista com todos os funcionários cadastrados no sistema.")
    @ApiResponse(responseCode = "200", description = "Lista de funcionários retornada com sucesso")
    @GetMapping("/listar")
    public ResponseEntity<List<FuncionarioDTO>> listarFuncionarios() {
        List<FuncionarioDTO> funcionarios = funcionariosService.listarFuncionarios();
        return ResponseEntity.ok(funcionarios);
    }

    @Operation(summary = "Cria um novo funcionário", description = "Cadastra um novo funcionário no sistema. O ID é gerado automaticamente.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Funcionário criado com sucesso"),
            @ApiResponse(responseCode = "400", description = "Dados inválidos fornecidos no corpo da requisição")
    })
    @PostMapping("/criar")
    public ResponseEntity<String> criarFuncionario(@RequestBody FuncionarioDTO funcionarioDTO) {
        FuncionarioDTO novoFuncionario = funcionariosService.criarFuncionario(funcionarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Funcionário criado com sucesso! Nome: " + novoFuncionario.getNome() + " (ID: " + novoFuncionario.getId() + ")");
    }

    @Operation(summary = "Atualiza um funcionário existente", description = "Altera os dados de um funcionário com base no seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Funcionário atualizado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Funcionário não encontrado com o ID fornecido")
    })
    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> alterarFuncionariosId(
            @Parameter(description = "ID do funcionário a ser atualizado", required = true)
            @PathVariable Long id,
            @RequestBody FuncionarioDTO funcionarioDTO) {
        FuncionarioDTO funcionarioAtualizado = funcionariosService.atualizarFuncionario(id, funcionarioDTO);
        if (funcionarioAtualizado != null) {
            return ResponseEntity.ok("Funcionário de ID " + id + " alterado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O funcionário com ID " + id + " não foi encontrado.");
        }
    }

    @Operation(summary = "Deleta um funcionário", description = "Remove um funcionário do sistema com base no seu ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Funcionário deletado com sucesso"),
            @ApiResponse(responseCode = "404", description = "Funcionário não encontrado com o ID fornecido")
    })
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarFuncionariosId(
            @Parameter(description = "ID do funcionário a ser deletado", required = true)
            @PathVariable Long id) {
        if (funcionariosService.listarFuncionariosID(id) != null) {
            funcionariosService.deletarFuncionarioID(id);
            return ResponseEntity.ok("Funcionário de ID " + id + " deletado com sucesso.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O funcionário com ID " + id + " não foi encontrado.");
        }
    }
}