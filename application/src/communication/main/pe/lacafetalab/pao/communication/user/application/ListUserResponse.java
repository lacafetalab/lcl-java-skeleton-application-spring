package pe.lacafetalab.pao.communication.user.application;

import pe.lacafetalab.pao.shared.domain.bus.query.Response;

import java.util.List;

public final class ListUserResponse implements Response {
    private final List<UserResponse> userResponses;

    public ListUserResponse(List<UserResponse> userResponses) {
        this.userResponses = userResponses;
    }

    public List<UserResponse> userResponses() {
        return userResponses;
    }
}
