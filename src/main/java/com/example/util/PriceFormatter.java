package com.example.util;

import org.springframework.stereotype.Component;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Utility per formattare i prezzi in UI (Thymeleaf).
 *
 * Esempio: 1000 -> "1.000" (formato italiano con punto come separatore migliaia)
 */
@Component("priceFormatter")
public class PriceFormatter {

    public String format(Integer price) {
        if (price == null) {
            return "0";
        }
        NumberFormat nf = NumberFormat.getIntegerInstance(Locale.ITALY);
        nf.setGroupingUsed(true);
        return nf.format(price);
    }
}
