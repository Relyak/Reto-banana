package com.banana.bananawhatsapp.servicios;

import com.banana.bananawhatsapp.exceptions.MensajeException;
import com.banana.bananawhatsapp.exceptions.UsuarioException;
import com.banana.bananawhatsapp.modelos.Mensaje;
import com.banana.bananawhatsapp.modelos.Usuario;
import com.banana.bananawhatsapp.persistencia.IMensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class ServicioMensajeria implements IServicioMensajeria{

    @Autowired
    IMensajeRepository repo;

    @Override
    public Mensaje enviarMensaje(Usuario remitente, Usuario destinatario, String texto) throws UsuarioException, MensajeException {
        if(Validaciones.isUserValid(remitente) && Validaciones.isUserValid(destinatario)){
            // repo
            return null;
        }else{
            throw new UsuarioException("Usuarios incorrectos");
        }
    }

    @Override
    public List<Mensaje> mostrarChatConUsuario(Usuario remitente, Usuario destinatario) throws UsuarioException, MensajeException {
        if(Validaciones.isUserValid(remitente) && Validaciones.isUserValid(destinatario)){
            // repo
            return null;
        }else{
            throw new UsuarioException("Usuarios erroneos");
        }
    }

    @Override
    public boolean borrarChatConUsuario(Usuario remitente, Usuario destinatario) throws UsuarioException, MensajeException {
        if(Validaciones.isUserValid(remitente) && Validaciones.isUserValid(destinatario)){
            return true;
        }else{
            throw new UsuarioException("Ususarios erroneos");
        }

    }


}
