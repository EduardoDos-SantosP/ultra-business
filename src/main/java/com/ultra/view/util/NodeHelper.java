package com.ultra.view.util;

import javafx.css.Styleable;

import java.util.Arrays;
import java.util.HashMap;

public abstract class NodeHelper {
    public static HashMap<String, String> getStyleRules(Styleable element) {
        var style = element.getStyle();
        var rules = new HashMap<String, String>();

        Arrays.stream(style.split(";")).forEach(rule -> {
            String[] keyValue = rule.trim().split(":");
            if (keyValue.length != 2)
                throw new RuntimeException("Regra de estilo mal formada: '" + rule + "'");

            rules.put(keyValue[0].trim(), keyValue[1].trim());
        });

        return rules;
    }
}
