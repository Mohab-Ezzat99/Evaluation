package mrandroid.app.util.talent;

public enum TalentNames {

    PROGRAMING("PROGRAMING"),
    PHOTOSHOP("PHOTOSHOP"),
    ANIMATION("ANIMATION"),
    EDIT("EDIT");

    private String name;

    TalentNames(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
