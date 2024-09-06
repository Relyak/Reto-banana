package com.banana.bananawhatsapp.servicios;

import com.banana.bananawhatsapp.modelos.Usuario;

public class Validaciones {

    // TODO: quizás debería ir en el modelo
    public static boolean isUserValid(final Usuario user){
        return user != null && user.getNombre().isBlank() == false;
    }

    public static boolean isMessageValid(final String message){
        return message != null && message.isBlank() == false;
    }
}
