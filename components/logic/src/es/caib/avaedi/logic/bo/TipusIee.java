package es.caib.avaedi.logic.bo;

public enum TipusIee {
    T30 ("30"),
    T40 ("Renov. 30"),
    T50 ("50"),
    T50R ("Renov. 50");

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
}
