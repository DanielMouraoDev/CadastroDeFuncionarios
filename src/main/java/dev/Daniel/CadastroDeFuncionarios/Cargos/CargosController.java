package dev.Daniel.CadastroDeFuncionarios.Cargos;

import dev.Daniel.CadastroDeFuncionarios.Funcionarios.FuncionarioModel;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cargos")
public class CargosController {

    private CargosService cargosService;

    public CargosController(CargosService cargosService) {
        this.cargosService = cargosService;
    }

    @PostMapping("/criar")
    public CargosModel criarCargos(@RequestBody CargosModel cargos) {
        return cargosService.criarCargos(cargos);
    }

    @GetMapping("/listar/{id}")
    public CargosModel listarCargosID(@PathVariable Long id) {
        return cargosService.listarCargosID(id);
    }

    @GetMapping("/listar")
    public List<CargosModel> listarcargos() {
        return cargosService.listarCargos();
    }

    @PutMapping("alterar/{id}")
    public CargosModel alterarCargoID (@PathVariable Long id, @RequestBody CargosModel cargoAtualizado) {
        return cargosService.cargosAtualizado(id, cargoAtualizado);
    }

    @DeleteMapping("/deletarID/{id}")
    public void deletarCargosID (long id) {
        cargosService.deletarCargosID(id);
    }


}
