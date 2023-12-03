package com.example.admin.explor_the_world;

import android.support.v7.app.AppCompatActivity;

public class QuestionsScience extends AppCompatActivity {

    public String mQuestions[] = {

            "Which is the best country?",
            "For how many towns in lanka?",
            "Which amongst the best money?",
            "Which of theird?",
            "In which of the followeeth?",
            "Which of the follo",
            "Kangaroos, Platypu",
            "Which of the following key?",
            "Which one of the folke?",
            "Which of the follo",
            "Which one of the following is?",
            "Which animal can bre?",
            "Which anim?"

    };

    private String mChoices[][] = {

            {"Emu","Ostrich","Albatross","Siberian Crane"},
            {"About 25 million years","About 65 million years","About 100 million years","About 135 million years"},
            {"Elephant", "Whale", "Dinosaur", "Rhinoceros" },
            {"Pigeon","Parrot","Humming bird","House sparrow"},
            {"Alligator, Turtle & Tortoise", "Peacock, Ostrich & Tortoise", "Owl, Loris & Crow", "Turtle, Kiwi & Crow"},
            {"Flying fish", "Sea horse", "Frog", "Chameleon" },
            {"South America","Australia","Africa","Europe"},
            {"Mandrill","Baboon","Howler Monkey","Spider Monkey"},
            {"Glass snake","Sea snake","Tree snake","Blind snake"},
            {"Shark","Starfish","Eel","Sea horse"},
            {"Indian Bustara", "Ostrich", "Sarus crane", "Greater Flamingo"},
            {"Whale", "Dolphin", "Shark", "Crocodile"},
            {"Dog", "Cat", "Duck", "Sheep"}


    };

    private String mCorrectAnswers[] = {"Ostrich"," About 65 million years"," Whale ","Humming bird","Peacock, Ostrich & Tortoise","Frog","Australia","Mandrill.","Glass snake","Starfish", "Sarus crane", "Shark", "Duck"};

    public String getQuestion(int a){

        String question = mQuestions[a];
        return question;

    }

    public String getChoice1(int a){
        String choice = mChoices[a][0];
        return choice;
    }

    public String getChoice2(int a){
        String choice = mChoices[a][1];
        return choice;
    }

    public String getChoice3(int a){
        String choice = mChoices[a][2];
        return choice;
    }

    public String getChoice4(int a){
        String choice = mChoices[a][3];
        return choice;
    }

    public String getCorrectAnswer(int a){
        String answer = mCorrectAnswers[a];
        return answer;
    }

}
