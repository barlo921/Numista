package com.barlo.numista;

import com.barlo.numista.model.Coin;
import com.barlo.numista.utils.CoinUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NumistaConfiguration {

    @Bean
    public Coin getEditingCoin(){
        return new Coin();
    }

    @Bean
    public CoinUtil getCoinUtil() {
        return new CoinUtil();
    }

}
