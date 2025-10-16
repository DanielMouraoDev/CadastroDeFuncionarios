package dev.Daniel.CadastroDeFuncionarios.Funcionarios;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class FuncionarioController {

    private FuncionariosService funcionariosService;

    public FuncionarioController(FuncionariosService funcionariosService) {
        this.funcionariosService = funcionariosService;
    }

    @GetMapping("/boasvindas")
    public String boasvindas () {
            return "Essa é a minha primeira menssagem na rota";
    }

    @GetMapping("/listarid")
    public String mostrarFuncionariosId() {
        return "Mostrar funcionario por id";
    }

    @PostMapping ("/criar")
    public String criarFuncionarios() {
            return "Criar funcionario";
        }

        @GetMapping("/listar")
        public List<FuncionarioModel> listarFuncionarios() {
        return funcionariosService.listarFuncionarios();

            }

            @PutMapping("alterarID")
            public String alterarFuncionariosId () {
                return "alterar funcionario por id";
            }

                @DeleteMapping("/deletarID")
                public String deletarFuncionariosId () {
                    return "deletar funcionario por id";
        }
    }