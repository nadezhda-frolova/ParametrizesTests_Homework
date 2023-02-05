package businessGazeta;

import com.codeborne.selenide.CollectionCondition;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class BusinessGazetaHotNews {
    @ValueSource(
            strings ={"Казань", "Закамье"}
    )
    @ParameterizedTest (name = "HotNews")//Не отображается русское название тесткейса. Причину не нашла
    @Tags({@Tag("CRITICAL"),@Tag("UI")})
   void businessGazetaHotNews(String cities){
        open("https://www.business-gazeta.ru");
        $(".header__cities").$(byText(cities)).click();
        $$(".hot-news li").shouldHave(CollectionCondition.size(3));
    }


}
