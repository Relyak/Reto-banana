package com.banana.bananawhatsapp.persistencia;

import com.banana.bananawhatsapp.modelos.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface IUsuarioRepositoryData extends CrudRepository<Usuario,Integer> {

}
