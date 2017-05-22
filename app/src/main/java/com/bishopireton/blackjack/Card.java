package com.bishopireton.blackjack;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

/**
 * Created by AnneMarie on 5/17/2017.
 */

public class Card {
    private ImageView front;
    private int rank;
    private int suit;
    private boolean ace; //if ace is true, ace acts as one, if not, ace is eleven

    public static ImageView CARD_BACK; //this final variable will contain the ImageView that will act as the back for all of the cards

    Card(ImageView f, ImageView b, int r, int s) {
        front = f;
        rank = r;
        suit = s;
    }

    public ImageView getFront() {
        return front;
    }

    public int getRank() {
        return rank;
    }

    public int getSuit() {
        return suit;
    }

    public boolean getAce() {
        return ace;
    }

    public void switchAce() {
        ace = !ace;
    }
}
