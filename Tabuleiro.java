public class Tabuleiro {
    private int[][] grade = new int[20][20];
    private Robo robo;

    public Tabuleiro(int posXInicial, int posYInicial, String nomeArquivo) {
        this.robo = new Robo(posXInicial, posYInicial, nomeArquivo);
    }

    public void marcarPosicao(int x, int y) {
        if (x >= 0 && x < 20 && y >= 0 && y < 20) {
            grade[y][x] = 1; // ou grade[y][x]++ para contar passagens
        }
    }

    public void processarComandos() {
        int[] comandos = robo.getComandos();
        for (int i = 0; i < comandos.length; i++) {
            switch (comandos[i]) {
                case 1 -> robo.ativarCaneta();
                case 2 -> robo.desativarCaneta();
                case 3 -> robo.virarEsquerda();
                case 4 -> robo.virarDireita();
                case 5 -> {
                    if (i + 1 < comandos.length) {
                        robo.mover(comandos[++i], this);
                    }
                }
                case 6 -> exibirTabuleiro();
                case 9 -> {
                    System.out.println("Comando 9 - Fim do processamento");
                    return;
                }
                default -> System.out.println("Comando desconhecido: " + comandos[i]);
            }
        }
    }

    public void exibirTabuleiro() {
        System.out.println("\n=== TABULEIRO ===");
        System.out.printf("Posição do robô: (%d, %d)%n", robo.getPosX(), robo.getPosY());
        System.out.println("Orientação: " + robo.getOrientacao());
        System.out.println("Caneta: " + (robo.isCanetaAtiva() ? "ATIVA" : "INATIVA"));
        System.out.println();

        for (int y = 0; y < 20; y++) {
            for (int x = 0; x < 20; x++) {
                if (x == robo.getPosX() && y == robo.getPosY()) {
                    System.out.print("R ");
                } else {
                    System.out.print(grade[y][x] != 0 ? "# " : ". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public Robo getRobo() {
        return robo;
    }
}
