package pdf.generator;

import com.lowagie.text.DocumentException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xhtmlrenderer.pdf.ITextRenderer;

import java.io.IOException;
import java.util.Arrays;

public class TextRenderer extends ITextRenderer {
    private static final Logger logger = LoggerFactory.getLogger(TextRenderer.class);

    public TextRenderer() {
        this.addCyrillicFonts();
    }

    private void addCyrillicFonts() {
        Arrays.asList(Font.values()).forEach(font -> {
            try {
                getFontResolver().addFont("font/" + font.getFontName(), "Identity-H", true);
            } catch (DocumentException | IOException ex) {
                logger.error("Invoke addCyrillicFonts() with exception.", ex);
            }
        });
    }
}