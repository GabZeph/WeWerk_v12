package com.example.wewerk_v12.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.wewerk_v12.R;

public class ProfileFragment extends Fragment {

    private TextView mRealName_textView, mUsername_textView, mProgramsNumber_textView,
            mFollowersNumber_textView, mFollowingNumber_textView;

//    private Button mFollow_button, mMessage_button;

    private FrameLayout mProfileContrainer_frameLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        //initializing views
        mRealName_textView = (TextView) view.findViewById(R.id.realNameTextView);
        mUsername_textView = (TextView) view.findViewById(R.id.username_textView);
        mProgramsNumber_textView = (TextView) view.findViewById(R.id.programNumberTextView);
        mFollowersNumber_textView = (TextView) view.findViewById(R.id.followerNumberTextView);
        mFollowingNumber_textView = (TextView) view.findViewById(R.id.followingNumbertextView);

//        mFollow_button = (Button) view.findViewById(R.id.followButton);
//        mMessage_button = (Button) view.findViewById(R.id.messageButton);

        mProfileContrainer_frameLayout=(FrameLayout) view.findViewById(R.id.profileContainer_frameLayout);


        //TODO: change text in views according to user infos
        setUserInfos();
        //TODO: view user saved workout using pager adapter
        addWorkoutsProgramsToFrameLayout();

        return view;
    }

    private void addWorkoutsProgramsToFrameLayout() {
        //set pager adapter to get infos...

    }

    private void setUserInfos() {
        //retrieve data from firebase

        //change textviews according to user info


    }
}
