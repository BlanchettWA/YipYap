package cofc.edu.yipyap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import android.text.TextWatcher;
import android.content.Intent;
import android.view.KeyEvent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputType;
import java.util.ArrayList;


//Recieves number of turns, PlayerList, and Topic from the config actifity. They are named
//     as follors, respectively: "NumTurns","PlayerList","Topic"

public class MainActivity extends AppCompatActivity {


    // Variable initialization
    //Placed outisde of the function so they can persist through the whole activity
    TextView topic;
    TextView playerTurn;
    TextView enterWordsText;
    Button home;
    Button done;
    TextView wordsPosted;
    TextView roundsLeft;


    int roundCount = 1;
    int playerNum = 0;
    String player;
    ArrayList<String> words = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        topic = (TextView) findViewById(R.id.topicBox);
        playerTurn = (TextView) findViewById(R.id.playerTurn);
        enterWordsText = (TextView) findViewById(R.id.enterWordsText);
        home = (Button) findViewById(R.id.home);
        done = (Button) findViewById(R.id.done);
        wordsPosted = (EditText) findViewById(R.id.wordsPosted);
        roundsLeft = (TextView) findViewById(R.id.roundsLeft);


        // retrieving bundle from configActivity

        Intent extras = getIntent();

        roundCount = extras.getIntExtra("NumTurns",5);
        final ArrayList<String> playerList = extras.getStringArrayListExtra("PlayerList");
        final String gameTopic = extras.getStringExtra("Topic");

        topic.setText("Topic: " + gameTopic);
        roundsLeft.setText("Rounds Left: " + roundCount);
        playerTurn.setText("Player's Turn: " + playerList.get(playerNum));

        wordsPosted.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (roundCount == 0) {
                    Toast.makeText(getApplicationContext(), "The jig is up! Click 'Done' to see your full story.", Toast.LENGTH_SHORT).show();
                } else {
                    String word = wordsPosted.getText().toString();
                    if (word.length() > 0) {
                        words.add(word.toString());
                        playerNum++;
                        if (playerNum < playerList.size()) {
                            playerTurn.setText("Player's Turn: " + playerList.get(playerNum));
                        } else {
                            playerNum = 0;
                            playerTurn.setText("Player's Turn: " + playerList.get(playerNum));
                            roundCount--;
                            roundsLeft.setText("Rounds Left: " + roundCount);
                        }
                        wordsPosted.setText("");
                    }
                }
                return handled;
            }
        });

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.startActivity(new Intent(MainActivity.this, startActivity.class));
            }
        });

        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toResult = new Intent(MainActivity.this, recordActivity.class);
                toResult.putExtra("NumRounds", roundCount);
                toResult.putExtra("PlayerList",playerList);
                toResult.putExtra("Topic", gameTopic);
                toResult.putExtra("WordStory",words);
                MainActivity.this.startActivity(toResult);
            }
        });






    }
}
