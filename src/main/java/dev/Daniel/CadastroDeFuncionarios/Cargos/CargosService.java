package dev.Daniel.CadastroDeFuncionarios.Cargos;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CargosService {

    private final CargosRepository cargosRepository;
    private final CargosMapper cargosMapper;

    public CargosService(CargosRepository cargosRepository, CargosMapper cargosMapper) {
        this.cargosRepository = cargosRepository;
        this.cargosMapper = cargosMapper;
    }

    // LISTAR TODOS
    public List<CargosDTO> listarCargos() {
        List<CargosModel> cargos = cargosRepository.findAll();
        return cargos.stream()
                .map(cargosMapper::map)
                .collect(Collectors.toList());
    }

    // LISTAR POR ID
    public CargosDTO listarCargosID(Long id) {
        Optional<CargosModel> cargosporID = cargosRepository.findById(id);
        return cargosporID.map(cargosMapper::map).orElse(null);
    }

    // CRIAR
    public CargosDTO criarCargos(CargosDTO cargosDTO) {
        CargosModel cargo = cargosMapper.map(cargosDTO);
        cargo = cargosRepository.save(cargo);
        return cargosMapper.map(cargo);
    }

    // DELETAR
    public void deletarCargosID(Long id) {
        cargosRepository.deleteById(id);
    }

    public CargosDTO atualizarCargo(Long id, CargosDTO cargosDTO) {
        if (cargosRepository.existsById(id)) {
            CargosModel cargoAtualizado = cargosMapper.map(cargosDTO);
            cargoAtualizado.setId(id); // Garante que o ID correto está sendo atualizado
            CargosModel cargoSalvo = cargosRepository.save(cargoAtualizado);
            return cargosMapper.map(cargoSalvo);
        }
        return null;
    }
}