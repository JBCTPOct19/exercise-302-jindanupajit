package com.jindanupajit.javabootcamp.exercise3021;

import com.jindanupajit.javabootcamp.exercise3021.entity.Task;
import com.jindanupajit.javabootcamp.exercise3021.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/task/all")
    public String taskPage(Model model) {
        model.addAttribute("tasks",taskRepository.findAll());
        return "tasks";
    }

    @GetMapping("/task/new")
    public String taskAddPage(Model model) {
        model.addAttribute( "task", new Task());
        return "task_new";
    }

    @PostMapping("/task/new/process")
    public String taskNewProcessForm(@Valid Task task, BindingResult result) {

        if (result.hasErrors()) {
            System.out.print("result error: "+result.toString());
           return "task_new"; }

        taskRepository.save(task);
        return "redirect:/task/all";
    }



}
