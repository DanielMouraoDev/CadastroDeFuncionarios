package dev.Daniel.CadastroDeFuncionarios.Funcionarios;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FuncionariosService {

    private final FuncionariosRepository funcionariosRepository;
    private final FuncionarioMapper funcionarioMapper;


    public FuncionariosService(FuncionariosRepository funcionariosRepository, FuncionarioMapper funcionarioMapper) {
        this.funcionariosRepository = funcionariosRepository;
        this.funcionarioMapper = funcionarioMapper;
    }

    //listar
    public List<FuncionarioDTO> listarFuncionarios() {
       List<FuncionarioModel> funcionarios = funcionariosRepository.findAll();
       return funcionarios.stream()
               .map(funcionarioMapper::map)
               .collect(Collectors.toList());
    }

    // listar por id
    public FuncionarioDTO listarFuncionariosID(Long id) {
        Optional<FuncionarioModel> funcionarioporID = funcionariosRepository.findById(id);
        return funcionarioporID.map(funcionarioMapper::map).orElse(null);
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
    public FuncionarioDTO atualizarFuncionario(Long id, FuncionarioDTO funcionarioDTO) {
        Optional<FuncionarioModel> funcionarioExistente = funcionariosRepository.findById(id);

        if (funcionarioExistente.isPresent()) {
            FuncionarioModel funcionarioAtualizado = funcionarioMapper.map(funcionarioDTO);
            funcionarioAtualizado.setId(id);
            FuncionarioModel funcionarioSalvo = funcionariosRepository.save(funcionarioAtualizado);
            return funcionarioMapper.map(funcionarioSalvo);
        }

        return null;
    }

    }
