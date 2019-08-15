package com.comp2601.pullparserapp;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * (c) 2019 L.D. Nel
 */
public class Question {

    private static final String TAG = Question.class.getSimpleName();

    //XML tags the define Question properties
    public static final String XML_QUESTION = "question";
    public static final String XML_QUESTION_TEXT = "question_text";
    public static final String XML_ANSWER = "answer";
    public static final String XML_ATTR_CONTRIBUTER = "contributor";

    private String mQuestionString; //id of string resource representing the question
    private boolean mAnswer; //boolean representing the question answer
    private String mContributor; //author or contributor of the question
    private String Memail;
    public Question(String aQuestion, String Aemail){
        mQuestionString = aQuestion;
        Memail = Aemail;
        mContributor = "anonymous";

    }



    public String getQuestionString(){return mQuestionString;}
    public boolean getAnswer(){return mAnswer;}
    public String getContributer(){return mContributor;}
    public String getEmail(){return  Memail;}
    public String toString(){
        String toReturn = "";
        if(mContributor != null && !mContributor.isEmpty())
            toReturn += "[" + mContributor + "] ";
        toReturn += mQuestionString;
        return toReturn;
    }




}
