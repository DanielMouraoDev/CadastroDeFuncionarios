package dev.Daniel.CadastroDeFuncionarios.Funcionarios;

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
    public String boasvindas () {
            return "Essa é a minha primeira menssagem na rota";
    }

    @GetMapping("/listar/{id}")
    public FuncionarioModel mostrarFuncionariosId(@PathVariable Long id) {
        return funcionariosService.listarFuncionariosID(id);
    }

    @PostMapping ("/criar")
    public FuncionarioModel criarFuncionarios(@RequestBody FuncionarioModel funcionario) {
            return funcionariosService.criarFuncionario(funcionario);
        }

        @GetMapping("/listar")
        public List<FuncionarioModel> listarFuncionarios() {
        return funcionariosService.listarFuncionarios();

            }

            @PutMapping("alterar/{id}")
            public FuncionarioModel alterarFuncionariosId (@PathVariable Long id, @RequestBody FuncionarioModel funcionarioAtualizado) {
                return funcionariosService.atualizarFuncionario(id, funcionarioAtualizado);
            }

                @DeleteMapping("/deletarID/{id}")
                public void deletarFuncionariosId (@PathVariable Long id) {
                    funcionariosService.deletarFuncionarioID(id);
        }
    }

