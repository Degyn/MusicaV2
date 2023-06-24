import java.util.Date;

public class MusicaInstrumental extends Musica {
    private String instrumento;
    private String imagemPartitura;

    public MusicaInstrumental(int identificador, String titulo, int duracaoMinutos, int duracaoSegundos,
                              String autores, Date data, String generoMusical, String instrumento, String imagemPartitura) {
        super(identificador, titulo, duracaoMinutos, duracaoSegundos, autores, data, generoMusical);
        this.instrumento = instrumento;
        this.imagemPartitura = imagemPartitura;
    }

    public String getInstrumento() {
        return instrumento;
    }

    public String getImagemPartitura() {
        return imagemPartitura;
    }

}
