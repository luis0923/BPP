package Verification;

import java.text.Normalizer;

/**
 * Centraliza as regras de validação e normalização utilizadas no sistema.
 *
 * <p>A criação desta classe evita duplicação de regras e facilita futuras
 * manutenções relacionadas à Programação Defensiva.</p>
 */
public final class NewsValidator {

    private static final int MIN_TEXT_LENGTH = 10;
    private static final int MAX_TEXT_LENGTH = 1000;

    /**
     * Construtor privado para impedir a instanciação da classe utilitária.
     */
    private NewsValidator() {
    }

    /**
     * Valida e normaliza o texto de uma notícia.
     *
     * <p>O método remove espaços excedentes, impede textos nulos, vazios,
     * excessivamente curtos, muito longos ou sem caracteres alfabéticos.</p>
     *
     * @param text texto informado pelo usuário.
     * @return texto validado e normalizado.
     * @throws IllegalArgumentException caso o texto não atenda às regras definidas.
     */
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

    /**
     * Valida e normaliza a classificação informada manualmente.
     *
     * <p>O método aceita variações com acento, mas padroniza o retorno sem acentuação.</p>
     *
     * @param classification classificação informada pelo usuário.
     * @return classificação validada e padronizada.
     * @throws IllegalArgumentException caso a classificação seja nula ou inválida.
     */
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

    /**
     * Remove acentos de uma string para facilitar a comparação de entradas.
     *
     * @param text texto original.
     * @return texto sem acentuação.
     */
    private static String removeAccents(String text) {
        String normalized = Normalizer.normalize(text, Normalizer.Form.NFD);
        return normalized.replaceAll("\\p{M}", "");
    }
}
