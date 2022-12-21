package menu.domain.service;

import menu.domain.Category;
import menu.domain.Menu;
import menu.domain.repository.MenuRepository;

public class MenuMaker {

    private final MenuRepository menuRepository;

    public MenuMaker(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public void makeMenus() {
        makeJapaneseMenu();
        makeKoreanMenu();
        makeChineseMenu();
        makeAsianMenu();
        makeWesternMenu();
    }

    private void makeJapaneseMenu() {
        menuRepository.addMenu(new Menu("규동", Category.JAPANESE));
        menuRepository.addMenu(new Menu("우동", Category.JAPANESE));
        menuRepository.addMenu(new Menu("미소시루", Category.JAPANESE));
        menuRepository.addMenu(new Menu("스시", Category.JAPANESE));
        menuRepository.addMenu(new Menu("가츠동", Category.JAPANESE));
        menuRepository.addMenu(new Menu("오니기리", Category.JAPANESE));
        menuRepository.addMenu(new Menu("하이라이스", Category.JAPANESE));
        menuRepository.addMenu(new Menu("라멘", Category.JAPANESE));
        menuRepository.addMenu(new Menu("오코노미야끼", Category.JAPANESE));
    }

    private void makeKoreanMenu() {
        menuRepository.addMenu(new Menu("김밥", Category.KOREAN));
        menuRepository.addMenu(new Menu("김치찌개", Category.KOREAN));
        menuRepository.addMenu(new Menu("쌈밥", Category.KOREAN));
        menuRepository.addMenu(new Menu("된장찌개", Category.KOREAN));
        menuRepository.addMenu(new Menu("비빔밥", Category.KOREAN));
        menuRepository.addMenu(new Menu("칼국수", Category.KOREAN));
        menuRepository.addMenu(new Menu("불고기", Category.KOREAN));
        menuRepository.addMenu(new Menu("떡볶이", Category.KOREAN));
        menuRepository.addMenu(new Menu("제육볶음", Category.KOREAN));
    }

    private void makeChineseMenu() {
        menuRepository.addMenu(new Menu("깐풍기", Category.CHINESE));
        menuRepository.addMenu(new Menu("볶음면", Category.CHINESE));
        menuRepository.addMenu(new Menu("동파육", Category.CHINESE));
        menuRepository.addMenu(new Menu("짜장면", Category.CHINESE));
        menuRepository.addMenu(new Menu("짬뽕", Category.CHINESE));
        menuRepository.addMenu(new Menu("마파두부", Category.CHINESE));
        menuRepository.addMenu(new Menu("탕수육", Category.CHINESE));
        menuRepository.addMenu(new Menu("토마토 달걀볶음", Category.CHINESE));
        menuRepository.addMenu(new Menu("고추잡채", Category.CHINESE));
    }

    private void makeAsianMenu() {
        menuRepository.addMenu(new Menu("팟타이", Category.ASIAN));
        menuRepository.addMenu(new Menu("카오 팟", Category.ASIAN));
        menuRepository.addMenu(new Menu("나시고렝", Category.ASIAN));
        menuRepository.addMenu(new Menu("파인애플 볶음밥", Category.ASIAN));
        menuRepository.addMenu(new Menu("쌀국수", Category.ASIAN));
        menuRepository.addMenu(new Menu("똠얌꿍", Category.ASIAN));
        menuRepository.addMenu(new Menu("반미", Category.ASIAN));
        menuRepository.addMenu(new Menu("월남쌈", Category.ASIAN));
        menuRepository.addMenu(new Menu("분짜", Category.ASIAN));
    }

    private void makeWesternMenu() {
        menuRepository.addMenu(new Menu("라자냐", Category.WESTERN));
        menuRepository.addMenu(new Menu("그라탱", Category.WESTERN));
        menuRepository.addMenu(new Menu("뇨끼", Category.WESTERN));
        menuRepository.addMenu(new Menu("끼슈", Category.WESTERN));
        menuRepository.addMenu(new Menu("프렌치 토스트", Category.WESTERN));
        menuRepository.addMenu(new Menu("바게트", Category.WESTERN));
        menuRepository.addMenu(new Menu("스파게티", Category.WESTERN));
        menuRepository.addMenu(new Menu("피자", Category.WESTERN));
        menuRepository.addMenu(new Menu("파나니", Category.WESTERN));
    }
}
