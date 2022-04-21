package com.sharzelahmad.netscampproject;

import java.util.ArrayList;
import java.util.List;

public class QuestionBank {

    private  static  List<QuestionList> javaQuestions(){
        final List<QuestionList> questionsLists = new ArrayList<>();

//        create objext of questionList class and pass a questions along with options and answer
        final QuestionList question1 = new QuestionList("Which of the following option leads to the portability and security of Java?","Bytecode is executed by JVM","The applet makes the Java code secure and portable","Use of exception handling","Dynamic binding between objects","Bytecode is executed by JVM","");
        final QuestionList question2 = new QuestionList("Which of the following is not a Java features?","Dynamic","Architecture Neutral","Use of pointers","Object-oriented","Use of pointers","");
        final QuestionList question3 = new QuestionList("The \\u0021 article referred to as a","Unicode escape sequence","Octal escape","Hexadecimal","Line feed","Unicode escape sequence","");
        final QuestionList question4 = new QuestionList("_____ is used to find and fix bugs in the Java programs.","JVM","JRE","JDK","JDB","JDB","");
        final QuestionList question5 = new QuestionList(" What is the return type of the hashCode() method in the Object class?","object","int","long","void","int","");
        final QuestionList question6 = new QuestionList("What does the expression float a = 35 / 0 return?","0","Not a Number","infinity","Run time exception","infinity","");

//        add all questions to List<QuestionsList>
        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);
        questionsLists.add(question4);
        questionsLists.add(question5);
        questionsLists.add(question6);

        return questionsLists;


    }

    private  static  List<QuestionList> phpQuestions(){
        final List<QuestionList> questionsLists = new ArrayList<>();

//        create objext of questionList class and pass a questions along with options and answer
        final QuestionList question1 = new QuestionList("PHP stands for -","Hypertext Preprocessor","Pretext Hypertext Preprocessor","Personal Home Processor","None of the above","Hypertext Preprocessor","");
        final QuestionList question2 = new QuestionList("Who is known as the father of PHP?","Drek Kolkevi","List Barely","Rasmus Lerdrof","None of the above","Rasmus Lerdrof","");
        final QuestionList question3 = new QuestionList("Variable name in PHP starts with -","! (Exclamation)","$ (Dollar)","& (Ampersand)","# (Hash)","$ (Dollar)","");
        final QuestionList question4 = new QuestionList("Which of the following is the default file extension of PHP?",".php",".hphp",".xml",".html",".php","");
        final QuestionList question5 = new QuestionList("Which of the following is not a variable scope in PHP?","Extern","Static","Local","Global","Extern","");
        final QuestionList question6 = new QuestionList("Which of the following is used to display the output in PHP?","Echo","Write","Print","Both (a) and (c)","Both (a) and (c)","");

//        add all questions to List<QuestionsList>
        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);
        questionsLists.add(question4);
        questionsLists.add(question5);
        questionsLists.add(question6);

        return questionsLists;


    }

    private  static  List<QuestionList> htmlQuestions(){
        final List<QuestionList> questionsLists = new ArrayList<>();

//        create objext of questionList class and pass a questions along with options and answer
        final QuestionList question1 = new QuestionList("HTML stands for -","HighText Machine Language","HyperText and links Markup Language","HyperText Markup Language","None of these","HyperText Markup Language","");
        final QuestionList question2 = new QuestionList("The correct sequence of HTML tags for starting a webpage is -","Head, Title, HTML, body","HTML, Body, Title, Head","HTML, Head, Title, Body","HTML, Head, Title, Body","HTML, Head, Title, Body","");
        final QuestionList question3 = new QuestionList("Which of the following element is responsible for making the text bold in HTML?","<pre>","<a>","<b>","<br>","<b>","");
        final QuestionList question4 = new QuestionList("Which of the following tag is used for inserting the largest heading in HTML?","<h3>","<h1>","<h5>","<h6>","<h1>","");
        final QuestionList question5 = new QuestionList("Which of the following tag is used to insert a line-break in HTML?","<a>","<b>","<br>","<pre>","<br>","");
        final QuestionList question6 = new QuestionList("How to create an unordered list (a list with the list items in bullets) in HTML?","<ul>","<ol>","<li>","<i>","<ul>","");

//        add all questions to List<QuestionsList>
        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);
        questionsLists.add(question4);
        questionsLists.add(question5);
        questionsLists.add(question6);

        return questionsLists;


    }

    private  static  List<QuestionList> androidQuestions(){
        final List<QuestionList> questionsLists = new ArrayList<>();

//        create objext of questionList class and pass a questions along with options and answer
        final QuestionList question1 = new QuestionList("Android is -","an Operating System","a Web Server","a Web Browser","None of the above","an Operating System","");
        final QuestionList question2 = new QuestionList("Under which of the following Android is licensed?","OSS","Sourceforge","Apache/MIT","None of the Above","Apache/MIT","");
        final QuestionList question3 = new QuestionList("For which of the following Android is mainly developed?","Server","Laptop","Desktop","Mobile devices","Mobile devices","");
        final QuestionList question4 = new QuestionList("Which of the following virtual machine is used by the Android operating system?","JVM","Dalvik virtual machine","Simple Virtual Machine","None of the Above","Dalvik virtual machine","");
        final QuestionList question5 = new QuestionList("Android is based on which of the following language?","C++","C","Java","None of the Above","Java","");
        final QuestionList question6 = new QuestionList("APK stands for -","Android Phone Kit","Android Page Kit","Android Package Kit","None of the Above","Android Package Kit","");

//        add all questions to List<QuestionsList>
        questionsLists.add(question1);
        questionsLists.add(question2);
        questionsLists.add(question3);
        questionsLists.add(question4);
        questionsLists.add(question5);
        questionsLists.add(question6);

        return questionsLists;


    }
    public static List<QuestionList> getQuestions(String selectedTopicName) {
        switch (selectedTopicName) {
            case "java":

                return javaQuestions();
            case "php":

                return phpQuestions();
            case "html":

                return htmlQuestions();
            default:

                return androidQuestions();
        }
    }


}
