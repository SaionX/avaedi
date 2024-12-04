package es.caib.avaedi.logic.bo;

import java.util.HashMap;
import java.util.Map;

public enum TipusIee {
    T30 ("IEE 30"),
    T40 ("Renov. IEE 30"),
    T50 ("IEE 50"),
    T50R ("Renov. IEE 50");

    private String text;

    private TipusIee(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public static TipusIee fromString(String text) {
        for (TipusIee b : TipusIee.values()) {
            if (b.text.equals(text)) {
                return b;
            }
        }
        return null;
    }
    public static TipusIee fromName(String name) {
        for (TipusIee b : TipusIee.values()) {
            if (b.name().equals(name)) {
                return b;
            }
        }
        return null;
    }

    // Mètode per convertir a JSON
    public Map<String, String> toJson() {
        Map<String, String> jsonMap = new HashMap<String, String>();
        jsonMap.put("name", this.name());
        jsonMap.put("text", this.getText());
        return jsonMap;
    }
}
