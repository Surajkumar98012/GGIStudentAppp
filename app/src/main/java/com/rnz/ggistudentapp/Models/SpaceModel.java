package com.rnz.ggistudentapp.Models;

import android.widget.ImageView;
import android.widget.TextView;

public class SpaceModel {
    private String notesTitle,pdfUrl;

    public SpaceModel() {
    }

    public SpaceModel(String notesTitle, String pdfUrl) {
        this.notesTitle = notesTitle;
        this.pdfUrl = pdfUrl;
    }

    public String getnotesTitle() {
        return notesTitle;
    }

    public void setnotesTitle(String notesTitle) {
        this.notesTitle = notesTitle;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }


}
