package com.example.moaleminternsip;

class Model {
    private int image;
    private String subject;

    Model(int image, String subject ){
        this.image = image;
        this.subject = subject;
    }

    int getImage() {
        return image;
    }

    String getSubject() {
        return subject;
    }

}
