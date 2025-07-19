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
    // private final Request request;


    public RequestsSet(RecommendationsRepository repository,  MethodOperator method) {
        this.repository = repository;
      //  this.request = request;
        this.method = method;
    }




    public Request getRequestsUserOf(UUID id, List<String> listArguments,Recommendations recommendations) {

       return new Request("user_of",
               listArguments, repository.userOf(id,"CREDIT"),recommendations);



    }

    public Request getRequestsActiveUserOf(UUID id, List<String> list, Recommendations recommendations) {


        return new Request( "Active_User_Of",
                List.of(list.get(0)), repository.activeUserOf(id, list.get(0)), recommendations);


    }


    public Request getRequestsSum(UUID id, List<String> listArgument,Recommendations recommendations) {

        int newNum = Integer.parseInt(listArgument.get(3));

        return new Request(
                "Transaction_Sum_Compare", listArgument,
                method.operator(repository.sum(id, listArgument.get(0), listArgument.get(1)), listArgument.get(2), newNum),
       recommendations );


    }

    public Request getRequestsTransactionsSumCompareDepositWithdraw(UUID id, List<String> listArgument,
                                                                         Recommendations recommendations ) {


        return new Request( "TransactionsSumCompareDepositWithdraw", listArgument,


                (method.operator( (repository.sum(id, listArgument.get(0), "DEPOSIT")) ,
                        listArgument.get(1),
                        (repository.sum(id, listArgument.get(1), " WITHDRAW"))))
                ,recommendations);


    }


}




