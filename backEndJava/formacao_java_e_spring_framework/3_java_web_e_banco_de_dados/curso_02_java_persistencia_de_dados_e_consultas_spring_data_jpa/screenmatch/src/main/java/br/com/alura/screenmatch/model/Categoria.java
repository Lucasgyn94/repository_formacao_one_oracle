package br.com.alura.screenmatch.model;

import java.text.Normalizer;

public enum Categoria {
    ACAO("Action", "Ação", "Acao"),
    ROMANCE("Romance", "Romance", "Romance"),
    COMEDIA("Comedy", "Comédia", "Comedia"),
    DRAMA("Drama", "Drama", "Drama"),
    CRIME("Crime", "Crime", "Crime");

    private String categoriaOmdb;
    private String categoriaPortugues;


    Categoria(String categoriaOmdb, String categoriaPortugues, String categoriaPortuguesSemAcento) {
        this.categoriaOmdb = categoriaOmdb;
        this.categoriaPortugues = categoriaPortugues;
    }

    public static Categoria fromString(String text) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoriaOmdb.equalsIgnoreCase(text)) {
                return categoria;
            }
        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada!");

    }

    public static Categoria fromPortugues(String text) {
        for (Categoria categoria : Categoria.values()) {

            if (categoria.categoriaPortugues.equalsIgnoreCase(text) || removerAcentos(categoria.categoriaPortugues).equalsIgnoreCase(removerAcentos(text))) {
                return categoria;
            }

        }
        throw new IllegalArgumentException("Nenhuma categoria encontrada!");
    }

    private static String removerAcentos(String str) {
        return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
    }

}
