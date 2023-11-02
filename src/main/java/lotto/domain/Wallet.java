package lotto.domain;

import java.util.List;
import lotto.vo.Lotto;

public class Wallet {

    private final List<Lotto> lottoBundle;

    public Wallet(List<Lotto> lottoBundle) {
        this.lottoBundle = lottoBundle;
    }

    public List<Lotto> getLottoBundle() {
        return lottoBundle;
    }
}
