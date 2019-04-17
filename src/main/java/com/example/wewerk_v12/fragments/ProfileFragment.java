package com.example.wewerk_v12.fragments;

import android.content.Intent;
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
import android.widget.Toast;

import com.example.wewerk_v12.R;
import com.example.wewerk_v12.activities.FollowActivity;
import com.example.wewerk_v12.models.User;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {

    private TextView mRealName_textView, mUsername_textView, mProgramsNumber_textView,
            mFollowersNumber_textView, mFollowingNumber_textView;

//    private Button mFollow_button, mMessage_button;

    //private FrameLayout mProfileContrainer_frameLayout;

    private ArrayList<User> mUserArrayList = new ArrayList<>();

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
//TODO: add button


//        mFollow_button = (Button) view.findViewById(R.id.followButton);
//        mMessage_button = (Button) view.findViewById(R.id.messageButton);

        mFollowingNumber_textView.setOnClickListener(onTextViewClickedListener);
        mFollowersNumber_textView.setOnClickListener(onTextViewClickedListener);


        //  mProfileContrainer_frameLayout = (FrameLayout) view.findViewById(R.id.profileContainer_frameLayout);


        //TODO: change text in views according to user infos
        setUserInfos();
        //TODO: view user saved workout using pager adapter
        //addWorkoutsProgramsToFrameLayout();

        return view;
    }

    private View.OnClickListener onTextViewClickedListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

//            ArrayList<User> userArrayList = new ArrayList<>();
//mUserArrayList.clear();

            switch (view.getId()) {
                case R.id.followerNumberTextView:
                    Toast.makeText(getContext(), R.string.text_followers, Toast.LENGTH_SHORT).show();

                    //TODO: retrieve user followers from firebase
                    //generating fake folllowers
                    generatingFakeFollowers();

                    break;
                case R.id.followingNumbertextView:
                    Toast.makeText(getContext(), R.string.text_following, Toast.LENGTH_SHORT).show();

                    //TODO: retrieve user following from firebase

                    //generating fake follloings
                    genreatingFakeFollowing();

                    break;

                default:
                    break;
            }

            //showing followers or following users page
            goToFollowPage();

        }
    };

    private void genreatingFakeFollowing() {
        for (int i = 0; i < 100; i++) {
            User user = new User("jerry", "jerry123");
            mUserArrayList.add(user);
        }
    }

    private void generatingFakeFollowers() {
        for (int i = 0; i < 100; i++) {
            User user = new User("bob", "bobby123");
            mUserArrayList.add(user);
        }
    }

    private void goToFollowPage() {
        Intent intent = new Intent(getContext(), FollowActivity.class);
        intent.putExtra("follow_arrayList", mUserArrayList);
        startActivity(intent);
    }


//    private void addWorkoutsProgramsToFrameLayout() {
//        //set pager adapter to get infos...
//
//    }

    private void setUserInfos() {
        //retrieve data from firebase

        //change textviews according to user info


    }
}
