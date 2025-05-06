package com.skypro.teamwork.interfase;

import com.skypro.teamwork.model.Requests;
import com.skypro.teamwork.repository.RecommendationsRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class RequestsSetTransactionsSumCompare implements RequestsSet {
    private final RecommendationsRepository repository;
    private final MethodOperator method;

    public RequestsSetTransactionsSumCompare(RecommendationsRepository repository, MethodOperator method) {
        this.repository = repository;
        this.method = method;
    }
    @Override
    public List<Requests> getRequests(UUID id, List<String> listArguments) {
        int newNum = Integer.parseInt(listArguments.get(3));

        List<Requests> requestsList = List.of(new Requests(3L,
                "Transaction_Sum_Compare", listArguments,
                method.operator(repository.sum(id, listArguments.get(0), listArguments.get(1)), listArguments.get(2), newNum)));
        return requestsList;
    }
}
