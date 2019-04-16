package com.example.wewerk_v12.fragments;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wewerk_v12.R;
import com.example.wewerk_v12.activities.IntroSliderActivity;
import com.example.wewerk_v12.adapters.WorkoutProgramRecyclerAdapter;
import com.example.wewerk_v12.models.Exercice;
import com.example.wewerk_v12.models.WorkoutDay;
import com.example.wewerk_v12.models.WorkoutProgram;

import java.util.ArrayList;

public class WorkoutProgramListFragment extends Fragment implements WorkoutProgramRecyclerAdapter.OnWorkoutProgramListener {

    //ui components
    private TextView mWorkoutType_textView;
    private RecyclerView mDiscovery_recyclerView;

    //vars
    private ArrayList<WorkoutProgram> mWorkoutProgramArrayList = new ArrayList<>();
    private WorkoutProgramRecyclerAdapter mWorkoutProgramRecyclerAdapter;

    private static final String TAG = "WorkoutProgramListFragm";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_workout_program_list, container, false);

        //initializing views
        mWorkoutType_textView = (TextView) view.findViewById(R.id.workoutType_textView);
        mDiscovery_recyclerView = (RecyclerView) view.findViewById(R.id.discovery_recyclerView);

        //change the text inside the views

        //set the array to the listadapter and associating adapter to the recycler view to adapt the note
        initRecyclerView();

        //retrieving workouts program data from firebase
        retrievingWorkoutProgramData();
        return view;
    }

    private void retrievingWorkoutProgramData() {
        //TODO: getting workout program informations from firebase

        //exapmple of dataset
        for (int i = 0; i < 100; i++) {

            //TODO: replace exercise with constructor having image
            Exercice exercice = new Exercice("squat", 8, 4);

            ArrayList<Exercice> exerciceArrayList = new ArrayList<>();
            exerciceArrayList.add(exercice);
            exerciceArrayList.add(exercice);
            exerciceArrayList.add(exercice);

            WorkoutDay workoutDay = new WorkoutDay(exerciceArrayList, "leg day");

            ArrayList<WorkoutDay> workoutDayArrayList = new ArrayList<>();
            workoutDayArrayList.add(workoutDay);
            workoutDayArrayList.add(workoutDay);
            workoutDayArrayList.add(workoutDay);

            WorkoutProgram workoutProgram = new WorkoutProgram("gainz", " i want muscles",
                    "bob", "very hard", workoutDayArrayList);

            mWorkoutProgramArrayList.add(workoutProgram);
        }
        mWorkoutProgramRecyclerAdapter.notifyDataSetChanged();
    }

    private void initRecyclerView() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mDiscovery_recyclerView.setLayoutManager(linearLayoutManager);
        mWorkoutProgramRecyclerAdapter = new WorkoutProgramRecyclerAdapter(mWorkoutProgramArrayList, this);
        mDiscovery_recyclerView.setAdapter(mWorkoutProgramRecyclerAdapter);
    }


    //TODO: add back listener to go on previous fragment
    @Override
    public void onWorkoutProgramClicked(int position) {
//        //going to single program view page by witching fragment
        WorkoutProgramSingleFragment workoutProgramSingleFragment = new WorkoutProgramSingleFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, workoutProgramSingleFragment);
        fragmentTransaction.commit();

    }
}
