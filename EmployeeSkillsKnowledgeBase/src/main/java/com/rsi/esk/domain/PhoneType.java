package com.rsi.esk.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.dom4j.tree.AbstractEntity;


@Entity
@Table(schema = "esk", name = "phone_type")
public class PhoneType extends AbstractEntity{

	private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "phone_type_id")
    private Long id;
    @Column(name = "phone_type_desc")
    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // This must return true for another PhoneType object with same id.
    public boolean equals(Object other) {
        return (other instanceof PhoneType && (id != null))
        ? id.equals(((PhoneType) other).getId()) : (other == this);
    }

    // This must return the same hashCode for every PhoneType object with the
    // same key.
    public int hashCode() {
        return (id != null) ? (this.getClass().hashCode() + id.hashCode())
                            : super.hashCode();
    }

    // Override Object#toString() so that it returns a human readable String
    // representation.
    // It is not required by the Converter or so, it just pleases the reading in
    // the logs.
    public String toString() {
        return "Foo[" + id + "," + description + "]";
    }
}
