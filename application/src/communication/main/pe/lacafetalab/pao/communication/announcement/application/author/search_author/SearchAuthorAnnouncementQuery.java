package pe.lacafetalab.pao.communication.announcement.application.author.search_author;

import pe.lacafetalab.pao.shared.domain.bus.query.Query;

import java.util.Objects;

public final class SearchAuthorAnnouncementQuery implements Query {
    private final String authorId;
    private final Integer page;

    public SearchAuthorAnnouncementQuery(String authorId, Integer page) {
        this.authorId = authorId;
        this.page = page;
    }

    public String authorId() {
        return authorId;
    }

    public Integer page() {
        return page;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SearchAuthorAnnouncementQuery)) return false;
        SearchAuthorAnnouncementQuery that = (SearchAuthorAnnouncementQuery) o;
        return Objects.equals(authorId, that.authorId) &&
                Objects.equals(page, that.page);
    }

    @Override
    public int hashCode() {
        return Objects.hash(authorId, page);
    }
}
