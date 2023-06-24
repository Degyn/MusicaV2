import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class UsuarioComum extends Usuario {

    private List<Integer> colecaoParticular;

    public UsuarioComum(String nome, String login, String senha) {
        super(nome, getIdentificador(), login, senha);
        colecaoParticular = new ArrayList<>();
    }

    public void adicionarMusica(Musica musica) {
        // Adicionar música à coleção particular
        colecaoParticular.add(musica.getIdentificador());
        System.out.println("Música adicionada à coleção particular: " + musica.getTitulo());
    }

    public void removerMusica(Musica musica) {
        // Remover música da coleção particular
        if (colecaoParticular.remove(Integer.valueOf(musica.getIdentificador()))) {
            System.out.println("Música removida da coleção particular: " + musica.getTitulo());
        } else {
            System.out.println("Música não encontrada na coleção particular: " + musica.getTitulo());
        }
    }

    public List<Integer> getColecaoParticular() {
        return colecaoParticular;
    }

    public Musica buscarMusicaPorTitulo(String titulo, List<Musica> todasMusicas) {
        for (Musica musica : todasMusicas) {
            if (musica.getTitulo().equals(titulo)) {
                return musica;
            }
        }
        return null;
    }

    public void salvarColecaoParticular() {
        String fileName = getLogin() + ".bin";
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))) {
            outputStream.writeObject(colecaoParticular);
            System.out.println("Coleção particular de músicas salva com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar coleção particular de músicas: " + e.getMessage());
        }
    }

    public void carregarColecaoParticular() {
        String fileName = getLogin() + ".bin";
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            colecaoParticular = (List<Integer>) inputStream.readObject();
            System.out.println("Coleção particular de músicas carregada com sucesso.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar coleção particular de músicas: " + e.getMessage());
        }
    }

    public void visualizarColecaoPrincipal(Musica[] todasMusicas) {
        System.out.println("Coleção Principal:");
        for (Musica musica : todasMusicas) {
            System.out.println(musica.getTitulo());
        }
    }


// REfazer a função para visualizar de uma forma genérica qualquer usuario

    //public void visualizarColecaoParticular(Object usuario1) {
    //    System.out.println("Coleção Particular:");
    //    for (Integer musicaId : usuario1.getColecaoParticular()) {
    //        Musica musica = buscarMusicaPorTitulo(musicaId, todasMusicas);
    //        if (musica != null) {
    //            System.out.println(musica.getTitulo());
    //        }
    //    }
   // }
}
