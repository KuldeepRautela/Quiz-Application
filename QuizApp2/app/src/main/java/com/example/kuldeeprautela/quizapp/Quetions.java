package com.example.kuldeeprautela.quizapp;

import android.widget.ListView;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Kuldeep Rautela on 9/9/2019.
 */

public class Quetions {
    @SerializedName("results")
     List<Quetions> quetions;

    public List<Quetions> getQuetions() {
        return quetions;
    }

    public void setQuetions(List<Quetions> quetions) {
        this.quetions = quetions;
    }

    @SerializedName("question")
    private  String question;
    @SerializedName("correct_answer")
    private  String correct_ans;
    @SerializedName("incorrect_answers")
    private  String[] wrong_ans;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getCorrect_ans() {
        return correct_ans;
    }

    public void setCorrect_ans(String correct_ans) {
        this.correct_ans = correct_ans;
    }

    public String[] getWrong_ans() {
        return wrong_ans;
    }

    public void setWrong_ans(String[] wrong_ans) {
        this.wrong_ans = wrong_ans;
    }
}
