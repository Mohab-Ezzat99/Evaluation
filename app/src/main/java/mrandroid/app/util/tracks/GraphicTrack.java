package mrandroid.app.util.tracks;

public enum GraphicTrack {

    LABEL("GraphicTrack"),
    PHOTOSHOP("PHOTOSHOP"),
    INDESIGN("INDESIGN"),
    ILLUSTRATOR("ILLUSTRATOR");

    private String value;

    GraphicTrack(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
