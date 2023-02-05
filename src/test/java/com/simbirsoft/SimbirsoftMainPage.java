package com.simbirsoft;

import com.simbirsoft.data.Locale;
import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SimbirsoftMainPage {

    @BeforeAll
    static void simpleTest() {
        open("https://www.simbirsoft.com");
    }
    static Stream<Arguments> simbirSoftLocaleCheck(){
        return Stream.of(
                Arguments.of(Locale.En, List.of("Projects", "Services", "Insights", "About Us", "Locations")),
                Arguments.of(Locale.Ru, List.of("Проекты", "Услуги", "Блог", "Вакансии", "Карьера", "О нас", "Контакты"))

        );
    }
    @MethodSource
    @ParameterizedTest(name="HelloWorld")//Не отображается русское название тесткейса. Причину не нашла
    @Tags({@Tag("BLOCKER"),@Tag("UI")})
    void simbirSoftLocaleCheck(
            Locale locale,
            List<String> buttons
    )    {
        $(".gh-tools").$(byText(locale.name())).click();
        $$(".gh-nav a").filter(visible).shouldHave(CollectionCondition.texts(buttons));
    }
}
