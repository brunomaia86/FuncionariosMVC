package com.gestaofuncionarioMVC.funcionariosmvc;

import java.io.OutputStream;
import java.sql.Connection;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRExporter;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;

public class GeradorDeRelatorios {
	private Connection conexao;

	public GeradorDeRelatorios() {

	}

	public GeradorDeRelatorios(Connection conexao) {
		this.conexao = conexao;
	}

	public void geraPdfV1(String nomeArquivo, Map<String, Object> parametros, OutputStream saida,
			JRDataSource dataSource) {

		try {

			// compila jrxml em memoria
			JasperReport jasper = JasperCompileManager.compileReport(nomeArquivo);

			// preenche relatorio
			JasperPrint print = JasperFillManager.fillReport(jasper, parametros, dataSource);

			// exporta para pdf
			JRExporter exporter = new JRPdfExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, saida);

			exporter.exportReport();

		} catch (Exception e) {
			throw new RuntimeException("Erro ao gerar relatório", e);
		}
	}

	public void geraPdfV2(String nomeArquivo, Map<String, Object> parametros, OutputStream saida) {

		try {

			// compila jrxml em memoria
			JasperReport jasper = JasperCompileManager.compileReport(nomeArquivo);

			// preenche relatorio
			JasperPrint print = JasperFillManager.fillReport(jasper, parametros, conexao);

			// exporta para pdf
			JRExporter exporter = new JRPdfExporter();
			exporter.setParameter(JRExporterParameter.JASPER_PRINT, print);
			exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, saida);

			exporter.exportReport();

		} catch (Exception e) {
			throw new RuntimeException("Erro ao gerar relatório", e);
		}
	}
}
