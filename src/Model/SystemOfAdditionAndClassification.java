package Model;
import Verification.NewsClassification;

import java.util.Scanner;

public class SystemOfAdditionAndClassification {
    public static NewsRepository newsRepository = new NewsRepository();

    // função responsavel por "printar" cada texto e sua classificação, mover daqui
    public static void returnTextInformation() {

        for (int i = 0; i < newsRepository.newsRepository.size(); i++) {
            System.out.println("Texto: " + newsRepository.newsRepository.get(i).getText());
            System.out.println("Classificacao: " + newsRepository.newsRepository.get(i).getClassification());
            System.out.println("-------------------");
        }

    }

    public static void manualTextAdditionAndClassification(Scanner scanner) {

        System.out.print("Digite o texto: ");
        String text = scanner.nextLine();

        System.out.print("Digite classificacao: ");
        String classifier = scanner.nextLine();

        newsRepository.newsStorage(text, classifier);

    }

    public static void automaticTextAdditionAndClassification(Scanner scanner) {
        NewsClassification newsClassification = new NewsClassification();
        System.out.print("Digite o texto: ");
        String text = scanner.nextLine();

        String classifier = newsClassification.messageAnalysis(text);
        newsRepository.newsStorage(text, classifier);
    }
}