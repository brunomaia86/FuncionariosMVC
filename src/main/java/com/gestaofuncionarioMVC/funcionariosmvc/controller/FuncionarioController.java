package com.gestaofuncionarioMVC.funcionariosmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gestaofuncionarioMVC.funcionariosmvc.domain.Cargo;
import com.gestaofuncionarioMVC.funcionariosmvc.domain.Funcionario;
import com.gestaofuncionarioMVC.funcionariosmvc.domain.UF;
import com.gestaofuncionarioMVC.funcionariosmvc.service.CargoService;
import com.gestaofuncionarioMVC.funcionariosmvc.service.FuncionarioService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {

	@Autowired
	private FuncionarioService funcionarioService;

	@Autowired
	private CargoService cargoService;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Funcionario funcionario) {
		return "/funcionario/cadastro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("listaFuncionarios", funcionarioService.buscarTodos());
		return "/funcionario/lista";
	}

	@PostMapping("/salvar")
	public String salvar(Funcionario funcionario, RedirectAttributes redAttr) {
		funcionarioService.salvar(funcionario);
		redAttr.addFlashAttribute("success", "Funcionário salvo com sucesso!");
		return "redirect:/funcionarios/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model ) {
		model.addAttribute("funcionario", funcionarioService.buscarPorId(id));
		return "funcionario/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Funcionario funcionario, RedirectAttributes redAttr) {
		funcionarioService.editar(funcionario);
		redAttr.addFlashAttribute("success", "Funcionário editado com sucesso!!!");
		return "redirect:/funcionarios/listar";
	}
	
	@GetMapping("/remover/{id}")
	public String remover(@PathVariable("id") Long id, RedirectAttributes redAttr) {
		funcionarioService.excluir(id);
		redAttr.addFlashAttribute("success", "Funcionário removido com sucesso");
		return "redirect:/funcionarios/listar";
	}
	
	@GetMapping("/buscar/nome")
	public String buscarListPorNome(@RequestParam("nome") String nome, ModelMap model) {
		model.addAttribute("listaFuncionarios", funcionarioService.buscarPorNome(nome));
		return "/funcionario/lista";
	}
	
	@ModelAttribute("cargos")
	public List<Cargo> listaDeCargos() {
		return cargoService.buscarTodos();
	}
	
	@GetMapping("/buscar/cargo")
	public String buscarListPorCargo(@RequestParam("id") Long id, ModelMap model){
		model.addAttribute("listaFuncionarios",funcionarioService.buscarPorCargo(id));
		return "/funcionario/lista";
	}
	
	@ModelAttribute("ufs")
	public UF[] listaDeUf() {
		return UF.values();
	}
}