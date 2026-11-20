package sample;

/**
 * Breaks the Oilmod1 deviations from Google style, see expected-violations.txt for the violations checkstyle must report.
 */
public class InvalidSample {

    // the next line is 161 characters long, one more than the maximum allowed line length
    private static final String TOO_LONG_LINE = "..............................................................................................................";

  // two-space indentation instead of four
  private int value;

    public String parseXMLDocument() {
        return TOO_LONG_LINE;
    }

    public String wrapped(String first, String second) {
        return first
            + second;
    }

    //comment without a leading space
    public int value() {
        return value;
    }

    // a suppression for previous lines must not also suppress the next line
    private int parseXMLValue;
    // CHECKSTYLE.SUPPRESS: AbbreviationAsWordInName for -1 lines
    private int parseHTMLValue;

    public String query() {
        String sql =
                """
                SELECT id
                """
                .stripIndent();
        return sql;
    }

    // a text block closed by """ on its own line must not disable the line length check, the next line is 161 characters long
    private static final String TOO_LONG_AFTER_TEXT_BLOCK = "..................................................................................................";

    ///markdown doc comment without a leading space
    private int markdownDoc;

    //*comment starting with a star
    private int starComment;
}
