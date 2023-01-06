package com.rnz.ggistudentapp.Models;

public class MstModel {
    private String mstTitle,pdfUrl;

    public MstModel() {
    }

    public MstModel(String mstTitle, String pdfUrl) {
        this.mstTitle = mstTitle;
        this.pdfUrl = pdfUrl;
    }

    public String getMstTitle() {
        return mstTitle;
    }

    public void setMstTitle(String mstTitle) {
        this.mstTitle = mstTitle;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }
}
