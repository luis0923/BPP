package Model;
import Verification.NewsClassification;

import java.util.Scanner;

public class Sistema
{
    public static NewsRepository newsRepository = new NewsRepository();

    // função responsavel por "printar" cada texto e sua classificação, mover daqui
    public static void returnTextInformation()
    {

        for (int i = 0; i < newsRepository.newsRepository.size(); i++)
        {
            System.out.println("Texto: " + newsRepository.newsRepository.get(i).getText());
            System.out.println("Classificacao: " + newsRepository.newsRepository.get(i).getClassification());
            System.out.println("-------------------");
        }

    }

    public static void manualTextAdditionAndClassification(Scanner scanner)
    {

        System.out.print("Digite o texto: ");
        String text = scanner.nextLine();

        System.out.print("Digite classificacao: ");
        String classifier = scanner.nextLine();

        newsRepository.newsStorage(text, classifier);

    }

    public static void automaticTextAdditionAndClassification(Scanner scanner)
    {
        NewsClassification newsClassification = new NewsClassification();
        System.out.print("Digite o texto: ");
        String text = scanner.nextLine();

        String classifier = newsClassification.messageAnalysis(text);
        newsRepository.newsStorage(text, classifier);
    }

    public static void menu()
    {
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
                    manualTextAdditionAndClassification(scanner);
                    break;
                case 2:
                    automaticTextAdditionAndClassification(scanner);
                    break;
                case 3:
                    returnTextInformation();
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

    // Manter enquanto estiver testando
    public static void main(String[] args) {
        menu();
    }
}