package lotto;

import lotto.exception.WrongTypeFormatException;
import lotto.service.impl.ValidateServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @DisplayName("금액 입력 시 문자가 들어가면 IllegalArgumentException 예외가 발생한다")
    @Test
    void createMoneyByWrongTypeOne() {
        ValidateServiceImpl validateService = new ValidateServiceImpl();
        Assertions.assertThatThrownBy(() -> validateService.checkCorrectMoney(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액 입력 시 문자가 들어가면 WrongTypeFormatException 예외가 발생한다")
    @Test
    void createMoneyByWrongTypeTwo() {
        ValidateServiceImpl validateService = new ValidateServiceImpl();
        Assertions.assertThatThrownBy(() -> validateService.checkCorrectMoney("1000j"))
                .isInstanceOf(WrongTypeFormatException.class);
    }

    @DisplayName("금액 입력 시 1000원 단위가 아니면 IllegalArgumentException 예외가 발생한다")
    @Test
    void createMoneyByWrongUnitTypeOne() {
        ValidateServiceImpl validateService = new ValidateServiceImpl();
        Assertions.assertThatThrownBy(() -> validateService.checkCorrectMoney("1500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("금액 입력 시 1000원 단위가 아니면 WrongTypeFormatException 예외가 발생한다")
    @Test
    void createMoneyByWrongUnitTypeTwo() {
        ValidateServiceImpl validateService = new ValidateServiceImpl();
        Assertions.assertThatThrownBy(() -> validateService.checkCorrectMoney("1500"))
                .isInstanceOf(WrongTypeFormatException.class);
    }
}
