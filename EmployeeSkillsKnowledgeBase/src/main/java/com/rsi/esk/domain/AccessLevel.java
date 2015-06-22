package com.rsi.esk.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.dom4j.tree.AbstractEntity;

@Entity
@Table(schema = "esk", name = "access_level")
public class AccessLevel extends AbstractEntity{

	private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "access_level_id")
    private Long id;
    @Column(name = "access_level_desc")
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

}
