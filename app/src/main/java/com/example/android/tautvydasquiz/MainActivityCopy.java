package com.example.android.tautvydasquiz;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivityCopy extends Activity {
    int result = 0; //counting results;
    boolean resultForFirstQuesion, resultForSecondQuesion, resultForThirdQuesion,resultForForthQuesion,
            resultForFithQuesion,resultForSixthQuesion,resultForSeventhQuesion,resultForEigthQuesion = false;

    //calculating result for first question;
    private boolean firstAnwserCalculation (){
        EditText firstAnwser = (EditText) findViewById(R.id.firstAnwser);
        String firstAnwserEntered = firstAnwser.getText().toString();
        if (firstAnwserEntered.equals("1918/02/16")) {
            return true;
        }
        else {
            return false;
        }
    }
    //calculating result for second question;
    private boolean secondAnswerCalculation (){
        EditText secondAnwser = (EditText) findViewById(R.id.secondAnwser);
        String secondAnwserEntered = secondAnwser.getText().toString();
        if (secondAnwserEntered.equals("Mindaugas")) {
            return true;
        }
        else {
            return false;
        }
    }

    public void getResults(View view){
        /*
        *geting anwser for first question;
        */
        if (firstAnwserCalculation()){
            resultForFirstQuesion = true;
            result++;
        }
        /*
        *result for second question
        */
        if (secondAnswerCalculation()){
            resultForSecondQuesion = true;
            result++;
        }

        String resultMessage = createResultsReport(result, resultForFirstQuesion, resultForSecondQuesion, resultForThirdQuesion, resultForForthQuesion);
        displayResult(resultMessage);
    }
        //check if radio button is clicked;
    public void onRadioButtonClicked1(View view) {
        boolean thirdAnwser = ((RadioButton) view).isChecked();
        //check anwser for radio button;
        switch (view.getId()) {
            case R.id.lessThanThree:
                if (thirdAnwser) {
                    resultForThirdQuesion = true;
                    result++;
                }
                break;
            case R.id.lessThree:
                if (thirdAnwser) {
                    resultForThirdQuesion = false;
                }
                break;

            case R.id.lessMoreThree:
                if (thirdAnwser) {
                    resultForThirdQuesion = false;
                }
                break;
        }
    }
        //check if radio button is clicked;
    public void onRadioButtonClicked2(View view) {
        boolean forthAnwser = ((RadioButton) view).isChecked();
        //check anwser for radio button;
        switch (view.getId()) {
            case R.id.Basketball:
                if (forthAnwser) {
                    resultForForthQuesion = true;
                    result++;
                }
            case R.id.Football:
                if (forthAnwser) {
                    resultForForthQuesion = false;
                }

            case R.id.Tennis:
                if (forthAnwser) {
                    resultForForthQuesion = false;
                }
        }
    }


    /*
    *create results report
     */
    public String createResultsReport(int result, boolean resultForFirstQuesion,boolean resultForSecondQuesion, boolean resultForThirdQuesion,
                                      boolean resultForForthQuesion){
        String resultMessage = "You have anwsered to " + result + " questions corectly.";
        resultMessage += "\nAnwser for first question is " + resultForFirstQuesion;
        resultMessage += "\nAnwser for second question is " + resultForSecondQuesion;
        resultMessage += "\nAnwser for third question is " + resultForThirdQuesion;
        resultMessage += "\nAnwser for forth question is " + resultForForthQuesion;
        return resultMessage;
    }

    /*
    *Shows anwser
     */
    private void displayResult(String message) {
        TextView quizResultTextView = (TextView) findViewById(R.id.display_result);
        quizResultTextView.setText(message);
    }


@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

}
    }




