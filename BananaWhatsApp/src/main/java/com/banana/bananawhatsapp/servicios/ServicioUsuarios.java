package com.banana.bananawhatsapp.servicios;

import com.banana.bananawhatsapp.exceptions.UsuarioException;
import com.banana.bananawhatsapp.modelos.Usuario;
import com.banana.bananawhatsapp.persistencia.IMensajeRepository;
import com.banana.bananawhatsapp.persistencia.IUsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ServicioUsuarios implements IServicioUsuarios{

    @Autowired
    IUsuarioRepository repoUser;

    @Autowired
    IMensajeRepository repoMen;

    @Override
    public Usuario obtener(int id) throws UsuarioException {
        return repoUser.findById(id).orElseThrow(UsuarioException::new);
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) throws UsuarioException {
        if(Validaciones.isUserValid(usuario)){

            repoUser.save(usuario);
            return usuario;
        }else{
            throw new UsuarioException("Usuario no válido");
        }
    }

    @Override
    public boolean borrarUsuario(Usuario usuario) throws UsuarioException {
        // debería buscar el usuario en caso que exista?
        // voy a suponer que el id existe
        if(Validaciones.isUserValid(usuario) && repoUser.findById(usuario.getId()).isPresent()){
            try {
                repoMen.borrarTodos(usuario);
                repoUser.delete(usuario);
            }catch (Exception e){

            }
        }

        // quizás devolver la excepción?
        return false;
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) throws UsuarioException {
        if(Validaciones.isUserValid(usuario) && repoUser.findById(usuario.getId()).isPresent()){
            return repoUser.save(usuario);
        }else{
            throw new UsuarioException("Error de usuario");
        }
    }

    @Override
    // No entiendo este metodo...
    public Set<Usuario> obtenerPosiblesDesinatarios(Usuario usuario, int max) throws UsuarioException {
        //
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