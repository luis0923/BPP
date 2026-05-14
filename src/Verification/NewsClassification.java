package Verification;

/**
 * Responsável pela classificação automática de notícias.
 *
 * <p>A análise utiliza regras simples baseadas na presença de fonte declarada
 * e em sinais textuais que podem indicar conteúdo duvidoso.</p>
 */
public class NewsClassification {

    /**
     * Analisa o texto informado e retorna uma classificação automática.
     *
     * @param text texto da notícia a ser analisada.
     * @return classificação calculada: {@code confiavel}, {@code duvidosa} ou {@code falsa}.
     * @throws IllegalArgumentException caso o texto seja inválido.
     */
    public static String messageAnalysis(String text) {
        String normalizedText = NewsValidator.validateAndNormalizeText(text);
        String upperText = normalizedText.toUpperCase();

        if (upperText.contains("FONTE") || upperText.contains("FONTE:")) {
            return "confiavel";
        }

        int score = scoreCalculator(upperText);

        if (score == 0) return "confiavel";
        if (score == 1) return "duvidosa";
        return "falsa";
    }

    /**
     * Calcula uma pontuação de risco para o texto analisado.
     *
     * <p>Quanto maior a pontuação, maior a chance de a notícia ser classificada
     * como duvidosa ou falsa.</p>
     *
     * @param text texto normalizado em letras maiúsculas.
     * @return pontuação calculada a partir dos critérios definidos.
     */
    private static int scoreCalculator(String text) {
        // A ausência de fonte já adiciona um risco inicial à notícia.
        int score = 1;

        if (text.contains("!!!")) score++;
        if (text.contains("URGENTE")) score++;
        if (text.length() < 10) score++;

        return score;
    }
}
