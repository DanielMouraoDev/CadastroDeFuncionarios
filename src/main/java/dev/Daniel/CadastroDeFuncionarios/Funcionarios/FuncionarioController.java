package dev.Daniel.CadastroDeFuncionarios.Funcionarios;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class FuncionarioController {

    @GetMapping("/boasvindas")
    public String boasvindas () {
            return "Essa é a minha primeira menssagem na rota";
    }
}
