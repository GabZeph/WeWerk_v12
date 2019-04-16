package com.example.wewerk_v12.fragments;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wewerk_v12.R;
import com.example.wewerk_v12.adapters.WorkoutDayRecyclerAdapter;
import com.example.wewerk_v12.adapters.WorkoutProgramRecyclerAdapter;
import com.example.wewerk_v12.models.Exercice;
import com.example.wewerk_v12.models.WorkoutDay;

import java.util.ArrayList;

public class WorkoutProgramSingleFragment extends Fragment {


    //ui components
    private TextView mWorkoutProgramName_textView, mSolicitedMuscles_textView,
            mWorkoutDescription_textView, mDifficulty_textView, mWorkoutType_textView;
    private ImageView mDifficultyIcon_imageView, mWorkoutType_imageView;
    private RecyclerView mWorkoutDays_recyclerView;

    //vars
    private ArrayList<WorkoutDay> mWorkoutDayArrayList = new ArrayList<>();
    private WorkoutDayRecyclerAdapter mWorkoutDayRecyclerAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_single_workout_program_item, container, false);

        //initializing views
        mWorkoutDays_recyclerView = (RecyclerView) view.findViewById(R.id.workoutDays_recyclerView);

        mDifficultyIcon_imageView = (ImageView) view.findViewById(R.id.difficulty_icon_imageView);
        mWorkoutType_imageView = (ImageView) view.findViewById(R.id.workoutType_icon_imageView);
        mWorkoutProgramName_textView = (TextView) view.findViewById(R.id.workoutProgramName_textView);
        mSolicitedMuscles_textView = (TextView) view.findViewById(R.id.solicitedMuscles_textView);
        mWorkoutDescription_textView = (TextView) view.findViewById(R.id.workoutDescription_textView);
        mDifficulty_textView = (TextView) view.findViewById(R.id.difficulty_textView);
        mWorkoutType_textView = (TextView) view.findViewById(R.id.workoutType_textView);

        //initializing recycler view
        initRecyclerView();

        //retrieving movement infos from firebase
        retrievingWorkoutDaysInfos();

        return view;
    }

    private void retrievingWorkoutDaysInfos() {
        //TODO: Retrieve infos from the clicked program

        Exercice exercice = new Exercice("squat", 8, 4);

        ArrayList<Exercice> exerciceArrayList = new ArrayList<>();
        exerciceArrayList.add(exercice);
        exerciceArrayList.add(exercice);
        exerciceArrayList.add(exercice);

        WorkoutDay workoutDay = new WorkoutDay(exerciceArrayList, "leg day");

//        ArrayList<WorkoutDay> workoutDayArrayList = new ArrayList<>();
        mWorkoutDayArrayList.add(workoutDay);
        mWorkoutDayArrayList.add(workoutDay);
        mWorkoutDayArrayList.add(workoutDay);


//update data change
        mWorkoutDayRecyclerAdapter.notifyDataSetChanged();
    }

    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mWorkoutDays_recyclerView.setLayoutManager(linearLayoutManager);
        mWorkoutDayRecyclerAdapter = new WorkoutDayRecyclerAdapter(mWorkoutDayArrayList);
        mWorkoutDays_recyclerView.setAdapter(mWorkoutDayRecyclerAdapter);

    }
}
