package com.istic.jeremy.mmm_tp1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        startActivityWithIntent();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_second, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void startActivityWithIntent() {
//        Intent intent = getIntent();
//
//        TextView fnE = (TextView)findViewById(R.id.result_firstName);
//        fnE.setText(" : " + intent.getStringExtra("firstName"));
//
//        TextView lnE = (TextView)findViewById(R.id.result_lastName);
//        lnE.setText(" : " + intent.getStringExtra("lastName"));
//
//        TextView bdE = (TextView)findViewById(R.id.result_birthDay);
//        bdE.setText(" : " + intent.getStringExtra("birthDay"));
//
//        TextView bdC = (TextView)findViewById(R.id.result_birthCity);
//        bdC.setText(" : " + intent.getStringExtra("birthCity"));



        Person person = getIntent().getExtras().getParcelable("Person");

        TextView fnE = (TextView)findViewById(R.id.result_firstName);
        fnE.setText(" : " + person.getFirstName());

        TextView lnE = (TextView)findViewById(R.id.result_lastName);
        lnE.setText(" : " + person.getLastName());

        TextView bdE = (TextView)findViewById(R.id.result_birthDay);
        bdE.setText(" : " + person.getBirthDay());

        TextView bdC = (TextView)findViewById(R.id.result_birthCity);
        bdC.setText(" : " + person.getBirthCity());

    }
}
