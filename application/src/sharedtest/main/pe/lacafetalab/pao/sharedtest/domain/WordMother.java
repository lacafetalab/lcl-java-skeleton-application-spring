package pe.lacafetalab.pao.sharedtest.domain;

public final class WordMother {
    public static String random() {
        return MotherCreator.random().lorem().word();
    }
}
