package com.space.myfirstapplication;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class SecondActivity extends Activity {

    private static final String TAG ="TAG" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //retrieve data from First screen
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null)
        {
            String username = bundle.getString("USER_NAME");
            Log.d(TAG, "onCreate: Username   " + username);

        }

        setContentView(R.layout.activity_second);
    }

    //@Override
   /* protected void onDestroy() {
        finish();
        setResult(Activity.RESULT_OK);
        super.onDestroy();
    }*/

    public void onCloseActivity(View view){
        setResult(Activity.RESULT_OK);
        finish();

    }
}
