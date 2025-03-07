package com.skypro.teamwork.controller;

import com.skypro.teamwork.service.RecommendationService;
import org.h2.engine.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(path = "/controller")
public class RecommendationController {
    private final RecommendationService service;

    public RecommendationController(RecommendationService service) {
        this.service = service;
    }

    @GetMapping(path = "/get")
public int get(UUID id){
        return service.getСonditions(id);

    }
    @GetMapping(path = "/getAll")
    public JdbcTemplate getAll(){
        return service.getAll();
    }

}
