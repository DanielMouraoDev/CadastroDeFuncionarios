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

    //listar
    public List<FuncionarioModel> listarFuncionarios() {
        return funcionariosRepository.findAll();
    }

    // listar por id
    public FuncionarioModel listarFuncionariosID(Long id) {
        Optional<FuncionarioModel> funcionarioporID = funcionariosRepository.findById(id);
        return funcionarioporID.orElse(null);
    }

    // criar
    public FuncionarioModel criarFuncionario(FuncionarioModel funcionario) {
        FuncionarioModel funcionarioSalvo = funcionariosRepository.save(funcionario);
        return funcionariosRepository.findById(funcionarioSalvo.getId()).orElse(null);
    }

    //deletar
    public void deletarFuncionarioID(Long id) {
         funcionariosRepository.deleteById(id);
    }
}



