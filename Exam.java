package com.comp2601.pullparserapp;

import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * (c) 2018 LD Nel
 */
import android.util.Log;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * (c) 2019 L.D. Nel
 */
public class Exam {

    private static final String TAG = Exam.class.getSimpleName();

    //XML tags used to define an exam of multiple choice questions.
    public static final String XML_EXAM = "exam";


    public static ArrayList pullParseFrom(BufferedReader reader){
        ArrayList<Question> questions = null;
        //ArrayList questions = Question.exampleSet1(); //for now
        questions = new ArrayList<Question>();
        // Get our factory and create a PullParser
        XmlPullParserFactory factory = null;
        try {
            factory = XmlPullParserFactory.newInstance();
            XmlPullParser xpp = factory.newPullParser();
            String CurrTag="";
            String CurrQuestion = "";
            String CurrEmail = "";
            boolean CurrAnswer = false;
            xpp.setInput(reader); // set input file for parser
            int eventType = xpp.getEventType(); // get initial eventType
            // Loop through pull events until we reach END_DOCUMENT
            while (eventType != XmlPullParser.END_DOCUMENT) {
                // handle the xml tags encountered
                switch (eventType) {
                    case XmlPullParser.START_TAG: //XML opening tags
                        Log.i(TAG,"START_TAG: "+xpp.getName());
                        CurrTag=xpp.getName();
                        break;
                    case XmlPullParser.TEXT:
                        Log.i(TAG,"TEXT: "+xpp.getText());
                        if (CurrTag.contains("question_text"))
                            CurrQuestion+=xpp.getText().trim();

                        else if(CurrTag.contains("email"))
                            CurrEmail+=xpp.getText().trim();
                        break;
                    case XmlPullParser.END_TAG: //XML closing tags
                        Log.i(TAG,"END_TAG: "+xpp.getName());
                        if (xpp.getName().trim().contains("question_text"))
                        {
                            questions.add(new Question(CurrQuestion,CurrEmail));
                            CurrQuestion = "";
                            CurrTag="";

                        }
                        break;

                    default:
                        break;
                }
                //iterate
                eventType = xpp.next();
            }
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }

        return questions;

    }

}
