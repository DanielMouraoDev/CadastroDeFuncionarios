package dev.Daniel.CadastroDeFuncionarios.Funcionarios;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionariosService {

    private final FuncionariosRepository funcionariosRepository;
    private final FuncionarioMapper funcionarioMapper;

    // APENAS UM CONSTRUTOR. Agora o Spring sabe exatamente o que fazer.
    public FuncionariosService(FuncionariosRepository funcionariosRepository, FuncionarioMapper funcionarioMapper) {
        this.funcionariosRepository = funcionariosRepository;
        this.funcionarioMapper = funcionarioMapper;
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
    public FuncionarioDTO criarFuncionario(FuncionarioDTO funcionarioDTO) {
        FuncionarioModel funcionario = funcionarioMapper.map(funcionarioDTO);
        funcionario = funcionariosRepository.save(funcionario);
        return funcionarioMapper.map(funcionario);
    }

    //deletar
    public void deletarFuncionarioID(Long id) {
        funcionariosRepository.deleteById(id);
    }

    //ALTERAR
    public FuncionarioModel atualizarFuncionario (Long id, FuncionarioModel funcionarioAtualizado) {
        if (funcionariosRepository.existsById(id)) {
            funcionarioAtualizado.setId(id);
            return funcionariosRepository.save(funcionarioAtualizado);
        }
        return null;
    }
}