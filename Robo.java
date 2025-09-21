import java.io.*;

public class Robo {
    private boolean canetaAtiva = false;
    private int orientacao = 0; // 0=Norte, 1=Leste, 2=Sul, 3=Oeste
    private int[] comandos;
    private int posX, posY;

    public Robo(int posXInicial, int posYInicial, String nomeArquivo) {
        this.posX = posXInicial;
        this.posY = posYInicial;
        this.comandos = lerComandos(nomeArquivo);
    }

    private int[] lerComandos(String nomeArquivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha = br.readLine();
            if (linha != null) {
                return java.util.Arrays.stream(linha.split(","))
                        .map(String::trim)
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler arquivo: " + e.getMessage());
        }
        return new int[0];
    }

    public void ativarCaneta() { canetaAtiva = true; }
    public void desativarCaneta() { canetaAtiva = false; }
    public void virarEsquerda() { orientacao = (orientacao + 3) % 4; }
    public void virarDireita() { orientacao = (orientacao + 1) % 4; }

    public void mover(int passos, Tabuleiro tabuleiro) {
        int dx = 0, dy = 0;
        switch (orientacao) {
            case 0 -> dy = -1; // norte
            case 1 -> dx = 1;  // leste
            case 2 -> dy = 1;  // sul
            case 3 -> dx = -1; // oeste
        }

        for (int i = 0; i < passos; i++) {
            if (canetaAtiva) tabuleiro.marcarPosicao(posX, posY);
            posX += dx;
            posY += dy;
        }
        if (canetaAtiva) tabuleiro.marcarPosicao(posX, posY);
    }

    public int[] getComandos() { return comandos; }
    public int getPosX() { return posX; }
    public int getPosY() { return posY; }
    public boolean isCanetaAtiva() { return canetaAtiva; }

    public String getOrientacao() {
        return switch (orientacao) {
            case 0 -> "Norte";
            case 1 -> "Leste";
            case 2 -> "Sul";
            case 3 -> "Oeste";
            default -> "Desconhecida";
        };
    }
}
