package com.bishopireton.blackjack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by AnneMarie on 6/4/2017.
 */

public class EndingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ending_layout);

        Intent intent = getIntent();
        String reason = intent.getStringExtra(GameActivity.REASON);
        boolean won = intent.getBooleanExtra(GameActivity.WINNER, true);

        if(won);


    }
}
