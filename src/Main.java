import Model.Dashboard;

/**
 * Classe principal da aplicação.
 *
 * <p>Responsável apenas por iniciar o sistema e delegar a execução do menu
 * principal para a classe {@link Dashboard}.</p>
 */
public class Main {

    /**
     * Ponto de entrada da aplicação.
     *
     * @param args argumentos de linha de comando, não utilizados neste projeto.
     */
    public static void main(String[] args) {
        Dashboard.menu();
    }
}