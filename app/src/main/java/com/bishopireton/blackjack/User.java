package com.bishopireton.blackjack;

import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by AnneMarie on 5/22/2017.
 */

public class User {
    private ArrayList<Card> cards;
    private ImageView[] images;

    User(ArrayList<Card> c, ImageView[] i) {
        cards = c;
        images = i;
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
}