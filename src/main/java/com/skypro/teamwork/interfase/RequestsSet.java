package com.skypro.teamwork.interfase;

import com.skypro.teamwork.model.Requests;
import com.skypro.teamwork.model.Type;
import com.skypro.teamwork.repository.RecommendationsRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public interface  RequestsSet {
    public List<Requests> getRequests(UUID id,List<String>listArguments);
  /* private final RecommendationsRepository repository;
    private final MethodOperator method;

    private final Requests requests;


    public RequestsSet(RecommendationsRepository repository, Requests requests, MethodOperator method) {
        this.repository = repository;
        this.requests = requests;
        this.method = method;
    }




    public List<Requests> getRequestsUserOf(UUID id, List<String> listArguments) {

        List<Requests> requestsList = List.of(new Requests(1L, "user_of",
                listArguments, repository.userOf(id, Type.valueOf(listArguments.get(0)))));

        return requestsList;

    }

    public List<Requests> getRequestsActiveUserOf(UUID id, List<String> list) {


        List<Requests> requestsList = List.of(new Requests(2L, "Active_User_Of",
                List.of(list.get(0)), repository.userOf(id, Type.valueOf(list.get(0)))));
        return requestsList;

    }


    public List<Requests> getRequestsSum(UUID id, List<String> listArgument) {

        int newNum = Integer.parseInt(listArgument.get(3));

        List<Requests> requestsList = List.of(new Requests(3L,
                "Transaction_Sum_Compare", listArgument,
                method.operator(repository.sum(id, listArgument.get(0), listArgument.get(1)), listArgument.get(2), newNum)));
        return requestsList;

    }

    public List<Requests> getRequestsTransactionsSumCompareDepositWithdraw(UUID id, List<String> listArgument) {


        List<Requests> requestsList = List.of(new Requests(4L, "TransactionsSumCompareDepositWithdraw", listArgument,
                (method.operator((repository.sum(id, listArgument.get(0), "DEPOSIT")),
                        listArgument.get(1), (repository.sum(id, listArgument.get(1)
                                , " WITHDRAW"))
                ))));
        return requestsList;

    }*/
}




