package com.example.wewerk_v12.fragments;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.wewerk_v12.R;
import com.example.wewerk_v12.activities.SendMessageActivity;

public class ProfileStalkingFragment extends Fragment {

    private TextView mRealNameTextView, mUsernameTextView, mProgramNumber_textView,
            mFollowerNumber_textView, mFollowingNumber_textView;
    private Button mFollowButton, mMessageButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile_stalking_fragment, container, false);
        //initializing views
        mRealNameTextView = (TextView) view.findViewById(R.id.realNameTextView);
        mUsernameTextView = (TextView) view.findViewById(R.id.usernameTextView);
        mProgramNumber_textView = (TextView) view.findViewById(R.id.programNumberTextView);
        mFollowerNumber_textView = (TextView) view.findViewById(R.id.followerNumberTextView);
        mFollowingNumber_textView = (TextView) view.findViewById(R.id.followingNumbertextView);

        mFollowButton = (Button) view.findViewById(R.id.followButton);
        mMessageButton = (Button) view.findViewById(R.id.messageButton);

//TODO: change textviews with setter

        mFollowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: add following when clicking on follow
            }
        });


        mMessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: message the user
                sendMessageActivity();
            }
        });

        return view;
    }

    private void sendMessageActivity() {
        Intent intent = new Intent(getContext(), SendMessageActivity.class);
        startActivity(intent);
    }
}
