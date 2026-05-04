package Verification;

public class News
{
    private String text;
    private String classification;


    //Função construtora, que recebe e trata as noticias
    public News(String text, String classification) //News é oriunda da refatoração da "Função faz tudo"
    {
        if(text == null || text.isBlank())
        {
            throw new IllegalArgumentException("O Texto é inválido");
        }

        this.text = text;
        this.classification =(classification == null || classification.isBlank())
                ? "Duvidosa"
                : classification;
    }
    public String getText(){return text;}

    public String getClassification(){return classification;}

}
