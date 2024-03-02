package com.example.api_server_autorizacion.repository;

import com.example.api_server_autorizacion.repository.model.Usuario;

public interface IUsuarioRepository {

    public Usuario consultarPorNomnbre(String nombre);
    
}
