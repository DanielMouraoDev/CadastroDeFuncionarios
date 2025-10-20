package dev.Daniel.CadastroDeFuncionarios.Funcionarios;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private FuncionariosService funcionariosService;

    public FuncionarioController(FuncionariosService funcionariosService) {
        this.funcionariosService = funcionariosService;
    }

    @GetMapping("/boasvindas")
    public String boasvindas() {
        return "Essa é a minha primeira menssagem na rota";
    }

    @GetMapping("/listar/{id}")
    public ResponseEntity<?> mostrarFuncionariosId(@PathVariable Long id) {
        FuncionarioDTO funcionario = funcionariosService.listarFuncionariosID(id);
        if (funcionario != null) {
            return ResponseEntity.ok("Funcionario encontrados:" + funcionario.getNome());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Funcionario com id " + id + "  nao encontrado");
        }
    }


    @GetMapping("/listar")
    public ResponseEntity<List<FuncionarioDTO>> listarFuncionarios() {
        List<FuncionarioDTO> funcionarios = funcionariosService.listarFuncionarios();
        return ResponseEntity.ok(funcionarios);
    }

    @PostMapping("/criar")
    public ResponseEntity<String> criarFuncionario(@RequestBody FuncionarioDTO funcionarioDTO) {
        FuncionarioDTO novoFuncionario = funcionariosService.criarFuncionario(funcionarioDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Funcionario criado com sucesso!:" + novoFuncionario.getNome() + " (ID):" + novoFuncionario.getId());
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<String> alterarFuncionariosId(@PathVariable Long id, @RequestBody FuncionarioDTO funcionarioDTO) {
        FuncionarioDTO funcionarioAtualizado = funcionariosService.atualizarFuncionario(id, funcionarioDTO);
        if (funcionarioAtualizado != null) {
            return ResponseEntity.ok("Funcionario de ID " + id + " alterado com sucesso!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O funcionario com ID " + id + " não foi encontrado.");
        }
    }
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarFuncionariosId(@PathVariable Long id) {
        if (funcionariosService.listarFuncionariosID(id) != null) {
            funcionariosService.deletarFuncionarioID(id);
            return ResponseEntity.ok("Funcionario de ID" + id + " deletado com sucesso");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("O funcionario nao foi encontrado");

        }
    }
}