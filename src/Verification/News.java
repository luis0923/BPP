package Verification;

/**
 * Representa uma notícia cadastrada no sistema.
 *
 * <p>A classe garante que toda notícia criada possua texto e classificação válidos,
 * evitando que objetos inconsistentes sejam armazenados no repositório.</p>
 */
public class News {

    private final String text;
    private final String classification;

    /**
     * Cria uma notícia a partir do texto e da classificação informados.
     *
     * @param text texto da notícia.
     * @param classification classificação da notícia.
     * @throws IllegalArgumentException caso o texto ou a classificação sejam inválidos.
     */
    public News(String text, String classification) {
        this.text = NewsValidator.validateAndNormalizeText(text);
        this.classification = NewsValidator.validateAndNormalizeClassification(classification);
    }

    /**
     * Retorna o texto da notícia.
     *
     * @return texto validado da notícia.
     */
    public String getText() {
        return text;
    }

    /**
     * Retorna a classificação da notícia.
     *
     * @return classificação validada da notícia.
     */
    public String getClassification() {
        return classification;
    }
}
