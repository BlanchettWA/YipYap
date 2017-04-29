package cofc.edu.yipyap;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class rankingActivity extends AppCompatActivity {


    Button homeButton;
    Button fScreen;
    ListView wordPlay;
    ArrayList<String> wordsPlayed;
    int[] likeList;
    ArrayList<String> players;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivy_rating);

        homeButton = (Button) findViewById(R.id.home);
        fScreen =  (Button) findViewById(R.id.finalScreen);
        wordPlay = (ListView) findViewById(R.id.wordsPlayed);

        Intent previousData = getIntent();
        wordsPlayed = previousData.getStringArrayListExtra("WordStory");
        players = previousData.getStringArrayListExtra("PlayerList");

        //Create and initialize array for tracking the likes.
        likeList = new int[wordsPlayed.size()];
        for (int i = 0; i < wordsPlayed.size(); i++){likeList[i] = 0;}



        ArrayAdapter<String> toList = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,wordsPlayed);
        wordPlay.setAdapter(toList);
        toList.notifyDataSetChanged();


        fScreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tofinal = new Intent(rankingActivity.this, finalScreen.class);
                rankingActivity.this.startActivity(tofinal);
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rankingActivity.this.startActivity(new Intent(rankingActivity.this, startActivity.class));
            }
        });


    }
}