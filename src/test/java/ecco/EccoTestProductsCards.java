package ecco;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class EccoTestProductsCards {
    @CsvSource({
    "Сумки, Кожаные аксессуары",
    "Аксессуары, Аксессуары"
    })

    @ParameterizedTest(name="HelloWorld")//Не отображается русское название тесткейса. Причину не нашла
    @Tags({@Tag("BLOCKER"),@Tag("UI")})
    void eccoProductCorrespondsToTheDescription(
            String productName,
            String productDescription
    ) {

        open("https://ecco.ru");
        $(".new-header-menu-wrap").$(byText(productName)).click();
        $(".i-catalog").shouldHave(text(productDescription));
    }


}

