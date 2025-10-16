package dev.Daniel.CadastroDeFuncionarios.Funcionarios;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class FuncionarioController {

    @GetMapping("/boasvindas")
    public String boasvindas () {
            return "Essa é a minha primeira menssagem na rota";
    }

    //CREATE
    @PostMapping
    @GetMapping("/todosID")
    public String mostrarFuncionariosId() {
        return "Mostrar funcionario por id";
    }

    //READ

    @GetMapping("/criar")
    public String criarFuncionarios() {
            return "Criar funcionario";
        }

            //READ
            @GetMapping("/todosID")
            public String mostrarFuncionarios() {
                return "Mostrar funcionarios";
            }


            //UPDATE
            @PutMapping("alterarID")
            public String alterarFuncionariosId () {
                return "alterar funcionario por id";
            }

                //DELETE
                @DeleteMapping("/deletarID")
                public String deletarFuncionariosId () {
                    return "deletar funcionario por id";
        }
    }