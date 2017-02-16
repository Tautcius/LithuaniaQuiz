package com.example.android.tautvydasquiz;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends Activity {
    int result = 0; //counting results;

    private EditText firstAnswer, secondAnswer, fifthAnwser, seventhAnwser;
    private RadioGroup thirdQuestion, forthQuestion;
    private RadioButton thirdAnwserRadio, forthAnserRadio;
    private int thirdAnwser, forthAnwser;
    boolean basketball, rowing, weightLifting, canoeing, boxing;
    String resultForFirstQuesion, resultForSecondQuesion, resultForThirdQuesion, resultForForthQuesion,
            resultForFifthQuesion, resultForSixthQuesion, resultForSeventhQuesion;

    public void getResults(View view) {
    /*
    *geting anwser for first question;
    */
        if (firstAnswer.getText().toString().equals("1918/02/16")) {
            resultForFirstQuesion = "Correct";
            result++;
        } else {
            resultForFirstQuesion = "Wrong";
        }
    /*
    *geting anwser for second question;
    */
        if (secondAnswer.getText().toString().equals("Mindaugas")) {
            resultForSecondQuesion = "correct";
            result++;
        } else {
            resultForSecondQuesion = "wrong";
        }
    /*
    *geting anwser for third question;
    */
        if (thirdAnwserRadio.getText().toString().equals("Less than 3 millions")) {
            resultForThirdQuesion = "correct";
            result++;
        } else {
            resultForThirdQuesion = "wrong";
        }
    /*
    *geting anwser for forth question;
    */
        if (forthAnserRadio.getText().toString().equals("Basketball")) {
            resultForForthQuesion = "correct";
            result++;
        } else {
            resultForForthQuesion = "wrong";
        }
    /*
    *geting anwser for fifth question;
    */
        if (fifthAnwser.getText().toString().equals("Basketball")) {
            resultForFifthQuesion = "correct";
            result++;
        } else {
            resultForFifthQuesion = "wrong";
        }
    /*
    *geting anwser for sixth question;
    */
        if ((basketball && boxing) != (canoeing && rowing && weightLifting)) {
            resultForSixthQuesion = "correct";
            result++;
        } else {
            resultForSixthQuesion = "wrong";
        }
    /*
    *geting anwser for seventh question;
    */
        if (seventhAnwser.getText().toString().equals("Vilnius")) {
            resultForSeventhQuesion = "correct";
            result++;
        } else {
            resultForSeventhQuesion = "wrong";
        }


        String resultMessage = createResultsReport(result, resultForFirstQuesion, resultForSecondQuesion, resultForThirdQuesion, resultForForthQuesion, resultForFifthQuesion, resultForSixthQuesion, resultForSeventhQuesion);
        displayResult(resultMessage);
        result = 0;
    }

    /*
    *create results report
     */
    public String createResultsReport(int result, String resultForFirstQuesion, String resultForSecondQuesion,
                                      String resultForThirdQuesion, String resultForForthQuesion, String resultForFifthQuesion,
                                      String resultForSixthQuesion, String resultForSeventhQuesion){
        String resultMessage = "You have anwsered to " + result + " questions corectly.";
        resultMessage += "\nAnwser for first question is " + resultForFirstQuesion;
        resultMessage += "\nAnwser for second question is " + resultForSecondQuesion;
        resultMessage += "\nAnwser for third question is " + resultForThirdQuesion;
        resultMessage += "\nAnwser for forth question is " + resultForForthQuesion;
        resultMessage += "\nAnwser for fifth question is " + resultForFifthQuesion;
        resultMessage += "\nAnwser for sixth question is " + resultForSixthQuesion;
        resultMessage += "\nAnwser for seventh question is " + resultForSeventhQuesion;
        return resultMessage;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstAnswer = (EditText)findViewById(R.id.firstAnwser);
        secondAnswer = (EditText)findViewById(R.id.secondAnwser);
        fifthAnwser = (EditText)findViewById(R.id.fifthAnwser);
        CheckBox checkBoxBasketball, checkBoxRowing, checkBoxWheightLifting, checkBoxCanoeing, checkBoxBoxing;
        checkBoxBasketball = (CheckBox)findViewById(R.id.checkbox_basketball);
        basketball = checkBoxBasketball.isChecked();
        checkBoxBoxing = (CheckBox)findViewById(R.id.checkbox_boxing);
        boxing = checkBoxBoxing.isChecked();
        checkBoxRowing = (CheckBox)findViewById(R.id.checkbox_rowing);
        rowing = checkBoxRowing.isChecked();
        checkBoxWheightLifting = (CheckBox)findViewById(R.id.checkbox_weightlifting);
        weightLifting = checkBoxWheightLifting.isChecked();
        checkBoxCanoeing = (CheckBox)findViewById(R.id.checkbox_canoeing);
        canoeing = checkBoxCanoeing.isChecked();
        seventhAnwser = (EditText)findViewById(R.id.seventhAnwser);

        thirdQuestion = (RadioGroup)findViewById(R.id.third_question);
        thirdAnwser = thirdQuestion.getCheckedRadioButtonId();
        thirdAnwserRadio = (RadioButton)findViewById(thirdAnwser);
        forthQuestion = (RadioGroup)findViewById(R.id.forth_question);
        forthAnwser = forthQuestion.getCheckedRadioButtonId();
        forthAnserRadio = (RadioButton)findViewById(forthAnwser);
    }


    /*
    *Shows anwser
     */
    private void displayResult(String message) {
        TextView quizResultTextView = (TextView) findViewById(R.id.display_result);
        quizResultTextView.setText(message);
    }
}



