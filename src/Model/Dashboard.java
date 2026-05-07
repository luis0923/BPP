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
            System.out.println("1 - adicionar manual");
            System.out.println("2 - adicionar automatico");
            System.out.println("3 - listar");
            System.out.println("4 - sair");

            int op = scanner.nextInt();
            scanner.nextLine();

            switch(op)
            {
                case 1:
                    systemOfAdditionAndClassification.manualTextAdditionAndClassification(scanner);
                    break;
                case 2:
                    systemOfAdditionAndClassification.automaticTextAdditionAndClassification(scanner);
                    break;
                case 3:
                    systemOfAdditionAndClassification.returnTextInformation();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Digite um valor válido!");


            }

        }
        scanner.close();

    }
}
