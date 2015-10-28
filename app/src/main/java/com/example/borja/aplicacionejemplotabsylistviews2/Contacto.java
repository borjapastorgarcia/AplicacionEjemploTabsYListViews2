package com.example.borja.aplicacionejemplotabsylistviews2;

import android.graphics.drawable.Drawable;

/**
 * Created by Borja on 28/10/2015.
 */
public class Contacto {
    private String nombreContacto;
    private String nick;
    private Drawable imageIcon;

    public Contacto(String nombreContacto, String nick, Drawable imageIcon) {
        this.nombreContacto = nombreContacto;
        this.nick = nick;
        this.imageIcon = imageIcon;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public Drawable getImageIcon() {
        return imageIcon;
    }

    public String getNick() {
        return nick;
    }
}
