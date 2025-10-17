package dev.Daniel.CadastroDeFuncionarios.Funcionarios;

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
    public FuncionarioDTO mostrarFuncionariosId(@PathVariable Long id) {
        return funcionariosService.listarFuncionariosID(id);
    }

    @GetMapping("/listar")
    public List<FuncionarioDTO> listarFuncionarios() {
        return funcionariosService.listarFuncionarios();
    }

    @PostMapping("/criar")
    public FuncionarioDTO criarFuncionarios(@RequestBody FuncionarioDTO funcionarioDTO) {
        return funcionariosService.criarFuncionario(funcionarioDTO);
    }

    @PutMapping("/alterar/{id}")
    public ResponseEntity<FuncionarioDTO> alterarFuncionariosId(@PathVariable Long id, @RequestBody FuncionarioDTO funcionarioAtualizado) {
        FuncionarioDTO funcionario = funcionariosService.atualizarFuncionario(id, funcionarioAtualizado);
        return null;
    }

    @DeleteMapping("/deletar/{id}")
    public void deletarFuncionariosId(@PathVariable Long id) {
        funcionariosService.deletarFuncionarioID(id);

    }
}