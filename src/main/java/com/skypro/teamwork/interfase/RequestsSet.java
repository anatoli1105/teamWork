package com.skypro.teamwork.interfase;

import com.skypro.teamwork.model.Recommendations;
import com.skypro.teamwork.model.Request;
import com.skypro.teamwork.model.Type;
import com.skypro.teamwork.repository.RecommendationsRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class RequestsSet {

   private final RecommendationsRepository repository;
    private final MethodOperator method;
    private final Request request;


    public RequestsSet(RecommendationsRepository repository, Request request, MethodOperator method) {
        this.repository = repository;
        this.request = request;
        this.method = method;
    }




    public List<Request> getRequestsUserOf(UUID id, List<String> listArguments) {

        List<Request> requestList = List.of(new Request( "user_of",
                listArguments, repository.userOf(id,listArguments.get(0))));

        return requestList;

    }

    public List<Request> getRequestsActiveUserOf(UUID id, List<String> list, Recommendations nameProduct) {


        List<Request> requestList = List.of(new Request( "Active_User_Of",
                List.of(list.get(0)), repository.userOf(id, list.get(0)), nameProduct));
        return requestList;

    }


    public List<Request> getRequestsSum(UUID id, List<String> listArgument) {

        int newNum = Integer.parseInt(listArgument.get(3));

        List<Request> requestList = List.of(new Request(
                "Transaction_Sum_Compare", listArgument,
                method.operator(repository.sum(id, listArgument.get(0), listArgument.get(1)), listArgument.get(2), newNum)));
        return requestList;

    }

    public List<Request> getRequestsTransactionsSumCompareDepositWithdraw(UUID id, List<String> listArgument
                                                                          ) {


        List<Request> requestList = List.of(new Request( "TransactionsSumCompareDepositWithdraw", listArgument,
                (method.operator((repository.sum(id, listArgument.get(0), "DEPOSIT")),
                        listArgument.get(1), (repository.sum(id, listArgument.get(1)
                                , " WITHDRAW"))))));
        return requestList;

    }


}




