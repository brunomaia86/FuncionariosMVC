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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gestaofuncionarioMVC.funcionariosmvc.domain.Cargo;
import com.gestaofuncionarioMVC.funcionariosmvc.domain.Departamento;
import com.gestaofuncionarioMVC.funcionariosmvc.service.CargoService;
import com.gestaofuncionarioMVC.funcionariosmvc.service.DepartamentoService;

@Controller
@RequestMapping("/cargos")
public class CargoController {
	
	@Autowired
	private CargoService cargoService;
	
	@Autowired
	private DepartamentoService departamentoService;

	@GetMapping("/cadastrar")
	public String cadastrar(Cargo cargo) {
		return "/cargo/cadastro";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("cargos", cargoService.buscarTodos());
		return "/cargo/lista";
	}
	
	@PostMapping("/salvar")
	public String salvar(Cargo cargo, RedirectAttributes redAttr) {
		cargoService.salvar(cargo);
		redAttr.addFlashAttribute("success", "Cargo inserido com sucesso!");
		return "redirect:/cargos/cadastrar";
	}
	
	@ModelAttribute("departamentos")
	public List<Departamento> listaDeDepartamentos() {
		return departamentoService.buscarTodos();
	}
	
	@GetMapping("/editar/{id}")
	public String preeditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("cargo", cargoService.buscarPorId(id));
		return "cargo/cadastro";
	}
	
	@PostMapping("/editar")
	public String editar(Cargo cargo, RedirectAttributes redAttr) {
		cargoService.editar(cargo);
		redAttr.addFlashAttribute("success", "Cargo editado com sucesso!");
		return "redirect:/cargos/listar";
	}
	
}