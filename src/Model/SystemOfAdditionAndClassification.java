package Model;

import Verification.NewsClassification;

import java.util.Scanner;

public class SystemOfAdditionAndClassification {
    public static NewsRepository newsRepository = new NewsRepository();

    public static void returnTextInformation() {
        if (newsRepository.isEmpty()) {
            System.out.println("Nenhuma notícia cadastrada.");
            return;
        }

        for (int i = 0; i < newsRepository.getAllNews().size(); i++) {
            System.out.println("Texto: " + newsRepository.getAllNews().get(i).getText());
            System.out.println("Classificacao: " + newsRepository.getAllNews().get(i).getClassification());
            System.out.println("-------------------");
        }
    }

    public static void manualTextAdditionAndClassification(Scanner scanner) {
        String text = readRequiredText(scanner);

        String classifier = readValidClassification(scanner);

        saveNews(text, classifier);
    }

    public static void automaticTextAdditionAndClassification(Scanner scanner) {
        NewsClassification newsClassification = new NewsClassification();

        String text = readRequiredText(scanner);

        String classifier = newsClassification.messageAnalysis(text);

        saveNews(text, classifier);
    }

    private static String readRequiredText(Scanner scanner) {
        while (true) {
            System.out.print("Digite o texto: ");
            String text = scanner.nextLine();

            try {
                return NewsValidator.validateAndNormalizeText(text);
            } catch (IllegalArgumentException e) {
                System.out.println("Entrada inválida: " + e.getMessage());
            }
        }
    }

    private static String readValidClassification(Scanner scanner) {
        while (true) {
            System.out.print("Digite classificacao (confiavel, duvidosa ou falsa): ");
            String classifier = scanner.nextLine();

            try {
                return NewsValidator.validateAndNormalizeClassification(classifier);
            } catch (IllegalArgumentException e) {
                System.out.println("Entrada inválida: " + e.getMessage());
            }
        }
    }

    private static void saveNews(String text, String classifier) {
        try {
            newsRepository.newsStorage(text, classifier);
            System.out.println("Notícia cadastrada com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao cadastrar notícia: " + e.getMessage());
        }
    }
}