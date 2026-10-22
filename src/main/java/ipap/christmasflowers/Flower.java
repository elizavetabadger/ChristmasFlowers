package ipap.christmasflowers;

public enum Flower {
    GERANIUM("G", "Герань"),
    CROCUS("C", "Крокус"),
    VIOLET("V", "Фиалка");

    private final String letterCode;
    private final String name;

    Flower(String letterCode, String name) {
        this.letterCode = letterCode;
        this.name = name;
    }

    public String getLetterCode() {
        return letterCode;
    }

    public String getName() {
        return name;
    }
}