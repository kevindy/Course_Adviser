package com.example.kevinmarlsondy.courseadviser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.Serializable;
import java.util.List;

public class MainActivity extends Activity {

    private CourseChecklist coursechecklist = new CourseChecklist();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public void onClickFindCourse(View view){



        //Get a reference to the Spinner
        Spinner spinner = (Spinner) findViewById(R.id.spinner_terms);

        //Get a reference to the TextView
        TextView courses = (TextView) findViewById(R.id.tv_courses);

        //Get the selected item in the Spinner
        String term = String.valueOf(spinner.getSelectedItem());

        //Get recommendations from the Course Checklist
        List<String> courseList = coursechecklist.getCourses(term);

        //Format string list
        StringBuilder coursesFormatted = new StringBuilder();

        for (String course: courseList)
            coursesFormatted.append(course).append('\n');



        Intent intent = new Intent(this, Three.class);
        intent.putExtra("mymessage", (Serializable) coursesFormatted);
        startActivity(intent);

    }

    /*//Call onDisplayCourses() when the button is clicked
    public void onDisplayCourses(View view){
        //EditText messageView=(EditText)findViewById(R.id.message);
        //String messageText=messageView.getText().toString();
        Intent intent = new Intent(this, CourseChecklist.class);
        //intent.putExtra(CourseChecklist.EXTRA_MESSAGE, messageText);
        startActivity(intent);
    }*/

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
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
