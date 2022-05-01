package com.rnz.ggistudentapp.Models;

public class AnnouncementModel {
    String date,batch,announcementtitle,announcement;

    public AnnouncementModel(String date, String batch, String announcementtitle, String announcement) {
        this.date = date;
        this.batch = batch;
        this.announcementtitle = announcementtitle;
        this.announcement = announcement;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getAnnouncementtitle() {
        return announcementtitle;
    }

    public void setAnnouncementtitle(String announcementtitle) {
        this.announcementtitle = announcementtitle;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }
}
