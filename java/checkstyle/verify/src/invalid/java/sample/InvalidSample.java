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

    /*block comment without a leading space*/
    private int blockComment;

    // a suppression directive in a string literal must not suppress violations, the next line is 161 characters long
    private static final String DIRECTIVE = "// CHECKSTYLE.SUPPRESS: LineLength for +1 lines";
    private static final String TOO_LONG_AFTER_LITERAL = ".....................................................................................................";

    // however many spaces follow //, a suppression for previous lines must not also suppress the next line
    private int prevSpacedXMLValue;
    //                         CHECKSTYLE.SUPPRESS: AbbreviationAsWordInName for -1 lines
    private int afterSpacedXMLValue;
}
