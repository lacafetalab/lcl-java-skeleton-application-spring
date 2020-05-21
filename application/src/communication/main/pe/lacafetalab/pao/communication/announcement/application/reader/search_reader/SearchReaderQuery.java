package pe.lacafetalab.pao.communication.announcement.application.reader.search_reader;

import pe.lacafetalab.pao.shared.domain.bus.query.Query;

import java.util.Objects;

public final class SearchReaderQuery implements Query {
    private final String readerId;
    private final Integer page;

    public SearchReaderQuery(String readerId, Integer page) {
        this.readerId = readerId;
        this.page = page;
    }

    public String readerId() {
        return readerId;
    }

    public Integer page() {
        return page;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SearchReaderQuery)) return false;
        SearchReaderQuery that = (SearchReaderQuery) o;
        return Objects.equals(readerId, that.readerId) &&
                Objects.equals(page, that.page);
    }

    @Override
    public int hashCode() {
        return Objects.hash(readerId, page);
    }
}
