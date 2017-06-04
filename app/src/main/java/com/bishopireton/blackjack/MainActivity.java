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


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setValues();
        playGame();
    }

    public void setValues() {
        //Setting the values
        Card.cardBack = R.drawable.card_back;
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

    //performs all actions from beginning of game till player's first choice to hit or stay
    public void playGame() {
        for(int i = 0; i < 2; i++) {
            player.addCard(deck.deal());
            house.addCard(deck.deal());
        }

        //changes the ImageViews
        setCard(player.nextView(), getImage(player.cards().get(0)));
        setCard(house.nextView(), Card.cardBack);
        setCard(player.nextView(), getImage(player.cards().get(1)));
        setCard(house.nextView(), getImage(house.cards().get(1)));

        //used for an immediate win
        if(player.sumCards() == 21 || house.sumCards() == 21);
        //Replace with winning layout and show dealer's card

        hitButton.setVisibility(View.VISIBLE);
        stayButton.setVisibility(View.VISIBLE);
    }

    public static void setCard(ImageView view, int id) {
        //add something into setCard that simultaneously changes card values in other layout
        view.setVisibility(View.VISIBLE);
        view.setImageResource(id);
    }

    //hit function for either user
    public void hit(User user) {
        player.addCard(deck.deal());
        setCard(user.nextView(), getImage(user.cards().get(user.size() - 1)));
    }

    //hit function for player
    public void onClickHit(View view) {
        hit(player);
    }

    public void onClickStay(View view) {
        player.setStatus(false);
        hitButton.setVisibility(View.GONE);
        stayButton.setVisibility(View.GONE);
    }

    //gets the corresponding image for the Card passed
    public int getImage(Card c) {
        String name = ""; //temp variable to hold the name before turning it into an id
        switch(c.getSuit()) {
            case 1: //clubs
                name = "clubs" + c.getRank();
            case 2: //diamonds
                name = "diamonds" + c.getRank();
            case 3: //hearts
                name = "hearts" + c.getRank();
            case 4: //spades
                name = "spades" + c.getRank();
        }

        return getResources().getIdentifier(name, "drawable", getPackageName());
    }
}