package com.rsi.esk.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "esk.employee_skill_xref")
public class EmployeeSkill {
    @Id
    @Column(name = "employee_skill_id", unique = true, nullable = false)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "skill_type_id", nullable = false)
    private SkillType skillType;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;
    @NotNull
    @Column(name = "skill_level")
    private Integer skillLevel;

    public EmployeeSkill() {
    }

    public EmployeeSkill(Integer skillLevel) {
        this.skillLevel = skillLevel;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    //This will need to accept SkillTypeId class as input
    public void setSkillTypeId(SkillType skillType) {
        this.skillType = skillType;
    }
    
    public void setEmployeeId(Employee employee) {
        this.employee = employee;
    }
    
    public Integer getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(Integer skillLevel) {
        this.skillLevel = skillLevel;
    }
}