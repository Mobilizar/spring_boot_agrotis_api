package com.mobilizar.agrotis.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="analysis")
public class Analysis implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column()
    private String owner;

    @Column(nullable = false, name = "start_date")
    private Date startDate;

    @Column(nullable = false, name = "end_date")
    private Date endDate;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(
            nullable = false ,
            name="property_id",
            foreignKey = @ForeignKey(
                    name = "fk_property_analysis"
            ),
            referencedColumnName = "id"
    )
    private Property property;

    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(
            nullable = false,
            name="laboratory_id",
            foreignKey = @ForeignKey(
                    name = "fk_laboratory_analysis"
            ),
            referencedColumnName = "id"
    )
    private Laboratory laboratory;

    @Column()
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
