import java.io.*;

public class Teste {
    public static void main(String[] args) {
        String nomeArquivo = "comandos.txt";

        try {
            File arquivo = new File(nomeArquivo);
            if (arquivo.createNewFile()) {
                System.out.println("Arquivo criado: " + nomeArquivo);
            } else {
                System.out.println("Arquivo já existe, usando conteúdo atual...");
            }
        } catch (IOException e) {
            System.err.println("Erro ao criar arquivo: " + e.getMessage());
        }

        Tabuleiro tabuleiro = new Tabuleiro(10, 10, nomeArquivo);
        tabuleiro.processarComandos();

        tabuleiro.exibirTabuleiro();
    }
}
