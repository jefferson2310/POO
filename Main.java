import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Nome do treinador: ");
        String nome = sc.nextLine();
        System.out.print("Idade: ");
        int idade = sc.nextInt();
        sc.nextLine();

        Treinador treinador = new Treinador(nome, idade);

        int opcao;
        do {
            System.out.println("\n==== MENU ====");
            System.out.println("1. Mostrar dados");
            System.out.println("2. Adicionar Pokémon");
            System.out.println("3. Retirar Pokémon");
            System.out.println("4. Ganhar medalha");
            System.out.println("5. Sair");
            System.out.print("Opção: ");
            opcao = sc.nextInt();
            sc.nextLine();

            if (opcao == 1) {
                treinador.exibirInfo();
            }
            else if (opcao == 2) {
                System.out.print("Espécie: ");
                String especie = sc.nextLine();
                System.out.print("Tipo: ");
                String tipo = sc.nextLine();
                treinador.adicionarPokemon(new Pokemon(especie, tipo));
            }
            else if (opcao == 3) {
                System.out.print("Espécie do Pokémon a retirar: ");
                treinador.retirarPokemon(sc.nextLine());
            }
            else if (opcao == 4) {
                System.out.println("Medalhas possíveis: Pedra, Cascata, Trovao, Arco-Íris, Pantano, Alma, Vulcao, Terra");
                System.out.print("Nome da medalha: ");
                treinador.adicionarMedalha(sc.nextLine());
            }
            else if (opcao == 5) {
                System.out.println("Saindo...");
            }
            else {
                System.out.println("Opção inválida!");
            }

        } while (opcao != 5);

        sc.close();
    }
}
