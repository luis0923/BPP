package Verification;

import java.text.Normalizer;

public final class NewsValidator {

    private static final int MIN_TEXT_LENGTH = 10;
    private static final int MAX_TEXT_LENGTH = 1000;

    private NewsValidator() {
        // Impede que a classe seja instanciada
    }

    public static String validateAndNormalizeText(String text) {
        if (text == null) {
            throw new IllegalArgumentException("O texto não pode ser nulo.");
        }

        String normalizedText = text.trim().replaceAll("\\s+", " ");

        if (normalizedText.isEmpty()) {
            throw new IllegalArgumentException("O texto não pode ser vazio.");
        }

        if (normalizedText.length() < MIN_TEXT_LENGTH) {
            throw new IllegalArgumentException(
                "O texto deve possuir pelo menos " + MIN_TEXT_LENGTH + " caracteres."
            );
        }

        if (normalizedText.length() > MAX_TEXT_LENGTH) {
            throw new IllegalArgumentException(
                "O texto não pode ultrapassar " + MAX_TEXT_LENGTH + " caracteres."
            );
        }

        if (!normalizedText.matches(".*[\\p{L}].*")) {
            throw new IllegalArgumentException("O texto deve conter pelo menos uma letra.");
        }

        return normalizedText;
    }

    public static String validateAndNormalizeClassification(String classification) {
        if (classification == null) {
            throw new IllegalArgumentException("A classificação não pode ser nula.");
        }

        String normalizedClassification = removeAccents(classification)
                .trim()
                .toLowerCase();

        switch (normalizedClassification) {
            case "confiavel":
                return "confiavel";
            case "duvidosa":
                return "duvidosa";
            case "falsa":
                return "falsa";
            default:
                throw new IllegalArgumentException(
                    "Classificação inválida. Use apenas: confiavel, duvidosa ou falsa."
                );
        }
    }

    private static String removeAccents(String text) {
        String normalized = Normalizer.normalize(text, Normalizer.Form.NFD);
        return normalized.replaceAll("\\p{M}", "");
    }
}