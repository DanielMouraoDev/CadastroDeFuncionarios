package dev.Daniel.CadastroDeFuncionarios.Funcionarios;

import org.springframework.stereotype.Component;

@Component
public class FuncionarioMapper {

    public FuncionarioModel map(FuncionarioDTO funcionarioDTO) {


        FuncionarioModel funcionarioModel = new FuncionarioModel();
        funcionarioModel.setId(funcionarioDTO.getId());
        funcionarioModel.setNome(funcionarioDTO.getNome());
        funcionarioModel.setEmail(funcionarioDTO.getEmail());
        funcionarioModel.setIdade(funcionarioDTO.getIdade());
        funcionarioModel.setSenioridade(funcionarioDTO.getSenioridade());
        funcionarioModel.setCargosModel(funcionarioDTO.getCargo());

        return funcionarioModel;
    }

    public FuncionarioDTO map(FuncionarioModel funcionarioModel) {

        FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
        funcionarioDTO.setId(funcionarioModel.getId());
        funcionarioDTO.setNome(funcionarioModel.getNome());
        funcionarioDTO.setEmail(funcionarioModel.getEmail());
        funcionarioDTO.setIdade(funcionarioModel.getIdade());
        funcionarioDTO.setSenioridade(funcionarioModel.getSenioridade());

        return funcionarioDTO;

    }
}
