package br.com.alura.my_musics.models;

public class MinhasPreferidas {

    public void inclui(Audio audio) {
        if (audio.getClassificacao() >= 9) {
            System.out.println(audio.getTitulo() + " e considerado sucesso absoluto e preferido por todos!");
        } else {
            System.out.println(audio.getTitulo() + " tambem e um dos que todo mundo esta curtindo!");
        }
    }
}
