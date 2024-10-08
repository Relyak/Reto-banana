package com.banana.bananawhatsapp.persistencia;

import com.banana.bananawhatsapp.modelos.Mensaje;
import com.banana.bananawhatsapp.modelos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.sql.SQLException;
import java.util.List;

public interface IMensajeRepository extends JpaRepository<Mensaje,Integer> {
    //public Mensaje addMensaje(Mensaje mensaje) throws SQLException;

    @Query("Select m FROM Mensaje m WHERE m.remitente = :remitente")
    public List <Mensaje> obtener(@Param("remitente") Usuario remitente);
    //modificado este metodo porque no tenia sentido con esta forma de hacerlo
    @Query("SELECT m FROM Mensaje m WHERE (m.remitente = :cliente AND m.destinatario = :aEnviar) OR (m.remitente = :aEnviar AND m.destinatario = :cliente)")
    public List<Mensaje> obtenerEntre(@Param("cliente") Usuario cliente, @Param("aEnviar") Usuario aEnviar) throws SQLException;
    @Query("DELETE FROM Mensaje m WHERE (m.remitente = :cliente AND m.destinatario = :aEnviar) OR (m.remitente = :aEnviar AND m.destinatario = :cliente)")
    public boolean borrarEntre(@Param("cliente")Usuario cliente, @Param("aEnviar")Usuario aEnviar) throws Exception;
    @Query("DELETE FROM Mensaje m WHERE m.remitente = :remitente")
    public boolean borrarTodos(@Param("remitente")Usuario remitente) throws SQLException;

}
