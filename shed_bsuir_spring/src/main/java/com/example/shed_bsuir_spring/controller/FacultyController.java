package com.example.shed_bsuir_spring.controller;

import com.example.shed_bsuir_spring.service.FacultyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/fac")
public class FacultyController {
    private FacultyService facultyService;
}
