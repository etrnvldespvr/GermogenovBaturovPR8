package com.example.github1germogenov;
import android.graphics.Bitmap;

public class Contributor {

    private String login;
    private String contributions;
    private String type;
    private String avatar_url;
    private Bitmap bitmap;
    private int id;

    public String getLogin() { return login; }
    public String getContributions() { return "Contributions: " + contributions; }
    public String getPhoto() { return avatar_url; }
    public void setPhoto(String avatar_url) { this.avatar_url = avatar_url; }
    public Bitmap getBitmap() { return bitmap; }
    public void setBitmap(Bitmap bitmap) { this.bitmap = bitmap; }

    @Override
    public String toString() { return login; }
    /*@Override
    public String toString() {
        return type + " " + login + " (" + contributions + ")\n";
    }*/

}
