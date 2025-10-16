package dev.Daniel.CadastroDeFuncionarios.Funcionarios;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionariosService {

    private FuncionariosRepository funcionariosRepository;

    public FuncionariosService(FuncionariosRepository funcionariosRepository) {
        this.funcionariosRepository = funcionariosRepository;
    }

    public List<FuncionarioModel> listarFuncionarios() {
        return funcionariosRepository.findAll();
    }

    public FuncionarioModel listarFuncionariosID(Long id) {
        Optional<FuncionarioModel> funcionarioporID = funcionariosRepository.findById(id);
        return funcionarioporID.orElse(null);
    }
}



