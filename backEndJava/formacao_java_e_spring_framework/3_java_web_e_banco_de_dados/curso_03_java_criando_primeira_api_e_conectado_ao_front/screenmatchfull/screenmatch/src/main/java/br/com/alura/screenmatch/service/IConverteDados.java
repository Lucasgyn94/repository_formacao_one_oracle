package br.com.alura.screenmatch.service;

import org.springframework.stereotype.Service;

@Service
public interface IConverteDados {
    <T> T obterDados(String json, Class<T> classe);
}
