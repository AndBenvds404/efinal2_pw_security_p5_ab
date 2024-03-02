package com.example.api_server_autorizacion.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.api_server_autorizacion.repository.IUsuarioRepository;
import com.example.api_server_autorizacion.repository.model.Usuario;

import static java.util.Collections.emptyList;

@Service
public class UsuarioServiceImpl implements UserDetailsService{

    @Autowired
    private IUsuarioRepository iUsuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // TODO Auto-generated method stub
        Usuario usuario = iUsuarioRepository.consultarPorNomnbre(username);

        return new User(usuario.getNombre(), usuario.getPassword(), emptyList());
    }
    
}
