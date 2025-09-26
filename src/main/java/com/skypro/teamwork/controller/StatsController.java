package com.skypro.teamwork.controller;

import com.skypro.teamwork.model.RecommendationDTO;
import com.skypro.teamwork.model.Recommendations;
import com.skypro.teamwork.model.Stats;
import com.skypro.teamwork.service.RecommendationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/rule")
public class StatsController {
    private final RecommendationService service;


    public StatsController(RecommendationService service) {

        this.service = service;

    }
    @GetMapping(path = "/stats")
    public List<Stats>  getCount() {
        return service.countRule();

    }
}
