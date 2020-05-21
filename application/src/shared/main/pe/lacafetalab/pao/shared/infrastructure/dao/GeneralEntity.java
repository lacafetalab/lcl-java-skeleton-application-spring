package pe.lacafetalab.pao.shared.infrastructure.dao;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;

import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;

import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter
@Setter
@TypeDefs({ @TypeDef(name = "json", typeClass = JsonStringType.class),
		@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class) })
public abstract class GeneralEntity<T> implements BaseDao<T> {
	private static final long serialVersionUID = 1L;

	@Column(insertable = true, updatable = false)
	private Date created;

	@Column(insertable = true, updatable = true)
	private Date updated;

	@PrePersist
	public void prePersist() {
		Date now = GregorianCalendar.getInstance().getTime();
		this.created = now;
		this.updated = now;
	}

	@PreUpdate
	public void preUpdate() {
		this.updated = GregorianCalendar.getInstance().getTime();
	}
}
