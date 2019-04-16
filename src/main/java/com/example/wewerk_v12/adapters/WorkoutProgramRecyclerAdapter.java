package com.example.wewerk_v12.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wewerk_v12.R;
import com.example.wewerk_v12.models.WorkoutProgram;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class WorkoutProgramRecyclerAdapter extends RecyclerView.Adapter<WorkoutProgramRecyclerAdapter.ViewHolder> {

    private ArrayList<WorkoutProgram> mWorkoutProgramArrayList = new ArrayList<>();
    private OnWorkoutProgramListener mOnWorkoutProgramListener;

    public WorkoutProgramRecyclerAdapter(ArrayList<WorkoutProgram> workoutProgramArrayList, OnWorkoutProgramListener onWorkoutProgramListener) {
        this.mWorkoutProgramArrayList = workoutProgramArrayList;
        this.mOnWorkoutProgramListener = onWorkoutProgramListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //instantiating view holder
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_workout_program_list_item, viewGroup, false);
        return new ViewHolder(view, mOnWorkoutProgramListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        //setting the attributes for each item
        //TODO: retrieve data from firebase

        //TODO: change image, difficulty, muscles solicitated views
        viewHolder.programName_textView.setText(mWorkoutProgramArrayList.get(i).getWorkoutProgramName());
        viewHolder.workoutCreator_textView.setText(mWorkoutProgramArrayList.get(i).getWorkoutProgramName());
//        viewHolder.difficulty_textView.setText(mWorkoutProgramArrayList.get(i).getWorkoutProgramName());
//        viewHolder.muscleSolicitated_textView.setText(mWorkoutProgramArrayList.get(i).get());

    }

    @Override
    public int getItemCount() {
        return mWorkoutProgramArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

//        CircleImageView programImage_imageView;

        ImageView creatorProfilePicture_imageView, bookmarkedProgram_imageView, lovedProgram_imageView;

        TextView creatorUsername_textView,programName_textView, workoutCreator_textView,
                muscleSolicitated_textView, difficulty_textView;

        OnWorkoutProgramListener onWorkoutListener;

        public ViewHolder(@NonNull View itemView, OnWorkoutProgramListener onWorkoutListener) {
            super(itemView);

            this.onWorkoutListener = onWorkoutListener;

            //initializing views from workout list_item
//            programImage_imageView = (CircleImageView) itemView.findViewById(R.id.programImage_imageView);
            programName_textView = (TextView) itemView.findViewById(R.id.programName_textView);
            workoutCreator_textView = (TextView) itemView.findViewById(R.id.workoutCreator_textView);
            muscleSolicitated_textView = (TextView) itemView.findViewById(R.id.muscleSolicitated_textView);
            creatorUsername_textView = (TextView) itemView.findViewById(R.id.creatorUsename_textView);

            creatorProfilePicture_imageView=(ImageView) itemView.findViewById(R.id.creatorProfilePicture_ImageView);
            bookmarkedProgram_imageView=(ImageView) itemView.findViewById(R.id.bookmarkedProgram_imageView);
            lovedProgram_imageView=(ImageView) itemView.findViewById(R.id.lovedProgram_imageView);

            //attaching on click listener to entire view
            itemView.setOnClickListener(this);

            //TODO: adding listener on liked and bookmarked button
            addingImageViewListener();

        }

        @Override
        public void onClick(View v) {
            onWorkoutListener.onWorkoutProgramClicked(getAdapterPosition());
        }
    }

    private void addingImageViewListener() {
    }

    public interface OnWorkoutProgramListener {
        void onWorkoutProgramClicked(int position);
    }

}
