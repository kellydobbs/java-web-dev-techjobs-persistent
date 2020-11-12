package org.launchcode.javawebdevtechjobspersistent.controllers;

import org.launchcode.javawebdevtechjobspersistent.models.Job;
import org.launchcode.javawebdevtechjobspersistent.models.data.EmployerRepository;
import org.launchcode.javawebdevtechjobspersistent.models.data.JobRepository;
import org.launchcode.javawebdevtechjobspersistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.launchcode.javawebdevtechjobspersistent.models.JobData;

import java.util.HashMap;

/**
 * Created by LaunchCode
 */
@Controller
@RequestMapping(value = "list")
public class ListController {

    @Autowired
    private JobRepository jobRepository;

    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private SkillRepository skillRepository;


    static HashMap<String, String> columnChoices = new HashMap<>();

    public ListController () {

        columnChoices.put("all", "All");
        columnChoices.put("position", "Position");
        columnChoices.put("employer", "Employer");
        columnChoices.put("skill", "Skill");
        columnChoices.put("location", "Location");

    }

    @RequestMapping("")
    public String list(Model model) {
        model.addAttribute("employers", employerRepository.findAll());
        model.addAttribute("skills", skillRepository.findAll());
        model.addAttribute("location", employerRepository.findAll());
        model.addAttribute("position", jobRepository.findAll());
        return "list";
    }


    @RequestMapping(value = "jobs")
    public String listJobsByColumnAndValue(Model model, @RequestParam String column, @RequestParam String value) {

        Iterable<Job> jobs;
        if (column.toLowerCase().equals("all")){
            jobs = jobRepository.findAll();
            System.out.println(jobs);
            if (!jobs.iterator().hasNext()) {
                model.addAttribute("title", "No jobs");
            } else {
                model.addAttribute("title", "All Jobs");
            }

        } else {
            jobs = JobData.findByColumnAndValue(column, value, jobRepository.findAll());

            if (!jobs.iterator().hasNext()) {
                model.addAttribute("title", "No jobs with " + columnChoices.get(column) + ": " + value);
            } else {
                model.addAttribute("title", "Jobs with " + columnChoices.get(column) + ": " + value);

            }
        }

        model.addAttribute("jobs", jobs);


        return "list-jobs";
    }
}
