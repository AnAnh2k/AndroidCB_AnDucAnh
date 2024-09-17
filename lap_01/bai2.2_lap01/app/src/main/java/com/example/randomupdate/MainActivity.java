package com.example.randomupdate;
import android.widget.*;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.randomupdate.R;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imgDice;
    private Button btnRoll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgDice = findViewById(R.id.imgDice);
        btnRoll = findViewById(R.id.btnRoll);

        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int number = random.nextInt(6) + 1; // Generate a random number between 1 and 6
                int drawableResId = getResources().getIdentifier("dice_" + number, "drawable", getPackageName());
                imgDice.setImageResource(drawableResId);
            }
        });
    }
}
