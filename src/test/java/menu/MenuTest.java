package menu;

import menu.domain.Category;
import menu.domain.Menu;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MenuTest {

    @Test
    void 동일_메뉴_이름_검사_기능_테스트() {
        Menu menu = new Menu("왕밤빵", Category.KOREAN);
        String wrongMenuName = "왕밤밤빵";
        String rightMenuName = "왕밤빵";

        assertTrue(menu.isSameName(rightMenuName));
        assertFalse(menu.isSameName(wrongMenuName));
    }
}
