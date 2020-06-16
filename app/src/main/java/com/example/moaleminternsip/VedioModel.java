package com.example.moaleminternsip;

 class VedioModel {

    private int image;
    private String subject;
    private int backGround;

    VedioModel(int image, String subject, int backGround) {
        this.image = image;
        this.subject = subject;
        this.backGround=backGround;
    }

    int getImage() {
        return image;
    }

    String getSubject() {
        return subject;
    }

     int getBackGround() {
        return backGround;
    }
}
