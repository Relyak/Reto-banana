package com.banana.bananawhatsapp.servicios;

import com.banana.bananawhatsapp.exceptions.UsuarioException;
import com.banana.bananawhatsapp.modelos.Usuario;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Set;

@Service
public class ServicioUsuarios implements IServicioUsuarios{


    @Override
    public Usuario obtener(int id) throws UsuarioException {
        return null;
    }

    @Override
    public Usuario crearUsuario(Usuario usuario) throws UsuarioException {
        if(Validaciones.isUserValid(usuario)){
            try{
                repo.crear(usuario);
                return usuario;
            }catch (SQLException e){
                throw new UsuarioException(e.getMessage());
            }
        }
    }

    @Override
    public boolean borrarUsuario(Usuario usuario) throws UsuarioException {
        // debería buscar el usuario en caso que exista?
        if(Validaciones.isUserValid(usuario) /* comprobar que existe*/){

        }

        // quizás devolver la excepción?
        return false;
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) throws UsuarioException {
        if(Validaciones.isUserValid(usuario) /* comprobar que existe*/){

        }else{
            throw new UsuarioException("Error de usuario");
        }
        // busco usuario si existe, creo que el delete no envia nada
        return null;
    }

    @Override
    public Set<Usuario> obtenerPosiblesDesinatarios(Usuario usuario, int max) throws UsuarioException {
        if(Validaciones.isUserValid(usuario)){

        }else{
            throw new UsuarioException("Ususario mal formado");
        }
        return null;
    }


}
