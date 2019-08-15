package com.comp2601.pullparserapp;

/**
 * (c) 2019 L.D. Nel
 */
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.String;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG =  MainActivity.class.getSimpleName();

    private Button AButton;
    private Button BButton;
    private Button CButton;
    private Button DButton;
    private Button EButton;

    private Button mNextButton;
    private Button mPrevButton;
    private Button mSendButton;
    private String emailAddress;
    private String emailBody;
    private EditText mStudentName;
    private EditText mStudentNumber;
    private TextView mQuestionTextView;
    private ArrayList<Question> questions;
    private ArrayList<Character> mAnswer;
    private int numberOfQuestion = 10;
    private int questionIndex;
    private int mCurrentQuestionIndex = 0;
    //private Object Protected;
    //ArrayList<Question> mQuestions;
    private static String QUESTION_INDEX_KEY = "question_index";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //set and inflate UI to manage

        AButton = (Button) findViewById(R.id.A_button);
        BButton = (Button) findViewById(R.id.B_button);
        CButton = (Button) findViewById(R.id.C_button);
        DButton = (Button) findViewById(R.id.D_button);
        EButton = (Button) findViewById(R.id.E_button);
        mPrevButton = (Button) findViewById(R.id.prev_button);
        mSendButton = (Button)findViewById(R.id.send_button);
        mNextButton = (Button) findViewById(R.id.next_button);
        mStudentName = (EditText) findViewById(R.id.name_text);
        mStudentNumber =(EditText) findViewById(R.id.student_text);
        mQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        mQuestionTextView.setTextColor(Color.BLUE);


        AButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mAnswer.size()<=questionIndex)
                     mAnswer.add(questionIndex, 'A');
                else
                mAnswer.set(questionIndex, 'A');
                Log.i(TAG, "A Button Clicked");
                //except A button, B,C,D,E button is not RED
                AButton.setBackgroundColor(Color.RED);
                BButton.setBackgroundColor(Color.rgb(214,215,215));
                CButton.setBackgroundColor(Color.rgb(214,215,215));
                DButton.setBackgroundColor(Color.rgb(214,215,215));
                EButton.setBackgroundColor(Color.rgb(214,215,215));


            }


        });
        BButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mAnswer.size()<=questionIndex)
                    mAnswer.add(questionIndex, 'B');
                else
                    mAnswer.set(questionIndex, 'B');

                System.out.println("B Button Clicked"); //print to console for debugging
                //except B button, E,C,D,A button is not RED
                BButton.setBackgroundColor(Color.RED);
                AButton.setBackgroundColor(Color.rgb(214,215,215));
                CButton.setBackgroundColor(Color.rgb(214,215,215));
                DButton.setBackgroundColor(Color.rgb(214,215,215));
                EButton.setBackgroundColor(Color.rgb(214,215,215));

            }

        });
        CButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mAnswer.size()<=questionIndex)
                    mAnswer.add(questionIndex, 'C');
                else
                    mAnswer.set(questionIndex, 'C');

                System.out.println("C Button Clicked"); //print to console for debugging
                //except C button, B,E,D,A button is not RED
                CButton.setBackgroundColor(Color.RED);
                BButton.setBackgroundColor(Color.rgb(214,215,215));
                AButton.setBackgroundColor(Color.rgb(214,215,215));
                DButton.setBackgroundColor(Color.rgb(214,215,215));
                EButton.setBackgroundColor(Color.rgb(214,215,215));

            }

        });
        DButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mAnswer.size()<=questionIndex)
                    mAnswer.add(questionIndex, 'D');
                else
                    mAnswer.set(questionIndex, 'D');

                System.out.println("D Button Clicked"); //print to console for debugging
                //except D button, B,C,E,A button is not RED
                DButton.setBackgroundColor(Color.RED);
                BButton.setBackgroundColor(Color.rgb(214,215,215));
                CButton.setBackgroundColor(Color.rgb(214,215,215));
                AButton.setBackgroundColor(Color.rgb(214,215,215));
                EButton.setBackgroundColor(Color.rgb(214,215,215));

            }

        });
        EButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mAnswer.size()<=questionIndex)
                    mAnswer.add(questionIndex, 'E');
                else
                    mAnswer.set(questionIndex, 'E');

                System.out.println("E Button Clicked"); //print to console for debugging

                Toast t;
                EButton.setBackgroundColor(Color.RED);
                //except E button, B,C,D,A button is not RED
                BButton.setBackgroundColor(Color.rgb(214,215,215));
                CButton.setBackgroundColor(Color.rgb(214,215,215));
                DButton.setBackgroundColor(Color.rgb(214,215,215));
                AButton.setBackgroundColor(Color.rgb(214,215,215));
            }

        });
        mPrevButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Log.i(TAG, "Prev Button Clicked");

                if(questionIndex > 0) questionIndex--;


                mQuestionTextView.setText("" + (questionIndex + 1) + ") " +
                        questions.get(questionIndex).toString());
                //reset background color when you clickPREV
                AButton.setBackgroundColor(Color.rgb(214,215,215));
                BButton.setBackgroundColor(Color.rgb(214,215,215));
                CButton.setBackgroundColor(Color.rgb(214,215,215));
                DButton.setBackgroundColor(Color.rgb(214,215,215));
                EButton.setBackgroundColor(Color.rgb(214,215,215));
                if(mAnswer.size()<=questionIndex){ }
                else{
                    char a = mAnswer.get(questionIndex);
                    if(a == 'A')
                        AButton.setBackgroundColor(Color.RED);
                    else if(a == 'B')
                        BButton.setBackgroundColor(Color.RED);
                    else if(a == 'C')
                        CButton.setBackgroundColor(Color.RED);
                    else if(a == 'D')
                        DButton.setBackgroundColor(Color.RED);
                    else if(a == 'E')
                        EButton.setBackgroundColor(Color.RED);

                }


            }

        });
        mNextButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //click NEXT button
                Log.i(TAG, "Next Button Clicked");

                //reset background color when you clickNEXT
                AButton.setBackgroundColor(Color.rgb(214,215,215));
                BButton.setBackgroundColor(Color.rgb(214,215,215));
                CButton.setBackgroundColor(Color.rgb(214,215,215));
                DButton.setBackgroundColor(Color.rgb(214,215,215));
                EButton.setBackgroundColor(Color.rgb(214,215,215));

                if(questionIndex < questions.size()-1) questionIndex++;

                mQuestionTextView.setText("" + (questionIndex + 1) + ") " +
                        questions.get(questionIndex).toString());
                if(mAnswer.size()<=questionIndex){
                    //return null;
                }
                else{
                    char a = mAnswer.get(questionIndex);
                    if(a == 'A')
                        AButton.setBackgroundColor(Color.RED);
                    else if(a == 'B')
                        BButton.setBackgroundColor(Color.RED);
                    else if(a == 'C')
                        CButton.setBackgroundColor(Color.RED);
                    else if(a == 'D')
                        DButton.setBackgroundColor(Color.RED);
                    else if(a == 'E')
                        EButton.setBackgroundColor(Color.RED);

                }



            }

        });
        mSendButton.setOnClickListener((View v) -> {
            //send XML to fernzhaofei@gmail.com
            /*format is
            <StudentName>feifeizhao</StudentName>
            <StudentNumber>101047476</StudentNumber>
            <QuestionNumber>1</QuestionNumber>
            <Answer>C</Answer>
            .
            .
            .

            */
            Log.i(TAG, "Send Button Clicked");
            emailAddress = questions.get(questionIndex).getEmail();
            String studentName = mStudentName.getText().toString();
            String studentNumber = mStudentNumber.getText().toString();
            //make sure student number and name is not empty

            if(!studentNumber.contains("Student Number")&& !studentNumber.isEmpty()&& !studentName.contains("Name")&& !studentName.isEmpty()) {

                emailBody += "<studentName>" + studentName + "</studentName>\n" + "<StudentNumber>" + studentNumber + "</StudentNumber>\n";

                for (int i = 0; i < mAnswer.size(); i++) {
                    emailBody += "<QuestionNumber>" + Integer.toString(i + 1) + "</QuestionNumber>\n" + "<Answer>" + mAnswer.get(i) + "</Answer>\n";

                }
                String emailSub = studentName +studentNumber+"Answer";
                String emailURI = "mailto:" + emailAddress;
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse(emailURI));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, emailSub);

                emailIntent.putExtra(Intent.EXTRA_TEXT, emailBody);

                startActivity(Intent.createChooser(emailIntent, "Email Client ..."));
            }


        });




        questions = null;
        questionIndex = 0;
        mAnswer = new ArrayList<Character>();

        ArrayList<Question> parsedModel = null;
        try {
            InputStream iStream = getResources().openRawResource(R.raw.comp2601exam);
            BufferedReader bReader = new BufferedReader(new InputStreamReader(iStream));
            parsedModel = Exam.pullParseFrom(bReader);
            bReader.close();
        }
        catch (java.io.IOException e){
            e.printStackTrace();

        }
        if(parsedModel == null || parsedModel.isEmpty())
            Log.i(TAG, "ERROR: Questions Not Parsed");
        questions = parsedModel;

        if(questions != null && questions.size() > 0)
            mQuestionTextView.setText("" + (questionIndex + 1) + ") " +
                    questions.get(questionIndex).toString());


    }
    //rotate not finished
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(QUESTION_INDEX_KEY, questionIndex);
        Log.i(TAG, "onSaveInstanceState(Bundle)");
    }



}
