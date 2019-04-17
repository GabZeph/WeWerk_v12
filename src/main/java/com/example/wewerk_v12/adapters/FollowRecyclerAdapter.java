package com.example.wewerk_v12.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.wewerk_v12.R;
import com.example.wewerk_v12.models.User;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class FollowRecyclerAdapter extends RecyclerView.Adapter<FollowRecyclerAdapter.ViewHolder> {

    private ArrayList<User> mUserArrayList = new ArrayList<>();
    private OnUserFollowListener mOnUserFollowListener;
    private static final String TAG = "FollowRecyclerAdapter";

    public FollowRecyclerAdapter(ArrayList<User> userArrayList, OnUserFollowListener onUserFollowListener) {
        this.mUserArrayList = userArrayList;
        this.mOnUserFollowListener = onUserFollowListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_follow_list_item, viewGroup, false);
        return new FollowRecyclerAdapter.ViewHolder(view, mOnUserFollowListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {

        //TODO: chancge profile picture

        //TODO: change follow button

        viewHolder.follow_realName_textView.setText(mUserArrayList.get(i).getRealName());
        viewHolder.follow_username_textView.setText(mUserArrayList.get(i).getUsername());
    }

    @Override
    public int getItemCount() {
        return mUserArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView follow_realName_textView, follow_username_textView;
        CircleImageView follow_profilePicture_imageView;
        Button follow_button;
        OnUserFollowListener onUserFollowListener;

        public ViewHolder(@NonNull View itemView, OnUserFollowListener onUserFollowListener) {
            super(itemView);

            follow_profilePicture_imageView = (CircleImageView) itemView.findViewById(R.id.follow_profilePicture_circleImageView);
            follow_realName_textView = (TextView) itemView.findViewById(R.id.follow_realName_textView);
            follow_username_textView = (TextView) itemView.findViewById(R.id.follow_username_textView);
            follow_button = (Button) itemView.findViewById(R.id.follow_button);

            this.onUserFollowListener = onUserFollowListener;

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onUserFollowListener.onUserFollowClicked(getAdapterPosition());
            Log.d(TAG, "onClick: " + getAdapterPosition());
        }
    }

    public interface OnUserFollowListener {
        void onUserFollowClicked(int position);
    }


}
