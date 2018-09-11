package pdf.generator;

import com.lowagie.text.DocumentException;
import org.apache.log4j.Logger;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.IOException;
import java.util.Arrays;

public class TextRenderer extends ITextRenderer {
    private static final Logger logger = Logger.getLogger(TextRenderer.class);

    public TextRenderer() {
        this.addCyrillicFonts();
    }

    private void addCyrillicFonts() {
        Arrays.asList(Font.values()).forEach(font -> {
            try {
                getFontResolver().addFont("font/" + font.getFontName(), "Identity-H", true);
            } catch (DocumentException | IOException e) {
                logger.error("Invoke addCyrillicFonts() exception: " + e.getMessage());
            }
        });
    }
}