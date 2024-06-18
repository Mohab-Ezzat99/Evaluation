package mrandroid.app.util.tracks;

public enum EditTrack {

    LABEL("EditTrack"),
    ADOBE_PREMIERE_PRO("ADOBE_PREMIERE_PRO"),
    FINAL_CUT_PRO("FINAL_CUT_PRO"),
    DAVINCI_RESOLVE("DAVINCI_RESOLVE");

    private String value;

    EditTrack(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
