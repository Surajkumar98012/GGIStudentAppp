package com.rnz.ggistudentapp.Models;

import android.widget.ImageView;
import android.widget.TextView;

public class SpaceModel {
    int cardimage;
   String cardtitle;
    public SpaceModel(int cardimage, String cardtitle) {
        this.cardimage = cardimage;
        this.cardtitle = cardtitle;
    }

    public int getCardimage() {
        return cardimage;
    }

    public void setCardimage(int cardimage) {
        this.cardimage = cardimage;
    }

    public String getCardtitle() {
        return cardtitle;
    }

    public void setCardtitle(String cardtitle) {
        this.cardtitle = cardtitle;
    }
}
