package Model;

import Verification.News;

import java.util.ArrayList;

public class NewsRepository
{
    String text;
    String classification;

    public ArrayList<News> newsRepository = new ArrayList<>();
    // Armazena os dados das noticias
    public void newsStorage(String text, String classification)
    {
        News news = new News(text, classification);

        newsRepository.add(news);
    }
}
