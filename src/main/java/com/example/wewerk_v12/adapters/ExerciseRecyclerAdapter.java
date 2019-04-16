package com.example.wewerk_v12.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wewerk_v12.R;
import com.example.wewerk_v12.models.Exercice;

import java.util.ArrayList;

public class ExerciseRecyclerAdapter extends RecyclerView.Adapter<ExerciseRecyclerAdapter.ViewHolder> {

    private ArrayList<Exercice> mExercisesArrayList = new ArrayList<>();

    public ExerciseRecyclerAdapter(ArrayList<Exercice> exercisesArrayList) {
        this.mExercisesArrayList = exercisesArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_exercise_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        //TODO: review setting data
        //changing exercise data
        viewHolder.movementName_textView.setText(mExercisesArrayList.get(i).getMovementName());
        viewHolder.repNumber_textView.setText(mExercisesArrayList.get(i).getRepNumber());
        viewHolder.setNumber_textView.setText(mExercisesArrayList.get(i).getSetNumber());

    }

    @Override
    public int getItemCount() {
        return mExercisesArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder  {

TextView movementName_textView, setNumber_textView, repNumber_textView;
    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        //initializing views
        movementName_textView=itemView.findViewById(R.id.movementName_textView);
        setNumber_textView=itemView.findViewById(R.id.setNumber_textView);
        repNumber_textView=itemView.findViewById(R.id.repNumber_textView);

    }
}



}
