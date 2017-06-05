package com.bishopireton.blackjack;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class TestActivity extends AppCompatActivity {

    public static Player player;
    public static Computer house;
    public static Deck deck;
    public static Button hitButton;
    public static Button stayButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        setValues();
        playGame();
    }

    public void setValues() {
        //Setting the values
        Card.cardBack = R.drawable.card_back;
        ImageView[] pCards = {(ImageView) findViewById(R.id.card1), (ImageView) findViewById(R.id.card2),
                (ImageView) findViewById(R.id.card3), (ImageView) findViewById(R.id.card4),
                (ImageView) findViewById(R.id.card5)};
        ImageView[] cCards = {(ImageView) findViewById(R.id.card6), (ImageView) findViewById(R.id.card7),
                (ImageView) findViewById(R.id.card8), (ImageView) findViewById(R.id.card9),
                (ImageView) findViewById(R.id.card10)};

        deck = new Deck();
        deck.shuffle();

        player = new Player(pCards);
        house = new Computer(cCards);

        hitButton = (Button) findViewById(R.id.hit_button);
        stayButton = (Button) findViewById(R.id.stay_button);

        //set to gone because they should only appear as dealt
        for(int i = 0; i < pCards.length; i++) {
            pCards[i].setVisibility(View.GONE);
            cCards[i].setVisibility(View.GONE);
        }

        //should appear when it's the person's turn
        hitButton.setVisibility(View.GONE);
        stayButton.setVisibility(View.GONE);
    }

    public void playGame() {
        for (int i = 0; i < 2; i++) {
            player.addCard(deck.deal());
            house.addCard(deck.deal());
        }

    }

    public static void setCard(ImageView view, Card card) {
        //add something into setCard that simultaneously changes card values in other layout
        view.setVisibility(View.VISIBLE);
        view.setImageResource(CardImages.getImage(card));
    }

    public int getImage(Card c) {

        /*int[][] imageIDs = new int[4][13];
        for(int row = 0; row < imageIDs.length; row++)
            for(int col = 0; col < imageIDs[row].length; col++) {
                if(row == 0)
                    imageIDs[row][col] = R.drawable.clubs(col)
            }
            */

        String name = ""; //temp variable to hold the name before turning it into an id
        switch(c.getSuit()) {
            case 1: //clubs
                name = "clubs" + c.getRank();
                break;
            case 2: //diamonds
                name = "diamonds" + c.getRank();
                break;
            case 3: //hearts
                name = "hearts" + c.getRank();
                break;
            case 4: //spades
                name = "spades" + c.getRank();
        }

        return getResources().getIdentifier(name, "drawable", this.getPackageName());
    }

}
