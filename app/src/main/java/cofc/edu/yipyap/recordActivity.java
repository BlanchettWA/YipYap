package cofc.edu.yipyap;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class recordActivity extends AppCompatActivity {
    // Button Id's
    /*
Back Button back2
    * */

    Button backButton;
    SharedPreferences stories;
    String storyNameString;
    String[] storyNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);

        backButton = (Button) findViewById(R.id.back2);
        stories = getSharedPreferences("sstories",MODE_PRIVATE);
        storyNameString = stories.getString("storyList","");
        System.out.println("HERE WE GO: " + storyNameString);
        if (storyNameString.length() > 0){storyNames = storyNameString.split("\\|");}
        else {storyNames = null;}
        System.out.println("Here is the table");

        for (int i = 0; i < storyNames.length; i++) {
            System.out.println(storyNames[i]);
        }


        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(recordActivity.this, startActivity.class));
            }
        });
    }

}
