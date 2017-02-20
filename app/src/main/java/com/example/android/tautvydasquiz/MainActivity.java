package com.example.android.tautvydasquiz;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
    int result = 0; //counting results;

    private EditText firstAnswer, secondAnswer, fifthAnwser, seventhAnwser;
    private RadioGroup thirdQuestion, forthQuestion;
    private RadioButton thirdAnwserRadio, forthAnwserRadio;
    private CheckBox checkBoxBasketball, checkBoxRowing, checkBoxWheightLifting, checkBoxCanoeing, checkBoxBoxing;
    boolean basketball, rowing, weightLifting, canoeing, boxing;
    String resultForFirstQuesion, resultForSecondQuesion, resultForThirdQuesion, resultForForthQuesion,
            resultForFifthQuesion, resultForSixthQuesion, resultForSeventhQuesion, resultMessage;

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
        if (thirdQuestion.getCheckedRadioButtonId() == thirdAnwserRadio.getId()) {
            resultForThirdQuesion = "correct";
            result++;
        } else {
            resultForThirdQuesion = "wrong";
        }
    /*
    *geting anwser for forth question;
    */
        if (forthQuestion.getCheckedRadioButtonId() == forthAnwserRadio.getId()) {
            resultForForthQuesion = "correct";
            result++;
        } else {
            resultForForthQuesion = "wrong";
        }
    /*
    *geting anwser for fifth question;
    */
        if (fifthAnwser.getText().toString().equals("4")) {
            resultForFifthQuesion = "correct";
            result++;
        } else {
            resultForFifthQuesion = "wrong";
        }
    /*
    *geting anwser for sixth question;
    */
        basketball = checkBoxBasketball.isChecked();
        boxing = checkBoxBoxing.isChecked();
        rowing = checkBoxRowing.isChecked();
        weightLifting = checkBoxWheightLifting.isChecked();
        canoeing = checkBoxCanoeing.isChecked();
        Log.v("MainActivity", "basketball is " + basketball);
        if ((rowing && weightLifting && canoeing) && !(basketball && boxing)) {
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

        Toast.makeText(this, "Don't forget to share your results!", Toast.LENGTH_SHORT).show();
        resultMessage = createResultsReport(result, resultForFirstQuesion, resultForSecondQuesion,
                resultForThirdQuesion, resultForForthQuesion, resultForFifthQuesion,
                resultForSixthQuesion, resultForSeventhQuesion);
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
    /*
    *Intent to maps app to find correct anwser
     */
    public void getDirections(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("geo:54.687157,25.279652")); // should fire maps app
        intent.putExtra(Intent.EXTRA_SUBJECT, "My results on Lithuania Quiz app");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    /*
    *Intent to email app to share results to firends.
     */
    public void shareEmail(View view){
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "My results on Lithuania Quiz app");
        intent.putExtra(Intent.EXTRA_TEXT, resultMessage);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        firstAnswer = (EditText) findViewById(R.id.firstAnwser);
        secondAnswer = (EditText) findViewById(R.id.secondAnwser);
        fifthAnwser = (EditText) findViewById(R.id.fifthAnwser);
        checkBoxBasketball = (CheckBox) findViewById(R.id.checkbox_basketball);
        checkBoxBoxing = (CheckBox) findViewById(R.id.checkbox_boxing);
        checkBoxRowing = (CheckBox) findViewById(R.id.checkbox_rowing);
        checkBoxWheightLifting = (CheckBox) findViewById(R.id.checkbox_weightlifting);
        checkBoxCanoeing = (CheckBox) findViewById(R.id.checkbox_canoeing);
        seventhAnwser = (EditText) findViewById(R.id.seventhAnwser);
        thirdQuestion = (RadioGroup)findViewById(R.id.third_question);
        thirdAnwserRadio = (RadioButton)findViewById(R.id.lessThanThree);
        forthQuestion = (RadioGroup)findViewById(R.id.forth_question);
        forthAnwserRadio = (RadioButton)findViewById(R.id.Basketball);
    }


    /*
    *Shows anwser
     */
    private void displayResult(String message) {
        TextView quizResultTextView = (TextView) findViewById(R.id.display_result);
        quizResultTextView.setText(message);
    }

}



