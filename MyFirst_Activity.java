package com.space.myfirstapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by dell on 7/8/16.
 */
public class MyFirst_Activity extends Activity {

    private static final int REQUEST_CODE =1 ;
    private EditText userName;

    //private static final String TAG="TAG";
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_mainlayout);

        userName = (EditText) findViewById(R.id.userEmail);
        if(savedInstanceState!=null) //to get the value of the bundle once a new activity is called
        {
            String email = savedInstanceState.getString("USER_MAIL");
            email = email+"ORIENTATION CHANGED";
            userName.setText("ORIENTATION CHANGED");
        }
        //Log.d(TAG,"OnCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
       // Log.d(TAG, "OnStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        //Log.d(TAG, "OnResume()");

    }

    @Override
    protected void onPause() {
        super.onPause();
        //Log.d(TAG, "OnPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
       // Log.d(TAG, "OnStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Log.d(TAG, "OnDestroy()");

    }

    public void SecondActivity(View view ){
        //create new activity
        Intent SecondActivity = new Intent(getApplicationContext(),SecondActivity.class);
        //pass data to second activity
        SecondActivity.putExtra("USER_NAME", "advaitdeshpande88@gmail.com");
        //startActivity(SecondActivity);
        startActivityForResult(SecondActivity,REQUEST_CODE);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("USER_MAIL",userName.getText().toString().trim());
        super.onSaveInstanceState(outState);
    }

    @Override
    //returns the value of the screen that is called.
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==REQUEST_CODE && resultCode==Activity.RESULT_OK){
            Toast.makeText(MyFirst_Activity.this, "SUCCESS", Toast.LENGTH_SHORT).show();
        }
        if(requestCode==REQUEST_CODE && resultCode==Activity.RESULT_CANCELED){
            Toast.makeText(MyFirst_Activity.this, "FAILURE", Toast.LENGTH_SHORT).show();

        }


        super.onActivityResult(requestCode, resultCode, data);
    }
}
