package Model;

import Verification.News;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Repositório em memória responsável por armazenar as notícias cadastradas.
 *
 * <p>A lista interna é mantida privada para impedir alterações externas indevidas.
 * Além disso, o repositório valida a duplicidade dos textos antes do armazenamento.</p>
 */
public class NewsRepository {

    private final List<News> newsRepository = new ArrayList<>();

    /**
     * Armazena uma notícia validada no repositório.
     *
     * @param text texto da notícia.
     * @param classification classificação atribuída à notícia.
     * @throws IllegalArgumentException caso a notícia já tenha sido cadastrada
     *                                  ou os dados informados sejam inválidos.
     */
    public void newsStorage(String text, String classification) {
        News news = new News(text, classification);

        if (existsByText(news.getText())) {
            throw new IllegalArgumentException("Essa notícia já foi cadastrada.");
        }

        newsRepository.add(news);
    }

    /**
     * Retorna uma lista somente leitura com todas as notícias cadastradas.
     *
     * @return lista imutável de notícias.
     */
    public List<News> getAllNews() {
        return Collections.unmodifiableList(newsRepository);
    }

    /**
     * Verifica se o repositório está vazio.
     *
     * @return {@code true} se não houver notícias cadastradas; caso contrário, {@code false}.
     */
    public boolean isEmpty() {
        return newsRepository.isEmpty();
    }

    /**
     * Verifica se já existe uma notícia cadastrada com o mesmo texto.
     *
     * @param text texto a ser comparado.
     * @return {@code true} se o texto já existir no repositório; caso contrário, {@code false}.
     */
    private boolean existsByText(String text) {
        for (News news : newsRepository) {
            if (news.getText().equalsIgnoreCase(text)) {
                return true;
            }
        }

        return false;
    }
}
