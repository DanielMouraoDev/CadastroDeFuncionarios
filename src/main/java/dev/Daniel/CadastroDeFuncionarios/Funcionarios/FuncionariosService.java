package dev.Daniel.CadastroDeFuncionarios.Funcionarios;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionariosService {

    private FuncionariosRepository funcionariosRepository;

    public FuncionariosService(FuncionariosRepository funcionariosRepository) {
        this.funcionariosRepository = funcionariosRepository;

    }

    public List<FuncionarioModel> listarFuncionarios() {
        return funcionariosRepository.findAll();
    }
}



