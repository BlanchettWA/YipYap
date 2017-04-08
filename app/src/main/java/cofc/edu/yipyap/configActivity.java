package cofc.edu.yipyap;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class configActivity extends AppCompatActivity {

    /*
    UI ID's:

    gameTopicBox - Entry Textbox for the Topic
    randomTopicButton - random selects from a list.
    addPlayerButton - Button to put a person in the list
    listPlayers - ListView that displays players in the game
    numTurnsBox - Entrybox for the number of teurns
    mainMenuButton - button to return to main menu
    startGameButton - Button to start the game


     */

    String[] randomTopicList = {"Sports","Technology","Weather","Art","People"};
    int numPlayers = 0;
    int numTurns = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
            }

}
