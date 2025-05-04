package com.skypro.teamwork.interfase;

import com.skypro.teamwork.model.Requests;
import com.skypro.teamwork.model.Type;
import com.skypro.teamwork.repository.RecommendationsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class RequestsSet {
    private final RecommendationsRepository repository;
    private final MethodOperator method;

    private final Requests requests;


    public RequestsSet(RecommendationsRepository repository, Requests requests, MethodOperator method) {
        this.repository = repository;
        this.requests = requests;
        this.method = method;
    }

    List<Requests> requestsList = new ArrayList<>();

    public Type returnType(String str, Type type) {

        if (str.equals(type)) {
            Type newType = type;
        }
        return type;
    }

    public List<Requests> getRequestsUserOf(UUID id, String typeProduct, Type type, List<Requests> requestsList) {

        if (repository.userOf(id, returnType(typeProduct, type)) == true) {
            requestsList = List.of(new Requests(1L, "user_of", List.of(typeProduct), true));
        }
        return requestsList;

    }

    public List<Requests> getRequestsActiveUserOf(UUID id, String typeProduct, Type type, List<Requests> requestsList) {
        if (repository.userOf(id, returnType(typeProduct, type)) == true) {
            requestsList = List.of(new Requests(2L, "Active_User_Of", List.of(typeProduct), true));
        }
        return requestsList;

    }


    public List<Requests> getRequestsSum(UUID id, String typeProduct, String typeTransactions,
                                         String typeCompare, int Number, List<Requests> requestsList) {
        String changeNumber = String.valueOf(Number);
        if (method.operator(repository.sum(id, typeProduct, typeTransactions), typeCompare, Number) == true) {
            requestsList = List.of(new Requests(3L,
                    "Transaction_Sum_Compare", List.of(typeProduct, typeTransactions, typeCompare, changeNumber), true));
        }
        return requestsList;

    }

    public List<Requests> getRequestsTransactionsSumCompareDepositWithdraw(UUID id,
                                                                           String typeProduct,
                                                                           String typeCompare, List<Requests> requestsList) {

        if (method.operator((repository.sum(id, typeProduct, "DEPOSIT")), typeCompare, (repository.sum(id, typeProduct
                , " WITHDRAW"))
        ) == true) {
            requestsList = List.of(new Requests(4L, "TransactionsSumCompareDepositWithdraw", List.of(typeProduct,
                    typeCompare), true));
        }
        return requestsList;

    }


}
