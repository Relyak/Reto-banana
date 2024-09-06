package com.banana.bananawhatsapp.servicios;

import com.banana.bananawhatsapp.modelos.Usuario;

public class Validaciones {

    // TODO: quizás debería ir en el modelo
    public static boolean isUserValid(final Usuario user){

        /*
        repoMen.borrarTodos(usuario);

            repoUser.delete(usuario);
         */

        return user != null && user.getNombre().isBlank() == false && user.isActivo(); // TODO: comprobar email (regex?)
    }

    public static boolean isMessageValid(final String message){
        return message != null && message.isBlank() == false;
    }
}