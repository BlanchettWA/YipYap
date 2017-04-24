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


    // Variable initialization
    //Placed outisde of the function so they can persist through the whole activity
    TextView topic;
    TextView playerTurn;
    EditText enterWords;
    Button home;
    Button done;
    TextView wordsPosted;
    TextView roundsLeft;


    int turnCount = 1;
    String player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        topic = (TextView) findViewById(R.id.topicBox);
        playerTurn = (TextView) findViewById(R.id.playerTurn);
        enterWords = (EditText) findViewById(R.id.enterWords);
        home = (Button) findViewById(R.id.home);
        done = (Button) findViewById(R.id.done);
        wordsPosted = (TextView) findViewById(R.id.wordsPosted);
        roundsLeft = (TextView) findViewById(R.id.roundsLeft);


        // retrieving bundle from configActivity

        System.out.println("HEY I GOT THE INITIAL STUFF DONE");
        System.out.println("________________________________");
        Intent extras = getIntent();
        System.out.println("HEY I CREATED AN INTENT");
        System.out.println("________________________________");



        int numTurns = extras.getIntExtra("NumTurns",5);
        ArrayList<String> playerList = extras.getStringArrayListExtra("PlayerList");
        String gameTopic = extras.getStringExtra("Topic");

        System.out.println("HEY I SET SOME VALUES UP");
        System.out.println("________________________________");

        topic.setText("Topic: " + gameTopic);
        roundsLeft.setText("Rounds Left: " + numTurns);

        System.out.println("ABOUT TO GET INTO A LOOP");

        /*
        // Game flow
        while(turnCount <= numTurns) {
            for(int i = 1; i < playerList.size(); i++) {
                player = playerList.get(i);
                playerTurn.setText("Player Turn: " + player);

            }
        }
*/






    }
}
