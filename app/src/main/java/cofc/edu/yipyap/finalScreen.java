package cofc.edu.yipyap;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class finalScreen extends AppCompatActivity {

    Button homeButton;
    Button againButton;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        homeButton = (Button) findViewById(R.id.home);
        againButton = (Button) findViewById(R.id.playAgain);

        againButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalScreen.this.startActivity(new Intent(finalScreen.this, configActivity.class));
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalScreen.this.startActivity(new Intent(finalScreen.this, startActivity.class));
            }
        });


    }
}
