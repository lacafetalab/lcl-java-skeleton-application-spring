package pe.lacafetalab.pao.sharedtest.domain;

public final class BooleanMother {
    public static Boolean random() {
        return MotherCreator.random().bool().bool();
    }
}
