package com.example.kevinmarlsondy.courseadviser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.widget.TextView;

/**
 * Created by Kevin Marlson Dy on 10/3/2015.
 */
public class Three extends Activity{

    private static final String DEBUG_TAG = "f";

    public static final String EXTRA_MESSAGE = "CourseChecklist";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checklist_course);
        Intent intent = getIntent();
        String messageText = intent.getStringExtra("mymessage");
        TextView messageView = (TextView)findViewById(R.id.display_courses);
        messageView.setText(messageText);

        Log.d(DEBUG_TAG, "onStart() "+messageText);

    }
}
