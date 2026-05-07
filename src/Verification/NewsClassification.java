package Verification;


//Mudanças: modularização e fragmentação dos metodos de analise
//Tratamento para o caso da fonte estar em letras minusculas
public class NewsClassification
{
    public static String messageAnalysis(String texto)
    {
        String normalizedText = texto.toUpperCase();
        if (normalizedText.contains("FONTE") || normalizedText.contains("FONTE:"))
        {
            return "confiavel";
        }

        int score = scoreCalculator(texto);

        if (score == 0) return "confiavel";
        if (score == 1) return "duvidosa";
        return "falsa";
    }

    //Calcula o Score da da mensagem
    private static int scoreCalculator(String texto)
    {
        int score = 1;

        if (texto.contains("!!!"))   score++;
        if (texto.contains("URGENTE")) score++;
        if (texto.length() < 10)     score++;

        return score;
    }
}
