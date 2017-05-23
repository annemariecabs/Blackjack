package com.bishopireton.blackjack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setting the values
        //Card.back = (ImageView) findViewById(R.drawable.aceofclubs);
        ImageView[] pCards = {(ImageView) findViewById(R.id.card6), (ImageView) findViewById(R.id.card2),
                (ImageView) findViewById(R.id.card3), (ImageView) findViewById(R.id.card4),
                (ImageView) findViewById(R.id.card5)};
        ImageView[] cCards = {(ImageView) findViewById(R.id.card6), (ImageView) findViewById(R.id.card7),
                (ImageView) findViewById(R.id.card8), (ImageView) findViewById(R.id.card9),
                (ImageView) findViewById(R.id.card10)};



    }

}
