package menu.domain.repository;

import menu.domain.Category;
import menu.domain.Menu;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static menu.constant.SystemConstant.ERROR_PREFIX;

public class MenuRepository {

    private final List<Menu> menus = new ArrayList<>();

    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    public Menu findByName(String menuName) {
        return menus.stream()
                .filter(menu -> menu.isSameName(menuName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_PREFIX + "존재하지 않는 메뉴입니다."));
    }
    public List<Menu> changeMenuNamesToMenus(List<String> menuNames) {
        return menuNames.stream()
                .map(this::findByName)
                .collect(Collectors.toUnmodifiableList());
    }
}
