package com.bishopireton.blackjack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    public static Player player;
    public static Computer house;
    public static Deck deck;
    public static Button hitButton;
    public static Button stayButton;


    //Make sure to change all ImageViews visibility to gone and buttons to invisible

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.opening_screen);
        //setValues();
    }

    public void setValues() {
        //Setting the values
        Card.cardBack = R.drawable.cardBack;
        ImageView[] pCards = {(ImageView) findViewById(R.id.card6), (ImageView) findViewById(R.id.card2),
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
    public static void setCard(ImageView view, int id) {
        //add something into setCard that simultaneously changes card values in other layout
        view.setVisibility(View.VISIBLE);
        view.setImageResource(id);
    }

    public static void hit(View view) {
        player.addCard(deck.deal());
    }

    public void play(View view) {
        setContentView(R.layout.activity_main);

        for(int i = 0; i < 2; i++) {
            player.addCard(deck.deal());
            house.addCard(deck.deal());
        }

        //changes the ImageViews
        setCard(player.getNextView(), player.getCards().get(0).getImage());
        setCard(player.getNextView(), player.getCards().get(1).getImage());
        setCard(house.getNextView(), Card.cardBack);
        setCard(house.getNextView(), house.getCards().get(1).getImage());

        if(player.sumCards() == 21 || house.sumCards() == 21);
        //Replace with winning layout and show dealer's card

        hitButton.setVisibility(View.VISIBLE);
        stayButton.setVisibility(View.VISIBLE);

    }
}