package SamplerInteraction;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class SamplerInteractionTest {

    private final SamplerInteraction sampler = new SamplerInteraction();

    @BeforeAll
    public void globalConfig() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 10000; // 10 segundos de espera
    }

    @BeforeEach
    public void setUp() {
        // Ao chamar este open(), ele agora espera pelo menu antes de continuar
        sampler.open();
    }

    @Test
    @DisplayName("Deve carregar a página inicial corretamente")
    public void testCarregamentoInicial() {
        String tituloAtual = sampler.getTitle();
        System.out.println("Título encontrado: " + tituloAtual);

        // Verifica se o título não é nulo e contém "Vaadin"
        assertNotNull(tituloAtual, "O título não devia ser nulo");
        assertTrue(tituloAtual.contains("Vaadin"), "O título da página devia conter 'Vaadin'");
    }

    @Test
    @DisplayName("Deve navegar pelos menus laterais")
    public void testNavegacaoMenus() {
        // 1. Clica em User Interface
        sampler.clickUserInterface();

        // Verifica URL
        String currentUrl = WebDriverRunner.getWebDriver().getCurrentUrl();
        assertTrue(currentUrl.contains("sampler"), "A URL deve manter-se no domínio do sampler");

        // 2. Clica em Data Input
        sampler.clickDataInput();
    }
}