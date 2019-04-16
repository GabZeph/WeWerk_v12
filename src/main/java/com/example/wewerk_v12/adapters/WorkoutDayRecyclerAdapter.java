package com.example.wewerk_v12.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wewerk_v12.R;
import com.example.wewerk_v12.models.WorkoutDay;

import java.util.ArrayList;

public class WorkoutDayRecyclerAdapter extends RecyclerView.Adapter<WorkoutDayRecyclerAdapter.ViewHolder> {

    private ArrayList<WorkoutDay> mWorkoutDayArrayList = new ArrayList<>();

    public WorkoutDayRecyclerAdapter(ArrayList<WorkoutDay> mWorkoutDayArrayList) {
        this.mWorkoutDayArrayList = mWorkoutDayArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_workout_day_list_item, viewGroup, false);



        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.day_textView.setText("Day " + (i+1));
    }

    @Override
    public int getItemCount() {
        return mWorkoutDayArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView day_textView;
        RecyclerView exercise_recyclerView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            day_textView = (TextView) itemView.findViewById(R.id.day_textView);
            exercise_recyclerView = (RecyclerView) itemView.findViewById(R.id.exercises_recyclerView);
        }
    }


}
