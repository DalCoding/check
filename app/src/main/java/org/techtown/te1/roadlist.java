package org.techtown.te1;

import android.graphics.drawable.Drawable;

public class roadlist {
    private Drawable iconDrawable ;
    private String titleStr ;
    private String roadtimeStr ;
    private String writetimeStr ;

    public void setIcon(Drawable icon) {
        iconDrawable = icon ;
    }
    public void setTitle(String title) {
        titleStr = title ;
    }
    public void setroadtime(String roadtime) {
        roadtimeStr = roadtime ;
    }
    public void setwritetime(String writetime) {
        writetimeStr = writetime;
    }

    public Drawable getIcon() {
        return this.iconDrawable ;
    }
    public String getTitle() {
        return this.titleStr ;
    }
    public String getroadTime() {
        return this.roadtimeStr ;
    }
    public String getwriteTime() {
        return this.writetimeStr ;
    }


}
