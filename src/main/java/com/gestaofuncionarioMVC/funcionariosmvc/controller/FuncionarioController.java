package com.gestaofuncionarioMVC.funcionariosmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	public String listar() {
		return "/funcionario/lista";
	}

	@PostMapping("/salvar")
	public String salvar(Funcionario funcionario, RedirectAttributes redAttr) {
		funcionarioService.salvar(funcionario);
		redAttr.addFlashAttribute("success", "Funcionario salvo com sucesso!");
		return "redirect:/funcionarios/listar";
	}
	
	@ModelAttribute("cargos")
	public List<Cargo> listaDeCargos() {
		return cargoService.buscarTodos();
	}
	
	@ModelAttribute("ufs")
	public UF[] listaDeUf() {
		return UF.values();
	}
}