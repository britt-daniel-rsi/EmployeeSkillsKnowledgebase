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
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "skill_type_id")
    private Integer skillTypeId;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Integer employeeId;
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

    public Integer getSkillTypeId() {
        return skillTypeId;
    }
    //This will need to accept SkillTypeId class as input
    public void setSkillTypeId(Integer skillTypeId) {
        this.skillTypeId = skillTypeId;
    }
    
    public Integer getEmployeeId() {
        return employeeId;
    }
    
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
    
    public Integer getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(Integer skillLevel) {
        this.skillLevel = skillLevel;
    }
}
