package pe.lacafetalab.pao.communication.user.application.search_criteria;

import pe.lacafetalab.pao.shared.domain.bus.query.Query;

public final class SearchCriteriaUserQuery implements Query {
    private final String id;
    private final String name;
    private final String lastname;
    private final String description;
    private final String birthdate;

    public SearchCriteriaUserQuery(String id, String name, String lastname, String description, String birthdate) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.description = description;
        this.birthdate = birthdate;
    }

    public String id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String lastname() {
        return lastname;
    }

    public String description() {
        return description;
    }

    public String birthdate() {
        return birthdate;
    }
}
