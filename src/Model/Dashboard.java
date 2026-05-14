package Model;

import java.util.Scanner;

public class Dashboard
{
    public static void menu()
    {
        SystemOfAdditionAndClassification systemOfAdditionAndClassification = new SystemOfAdditionAndClassification();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        while (running)
        {
            System.out.println("\n===== MENU =====");
            System.out.println("1 - Adicionar manual");
            System.out.println("2 - Adicionar automático");
            System.out.println("3 - Listar");
            System.out.println("4 - Sair");

            int op = readMenuOption(scanner);

            switch(op)
            {
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
                    System.out.println("Opção inválida.");
                    break;
            }

        }
        scanner.close();
    }
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
