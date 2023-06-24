import java.util.Date;

public abstract class Musica {
    private int identificador;
    private String titulo;
    private int duracaoMinutos;
    private int duracaoSegundos;
    private String autores;
    private Date data;
    private String generoMusical;

    public Musica(int identificador, String titulo, int duracaoMinutos, int duracaoSegundos, String autores, Date data, String generoMusical) {
        this.identificador = identificador;
        this.titulo = titulo;
        this.duracaoMinutos = duracaoMinutos;
        this.duracaoSegundos = duracaoSegundos;
        this.autores = autores;
        this.data = data;
        this.generoMusical = generoMusical;
    }

    public int getIdentificador() {
        return identificador;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public int getDuracaoSegundos() {
        return duracaoSegundos;
    }

    public String getAutores() {
        return autores;
    }

    public Date getData() {
        return data;
    }

    public String getGeneroMusical() {
        return generoMusical;
    }
}