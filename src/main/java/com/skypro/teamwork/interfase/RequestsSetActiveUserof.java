package com.skypro.teamwork.interfase;

import com.skypro.teamwork.model.Requests;
import com.skypro.teamwork.model.Type;
import com.skypro.teamwork.repository.RecommendationsRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class RequestsSetActiveUserof implements RequestsSet {
    private final RecommendationsRepository repository;
    private final MethodOperator method;

    public RequestsSetActiveUserof(RecommendationsRepository repository, MethodOperator method) {
        this.repository = repository;
        this.method = method;
    }
    @Override
    public List<Requests> getRequests(UUID id, List<String> listArguments) {
        List<Requests> requestsList = List.of(new Requests(2L, "Active_User_Of",
                List.of(listArguments.get(0)), repository.userOf(id, Type.valueOf(listArguments.get(0)))));
        return requestsList;
    }
}
