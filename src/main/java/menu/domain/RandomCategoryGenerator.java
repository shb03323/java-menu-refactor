package menu.domain;

import camp.nextstep.edu.missionutils.Randoms;

import static menu.constant.RecommendConstant.CATEGORY_LOWER_INCLUSIVE;
import static menu.constant.RecommendConstant.CATEGORY_UPPER_INCLUSIVE;

public class RandomCategoryGenerator implements CategoryGenerator {

    @Override
    public Category generate() {
        int categoryNumber = Randoms.pickNumberInRange(CATEGORY_LOWER_INCLUSIVE, CATEGORY_UPPER_INCLUSIVE);
        return Category.from(categoryNumber);
    }
}
