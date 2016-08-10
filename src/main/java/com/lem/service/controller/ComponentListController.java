package com.lem.service.controller;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.lem.constants.Constants;
import com.lem.service.manager.ComplexityTypeService;
import com.lem.service.manager.ComponentListService;
import com.lem.service.manager.EstimationModelTypeService;
import com.lem.service.manager.ProjectDetailsService;
import com.lem.service.model.ComplexityType;
import com.lem.service.model.ComponentList;
import com.lem.service.model.EstimationModelType;
import com.lem.service.model.ProjectDetails;

/**
 * 
 * @author ukathinokkula
 * 
 */
@Controller
@RequestMapping("/lem/component/")
public class ComponentListController {

	private static final Logger logger = Logger
			.getLogger(ComponentListController.class);

	@Autowired
	protected ComponentListService componentListService;
	
	@Autowired
	protected ComplexityTypeService complexityTypeService;
	
	@Autowired
	protected EstimationModelTypeService estimationModelTypeService;
	
	@Autowired
	protected ProjectDetailsService projectDetailsService;

	@RequestMapping(value = "/addComponent", method = RequestMethod.POST)
	public ModelAndView addComponentList(@ModelAttribute ComponentList componentList, HttpServletRequest request)
			throws Exception {
		Long projectId = Long.parseLong(request.getParameter("projectId").trim());
		
		Double totalHours = Double.valueOf(request.getParameter("hours").trim());
		componentList.setTotalHours(totalHours);
		componentListService.addComponentList(componentList, projectId);
		
		ModelAndView model = new ModelAndView("homePage");
		List<ProjectDetails> projectDetails = projectDetailsService.getActiveProjectDetails();

		model.addObject("projectList", projectDetails);
		return model;
	}
	
	@RequestMapping(value = "/openAddComponentPage", method = RequestMethod.GET)
	public ModelAndView openAddComponentPage(@ModelAttribute ComponentList componentList, HttpServletRequest request)
			throws Exception {
		Long projectId = Long.parseLong(request.getParameter("projectId").trim());
		ModelAndView model = new ModelAndView("component/addComponent");
		model.addObject("projectId",projectId);
		List<ComplexityType> complexityTypeList= complexityTypeService.getActiveComplexityTypes();
		model.addObject("complexityTypeList",complexityTypeList);
		List<EstimationModelType> estimationModelTypeList= estimationModelTypeService.getActiveEstimationModelTypes();
		model.addObject("estimationModelTypeList",estimationModelTypeList);
		return model;
	}

	@RequestMapping(value = "/incativateComponentList")
	public @ResponseBody
	Integer incativateComponentList(@RequestParam(value = "id") Long componentListId,
			Integer status) throws Exception {
		logger.info("entered incativateComponentList with id -->"+ componentListId + "  " + status);
		if (status == 0) {
			componentListService.updateComponentListStatus(componentListId, 1);
			return 1;
		} else if (status == 1) {
			componentListService.updateComponentListStatus(componentListId, 0);
			return 0;
		}

		return 0;
	}

	@RequestMapping(value = "/componentListByProjectId")
	public ModelAndView getComponentListByProjectId(HttpServletRequest request)
			throws Exception {
		
		Long projectId = Long.parseLong(request.getParameter("projectId").trim());
		ModelAndView model = new ModelAndView("component/viewComponentList");
		List<ComponentList> componentList = componentListService.getComponentsByProjectIdAndStatus(projectId, Constants.ACTIVE);
		Double totalProjectHours = componentListService.getTotalProjectHours(projectId, Constants.ACTIVE);
		model.addObject("componentList", componentList);
		model.addObject("projectId", projectId);
		model.addObject("totalProjectHours", totalProjectHours);
		
		
		//Pie chart start
		 
		 Map<String, Integer> dataMap = new HashMap<String, Integer>();
		 for (ComponentList cl : componentList) {
			 if(dataMap.containsKey(cl.getComplexityType().getComplexityType())) {
				Integer count = dataMap.get(cl.getComplexityType().getComplexityType());
				count = count + cl.getComponentCount();
				dataMap.put(cl.getComplexityType().getComplexityType(), count);
			 } 
			 else {
				 dataMap.put(cl.getComplexityType().getComplexityType(), cl.getComponentCount());
			 }
			 
		}
		
		DefaultPieDataset chartData = new DefaultPieDataset(); 
		for (Map.Entry<String, Integer> entry : dataMap.entrySet()) {
			chartData.setValue(entry.getKey()+":"+entry.getValue(), entry.getValue());
		}
		
		/* URL location = ComponentListController.class.getProtectionDomain().getCodeSource()
		            .getLocation();
		    String path = location.getFile();
		System.out.println("path >>>>"+path);*/
		JFreeChart chart = ChartFactory.createPieChart("Pie Chart ", chartData, true, true, false);
        try {
            final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection()); 
            final File imageFile = new File(request.getServletContext().getRealPath("/")+"resources/img/piechart.png");
            ChartUtilities.saveChartAsPNG(imageFile, chart, 600, 400, info);
        } catch (Exception e) {
            System.out.println(e);
        }
		model.addObject("chart", chart);
		//Pie chart end
		
