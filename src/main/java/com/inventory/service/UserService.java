package com.inventory.service;

import java.nio.charset.Charset;
import java.util.Optional;

import lombok.AllArgsConstructor;
import org.apache.commons.codec.binary.Base64;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.inventory.model.User;
import com.inventory.model.UserLogin;
import com.inventory.repository.UserRepository;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public Optional<User> cadastrarUsuario(User user) {
        if (userRepository.findByUser(user.getUser()).isPresent())
            return Optional.empty();
        user.setPassword(criptografarSenha(user.getPassword()));
        return Optional.of(userRepository.save(user));
    }

    public Optional<User> atualizarUsuario(User user) {
        if (userRepository.findById(user.getId()).isPresent()) {
            user.setPassword(criptografarSenha(user.getPassword()));
            return Optional.ofNullable(userRepository.save(user));
        }
        return Optional.empty();
    }

    public Optional<UserLogin> autenticarUsuario(Optional<UserLogin> usuarioLogin) {
        Optional<User> usuario = userRepository.findByUser(usuarioLogin.get().getUser());
        if (usuario.isPresent()) {
            if (compararSenhas(usuarioLogin.get().getPassword(), usuario.get().getPassword())) {
                usuarioLogin.get().setId(usuario.get().getId());
                usuarioLogin.get().setName(usuario.get().getName());
                usuarioLogin.get()
                        .setToken(gerarBasicToken(usuarioLogin.get().getUser(), usuarioLogin.get().getPassword()));
                usuarioLogin.get().setPassword(usuario.get().getPassword());
                return usuarioLogin;
            }
        }
        return Optional.empty();
    }

    private String gerarBasicToken(String usuario, String senha) {
        String token = usuario + ":" + senha;
        byte[] tokenBase64 = Base64.encodeBase64(token.getBytes(Charset.forName("US-ASCII")));
        return "Basic " + new String(tokenBase64);
    }

    private boolean compararSenhas(String senhaDigitada, String senhaBanco) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.matches(senhaDigitada, senhaBanco);
    }

    private String criptografarSenha(String senha) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(senha);
    }

}