package com.example.wewerk_v12.models;

import java.io.Serializable;
import java.util.ArrayList;

public class WorkoutProgram implements Serializable {

    String workoutProgramName;
    String workoutDescription;
    String creatorName;
    String difficulty;
    ArrayList<WorkoutDay> workoutDayArrayList=new ArrayList<>();

    //TODO: change string difficulty to enum

    public WorkoutProgram(String workoutProgramName, String workoutDescription, String creatorName, String difficulty, ArrayList<WorkoutDay> workoutDayArrayList) {
        this.workoutProgramName = workoutProgramName;
        this.workoutDescription = workoutDescription;
        this.creatorName = creatorName;
        this.difficulty = difficulty;
        this.workoutDayArrayList = workoutDayArrayList;
    }

    public String getWorkoutProgramName() {
        return workoutProgramName;
    }

    public void setWorkoutProgramName(String workoutProgramName) {
        this.workoutProgramName = workoutProgramName;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public ArrayList<WorkoutDay> getWorkoutDayArrayList() {
        return workoutDayArrayList;
    }

    public void setWorkoutDayArrayList(ArrayList<WorkoutDay> workoutDayArrayList) {
        this.workoutDayArrayList = workoutDayArrayList;
    }

    public String getWorkoutDescription() {
        return workoutDescription;
    }

    public void setWorkoutDescription(String workoutDescription) {
        this.workoutDescription = workoutDescription;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}
