package com.bishopireton.blackjack;

import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by AnneMarie on 5/22/2017.
 */

public class User {
    private ArrayList<Card> cards;
    private ImageView[] images;
    private int current;// keeps track of current ImageView
    private int size; //the number of Cards cards contains
    private boolean status; //still active (true) or has stayed (false)

    User(ArrayList<Card> c, ImageView[] i) {
        cards = c;
        images = i;
        size = 0; //no cards have been dealt to the user yet
        status = true; //because the user is automatically playing
        current = 0;
    }

    public void addCard(Card c) {
        cards.add(c);
        size++;
    }

    public int sumCards() {
        int sum = 0;
        for(Card card: cards)
            sum += card.getRank();

        return sum;
    }

    public ImageView nextView() {
        current++;
        return images[current - 1];
    }

    public int size() {
        return size;
    }

    public ArrayList<Card> cards() {
        return cards;
    }

    public boolean status() {return status;}

    public void setStatus(boolean b) {status = b;}
}