package dev.Daniel.CadastroDeFuncionarios.Funcionarios;

import dev.Daniel.CadastroDeFuncionarios.Cargos.CargosDTO;
import dev.Daniel.CadastroDeFuncionarios.Cargos.CargosService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/funcionarios/ui")
public class FuncionarioControllerUi {

    private final FuncionariosService funcionariosService;
    private final CargosService cargosService; // Dependência necessária para o formulário

    public FuncionarioControllerUi(FuncionariosService funcionariosService, CargosService cargosService) {
        this.funcionariosService = funcionariosService;
        this.cargosService = cargosService;
    }

    @GetMapping("/listar")
    public String listarFuncionarios(Model model) {
        List<FuncionarioDTO> funcionarios = funcionariosService.listarFuncionarios();
        model.addAttribute("funcionarios", funcionarios);
        return "ListarFuncionarios";
    }

    @GetMapping("/detalhes/{id}")
    public String mostrarDetalhesFuncionario(@PathVariable Long id, Model model) {
        FuncionarioDTO funcionario = funcionariosService.listarFuncionariosID(id);
        if (funcionario != null) {
            model.addAttribute("funcionario", funcionario);
            return "detalhes-funcionario"; // Renderiza a página de detalhes
        }
        return "redirect:/funcionarios/ui/listar"; // Se não encontrar, volta para a lista
    }

    @GetMapping("/novo")
    public String mostrarFormularioDeCadastro(Model model) {
        model.addAttribute("funcionario", new FuncionarioDTO()); // Objeto vazio para o formulário
        model.addAttribute("todosCargos", cargosService.listarCargos()); // Lista de cargos para o <select>
        return "formulario-funcionario";
    }

    @GetMapping("/alterar/{id}")
    public String mostrarFormularioDeAlteracao(@PathVariable Long id, Model model) {
        FuncionarioDTO funcionario = funcionariosService.listarFuncionariosID(id);
        if (funcionario != null) {
            model.addAttribute("funcionario", funcionario); // Objeto preenchido para o formulário
            model.addAttribute("todosCargos", cargosService.listarCargos());
            return "formulario-funcionario";
        }
        return "redirect:/funcionarios/ui/listar";
    }

    @PostMapping("/salvar")
    public String salvarFuncionario(@ModelAttribute("funcionario") FuncionarioDTO funcionarioDTO) {
        if (funcionarioDTO.getId() != null) {
            funcionariosService.atualizarFuncionario(funcionarioDTO.getId(), funcionarioDTO);
        } else {
            funcionariosService.criarFuncionario(funcionarioDTO);
        }
        return "redirect:/funcionarios/ui/listar"; // Redireciona para a lista após salvar
    }

    @GetMapping("/deletar/{id}")
    public String deletarFuncionarioId(@PathVariable Long id) {
        funcionariosService.deletarFuncionarioID(id);
        return "redirect:/funcionarios/ui/listar";
    }
}