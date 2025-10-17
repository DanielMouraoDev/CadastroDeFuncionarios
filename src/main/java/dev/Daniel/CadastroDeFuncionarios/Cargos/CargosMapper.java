package dev.Daniel.CadastroDeFuncionarios.Cargos;

import org.springframework.stereotype.Component;

@Component
public class CargosMapper {

    public CargosModel map(CargosDTO cargosDTO) {

        CargosModel cargosModel = new CargosModel();
        cargosModel.setId(cargosDTO.getId());
        cargosModel.setCargo(cargosDTO.getCargo());
        cargosModel.setSalario(cargosDTO.getSalario());

        return cargosModel;
    }

    public CargosDTO map(CargosModel cargosModel) {

        CargosDTO cargosDTO = new CargosDTO();
        cargosModel.setId(cargosModel.getId());
        cargosModel.setCargo(cargosModel.getCargo());
        cargosModel.setSalario(cargosDTO.getSalario());

        return cargosDTO;
    }

}
