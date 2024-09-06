package com.banana.bananawhatsapp.persistencia;

import com.banana.bananawhatsapp.modelos.Usuario;
<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;
=======
import org.springframework.data.repository.CrudRepository;
>>>>>>> 971e0fd5b00542a04fb131797da698b0cbfb076b

import java.sql.SQLException;
import java.util.Set;

public interface IUsuarioRepository {
    public Usuario obtener(int id) throws SQLException;

    public Usuario crear(Usuario usuario) throws SQLException;

    public Usuario actualizar(Usuario usuario) throws SQLException;

    public boolean borrar(Usuario usuario) throws SQLException;

    public Set<Usuario> obtenerPosiblesDestinatarios(Integer id, Integer max) throws SQLException;

}
