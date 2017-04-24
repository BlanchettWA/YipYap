package cofc.edu.yipyap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.text.TextWatcher;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import java.util.ArrayList;

//Recieves number of turns, PlayerList, and Topic from the config actifity. They are named
//     as follors, respectively: "NumTurns","PlayerList","Topic"

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Variable initialization
        TextView topic;
        TextView playerTurn;
        EditText enterWords;
        Button home;
        Button done;
        TextView wordsPosted;
        TextView roundsLeft;

        int turnCount = 1;
        String player;

        topic = (TextView) findViewById(R.id.topicBox);
        playerTurn = (TextView) findViewById(R.id.playerTurn);
        enterWords = (EditText) findViewById(R.id.enterWords);
        home = (Button) findViewById(R.id.home);
        done = (Button) findViewById(R.id.done);
        wordsPosted = (TextView) findViewById(R.id.wordsPosted);
        roundsLeft = (TextView) findViewById(R.id.roundsLeft);


        // retrieving bundle from configActivity
        Bundle extras = getIntent().getExtras();
        int numTurns = extras.getInt("NumTurns");
        ArrayList<String> playerList = extras.getStringArrayList("PlayerList");
        String gameTopic = extras.getString("Topic");

        topic.setText("Topic: " + gameTopic);
        roundsLeft.setText("Rounds Left: " + numTurns);

        // Game flow
        while(turnCount <= numTurns) {
            for(int i = 1; i < playerList.size(); i++) {
                player = playerList.get(i);
                playerTurn.setText("Player Turn: " + player);

            }
        }








    }
}
