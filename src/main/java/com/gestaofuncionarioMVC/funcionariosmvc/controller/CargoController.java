package com.gestaofuncionarioMVC.funcionariosmvc.controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gestaofuncionarioMVC.funcionariosmvc.domain.Cargo;
import com.gestaofuncionarioMVC.funcionariosmvc.domain.Departamento;
import com.gestaofuncionarioMVC.funcionariosmvc.service.CargoService;
import com.gestaofuncionarioMVC.funcionariosmvc.service.DepartamentoService;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

@Controller
@RequestMapping("/cargos")
public class CargoController {

	@Autowired
	private CargoService cargoService;

	@Autowired
	private DepartamentoService departamentoService;

	@Autowired
	DataSource dataSource;

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

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes redAttr) {
		if (cargoService.cargoNaoPossuiFuncionarios(id)) {
			cargoService.excluir(id);
			redAttr.addFlashAttribute("success", "Cargo removido com sucesso!");
		} else
			redAttr.addFlashAttribute("fail", "Cargo possui funcionario(s). Não removido!");
		return "redirect:/cargos/listar";
	}

	@RequestMapping(value="/relatorio", method= RequestMethod.GET)
	public void gerarRelatorio(HttpServletRequest request, HttpServletResponse response) {
		try {

			InputStream inputStream = this.getClass().getResourceAsStream("/relatorios/listaCargos.jrxml");
			JasperDesign design = JRXmlLoader.load(inputStream);
			JasperReport jasperReport = JasperCompileManager.compileReport(design);

			List<Cargo> cvs = cargoService.buscarTodos();

			JRDataSource dataSource = new JRBeanCollectionDataSource(cvs);

			Map<String, Object> param = new HashMap<>();
			param.put("datasource", dataSource);
			//param.put("age", 22);

			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, param, dataSource);
			response.setContentType("application/pdf");
			response.setHeader("Content-Disposition", "inline: filename=CurriculumVitea.pdf");

			final OutputStream outputStream = response.getOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, outputStream);

		} catch (JRException e) {
			System.out.println("deu ruim 1");
		} catch (Exception e) {
			System.out.println("deu ruim 2");
		}
	}

}