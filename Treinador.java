import java.util.ArrayList;

public class Treinador {

    private String nome;
    private int idade;
    private String[] medalhas = new String[8];
    private ArrayList<Pokemon> equipe = new ArrayList<>();

    public Treinador(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }
    public String getnome () {
        return nome;
    }
    public void setnome (String nome) {
        this.nome = nome;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String [] getmedalhas() {
        return medalhas;
    }
    public void setmedalhas (String[] medalhas) {
        this.medalhas = medalhas;
    }
    public void exibirInfo() {
        System.out.println("\nTreinador: " + nome + " (Idade: " + idade + ")");

        System.out.println("Medalhas: ");
        boolean temMedalha = false;
        for (String medalha : medalhas) {
            if (medalha != null) {
                System.out.println("- " + medalha);
                temMedalha = true;
            }
        }
        if (!temMedalha) {
            System.out.println("Nenhuma medalha conquistada.");
        }

        System.out.println("Equipe Pokémon:");
        if (equipe.isEmpty()) {
            System.out.println("Nenhum Pokémon na equipe.");
        } else {
            for (Pokemon p : equipe) {
                p.exibir();
            }
        }
    }

    public void adicionarPokemon(Pokemon p) {
        if (equipe.size() < 6) {
            equipe.add(p);
            System.out.println("Pokémon adicionado com sucesso!");
        } else {
            System.out.println("Equipe já tem 6 Pokémon, não é possível adicionar mais.");
        }
    }

    public void retirarPokemon(String especie) {
        boolean removido = equipe.removeIf(p -> p.getEspecie().equalsIgnoreCase(especie));
        if (removido) {
            System.out.println("Pokémon " + especie + " removido da equipe.");
        } else {
            System.out.println("Pokémon não encontrado na equipe.");
        }
    }

    public void adicionarMedalha(String medalha) {
        for (int i = 0; i < medalhas.length; i++) {
            if (medalhas[i] == null) {
                medalhas[i] = medalha;
                System.out.println("Medalha " + medalha + " conquistada!");
                return;
            }
        }
        System.out.println("Todas as medalhas já foram conquistadas.");
    }
}
