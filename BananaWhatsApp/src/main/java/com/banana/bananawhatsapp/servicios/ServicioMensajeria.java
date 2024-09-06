package com.banana.bananawhatsapp.servicios;

import com.banana.bananawhatsapp.exceptions.MensajeException;
import com.banana.bananawhatsapp.exceptions.UsuarioException;
import com.banana.bananawhatsapp.modelos.Mensaje;
import com.banana.bananawhatsapp.modelos.Usuario;
import com.banana.bananawhatsapp.persistencia.IMensajeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.sql.SQLException;
import java.util.List;

@Service
public class ServicioMensajeria implements IServicioMensajeria{

    @Autowired
    IMensajeRepository repo;

    @Override
    public Mensaje enviarMensaje(Usuario remitente, Usuario destinatario, String texto) throws UsuarioException, MensajeException {
        if(Validaciones.isUserValid(remitente) && Validaciones.isUserValid(destinatario)){
            Mensaje msg = new Mensaje(null,remitente,destinatario,texto,null);
            repo.save(msg);
            return msg;
        }else{
            throw new UsuarioException("Usuarios incorrectos");
        }
    }

    @Override
    public List<Mensaje> mostrarChatConUsuario(Usuario remitente, Usuario destinatario) throws UsuarioException, MensajeException {
        if(Validaciones.isUserValid(remitente) && Validaciones.isUserValid(destinatario)){
            try{
                return repo.obtenerEntre(remitente, destinatario);
            }catch (SQLException e){
                throw new UsuarioException(e.getMessage());
            }

        }else{
            throw new UsuarioException("Usuarios erróneos");
        }
    }

    @Override
    public boolean borrarChatConUsuario(Usuario remitente, Usuario destinatario) throws UsuarioException, MensajeException {
        if(Validaciones.isUserValid(remitente) && Validaciones.isUserValid(destinatario)){
            try{
                repo.borrarEntre(remitente, destinatario);
                return true;
            }catch(Exception e){
                // TODO: mejor excepción
                throw new UsuarioException(e.getMessage());
            }

        }else{
            throw new UsuarioException("Ususarios erróneos");
        }

    }


}
