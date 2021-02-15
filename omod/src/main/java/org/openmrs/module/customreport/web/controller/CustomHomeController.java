package org.openmrs.module.customreport.web.controller;

import org.openmrs.module.customreport.api.service.CustomReportService;
import org.openmrs.module.customreport.model.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CustomHomeController {
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
}
