package pe.lacafetalab.pao.communication.user.application.find_by_id;

import pe.lacafetalab.pao.shared.domain.bus.query.Query;

public final class UserFindByIdQuery implements Query {
    private final String id;

    public UserFindByIdQuery(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
}
