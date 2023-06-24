import java.util.ArrayList;
import java.util.List;

public class Administrador extends Usuario {
    private List<Musica> colecaoMusicas;
    private List<Usuario> usuarios;

    public Administrador(String nome, String identificador, String login, String senha) {
        super(nome, identificador, login, senha);
        colecaoMusicas = new ArrayList<>();
        usuarios = new ArrayList<>();
    }

    public void cadastrarMusica(Musica musica) {
        colecaoMusicas.add(musica);
        System.out.println("Música cadastrada com sucesso: " + musica.getTitulo());
    }

    public Musica buscarMusica(String titulo) {
        for (Musica musica : colecaoMusicas) {
            if (musica.getTitulo().equals(titulo)) {
                return musica;
            }
        }
        return null; // Retorna null se a música não for encontrada
    }

    public void atualizarMusica(Musica musica) {
        int index = colecaoMusicas.indexOf(musica);
        if (index != -1) {
            colecaoMusicas.set(index, musica);
            System.out.println("Música atualizada com sucesso: " + musica.getTitulo());
        } else {
            System.out.println("Música não encontrada: " + musica.getTitulo());
        }
    }

    public void removerMusica(Musica musica) {
        if (colecaoMusicas.remove(musica)) {
            System.out.println("Música removida com sucesso: " + musica.getTitulo());
        } else {
            System.out.println("Música não encontrada: " + musica.getTitulo());
        }
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
        System.out.println("Usuário adicionado com sucesso: " + usuario.getNome());
    }

    public Usuario buscarUsuario(String login) {
        for (Usuario usuario : usuarios) {
            if (usuario.getLogin().equals(login)) {
                return usuario;
            }
        }
        return null; // Retorna null se o usuário não for encontrado
    }

    public void removerUsuario(Usuario usuario) {
        if (usuarios.remove(usuario)) {
            System.out.println("Usuário removido com sucesso: " + usuario.getNome());
        } else {
            System.out.println("Usuário não encontrado: " + usuario.getNome());
        }
    }
}

