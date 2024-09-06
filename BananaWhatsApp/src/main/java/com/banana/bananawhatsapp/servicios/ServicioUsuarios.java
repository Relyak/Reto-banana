package com.banana.bananawhatsapp.servicios;

import com.banana.bananawhatsapp.exceptions.UsuarioException;
import com.banana.bananawhatsapp.modelos.Usuario;
import com.banana.bananawhatsapp.persistencia.IUsuarioRepositoryData;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Set;

@Service
public class ServicioUsuarios implements IServicioUsuarios{

    @Autowired
    IUsuarioRepositoryData repo;


    @Override
    public Usuario obtener(int id) throws UsuarioException {
        return repo.findById(id).orElseThrow(UsuarioException::new);
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) throws UsuarioException {
        if(Validaciones.isUserValid(usuario)){

            repo.save(usuario);
            return usuario;
        }else{
            throw new UsuarioException("Usuario no válido");
        }
    }

    @Override
    public boolean borrarUsuario(Usuario usuario) throws UsuarioException {
        // debería buscar el usuario en caso que exista?
        // voy a suponer que el id existe
        if(Validaciones.isUserValid(usuario) && repo.findById(usuario.getId()).isPresent()){
            // debería coger todos los mensajes?
            // borrar mensajes donde el usuario existe

            repo.delete(usuario);
        }

        // quizás devolver la excepción?
        return false;
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) throws UsuarioException {
        if(Validaciones.isUserValid(usuario) && repo.findById(usuario.getId()).isPresent()){
            return repo.save(usuario);
        }else{
            throw new UsuarioException("Error de usuario");
        }
    }

    @Override
    // No entiendo este metodo...
    public Set<Usuario> obtenerPosiblesDesinatarios(Usuario usuario, int max) throws UsuarioException {
        if(Validaciones.isUserValid(usuario)){
            // mmmm quizá en el repo?
            // quizá en la base
            //TODO: preguntar
        }else{
            throw new UsuarioException("Ususario mal formado");
        }
        return null;
    }


}
