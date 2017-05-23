package com.bishopireton.blackjack;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;


/**
 * Created by AnneMarie on 5/17/2017.
 */

public class Card {
    private int rank; // rank of ace is 1
    private int suit; //club = 1; diamond = 2; heart = 3; spade = 4
    private boolean ace; //if ace is true, ace acts as one, if not, ace is eleven

    public static int cardBack; //hold the id for the image that will act as all of the card's backs

    Card(int s, int r) {
        suit = s;
        rank = r;
    }

    public int getRank() {
        return rank;
    }

    public int getSuit() {
        return suit;
    }

    //returns the value of a card in Blackjack
    public int getValue() {
        if(rank == 1) {
            if (getAce())
                return 1;
            else
                return 11;
        }
        else if (rank > 10)
            return 11;
        else
            return rank;
    }

    public boolean getAce() {
        return ace;
    }

    public void switchAce() {
        ace = !ace;
    }

    public int getImage() {
        String name; //temp variable to hold the name before turning it into an id
        switch(suit) {
            case 1: //clubs
                name = "club" + rank;
            case 2: //diamonds
                name = "diamond" + rank;
            case 3: //hearts
                name = "heart" + rank;
            case 4: //spades
                name = "spade" + rank;
        }

        return 0;//getResources().getIdentifier(name, "drawable", com.bishopireton.blackjack );
    }
}
