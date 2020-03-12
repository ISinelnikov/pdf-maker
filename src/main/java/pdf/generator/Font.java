package pdf.generator;

import java.util.Arrays;

public enum Font {
    PT_ROOT_UI_REGULAR("PT_Root_UI_Regular.ttf");

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
                .orElse(PT_ROOT_UI_REGULAR);
    }
}