		return model;
	}

	@RequestMapping(value = "/openEditComponentPage")
	public ModelAndView openEditComponentPage(HttpServletRequest request)
			throws Exception {
		Long id = Long.parseLong(request.getParameter("id").trim());
		ModelAndView model = new ModelAndView("component/editComponent");
		ComponentList component = componentListService.getComponentListById(id);
		model.addObject("componentList", component);
		
		List<ComplexityType> complexityTypeList= complexityTypeService.getActiveComplexityTypes();
		model.addObject("complexityTypeList",complexityTypeList);
		List<EstimationModelType> estimationModelTypeList= estimationModelTypeService.getActiveEstimationModelTypes();
		model.addObject("estimationModelTypeList",estimationModelTypeList);
		
		return model;
	}
	
	@RequestMapping(value = "/editComponent", method = RequestMethod.POST)
	public ModelAndView editComponentList(@ModelAttribute ComponentList componentList, HttpServletRequest request)
			throws Exception {
		
		Long projectId = Long.valueOf(request.getParameter("projectId"));
		
		if (null != request.getParameter("hours").trim()
				&& "" != request.getParameter("hours").trim()) {
			Double totalHours = Double.valueOf(request.getParameter("hours").trim());
			componentList.setTotalHours(totalHours);
		}		
				
		componentListService.updateComponentListById(componentList, projectId);
		
		ModelAndView model = new ModelAndView("homePage");
		List<ProjectDetails> projectDetails = projectDetailsService.getActiveProjectDetails();
		model.addObject("projectList", projectDetails);
		
		return model;
	}
	
	@RequestMapping(value = "/componentById")
	public ModelAndView getComponentById(HttpServletRequest request)
			throws Exception {
		Long componentId = Long.parseLong(request.getParameter("id").trim());
		ModelAndView model = new ModelAndView("editComponentList");
		ComponentList component = componentListService.getComponentListById(componentId);
		model.addObject("component", component);
		return model;
	}
	
	@RequestMapping(value = "/loadTotalHours", method = RequestMethod.POST)
	public @ResponseBody 
	Double loadTotalHours(
			@RequestParam(value = "complexityType") Long complexityType, 
			@RequestParam(value = "componentCount") Integer componentCount, 
			@RequestParam(value = "newComponent") Integer newComponent)
			throws Exception {
		logger.info("Load hours for the complexityType:" + complexityType);
		ModelAndView modelAndView = new ModelAndView("component/addComponent");
		ComplexityType  complexityTypeOb = complexityTypeService.getComplexityTypeById(complexityType);
		Double totalHours = complexityTypeOb.getHours()*componentCount;
		//If same type of component is already implemented then we need not to spend much time on it.
		if (newComponent.intValue() == 0) {
			totalHours = (double) Math.round(totalHours * complexityTypeOb.getExistingComponentRatio());
		}
		
		modelAndView.addObject("totalHours", totalHours);
		return totalHours;
	}

	@RequestMapping(value = "/manageComponents")
	public ModelAndView manageComponents(HttpServletRequest request)
			throws Exception {
		
		Long projectId = Long.parseLong(request.getParameter("projectId").trim());
		ModelAndView model = new ModelAndView("component/manageComponents");
		List<ComponentList> activeComponents = componentListService.getComponentsByProjectIdAndStatus(projectId, Constants.ACTIVE);
		List<ComponentList> inactiveComponents = componentListService.getComponentsByProjectIdAndStatus(projectId, Constants.IN_ACTIVE);
		ProjectDetails pd = projectDetailsService.getProjectDetailsById(projectId);
		Double totalHours = Double.valueOf(0);
		for (ComponentList activeComponent: activeComponents) {
			totalHours+=activeComponent.getTotalHours();
		}
		model.addObject("totalHours", totalHours);
		model.addObject("activeComponents", activeComponents);
		model.addObject("inactiveComponents", inactiveComponents);
		model.addObject("projectId", projectId);
		model.addObject("projectName", pd.getName());
		return model;
	}
	
	@RequestMapping(value = "/loadTotalHoursByIds", method = RequestMethod.POST)
	public @ResponseBody Double loadTotalHoursByIds(
			@RequestParam(value = "selectedActiveComponentIds") Long[] selectedActiveComponentIds)
			throws Exception {
		logger.info("Load total hours for the selectedActiveComponentIds:" + selectedActiveComponentIds);
		ModelAndView modelAndView = new ModelAndView("component/manageComponents");
		Double  componentHours = componentListService.getTotalProjectHoursByIds(selectedActiveComponentIds);
		modelAndView.addObject("totalHours", componentHours);
		return componentHours;
	}
	
	@RequestMapping(value = "/addManageComponents", method = RequestMethod.POST)
	public ModelAndView addManageComponents(@ModelAttribute ComponentList components, HttpServletRequest request)
			throws Exception {
		
		//Setting active records
		Long[] selectedActiveComponentIds = components.getSelectedActiveComponentIds();
		
		if (null != selectedActiveComponentIds && selectedActiveComponentIds.length > 0) {
		
			for (int i = 0; i < selectedActiveComponentIds.length; i++) {
				if (null != selectedActiveComponentIds[i]) {
					componentListService.updateComponentListStatus(selectedActiveComponentIds[i], Constants.ACTIVE);
				}			
			}
		}
		
		//Setting inactive records		
		Long[] selectedInactiveComponentIds = components.getSelectedInactiveComponentIds();
		
		if (null != selectedInactiveComponentIds && selectedInactiveComponentIds.length > 0) {
		
			for (int i = 0; i < selectedInactiveComponentIds.length; i++) {
				if (null != selectedInactiveComponentIds[i]) {
					componentListService.updateComponentListStatus(selectedInactiveComponentIds[i], Constants.IN_ACTIVE);
				}			
			}
		}
		
		ModelAndView model = new ModelAndView("homePage");
		List<ProjectDetails> projectDetails = projectDetailsService.getActiveProjectDetails();

		model.addObject("projectList", projectDetails);
		
		return model;
	}
}
