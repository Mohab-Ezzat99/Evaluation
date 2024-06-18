package mrandroid.app.util.tracks;

public enum GraphicTrack {

    LABEL("GraphicTrack"),
    PHOTOSHOP("HTML"),
    INDESIGN("PYTHON"),
    ILLUSTRATOR("ILLUSTRATOR");

    private String value;

    GraphicTrack(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
