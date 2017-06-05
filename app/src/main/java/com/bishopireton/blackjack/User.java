package com.bishopireton.blackjack;

import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by AnneMarie on 5/22/2017.
 */

public class User {
    private ArrayList<Card> cards;
    private ImageView[] images;
    private int current;// keeps track of current ImageView and Card
    private boolean status; //still active (true) or has stayed (false)

    User(ArrayList<Card> c, ImageView[] i) {
        cards = c;
        images = i;
        status = true; //because the user is automatically playing
        current = 0;
    }

    public void addCard(Card c) {
        cards.add(c);
    }

    public int sumCards() {
        int sum = 0;
        for(Card card: cards)
            sum += card.getRank();

        return sum;
    }

    public ImageView getNextView() {
        return images[current];
    }

    public int size() {
        return cards.size();
    }

    public ArrayList<Card> cards() {
        return cards;
    }

    public boolean status() {return status;}

    public Card getNextCard() {
        current++;
        return cards.get(current - 1);
    }

    public void setStatus(boolean b) {status = b;}
}