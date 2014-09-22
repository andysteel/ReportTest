package com.gmail.andersoninfonet.reporttest.main;

import java.sql.Connection;


import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;




import java.util.HashMap;
import java.util.Map;

import com.gmail.andersoninfonet.reporttest.connection.ConnectionFactory;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;





//import com.gmail.andersoninfonet.reporttest.modelo.Cliente;

public class RelatorioDeClientes {
	
	public static void main(String[] args) throws JRException, SQLException{
		
		final Connection con = new ConnectionFactory().getConnection();
		
		/*Utilizando uma lista de objetos para preencher o relatorio
		 * 
		List<Cliente> lista = new ArrayList<Cliente>();
		
		Cliente c1 = new Cliente();
		c1.setNome("Anderson Dias");
		c1.setEmail("andersoninfonet@gmail.com");
		c1.setTelefone("(21)99236-4439");
		
		
		Cliente c2 = new Cliente();
		c2.setNome("Luciana Neri");
		c2.setEmail("lucianabatera@gmail.com");
		c2.setTelefone("(21)97309-8963");
		
		Cliente c3 = new Cliente();
		c3.setNome("Eduardo Conceição");
		c3.setEmail("eduardo@gmail.com");
		c3.setTelefone("(21)99876-5432");
		
		Cliente c4 = new Cliente();
		c4.setNome("Nubia Conceição");
		c4.setEmail("nubia@gmail.com");
		c4.setTelefone("(21)99234-5678");
		
		lista.add(c1);
		lista.add(c2);
		lista.add(c3);
		lista.add(c4);*/
		
		System.out.println("compilando jrxml ...");
		JasperReport report = JasperCompileManager.compileReport("relatorios/RelatorioContatos.jrxml");
		
		/*para passar parametros para o relatório (filtros)
		*Map<String, Object> parametros = new HashMap<String, Object>();
	    *parametros.put( "nomeCliente", "F%" );
	    */
		
		System.out.println("preenchendo relatorio ...");
		JasperPrint print = JasperFillManager.fillReport(report, null, con);
		
		/*preenchendo direto do objeto, sem conexao com banco
		 * JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(lista));
		 */
		
		System.out.println("exportando para pdf ...");
		/*exportando e salvando no caminho informado
		*JasperExportManager.exportReportToPdfFile(print, "relatorios/RelatorioContatos.pdf");
		*/
		JasperExportManager.exportReportToPdf(print);
		
		JasperViewer view = new JasperViewer(print, true);
		view.setVisible(true);
		view.toFront();
		
		System.out.println("relatorio gerado.");
		
	}

}
