package mrandroid.app.util.talent;

public enum TalentLevel {

    LOW("LOW"),
    NORMAL("NORMAL"),
    HIGH("HIGH");

    private String level;

    TalentLevel(String name) {
        this.level = name;
    }

    public String getName() {
        return level;
    }
}
