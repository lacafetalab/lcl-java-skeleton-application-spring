package pe.lacafetalab.pao.communication.user.application;

import pe.lacafetalab.pao.shared.domain.bus.query.Response;

import java.util.List;

public final class ListUserResponse implements Response {
    private final List<UserResponse> listUserResponse;

    public ListUserResponse(List<UserResponse> listUserResponse) {
        this.listUserResponse = listUserResponse;
    }

    public List<UserResponse> listUserResponse() {
        return listUserResponse;
    }
}
