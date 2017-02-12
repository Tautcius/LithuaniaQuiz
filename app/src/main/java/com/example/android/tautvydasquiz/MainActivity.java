package com.example.android.tautvydasquiz;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    int result = 0; //counting results;
    /*
    * Getting track of correct and wrong anwsers.
     */
    boolean resultForFirstQuesion, resultForSecondQuesion, resultForThirdQuesion, resultForForthQuesion,
            resultForFithQuesion, resultForSixthQuesion, resultForSeventhQuesion, resultForEigthQuesion = false;

//calculating result for first question;
private String firstAnwserCalculation (String firstAnwserEntered){
    if (firstAnwserEntered == "1918/02/16") {
        result += 1;
        resultForFirstQuesion = true;
    }
    return firstAnwserEntered;
}
//calculating result for second question;
private String secondAnswerCalculation (String secondAnwserEntered){
    if (secondAnwserEntered == "Mindaugas") {
        resultForSecondQuesion = true;
        result += 1;
    }
    return secondAnwserEntered;
}
public void getResults(View view){
    /*
    *geting anwser for first question;
     */
    EditText firstAnwser = (EditText) findViewById(R.id.firstAnwser);
    String firstAnwserEntered = firstAnwser.getText().toString();
    firstAnwserEntered= firstAnwserCalculation(firstAnwserEntered);

    /*
    *result for second question
     */
    EditText secondAnwser = (EditText) findViewById(R.id.secondAnwser);
    String secondAnwserEntered = secondAnwser.getText().toString();
    secondAnwserEntered = secondAnswerCalculation(secondAnwserEntered);

    String resultMessage = createResultsReport(result, resultForFirstQuesion, resultForSecondQuesion);

    displayResult(resultMessage);
}

    /*
    *create results report
     */
    public String createResultsReport(int result, boolean resultForFirstQuesion, boolean resultForSecondQuesion){
        String resultMessage = "You have anwsered to " + result + " questions corectly.";
        resultMessage += "\nAnwser for first question is " + resultForFirstQuesion;
        resultMessage += "\nAnwser for second question is " + resultForSecondQuesion;
        return resultMessage;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
           }
    /*
    *Shows anwser
     */
    private void displayResult(String message) {
        TextView quizResultTextView = (TextView) findViewById(R.id.display_result);
        quizResultTextView.setText(message);
    }
}
