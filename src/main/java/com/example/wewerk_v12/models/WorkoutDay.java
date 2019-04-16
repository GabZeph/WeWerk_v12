package com.example.wewerk_v12.models;

import java.io.Serializable;
import java.util.ArrayList;

public class WorkoutDay implements Serializable {

    ArrayList <Exercice> exerciceArrayList=new ArrayList<>();
    String workoutDayDescription;

    public WorkoutDay(ArrayList<Exercice> exerciceArrayList, String workoutDayDescription) {
        this.exerciceArrayList = exerciceArrayList;
        this.workoutDayDescription = workoutDayDescription;
    }


    public ArrayList<Exercice> getExerciceArrayList() {
        return exerciceArrayList;
    }

    public void setExerciceArrayList(ArrayList<Exercice> exerciceArrayList) {
        this.exerciceArrayList = exerciceArrayList;
    }

    public String getWorkoutDayDescription() {
        return workoutDayDescription;
    }

    public void setWorkoutDayDescription(String workoutDayDescription) {
        this.workoutDayDescription = workoutDayDescription;
    }


}
