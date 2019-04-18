package com.example.wewerk_v12.activities;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;

import com.example.wewerk_v12.R;

public class TimerActivity extends AppCompatActivity {

    private Chronometer mChronometer;
    private Button mStart_button, mStop_button, mReset_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        mChronometer = (Chronometer) findViewById(R.id.timer_chronometer);
        mStart_button = (Button) findViewById(R.id.timer_start_button);
        mStop_button = (Button) findViewById(R.id.timer_stop_button);
        mReset_button = (Button) findViewById(R.id.timer_reset_button);

        mStart_button.setOnClickListener(onStartButtonListener);
        mStop_button.setOnClickListener(onStopButtonListener);
        mReset_button.setOnClickListener(onPauseButtonListener);
    }

    View.OnClickListener onStartButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mChronometer.start();
        }
    };

    View.OnClickListener onStopButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mChronometer.stop();
        }
    };
    View.OnClickListener onPauseButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            mChronometer.stop();
            mChronometer.setBase(SystemClock.elapsedRealtime());
            //TODO: when clicking on start after the reset, start gets the old time
        }
    };


}
