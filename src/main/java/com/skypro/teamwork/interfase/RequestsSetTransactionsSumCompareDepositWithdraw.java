package com.skypro.teamwork.interfase;

import com.skypro.teamwork.model.Requests;
import com.skypro.teamwork.repository.RecommendationsRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class RequestsSetTransactionsSumCompareDepositWithdraw implements RequestsSet {
    private final RecommendationsRepository repository;
    private final MethodOperator method;

    public RequestsSetTransactionsSumCompareDepositWithdraw(RecommendationsRepository repository, MethodOperator method) {
        this.repository = repository;
        this.method = method;
    }
    @Override
    public List<Requests> getRequests(UUID id, List<String> listArguments) {
        List<Requests> requestsList = List.of(new Requests(4L, "TransactionsSumCompareDepositWithdraw", listArguments,
                (method.operator((repository.sum(id, listArguments.get(0), "DEPOSIT")),
                        listArguments.get(1), (repository.sum(id, listArguments.get(1)
                                , " WITHDRAW"))
                ))));
        return requestsList;
    }
}
