package com.mobilizar.agrotis.dtos;

import com.mobilizar.agrotis.entity.Laboratory;
import com.mobilizar.agrotis.entity.Property;

import javax.validation.constraints.NotBlank;
import java.util.Date;

public class AnalysisDTO {

    private Long id;

    @NotBlank
    private String owner;

    private Date startDate;

    private Date endDate;

    private Property property;

    private Laboratory laboratory;

    private String description;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public Laboratory getLaboratory() {
        return laboratory;
    }

    public void setLaboratory(Laboratory laboratory) {
        this.laboratory = laboratory;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
