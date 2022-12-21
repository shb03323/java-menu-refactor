package menu.domain.service;

import menu.domain.Category;
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
        menuRepository.addMenu("규동", Category.JAPANESE);
        menuRepository.addMenu("우동", Category.JAPANESE);
        menuRepository.addMenu("미소시루", Category.JAPANESE);
        menuRepository.addMenu("스시", Category.JAPANESE);
        menuRepository.addMenu("가츠동", Category.JAPANESE);
        menuRepository.addMenu("오니기리", Category.JAPANESE);
        menuRepository.addMenu("하이라이스", Category.JAPANESE);
        menuRepository.addMenu("라멘", Category.JAPANESE);
        menuRepository.addMenu("오코노미야끼", Category.JAPANESE);
    }

    private void makeKoreanMenu() {
        menuRepository.addMenu("김밥", Category.KOREAN);
        menuRepository.addMenu("김치찌개", Category.KOREAN);
        menuRepository.addMenu("쌈밥", Category.KOREAN);
        menuRepository.addMenu("된장찌개", Category.KOREAN);
        menuRepository.addMenu("비빔밥", Category.KOREAN);
        menuRepository.addMenu("칼국수", Category.KOREAN);
        menuRepository.addMenu("불고기", Category.KOREAN);
        menuRepository.addMenu("떡볶이", Category.KOREAN);
        menuRepository.addMenu("제육볶음", Category.KOREAN);
    }

    private void makeChineseMenu() {
        menuRepository.addMenu("깐풍기", Category.CHINESE);
        menuRepository.addMenu("볶음면", Category.CHINESE);
        menuRepository.addMenu("동파육", Category.CHINESE);
        menuRepository.addMenu("짜장면", Category.CHINESE);
        menuRepository.addMenu("짬뽕", Category.CHINESE);
        menuRepository.addMenu("마파두부", Category.CHINESE);
        menuRepository.addMenu("탕수육", Category.CHINESE);
        menuRepository.addMenu("토마토 달걀볶음", Category.CHINESE);
        menuRepository.addMenu("고추잡채", Category.CHINESE);
    }

    private void makeAsianMenu() {
        menuRepository.addMenu("팟타이", Category.ASIAN);
        menuRepository.addMenu("카오 팟", Category.ASIAN);
        menuRepository.addMenu("나시고렝", Category.ASIAN);
        menuRepository.addMenu("파인애플 볶음밥", Category.ASIAN);
        menuRepository.addMenu("쌀국수", Category.ASIAN);
        menuRepository.addMenu("똠얌꿍", Category.ASIAN);
        menuRepository.addMenu("반미", Category.ASIAN);
        menuRepository.addMenu("월남쌈", Category.ASIAN);
        menuRepository.addMenu("분짜", Category.ASIAN);
    }

    private void makeWesternMenu() {
        menuRepository.addMenu("라자냐", Category.WESTERN);
        menuRepository.addMenu("그라탱", Category.WESTERN);
        menuRepository.addMenu("뇨끼", Category.WESTERN);
        menuRepository.addMenu("끼슈", Category.WESTERN);
        menuRepository.addMenu("프렌치 토스트", Category.WESTERN);
        menuRepository.addMenu("바게트", Category.WESTERN);
        menuRepository.addMenu("스파게티", Category.WESTERN);
        menuRepository.addMenu("피자", Category.WESTERN);
        menuRepository.addMenu("파나니", Category.WESTERN);
    }
}
