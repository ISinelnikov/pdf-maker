package pdf.generator;

import java.util.Arrays;

public enum Font {
    Times_New_Roman("Times_New_Roman.ttf");

    private String fontName;

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
                .orElse(Times_New_Roman);
    }
}
