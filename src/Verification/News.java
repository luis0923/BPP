package Verification;

// Exclusão class D
//Função F virou news
public class News {
    private String text;
    private String classification;

    //Função construtora, que recebe e trata as noticias
    public News(String text, String classification) { //News é oriunda da refatoração da "Função faz tudo"
        this.text = NewsValidator.validateAndNormalizeText(text);
        this.classification = NewsValidator.validateAndNormalizeClassification(classification);
    }

    public String getText() {
        return text;
    }

    public String getClassification() {
        return classification;
    }
}