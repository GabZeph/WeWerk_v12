package com.example.wewerk_v12.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.wewerk_v12.R;

public class ProfileStalkingActivity extends AppCompatActivity {

    private TextView mRealNameTextView, mUsernameTextView, mProgramNumber_textView,
            mFollowerNumber_textView, mFollowingNumber_textView;
    private Button mFollowButton, mMessageButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_stalking);

        //initializing views
        mRealNameTextView = (TextView) findViewById(R.id.realNameTextView);
        mUsernameTextView = (TextView) findViewById(R.id.usernameTextView);
        mProgramNumber_textView = (TextView) findViewById(R.id.programNumberTextView);
        mFollowerNumber_textView = (TextView) findViewById(R.id.followerNumberTextView);
        mFollowingNumber_textView = (TextView) findViewById(R.id.followingNumbertextView);

        mFollowButton = (Button) findViewById(R.id.followButton);
        mMessageButton = (Button) findViewById(R.id.messageButton);

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
    }

    private void sendMessageActivity() {
        Intent intent = new Intent(this, SendMessageActivity.class);
        startActivity(intent);
    }
}
