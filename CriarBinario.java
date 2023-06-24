import java.io.*;

public class CriarBinario {
    private static final String LOGIN_FILE = "login.enc";

    public static void main(String[] args) {
        Usuario administrador = new Usuario("Administrador", 1, "admin", "admin123");
        Usuario usuarioComum = new Usuario("Usuário Comum", 2, "usuario", "senha123");

        // Serializar os usuários e escrever no arquivo binário
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(LOGIN_FILE))) {
            outputStream.writeObject(administrador);
            outputStream.writeObject(usuarioComum);
            System.out.println("Usuários foram escritos no arquivo.");
        } catch (IOException e) {
            System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
        }

        // Ler os usuários do arquivo binário
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(LOGIN_FILE))) {
            Usuario usuario1 = (Usuario) inputStream.readObject();
            Usuario usuario2 = (Usuario) inputStream.readObject();

            System.out.println("Usuário 1: " + usuario1.getNome());
            System.out.println("Usuário 2: " + usuario2.getNome());
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        }
    }
}

