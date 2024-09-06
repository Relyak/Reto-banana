package com.banana.bananawhatsapp.persistencia;

import com.banana.bananawhatsapp.config.SpringConfig;
import com.banana.bananawhatsapp.exceptions.UsuarioException;
import com.banana.bananawhatsapp.modelos.Usuario;
import com.banana.bananawhatsapp.util.DBUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.Set;

import static org.apache.logging.log4j.ThreadContext.isEmpty;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

@EnableAutoConfiguration
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {SpringConfig.class})
class UsuarioRepositoryTest {
    @Autowired
    IUsuarioRepository repo;

    //IMensajeRepository mensajeRepository;

    @BeforeEach
    void cleanAndReloadData() {
        DBUtil.reloadDB();
    }

    @Test
    @Order(1)
    void dadoUnUsuarioValido_cuandoCrear_entoncesUsuarioValido() throws Exception {
        Usuario nuevo = new Usuario(null, "Ricardo", "r@r.com", LocalDate.now(), true);
        repo.save(nuevo);

        assertThat(nuevo, notNullValue());
        assertThat(nuevo.getId(), greaterThan(0));
    }

    /*@Test
    @Order(2)
    void dadoUnUsuarioNOValido_cuandoCrear_entoncesExcepcion() {
        Usuario nuevo = new Usuario(null, "Ricardo", "r", LocalDate.now(), true);
        if (!(repo.save(nuevo).valido())) {
            assertThrows(UsuarioException.class, () -> {
                throw new UsuarioException();
            });
        }
    }*/

    @Test
    @Order(3)
    void dadoUnUsuarioValido_cuandoActualizar_entoncesUsuarioValido() throws Exception {
        Integer iDUser = 1;
        Usuario user = new Usuario(iDUser, "Kayler", "j@j.com", LocalDate.now(), true);
        Usuario userUpdate = repo.save(user);
        assertThat(userUpdate.getNombre(), is("Kayler"));
    }

   /* @Test
    @Order(4)
    void dadoUnUsuarioNOValido_cuandoActualizar_entoncesExcepcion() {
        Integer iDUser = -1;
        Usuario user = new Usuario(iDUser, "Juan", "j@j.com", LocalDate.now(), true);
        if (!(repo.save(user).valido())) {
            assertThrows(UsuarioException.class, () -> {
                throw new UsuarioException();
            });
        }
    }*/

    @Test
    @Order(5)
    void dadoUnUsuarioValido_cuandoBorrar_entoncesOK()  {
        Usuario user = repo.findById(1).get();
        repo.delete(user);
        //que poner para que pase el test
    }

    @Test
    @Order(6)
    void dadoUnUsuarioNOValido_cuandoBorrar_entoncesExcepcion() throws Exception {
        Usuario user = new Usuario(-1, null, null, null, true);
        assertThrows(Exception.class, () -> {
            repo.delete(user);
        });
    }
    /*
    @Test
    @Order(7)
    void dadoUnUsuarioValido_cuandoObtenerPosiblesDestinatarios_entoncesLista() throws Exception {
        Integer iDUser = 1;
        int numPosibles = 100;
        Usuario user = new Usuario(iDUser, "Juan", "j@j.com", LocalDate.now(), true);

        Set<Usuario> conjuntoDestinatarios = repo.obtenerPosiblesDestinatarios(user.getId(), numPosibles);
        assertTrue(conjuntoDestinatarios.size() <= numPosibles);
    }

    @Test
    @Order(8)
    void dadoUnUsuarioNOValido_cuandoObtenerPosiblesDestinatarios_entoncesExcepcion() throws Exception {
        Usuario user = new Usuario(-1, null, null, null, true);
        int numPosibles = 100;
        assertThrows(UsuarioException.class, () -> {
            Set<Usuario> conjuntoDestinatarios = repo.obtenerPosiblesDestinatarios(user.getId(), numPosibles);
        });

    }*/


}