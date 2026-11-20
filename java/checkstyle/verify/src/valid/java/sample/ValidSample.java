package sample;

import static java.util.Objects.requireNonNull;

import java.util.List;
import java.util.Map;

/**
 * Follows the Oilmod1 code style, checkstyle must report no violations for this file.
 */
public class ValidSample {

    private final Map<String, Integer> valuesById;

    /**
     * Creates a sample.
     *
     * @param valuesById values keyed by id
     */
    public ValidSample(Map<String, Integer> valuesById) {
        this.valuesById = requireNonNull(valuesById);
    }

    // public methods without javadoc are allowed
    public int getID(String id) {
        return valuesById.getOrDefault(id, 0);
    }

    public String describe(List<String> ids, boolean verbose) {
        StringBuilder builder = new StringBuilder();
        for (String id : ids) {
            switch (id) {
                case "first":
                    builder.append("1st");
                    break;
                default:
                    builder.append(id);
                    break;
            }
        }
        return builder.toString()
                + (verbose ? " (verbose)" : "");
    }

    // the next line is exactly 160 characters long, the maximum allowed line length
    private static final String LONGEST_ALLOWED_LINE = "......................................................................................................";

    @SuppressWarnings("checkstyle:AbbreviationAsWordInName")
    public String parseXMLDocument() {
        return LONGEST_ALLOWED_LINE;
    }

    // CHECKSTYLE.SUPPRESS: AbbreviationAsWordInName
    public String loadHTMLPage() {
        return LONGEST_ALLOWED_LINE;
    }

    // CHECKSTYLE.OFF: AbbreviationAsWordInName
    public String readJSONFile() {
        return LONGEST_ALLOWED_LINE;
    }
    // CHECKSTYLE.ON: AbbreviationAsWordInName

    // CHECKSTYLE.SUPPRESS: AbbreviationAsWordInName for +1 lines
    public String writeCSVFile() {
        return LONGEST_ALLOWED_LINE;
    }

    // forms the ranged filter does not support (here: more than one check) fall back to suppressing the next line
    // CHECKSTYLE.SUPPRESS: AbbreviationAsWordInName|MethodName for +1 lines
    public String writeXMLFile() {
        ///markdown doc comments and //* comments are allowed without a space
        //*
        return LONGEST_ALLOWED_LINE;
    }

    // a suppression directive in a trailing comment works after string literals containing //
    private final String url = "https://example.com"; // CHECKSTYLE.SUPPRESS: LineLength for +1 lines
    private static final String LONG_URL = "............................................................................................................................";
}
