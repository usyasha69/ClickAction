package com.example.pk.clickaction;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private int clickCounter;

    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new Handler();

        final Button goToActivityButton = (Button) findViewById(R.id.goToActivity);

        goToActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickCounter++;

                if (clickCounter > 0) {
                    handler.removeMessages(0);
                }

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if (clickCounter == 1) {
                            clickCounter = 0;
                            MainActivity.this.startActivity(new Intent(
                                    MainActivity.this ,ActivityTwo.class));
                        }
                        if (clickCounter == 2) {
                            clickCounter = 0;
                            MainActivity.this.startActivity(new Intent(
                                    MainActivity.this ,ActivityThree.class));
                        }
                        if (clickCounter == 3) {
                            clickCounter = 0;
                            MainActivity.this.startActivity(new Intent(
                                    MainActivity.this ,ActivityFour.class));
                        }
                        if (clickCounter > 3) {
                            clickCounter = 0;
                        }
                    }
                }, 1000);
            }
        });
    }
}
