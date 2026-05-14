package Model;

import Verification.News;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NewsRepository {

    private final List<News> newsRepository = new ArrayList<>();

    //Armazena os dados das notícias
    public void newsStorage(String text, String classification) {
        News news = new News(text, classification);

        if (existsByText(news.getText())) {
            throw new IllegalArgumentException("Essa notícia já foi cadastrada.");
        }

        newsRepository.add(news);
    }

    public List<News> getAllNews() {
        return Collections.unmodifiableList(newsRepository);
    }

    public boolean isEmpty() {
        return newsRepository.isEmpty();
    }

    private boolean existsByText(String text) {
        for (News news : newsRepository) {
            if (news.getText().equalsIgnoreCase(text)) {
                return true;
            }
        }

        return false;
    }
}