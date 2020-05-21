package pe.lacafetalab.pao.communication.announcement.application.reader.search_reader;


import pe.lacafetalab.pao.shared.domain.bus.query.Response;

import java.util.List;


public final class ReadersResponse implements Response {
    private final List<ReaderResponse> readerResponses;

    public ReadersResponse(List<ReaderResponse> readers) {
        this.readerResponses = readers;
    }

    public List<ReaderResponse> readerResponses() {
        return readerResponses;
    }
}
