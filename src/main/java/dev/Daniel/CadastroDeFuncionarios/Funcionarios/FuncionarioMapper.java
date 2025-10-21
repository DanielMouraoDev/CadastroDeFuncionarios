package dev.Daniel.CadastroDeFuncionarios.Funcionarios;

// Adicione estes imports
import dev.Daniel.CadastroDeFuncionarios.Cargos.CargosModel;
import dev.Daniel.CadastroDeFuncionarios.Cargos.CargosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FuncionarioMapper {

    @Autowired
    private CargosRepository cargosRepository;

    public FuncionarioModel map(FuncionarioDTO funcionarioDTO) {
        FuncionarioModel funcionarioModel = new FuncionarioModel();
        funcionarioModel.setId(funcionarioDTO.getId());
        funcionarioModel.setNome(funcionarioDTO.getNome());
        funcionarioModel.setEmail(funcionarioDTO.getEmail());
        funcionarioModel.setIdade(funcionarioDTO.getIdade());
        funcionarioModel.setSenioridade(funcionarioDTO.getSenioridade());

        if (funcionarioDTO.getCargoId() != null) {
            CargosModel cargo = cargosRepository.findById(funcionarioDTO.getCargoId()).orElse(null);
            funcionarioModel.setCargosModel(cargo);
        }

        return funcionarioModel;
    }

    public FuncionarioDTO map(FuncionarioModel funcionarioModel) {
        FuncionarioDTO funcionarioDTO = new FuncionarioDTO();
        funcionarioDTO.setId(funcionarioModel.getId());
        funcionarioDTO.setNome(funcionarioModel.getNome());
        funcionarioDTO.setEmail(funcionarioModel.getEmail());
        funcionarioDTO.setIdade(funcionarioModel.getIdade());
        funcionarioDTO.setSenioridade(funcionarioModel.getSenioridade());
        funcionarioDTO.setCargo(funcionarioModel.getCargosModel());

        if (funcionarioModel.getCargosModel() != null) {
            funcionarioDTO.setCargoId(funcionarioModel.getCargosModel().getId());
        }

        return funcionarioDTO;
    }
}