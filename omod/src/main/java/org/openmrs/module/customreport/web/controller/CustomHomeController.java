package org.openmrs.module.customreport.web.controller;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.openmrs.module.customreport.api.service.CustomReportService;
import org.openmrs.module.customreport.model.RegistrationCollection;
import org.openmrs.module.customreport.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.jasperreports.JasperReportsPdfView;

import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class CustomHomeController {
	
	@Autowired
	private ApplicationContext appContext;
	
	@Autowired
	CustomReportService customReportService;
	
	@ResponseBody
	@RequestMapping(value = "module/customreport/greeting", method = RequestMethod.GET)
	public String greeting() {
		return customReportService.welCome();
	}
	
	@ResponseBody
	@RequestMapping(value = "module/customreport/saveTeam", method = RequestMethod.POST)
	public void saveTeam(@RequestBody Team team) {
		customReportService.saveTeam(team);
	}
	
	@ResponseBody
	@RequestMapping(value = "module/customreport/getAllTeam", method = RequestMethod.GET)
	public List<Team> getAllTeam() {
		return customReportService.getAllTeam();
	}
	
	@ResponseBody
	@RequestMapping(value = "module/customreport/getAllRegCollection", method = RequestMethod.GET)
	public List<RegistrationCollection> getAllRegCollection() {
		return customReportService.getAllRegCollection();
	}
	
	@RequestMapping(value = "/module/customreport/pickReport", method = RequestMethod.GET)
	public ModelAndView getPdf() {
		JasperReportsPdfView view = new JasperReportsPdfView();
		view.setJdbcDataSource((DataSource) customReportService.getAllRegCollection());
		view.setUrl("classpath:RegistrationCollection.jrxml");
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("createdBy", "Admin");
		view.setApplicationContext(appContext);
		return new ModelAndView(view, params);
	}
	
	@ResponseBody
	@RequestMapping(value = "/module/customreport/getReport", method = RequestMethod.GET)
	public void getPdf(HttpServletResponse response) throws JRException, IOException {
		InputStream jasperStream = this.getClass().getResourceAsStream("/RegistrationCollection.jrxml");
		JasperDesign design = JRXmlLoader.load(jasperStream);
		JasperReport jasperReport = JasperCompileManager.compileReport(design);
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(customReportService.getAllRegCollection());
		Map<String, Object> params = new HashMap<String, Object>();
		//params.put("createdBy", "Admin");
		//JasperReport jasperReport = (JasperReport) JRLoader.loadObject(jasperStream);
		//JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, new JREmptyDataSource());
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, dataSource);
		
		response.setContentType("application/x-pdf");
		response.setHeader("Content-disposition", "inline; filename=Report.pdf");
		
		final OutputStream outStream = response.getOutputStream();
		JasperExportManager.exportReportToPdfStream(jasperPrint, outStream);
		System.out.println(dataSource);
	}
}
