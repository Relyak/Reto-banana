package com.banana.bananawhatsapp.persistencia;

import com.banana.bananawhatsapp.modelos.Mensaje;
import com.banana.bananawhatsapp.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface IMensajeRepository extends JpaRepository<Mensaje,Integer> {
    @Query("Select m FROM Mensaje m where m.remitente=:usuario")
    public List<Mensaje> findListaMensajes(@Param("usuario")Usuario usuario) throws SQLException;
    //public Mensaje crear(Mensaje mensaje) throws SQLException;

    /*public List<Mensaje> obtener(Usuario usuario) throws SQLException;

    public boolean borrarEntre(Usuario remitente, Usuario destinatario) throws Exception;*/

    public boolean borrarTodos(Usuario usuario) throws SQLException;
}
