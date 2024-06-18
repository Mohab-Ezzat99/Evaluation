package mrandroid.app.util.tracks;

public enum AnimationTrack {

    LABEL("AnimationTrack"),
    ADOBE_ANIMATE("ADOBE_ANIMATE"),
    BLENDER("BLENDER"),
    TOON_BOOM_HARMONY("TOON_BOOM_HARMONY");

    private String value;

    AnimationTrack(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
