package pdf.generator;

public enum Font {
    Times_New_Roman("Times_New_Roman.ttf");

    private String fontName;

    Font(String fontName) {
        this.fontName = fontName;
    }

    public static Font getFontByName(String fontName) {
        switch (fontName) {
            case "Times New Roman":
                return Font.Times_New_Roman;
            default:
                return Font.Times_New_Roman;
        }
    }
}
