package com.skypro.teamwork.controller;

import com.skypro.teamwork.interfase.RecommendationRuleSet;
import com.skypro.teamwork.model.RecommendationDTO;
import com.skypro.teamwork.model.Recommendations;
import com.skypro.teamwork.model.Request;
import com.skypro.teamwork.service.RecommendationService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/recommendation")
public class RecommendationController {
    private final RecommendationService service;


    public RecommendationController(RecommendationService service) {

        this.service = service;

    }

    @GetMapping(path = "/get")
    public List<RecommendationDTO> get(UUID id) {
        return service.getRecommendation(id);

    }

    @GetMapping(path = "/add")
    public List<Recommendations> add(UUID id) {
        return service.addRule(id);

    }

    @DeleteMapping(path = "/delete")
    public void delete(UUID id) {
        service.deleteRule(id);
    }

    @GetMapping(path = "/get_all")
    public List<Recommendations> getAll() {

        return service.getAll();

    }

    @GetMapping(path = "cache")
    public Recommendations getCache(UUID id) {

        return service.getName(id);

    }


}
