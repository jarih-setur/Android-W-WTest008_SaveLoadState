package com.example.wtest008_saveloadstate;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NextActivity extends AppCompatActivity {
    EditText etFirstname, etLastname;
    TextView tvCompiledName;
    final static String tagFirstname = "NextActivity.Firstname";
    final static String tagLastname = "NextActivity.Lastname";
    final static String tagCompiledname = "NextActivity.Compiledname";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        (Toast.makeText(this,"NextActivity.onCreate",Toast.LENGTH_SHORT)).show();
        Log.i("NextActivityLog","NextActivity.onCreate");
        setContentView(R.layout.activity_next);
        etFirstname = findViewById(R.id.etFirstname);
        etLastname  = findViewById(R.id.etLastname);
        tvCompiledName = findViewById(R.id.tvCompiledName);
        loadSavedInstanceState(savedInstanceState);

    }

    private void loadSavedInstanceState(Bundle savedInstanceState) {
        if (savedInstanceState!=null) {
            (Toast.makeText(this,"NextActivity.Loading saved state",Toast.LENGTH_SHORT)).show();
            if (savedInstanceState.containsKey(tagFirstname)) {
//                String str = savedInstanceState.getString(tagFirstname);
                etFirstname.setText(savedInstanceState.getString(tagFirstname)+" xxx");
            }
            else (Toast.makeText(this,"NextActivity.key not found: "+tagFirstname,Toast.LENGTH_SHORT)).show();

            if (savedInstanceState.containsKey(tagLastname))
                etLastname.setText(savedInstanceState.getString(tagLastname));
            else (Toast.makeText(this,"NextActivity.key not found: "+tagLastname,Toast.LENGTH_SHORT)).show();
            if (savedInstanceState.containsKey(tagCompiledname)) tvCompiledName.setText(savedInstanceState.getString(tagCompiledname));
            else (Toast.makeText(this,"NextActivity.key not found: "+tagCompiledname,Toast.LENGTH_SHORT)).show();

        }
        else {
            (Toast.makeText(this,"NextActivity.SavedStateNotFound",Toast.LENGTH_SHORT)).show();
        }
        Log.i("NextActivityLog","NextActivity.loadSavedInstanceState");
    }

    @Override
    protected void onStart() {
        super.onStart();
        (Toast.makeText(this,"NextActivity.onStart",Toast.LENGTH_SHORT)).show();
        Log.i("NextActivityLog","NextActivity.onStart");
    }

    @Override
    protected void onPause() {
        super.onPause();
        (Toast.makeText(this,"NextActivity.onPause",Toast.LENGTH_SHORT)).show();
        Log.i("NextActivityLog","NextActivity.onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        (Toast.makeText(this,"NextActivity.onStop",Toast.LENGTH_SHORT)).show();
        Log.i("NextActivityLog","NextActivity.onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        (Toast.makeText(this,"NextActivity.onDestroy",Toast.LENGTH_SHORT)).show();
        Log.i("NextActivityLog","NextActivity.onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        (Toast.makeText(this,"NextActivity.onRestart",Toast.LENGTH_SHORT)).show();
        Log.i("NextActivityLog","NextActivity.onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        (Toast.makeText(this,"NextActivity.onResume",Toast.LENGTH_SHORT)).show();
        Log.i("NextActivityLog","NextActivity.onResume");
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(tagFirstname,etFirstname.getText().toString()); // save edit field value
        outState.putString(tagLastname,etLastname.getText().toString());
        outState.putString(tagCompiledname,tvCompiledName.getText().toString());
        (Toast.makeText(this,"NextActivity.onSaveInstanceState bundle: " + etFirstname.getText().toString(),Toast.LENGTH_SHORT)).show();
        Log.d("NextActivityLog", "NextActivity.onSaveInstanceState bundle: " + outState.toString());
    }

    public void onBtnSaveClick(View view) {
        tvCompiledName.setText(etFirstname.getText().toString().trim()+" "+etLastname.getText().toString().trim());

    }

}
