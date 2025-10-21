package dev.Daniel.CadastroDeFuncionarios.Cargos;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cargos/ui")
public class CargosControllerUi {

    private final CargosService cargosService;

    public CargosControllerUi(CargosService cargosService) {
        this.cargosService = cargosService;
    }

    @GetMapping("/listar")
    public String listarCargos(Model model) {
        List<CargosDTO> cargos = cargosService.listarCargos();
        model.addAttribute("cargos", cargos);
        return "listar-cargos";
    }

    // 2. MOSTRA O FORMULÁRIO PARA CRIAR UM NOVO CARGO
    @GetMapping("/novo")
    public String mostrarFormularioDeCadastro(Model model) {
        model.addAttribute("cargo", new CargosDTO());
        return "formulario-cargo";
    }

    @GetMapping("/alterar/{id}")
    public String mostrarFormularioDeAlteracao(@PathVariable Long id, Model model) {
        CargosDTO cargo = cargosService.listarCargosID(id);
        if (cargo != null) {
            model.addAttribute("cargo", cargo);
            return "formulario-cargo";
        }
        return "redirect:/cargos/ui/listar";
    }

    @PostMapping("/salvar")
    public String salvarCargo(@ModelAttribute("cargo") CargosDTO cargosDTO) {
        if (cargosDTO.getId() != null) {
            cargosService.atualizarCargo(cargosDTO.getId(), cargosDTO);
        } else {
            cargosService.criarCargos(cargosDTO);
        }
        return "redirect:/cargos/ui/listar";
    }

    @GetMapping("/deletar/{id}")
    public String deletarCargo(@PathVariable Long id) {
        cargosService.deletarCargosID(id);
        return "redirect:/cargos/ui/listar";
    }
}