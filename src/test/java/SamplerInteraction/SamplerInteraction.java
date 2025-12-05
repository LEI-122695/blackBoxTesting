package SamplerInteraction;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.visible;

public class SamplerInteraction {

    // URL do site oficial do Vaadin Sampler
    private static final String URL = "https://demo.vaadin.com/sampler/";

    // --- ELEMENTOS ---
    private final SelenideElement userInterfaceMenu = $(byText("User interface"));
    private final SelenideElement dataInputMenu = $(byText("Data input"));

    // --- MÉTODOS (Ações) ---

    public void open() {
        Selenide.open(URL);

        // CORREÇÃO CRÍTICA:
        // Obrigamos o teste a esperar que o menu "User interface" apareça.
        // Só depois disso é que o site é considerado "carregado" e o título estará disponível.
        userInterfaceMenu.shouldBe(visible);
    }

    public void clickUserInterface() {
        userInterfaceMenu.shouldBe(visible).click();
    }

    public void clickDataInput() {
        dataInputMenu.shouldBe(visible).click();
    }

    public String getTitle() {
        return Selenide.title();
    }
}