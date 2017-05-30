package com.bishopireton.blackjack;

import android.widget.ImageView;

import com.bishopireton.blackjack.User;

import java.util.ArrayList;

/**
 * Created by AnneMarie on 5/22/2017.
 */

public class Player extends User {
    private boolean status; //if true person is still playing/hasn't stayed

    Player(ArrayList<Card> c, ImageView[] i) {
        super(c, i);
        status = true;
    }

    Player(ImageView[] i) {
        super(new ArrayList<Card>(), i);
        status = true;
    }

    public boolean getStatus() {
        return status;
    }

    public void stay() {
        status = false;
    }

    public void hit(Card c) {
        addCard(c);
    }
}
