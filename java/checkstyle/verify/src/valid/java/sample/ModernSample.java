package sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

/**
 * Modern Java constructs formatted with the Oilmod1 code style, checkstyle must report no violations for this file.
 */
public class ModernSample {

    private String userID = "";

    /**
     * A point.
     *
     * @param x horizontal position
     * @param y vertical position
     */
    public record Point(int x, int y) {}

    /** A shape. */
    public sealed interface Shape permits Circle, Square {}

    /**
     * A circle.
     *
     * @param radius radius of the circle
     */
    public record Circle(double radius) implements Shape {}

    /**
     * A square.
     *
     * @param side length of a side
     */
    public record Square(double side) implements Shape {}

    public String getUserID() {
        return userID;
    }

    public double area(Shape shape) {
        return switch (shape) {
            case Circle circle -> Math.PI * circle.radius() * circle.radius();
            case Square square -> square.side() * square.side();
        };
    }

    public String query() {
        String sql =
                """
                SELECT id
                FROM users
                """;
        return sql;
    }

    public String firstLine(String text) throws IOException {
        try (BufferedReader reader = new BufferedReader(new StringReader(text))) {
            return reader.readLine();
        }
    }

    public Runnable trimTask() {
        return () -> {
            userID = userID.trim();
        };
    }
}
