package br.com.alura.screenmatch_frases.service;

import br.com.alura.screenmatch_frases.dataTransferObject.FraseDTO;
import br.com.alura.screenmatch_frases.model.Frase;
import br.com.alura.screenmatch_frases.repository.FraseRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FraseService {
    @Autowired
    private FraseRepositorio repositorio;

    public FraseDTO obterFraseAleatoria() {
        Frase frase = repositorio.buscaFraseAleatoria();
        return new FraseDTO(frase.getTitulo(), frase.getFrase(), frase.getPersonagem(), frase.getPoster());
    }
}
