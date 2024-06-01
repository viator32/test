package de.fhws.fiw.fds.suttondemo.server.api.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRootName;
import de.fhws.fiw.fds.sutton.server.api.hyperlinks.Link;
import de.fhws.fiw.fds.sutton.server.api.hyperlinks.annotations.SuttonLink;
import de.fhws.fiw.fds.sutton.server.models.AbstractModel;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.time.LocalDate;
import java.util.List;

/**
 * Model class representing a Partner University.
 */
@JsonRootName("partnerUniversity")
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement(name = "partnerUniversity")
public class PartnerUniversity extends AbstractModel {

    @NotBlank(message = "University name is mandatory")
    @Size(max = 100, message = "University name must be less than 100 characters")
    private String universityName;

    @NotBlank(message = "Country is mandatory")
    @Size(max = 100, message = "Country name must be less than 100 characters")
    private String country;

    @NotBlank(message = "Department name is mandatory")
    @Size(max = 100, message = "Department name must be less than 100 characters")
    private String departmentName;

    @NotBlank(message = "Department URL is mandatory")
    @Size(max = 200, message = "Department URL must be less than 200 characters")
    private String departmentUrl;

    @NotBlank(message = "Contact person name is mandatory")
    @Size(max = 100, message = "Contact person name must be less than 100 characters")
    private String contactPerson;

    @Min(value = 0, message = "Number of outgoing students must be ≥ 0")
    private int numberOfOutgoingStudents;

    @Min(value = 0, message = "Number of incoming students must be ≥ 0")
    private int numberOfIncomingStudents;

    @NotNull(message = "First day of the next spring semester is mandatory")
    private LocalDate nextSpringSemesterStart;

    @NotNull(message = "First day of the next autumn semester is mandatory")
    private LocalDate nextAutumnSemesterStart;

    @SuttonLink(
            value = "partnerUniversities/${id}",
            rel = "self"
    )
    private transient Link selfLink;

    @SuttonLink(
            value = "partnerUniversities/${id}/modules",
            rel = "getModulesOfUniversity"
    )
    private transient Link modulesLink;

    // Default constructor for JPA
    public PartnerUniversity() {
    }

    // Parameterized constructor
    public PartnerUniversity(final String universityName, final String country, final String departmentName,
                             final String departmentUrl, final String contactPerson, final int numberOfOutgoingStudents,
                             final int numberOfIncomingStudents, final LocalDate nextSpringSemesterStart,
                             final LocalDate nextAutumnSemesterStart) {
        this.universityName = universityName;
        this.country = country;
        this.departmentName = departmentName;
        this.departmentUrl = departmentUrl;
        this.contactPerson = contactPerson;
        this.numberOfOutgoingStudents = numberOfOutgoingStudents;
        this.numberOfIncomingStudents = numberOfIncomingStudents;
        this.nextSpringSemesterStart = nextSpringSemesterStart;
        this.nextAutumnSemesterStart = nextAutumnSemesterStart;
    }

    // Getters and Setters

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(final String universityName) {
        this.universityName = universityName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(final String country) {
        this.country = country;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(final String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentUrl() {
        return departmentUrl;
    }

    public void setDepartmentUrl(final String departmentUrl) {
        this.departmentUrl = departmentUrl;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(final String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public int getNumberOfOutgoingStudents() {
        return numberOfOutgoingStudents;
    }

    public void setNumberOfOutgoingStudents(final int numberOfOutgoingStudents) {
        this.numberOfOutgoingStudents = numberOfOutgoingStudents;
    }

    public int getNumberOfIncomingStudents() {
        return numberOfIncomingStudents;
    }

    public void setNumberOfIncomingStudents(final int numberOfIncomingStudents) {
        this.numberOfIncomingStudents = numberOfIncomingStudents;
    }

    public LocalDate getNextSpringSemesterStart() {
        return nextSpringSemesterStart;
    }

    public void setNextSpringSemesterStart(final LocalDate nextSpringSemesterStart) {
        this.nextSpringSemesterStart = nextSpringSemesterStart;
    }

    public LocalDate getNextAutumnSemesterStart() {
        return nextAutumnSemesterStart;
    }

    public void setNextAutumnSemesterStart(final LocalDate nextAutumnSemesterStart) {
        this.nextAutumnSemesterStart = nextAutumnSemesterStart;
    }

    public Link getSelfLink() {
        return selfLink;
    }

    public void setSelfLink(final Link selfLink) {
        this.selfLink = selfLink;
    }

    public Link getModulesLink() {
        return modulesLink;
    }

    public void setModulesLink(final Link modulesLink) {
        this.modulesLink = modulesLink;
    }

    @Override
    public String toString() {
        return "PartnerUniversity{" +
                "id=" + id +
                ", universityName='" + universityName + '\'' +
                ", country='" + country + '\'' +
                ", departmentName='" + departmentName + '\'' +
                ", departmentUrl='" + departmentUrl + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", numberOfOutgoingStudents=" + numberOfOutgoingStudents +
                ", numberOfIncomingStudents=" + numberOfIncomingStudents +
                ", nextSpringSemesterStart=" + nextSpringSemesterStart +
                ", nextAutumnSemesterStart=" + nextAutumnSemesterStart +
                '}';
    }
}
