package mrandroid.app.util.tracks;

public enum ProgramingTrack {

    LABEL("ProgramingTrack"),
    HTML("HTML"),
    PYTHON("PYTHON"),
    JAVA("JAVA");

    private String value;

    ProgramingTrack(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
