package com.example.wtest008_saveloadstate;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    TextView tvCounter;
    public int iStep = 0;
    private Handler handler;
    private Runnable runnable;
    private final String SAVED_MESSAGE_KEY = "SAVED_MESSAGE";
    private static final String LOG_TAG = "WTest008";

    private static String STATE_TO_STORE = "state_to_store";

    private void loadSavedInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState!=null) {
            (Toast.makeText(this,"MainActivity.Loading saved state",Toast.LENGTH_SHORT)).show();
            if (savedInstanceState.containsKey("iStep")) {
                iStep = savedInstanceState.getInt("iStep");
                (Toast.makeText(this,"MainActivity.Key found "+savedInstanceState.getInt("iStep"),Toast.LENGTH_SHORT)).show();
            }
            else {
                (Toast.makeText(this,"MainActivity.key not found",Toast.LENGTH_SHORT)).show();
            }
        }
        else {
            (Toast.makeText(this,"MainActivity.SavedStateNotFound",Toast.LENGTH_SHORT)).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        (Toast.makeText(this,"MainActivity.onCreate",Toast.LENGTH_SHORT)).show();
        Log.i("zzMain","MainActivity.onCreate");
        loadSavedInstanceState(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Init global variables
        tvCounter = findViewById(R.id.tvCounter);
        // Load bundle values
        Log.d(LOG_TAG, "MainActivity.onCreate: savedInstanceState = " + (savedInstanceState == null ? "NULL" : "Not NULL"));

        // Update UI
        tvCounter.setText(Integer.toString(iStep));
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i("zzMain","MainActivity.onRestoreInstanceState");
        (Toast.makeText(this,"MainActivity.onRestoreInstanceState",Toast.LENGTH_SHORT)).show();
//        loadSavedInstanceState(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
        (Toast.makeText(this,"MainActivity.onStart",Toast.LENGTH_SHORT)).show();
        Log.i("zzMain","MainActivity.onStart");
        handler = new Handler();
        runnable = new Runnable() {
            @Override
            public void run() {
                /* do what you need to do */
                tvCounter = findViewById(R.id.tvCounter);
//                if (tvCounter!=null)
                    iStep++;
                    tvCounter.setText(Integer.toString(iStep));
                /* and here comes the "trick" */
                handler.postDelayed(this, 1000);
            }
        };
        handler.postDelayed(runnable, 1000);
    }

    @Override
    protected void onPause() {
        super.onPause();
        (Toast.makeText(this,"MainActivity.onPause",Toast.LENGTH_SHORT)).show();
        Log.i("zzMain","MainActivity.onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        (Toast.makeText(this,"MainActivity.onStop",Toast.LENGTH_SHORT)).show();
        Log.i("zzMain","MainActivity.onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        (Toast.makeText(this,"MainActivity.onDestroy",Toast.LENGTH_SHORT)).show();
        Log.i("zzMain","MainActivity.onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        (Toast.makeText(this,"MainActivity.onRestart",Toast.LENGTH_SHORT)).show();
        Log.i("zzMain","MainActivity.onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        (Toast.makeText(this,"MainActivity.onResume",Toast.LENGTH_SHORT)).show();
        Log.i("zzMain","MainActivity.onResume");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("iStep",iStep);
        (Toast.makeText(this,"MainActivity.onSaveInstanceState bundle: " + iStep,Toast.LENGTH_SHORT)).show();
        Log.d(LOG_TAG, "MainActivity.onSaveInstanceState bundle: " + outState.toString());
    }

    public void onOKClick(View view) {
        tvCounter = findViewById(R.id.tvCounter);
        tvCounter.setText(Integer.toString(11));
    }

    public void btnNextClick(View view) {
        Intent intent = new Intent(this,NextActivity.class);
        this.startActivity(intent);
    }

    public void onBtnQuitClick(View view) {

        finish();
        System.exit(0);
    }
}
