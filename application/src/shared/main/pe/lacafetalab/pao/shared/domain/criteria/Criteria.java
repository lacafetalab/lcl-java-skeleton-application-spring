package pe.lacafetalab.pao.shared.domain.criteria;

import java.util.Objects;
import java.util.Optional;

public final class Criteria {
    private final Filters           filters;
    private final Order             order;
    private final Optional<Integer> limit;
    private final Optional<Integer> offset;

    public Criteria(Filters filters, Order order, Optional<Integer> limit, Optional<Integer> offset) {
        this.filters = filters;
        this.order   = order;
        this.limit   = limit;
        this.offset  = offset;
    }

    public Criteria(Filters filters, Order order) {
        this.filters = filters;
        this.order   = order;
        this.limit   = Optional.empty();
        this.offset  = Optional.empty();
    }

    public Filters filters() {
        return filters;
    }

    public Order order() {
        return order;
    }

    public Optional<Integer> limit() {
        return limit;
    }

    public Optional<Integer> offset() {
        return offset;
    }

    public boolean hasFilters() {
        return filters.filters().size() > 0;
    }

    public String serialize() {
        return String.format(
            "%s~~%s~~%s~~%s",
            filters.serialize(),
            order.serialize(),
            offset.orElse(0),
            limit.orElse(0)
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Criteria)) return false;
        Criteria criteria = (Criteria) o;
        return Objects.equals(filters, criteria.filters) &&
                Objects.equals(order, criteria.order) &&
                Objects.equals(limit, criteria.limit) &&
                Objects.equals(offset, criteria.offset);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filters, order, limit, offset);
    }
}
