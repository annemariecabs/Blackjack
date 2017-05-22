package com.bishopireton.blackjack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setting the final for CARD_BACK
        //Card.CARD_BACK = (ImageView) findViewById(R.drawable.aceofclubs);

    }
}
