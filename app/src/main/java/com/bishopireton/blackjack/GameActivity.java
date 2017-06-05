package com.bishopireton.blackjack;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class GameActivity extends AppCompatActivity {

    public static User player;
    public static User house;
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
        house = new Player(cCards);

        hitButton = (Button) findViewById(R.id.hit_button);
        stayButton = (Button) findViewById(R.id.stay_button);

        //set to gone because they should only appear as dealt
        for(int i = 0; i < cCards.length; i++) {
            pCards[i].setVisibility(View.GONE);
            cCards[i].setVisibility(View.GONE);
        }

        //should appear when it's the person's turn
        hitButton.setVisibility(View.GONE);
        stayButton.setVisibility(View.GONE);
    }

    public void playGame() {
        for(int i = 0; i < 2; i++) {
            player.addCard(deck.deal());
            house.addCard(deck.deal());
        }

        //changes the ImageViews
        //hardcoded because debugger would not assist in finding the problem
        //with the shorter method
        ImageView view = player.getNextView();
        view.setImageResource(CardImages.getImage(player.getNextCard()));
        view.setVisibility(View.VISIBLE);

        view = house.getNextView();
        view.setImageResource(CardImages.getImage(house.getNextCard()));
        view.setVisibility(View.VISIBLE);

        view = player.getNextView();
        view.setImageResource(CardImages.getImage(player.getNextCard()));
        view.setVisibility(View.VISIBLE);

        view = house.getNextView();
        view.setImageResource(CardImages.getImage(house.getNextCard()));
        view.setVisibility(View.VISIBLE);

        //used for an immediate win
        if(player.sumCards() == 21 )
            end("blackjack", player);
        else if(house.sumCards() == 21)
            end("blackjack", house);

        hitButton.setVisibility(View.VISIBLE);
        stayButton.setVisibility(View.VISIBLE);
    }

    //hit function for either user
    public void hit(User user) {
        user.addCard(deck.deal());
        ImageView view = user.getNextView();
        view.setVisibility(View.VISIBLE);
        view.setImageResource(CardImages.getImage(user.getNextCard()));
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

    //only relevant to end so placed here
    public static final String REASON = "com.bishopireton.blackjack.REASON";
    public static final String WINNER = "com.bishopireton.blackjack.WINNER";

    public void end(String reason, User winner) {

        Intent whatsNext = new Intent(this, EndingActivity.class);
        whatsNext.putExtra(REASON, reason);
        if(winner.equals(player))
            whatsNext.putExtra(WINNER, true);
        else
            whatsNext.putExtra(REASON, false);
        startActivity(whatsNext);

    }
}
