package com.istic.jeremy.mmm_tp1;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_resetData) {
            EditText fnE = (EditText)findViewById(R.id.edit_firstName);
            EditText lnE = (EditText)findViewById(R.id.edit_lastName);
            EditText bdE = (EditText)findViewById(R.id.edit_birthDay);
            EditText bdC = (EditText)findViewById(R.id.edit_birthCity);

            fnE.setText(null);
            lnE.setText(null);
            bdE.setText(null);
            bdC.setText(null);
        }

        if (id == R.id.action_addTel) {
            LinearLayout linear = (LinearLayout)findViewById(R.id.linear_1);
            TextView telTextView = new TextView(this);
            telTextView.setText(R.string.label_tel);

            EditText telEditText = new EditText(this);
            telEditText.setInputType(InputType.TYPE_CLASS_NUMBER);

            linear.addView(telTextView);
            linear.addView(telEditText);

            item.setEnabled(false);
        }

        if (id == R.id.action_searchBirthCity ) {

            EditText bdC = (EditText)findViewById(R.id.edit_birthCity);
            String query = bdC.getText().toString();

            String url = "http://fr.wikipedia.org/wiki/Special:Search?search="+ query;
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * displayData : function use to display user data in a toast
     * use in q1.1
     * deprecated above q1.1
     * @param view
     */
    public void displayData(View view) {
        EditText fnE = (EditText)findViewById(R.id.edit_firstName);
        String firstName = fnE.getText().toString();

        EditText lnE = (EditText)findViewById(R.id.edit_lastName);
        String lastName = lnE.getText().toString();

        EditText bdE = (EditText)findViewById(R.id.edit_birthDay);
        String BirthDay = bdE.getText().toString();

        EditText bdC = (EditText)findViewById(R.id.edit_birthCity);
        String BirthCity = bdC.getText().toString();

        Toast.makeText(MainActivity.this, firstName + "\n" + lastName + "\n" + BirthDay + "\n" + BirthCity, Toast.LENGTH_SHORT).show();
    }

    public void sendDataToSecondActivity(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        EditText fnE = (EditText)findViewById(R.id.edit_firstName);
        String firstName = fnE.getText().toString();

        EditText lnE = (EditText)findViewById(R.id.edit_lastName);
        String lastName = lnE.getText().toString();

        EditText bdE = (EditText)findViewById(R.id.edit_birthDay);
        String birthDay = bdE.getText().toString();

        EditText bdC = (EditText)findViewById(R.id.edit_birthCity);
        String birthCity = bdC.getText().toString();
//
//        intent.putExtra("firstName", firstName);
//        intent.putExtra("lastName", lastName);
//        intent.putExtra("birthDay", birthDay);
//        intent.putExtra("birthCity", birthCity);


        Person person = new Person(firstName, lastName, birthDay, birthCity);

        intent.putExtra("Person",person);


        startActivity(intent);
    }
}
