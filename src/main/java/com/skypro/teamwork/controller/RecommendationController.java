package com.skypro.teamwork.controller;

import com.skypro.teamwork.interfase.RecommendationRuleSet;
import com.skypro.teamwork.model.User;
import com.skypro.teamwork.service.RecommendationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/recommendation")
public class RecommendationController {
    private final RecommendationService service;


    public RecommendationController(RecommendationService service) {
        this.service = service;

    }

    @GetMapping(path = "/get")
    public String get(UUID id) {
        return service.getRecommendation(id);

    }


}
