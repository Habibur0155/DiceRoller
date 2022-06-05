package com.example.diceroller;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private Button button;
    private TextView textView;
    private String s;
    private Random random;
    private int prev = -1;
    private int pres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        random = new Random();

        imageView = findViewById(R.id.imageView);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView);

        s = "No One Rolled The Dice";
        textView.setText(s);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int x = random.nextInt();
                if (x < 0) x *= -1;
                x = x % 6 + 1;
                prev = pres;
                pres = x;
                s = "Previous Dice Number: " + String.valueOf(prev) + "\n Present Dice Number: " + String.valueOf(x);
                textView.setText(s);
                changeImage(x);
            }
        });
    }

    private void changeImage(int x) {
        switch (x) {
            case 1: imageView.setImageResource(R.drawable.i); break;
            case 2: imageView.setImageResource(R.drawable.ii); break;
            case 3: imageView.setImageResource(R.drawable.iii); break;
            case 4: imageView.setImageResource(R.drawable.iv); break;
            case 5: imageView.setImageResource(R.drawable.v); break;
            default: imageView.setImageResource(R.drawable.vi);
        }
    }
}