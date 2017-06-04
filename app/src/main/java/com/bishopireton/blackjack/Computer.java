package com.bishopireton.blackjack;

import android.widget.ImageView;

import com.bishopireton.blackjack.Card;

import java.util.ArrayList;

/**
 * Created by AnneMarie on 5/17/2017.
 */

public class Computer extends User {

    Computer(ArrayList<Card> c, ImageView[] i) {
        super(c, i);
    }

    Computer(ImageView[] i) {
        super(new ArrayList<Card>(), i);
    }

    //if it returns true, it hits, if it returns false, it stays
    public boolean chooseMove() {
        int value = sumCards();

        if(value <= 16)
            return true;
        else
            return false;
    }
}
