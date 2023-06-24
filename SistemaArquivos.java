import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SistemaArquivos {
    private static final String MUSICAS_FILE = "musicas.bin";
    private static final String USUARIOS_FILE = "usuarios.bin";

    public static void salvarMusicas(List<Musica> musicas) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(MUSICAS_FILE))) {
            outputStream.writeObject(musicas);
            System.out.println("Dados das músicas salvos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados das músicas: " + e.getMessage());
        }
    }

    public static List<Musica> carregarMusicas() {
        List<Musica> musicas = new ArrayList<>();

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(MUSICAS_FILE))) {
            musicas = (List<Musica>) inputStream.readObject();
            System.out.println("Dados das músicas carregados com sucesso.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar dados das músicas: " + e.getMessage());
        }

        return musicas;
    }

    public static void salvarUsuarios(List<Usuario> usuarios) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(USUARIOS_FILE))) {
            outputStream.writeObject(usuarios);
            System.out.println("Dados dos usuários salvos com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro ao salvar dados dos usuários: " + e.getMessage());
        }
    }

    public static List<Usuario> carregarUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();

        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(USUARIOS_FILE))) {
            usuarios = (List<Usuario>) inputStream.readObject();
            System.out.println("Dados dos usuários carregados com sucesso.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao carregar dados dos usuários: " + e.getMessage());
        }

        return usuarios;
    }
}
