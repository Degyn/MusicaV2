import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Carregar dados de todas as músicas e todos os usuários
        List<Musica> todasMusicas = SistemaArquivos.carregarMusicas();
        List<Usuario> todosUsuarios = SistemaArquivos.carregarUsuarios();

        // Exemplo de criação de músicas
        Cancao cancao1 = new Cancao(1, null, 3, 12, null, null, null, null);
        MusicaInstrumental instrumental1 = new MusicaInstrumental(2, null, 0, 0, null, null, null, null, null);

        // Exemplo de criação de usuários
        UsuarioComum usuario1 = new UsuarioComum("Usuário 1", "usuario1", "senha1");
        UsuarioComum usuario2 = new UsuarioComum("Usuário 2", "usuario2", "senha2");

        // Adicionar músicas à coleção principal do sistema
        todasMusicas.add(cancao1);
        todasMusicas.add(instrumental1);

        // Adicionar usuários ao sistema
        todosUsuarios.add(usuario1);
        todosUsuarios.add(usuario2);

        // Adicionar músicas à coleção particular de um usuário
        usuario1.adicionarMusica(cancao1);
        usuario1.adicionarMusica(instrumental1);

        // Salvar todas as músicas e todos os usuários
        SistemaArquivos.salvarMusicas(todasMusicas);
        SistemaArquivos.salvarUsuarios(todosUsuarios);

        // Salvar coleção particular do usuário
        usuario1.salvarColecaoParticular();

        // Carregar coleção particular do usuário
        usuario1.carregarColecaoParticular();

        // Buscar música pelo título
        Musica musicaEncontrada = usuario1.buscarMusicaPorTitulo(null, todasMusicas);
        if (musicaEncontrada != null) {
            System.out.println("Música encontrada: " + musicaEncontrada.getTitulo());
        } else {
            System.out.println("Música não encontrada.");
        }

        // Visualizar coleção principal de músicas
        usuario1.visualizarColecaoPrincipal(null);

        // Visualizar coleção particular de músicas
        usuario1.visualizarColecaoParticular();
    }
}

