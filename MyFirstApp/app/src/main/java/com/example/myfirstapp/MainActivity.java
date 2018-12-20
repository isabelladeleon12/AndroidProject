package com.example.myfirstapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.mapbox.mapboxsdk.Mapbox;

/*Main activity, entry point for the app. When app is
 * built, system launches instance of this Activity
 * and loads its layout */

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //lmao

        Mapbox.getInstance(getApplicationContext(), getString(R.string.mapbox_access_token));
    }

    /** Called when the user taps the Send button
     * Must always be public, void, and with View parameter*/
    public void sendMessage(View view) {

        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText2);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);


    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if(resultCode == RESULT_OK) {
                String strEditText = data.getStringExtra("editTextValue");
            }
        }
    }
}
