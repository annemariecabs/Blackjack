package com.bishopireton.blackjack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by AnneMarie on 5/28/2017.
 */

public class OpeningActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opening_screen);
    }

    public void play(View view) {
        Intent whatsNext = new Intent(this, WinningActivity.class);
        startActivity(whatsNext);
    }
}
