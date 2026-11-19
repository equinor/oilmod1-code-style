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
}
