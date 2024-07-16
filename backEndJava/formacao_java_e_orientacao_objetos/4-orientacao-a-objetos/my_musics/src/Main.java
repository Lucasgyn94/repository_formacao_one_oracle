import br.com.alura.my_musics.models.MinhasPreferidas;
import br.com.alura.my_musics.models.Musica;
import br.com.alura.my_musics.models.Podcast;

public class Main {
    public static void main(String[] args) {
        Musica musica1 = new Musica();
        musica1.setTitulo("Forever");
        musica1.setCantor("Kiss");

        for (int i = 0; i < 50; i++) {
            musica1.reproduz();
        }
        for (int i = 0; i < 100; i++) {
            musica1.curte();
        }

        Podcast podcast1 = new Podcast();
        podcast1.setTitulo("BolhaDev");
        podcast1.setApresentador("Marcus Mendes");

        for (int i = 0; i < 1000; i++) {
            podcast1.reproduz();
        }

        for (int i = 0; i < 600; i++) {
            podcast1.curte();
        }

        MinhasPreferidas minhasPreferidas = new MinhasPreferidas();
        minhasPreferidas.inclui(musica1);
        minhasPreferidas.inclui(podcast1);

    }
}