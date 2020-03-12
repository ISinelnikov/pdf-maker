package pdf.generator;

import java.util.Arrays;

public enum Font {
    TIMES_NEW_ROMAN("Times_New_Roman.ttf");

    private final String fontName;

    Font(String fontName) {
        this.fontName = fontName;
    }

    public String getFontName() {
        return fontName;
    }

    public static Font getFontByName(String fontName) {
        return Arrays.stream(values())
                .filter(font -> font.getFontName().equals(fontName))
                .findFirst()
                .orElse(TIMES_NEW_ROMAN);
    }
}
