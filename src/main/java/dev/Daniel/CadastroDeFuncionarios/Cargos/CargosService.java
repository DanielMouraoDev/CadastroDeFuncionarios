package dev.Daniel.CadastroDeFuncionarios.Cargos;

import dev.Daniel.CadastroDeFuncionarios.Funcionarios.FuncionarioModel;
import dev.Daniel.CadastroDeFuncionarios.Funcionarios.FuncionariosRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CargosService {

    private CargosRepository cargosRepository;

    public CargosService(CargosRepository cargosRepositoryRepository) {
        this.cargosRepository = cargosRepositoryRepository;
    }

    //LISTAR

    public List<CargosModel> listarCargos() {
        return cargosRepository.findAll();
    }
        //LISTARPORID

        public CargosModel listarCargosID(Long id) {
            Optional<CargosModel> cargosporID = cargosRepository.findById(id);
            return cargosporID.orElse(null);
    }
        //CRIAR

        public CargosModel criarCargos(CargosModel cargos) {
        return cargosRepository.save(cargos);
    }
}
