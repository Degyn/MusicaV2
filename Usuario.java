import java.io.Serializable;

public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    private String nome;
    private int identificador;
    private String login;
    private String senha;

    public Usuario(String nome, int identificador, String login, String senha) {
        this.nome = nome;
        this.identificador = identificador;
        this.login = login;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public int getIdentificador() {
        return identificador;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }
}
 
    



