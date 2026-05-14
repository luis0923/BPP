package Model;

import Verification.News;
import Verification.NewsClassification;
import Verification.NewsValidator;

import java.util.Scanner;

/**
 * Controla as operações de cadastro, classificação e listagem de notícias.
 *
 * <p>Esta classe faz a mediação entre a interface de console, o classificador
 * automático e o repositório de notícias.</p>
 */
public class SystemOfAdditionAndClassification {

    private static final NewsRepository newsRepository = new NewsRepository();

    /**
     * Lista todas as notícias armazenadas no repositório.
     */
    public static void returnTextInformation() {
        if (newsRepository.isEmpty()) {
            System.out.println("Nenhuma notícia cadastrada.");
            return;
        }

        for (News news : newsRepository.getAllNews()) {
            System.out.println("Texto: " + news.getText());
            System.out.println("Classificacao: " + news.getClassification());
            System.out.println("-------------------");
        }
    }

    /**
     * Realiza o cadastro manual de uma notícia.
     *
     * <p>Nesse fluxo, o usuário informa tanto o texto quanto a classificação.</p>
     *
     * @param scanner objeto utilizado para leitura da entrada do usuário.
     */
    public static void manualTextAdditionAndClassification(Scanner scanner) {
        String text = readRequiredText(scanner);
        String classifier = readValidClassification(scanner);

        saveNews(text, classifier);
    }

    /**
     * Realiza o cadastro automático de uma notícia.
     *
     * <p>Nesse fluxo, o usuário informa apenas o texto. A classificação é definida
     * automaticamente pela classe {@link NewsClassification}.</p>
     *
     * @param scanner objeto utilizado para leitura da entrada do usuário.
     */
    public static void automaticTextAdditionAndClassification(Scanner scanner) {
        String text = readRequiredText(scanner);
        String classifier = NewsClassification.messageAnalysis(text);

        saveNews(text, classifier);
    }

    /**
     * Lê o texto da notícia até que uma entrada válida seja informada.
     *
     * @param scanner objeto utilizado para leitura da entrada do usuário.
     * @return texto validado e normalizado.
     */
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

    /**
     * Lê a classificação manual até que uma entrada válida seja informada.
     *
     * @param scanner objeto utilizado para leitura da entrada do usuário.
     * @return classificação validada e normalizada.
     */
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

    /**
     * Salva a notícia no repositório e trata possíveis erros de validação.
     *
     * @param text texto validado da notícia.
     * @param classifier classificação validada da notícia.
     */
    private static void saveNews(String text, String classifier) {
        try {
            newsRepository.newsStorage(text, classifier);
            System.out.println("Notícia cadastrada com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao cadastrar notícia: " + e.getMessage());
        }
    }
}
