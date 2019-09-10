package com.example.kuldeeprautela.quizapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Kuldeep Rautela on 9/9/2019.
 */

public interface Question {
@GET("api.php")
    Call<Quetions> getQuestion(@Query("amount") String amount,
                                     @Query("category") String category,
                                     @Query("difficulty") String difficulty,
                                     @Query("type") String type
                                     );

}
