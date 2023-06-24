import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;

public class Cancao extends Musica {
    private String letra;

    public Cancao(int identificador, String titulo, int duracaoMinutos, int duracaoSegundos,
                  String autores, Date data, String generoMusical, String letraArquivo) {
        super(identificador, titulo, duracaoMinutos, duracaoSegundos, autores, data, generoMusical);
        this.letra = carregarLetra(letraArquivo);
    }

    public String getLetra() {
        return letra;
    }

    private String carregarLetra(String letraArquivo) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(letraArquivo))) {
            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar a letra da música: " + e.getMessage());
        }
        return stringBuilder.toString();
    }

}
