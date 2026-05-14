package Model;

import java.util.Scanner;

/**
 * Responsável pela interação inicial com o usuário por meio do menu principal.
 *
 * <p>A classe concentra a navegação entre as funcionalidades disponíveis,
 * validando a opção informada para evitar falhas causadas por entradas inválidas.</p>
 */
public class Dashboard {

    /**
     * Exibe o menu principal e direciona o usuário para a funcionalidade escolhida.
     */
    public static void menu() {
        SystemOfAdditionAndClassification system = new SystemOfAdditionAndClassification();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Adicionar manual");
            System.out.println("2 - Adicionar automático");
            System.out.println("3 - Listar");
            System.out.println("4 - Sair");

            int option = readMenuOption(scanner);

            switch (option) {
                case 1:
                    system.manualTextAdditionAndClassification(scanner);
                    break;
                case 2:
                    system.automaticTextAdditionAndClassification(scanner);
                    break;
                case 3:
                    system.returnTextInformation();
                    break;
                case 4:
                    running = false;
                    System.out.println("Sistema encerrado.");
                    break;
                default:
                    // Mantido como proteção adicional caso novas opções sejam adicionadas futuramente.
                    System.out.println("Opção inválida.");
                    break;
            }
        }

        scanner.close();
    }

    /**
     * Lê e valida a opção do menu.
     *
     * <p>O método evita que entradas não numéricas ou fora do intervalo permitido
     * interrompam a execução do programa.</p>
     *
     * @param scanner objeto utilizado para leitura da entrada do usuário.
     * @return opção válida entre 1 e 4.
     */
    private static int readMenuOption(Scanner scanner) {
        while (true) {
            System.out.print("Escolha uma opção: ");
            String input = scanner.nextLine();

            try {
                int option = Integer.parseInt(input.trim());

                if (option >= 1 && option <= 4) {
                    return option;
                }

                System.out.println("Opção inválida. Digite um número entre 1 e 4.");
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Digite apenas números.");
            }
        }
    }
}
