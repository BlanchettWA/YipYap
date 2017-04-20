package cofc.edu.yipyap;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

//Recieves number of turns, PlayerList, and Topic from the config actifity. They are named
//     as follors, respectively: "NumTurns","PlayerList","Topic"

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
