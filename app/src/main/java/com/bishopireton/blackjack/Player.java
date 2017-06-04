package com.bishopireton.blackjack;

import android.widget.ImageView;

import com.bishopireton.blackjack.User;

import java.util.ArrayList;

/**
 * Created by AnneMarie on 5/22/2017.
 */

public class Player extends User {

    Player(ArrayList<Card> c, ImageView[] i) {
        super(c, i);
    }

    Player(ImageView[] i) {
        super(new ArrayList<Card>(), i);
    }
}
