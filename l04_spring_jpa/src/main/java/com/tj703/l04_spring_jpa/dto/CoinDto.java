package com.tj703.l04_spring_jpa.dto;

import lombok.Data;

@Data
public class CoinDto {
//market	업비트에서 제공중인 시장 정보	String
//korean_name	거래 대상 디지털 자산 한글명	String
//english_name	거래 대상 디지털 자산 영문명	String
//market_event.warning

    private String market;
    private String korean_name;
    private String english_name;
    private MarketEvent market_event;

    @Data
    public class MarketEvent {
        private boolean warning;
        private Caution caution;

        @Data
        private class Caution {
            private boolean PRICE_FLUCTUATIONS;
            private boolean TRADING_VOLUME_SOARING;
            private boolean DEPOSIT_AMOUNT_SOARING;
            private boolean GLOBAL_PRICE_DIFFERENCES;
            private boolean CONCENTRATION_OF_SMALL_ACCOUNTS;
        }

    }

}
