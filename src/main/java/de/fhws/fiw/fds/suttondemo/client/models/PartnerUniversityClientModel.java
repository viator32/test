package de.fhws.fiw.fds.suttondemo.client.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.fhws.fiw.fds.sutton.client.converters.ClientLinkJsonConverter;
import de.fhws.fiw.fds.sutton.client.model.AbstractClientModel;
import de.fhws.fiw.fds.sutton.client.utils.Link;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.time.LocalDate;

@XmlRootElement
public class PartnerUniversityClientModel extends AbstractClientModel {

    private String universityName;
    private String country;
    private String departmentName;
    private String departmentUrl;
    private String contactPerson;
    private int numberOfOutgoingStudents;
    private int numberOfIncomingStudents;
    private LocalDate nextSpringSemesterStart = LocalDate.of(1970, 1, 1);
    private LocalDate nextAutumnSemesterStart = LocalDate.of(1970, 1, 1);

    @JsonDeserialize(using = ClientLinkJsonConverter.class)
    private Link selfLink;

    @JsonDeserialize(using = ClientLinkJsonConverter.class)
    private Link modulesLink;

    public PartnerUniversityClientModel() {
    }

    public PartnerUniversityClientModel(final String universityName, final String country, final String departmentName,
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

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentUrl() {
        return departmentUrl;
    }

    public void setDepartmentUrl(String departmentUrl) {
        this.departmentUrl = departmentUrl;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public int getNumberOfOutgoingStudents() {
        return numberOfOutgoingStudents;
    }

    public void setNumberOfOutgoingStudents(int numberOfOutgoingStudents) {
        this.numberOfOutgoingStudents = numberOfOutgoingStudents;
    }

    public int getNumberOfIncomingStudents() {
        return numberOfIncomingStudents;
    }

    public void setNumberOfIncomingStudents(int numberOfIncomingStudents) {
        this.numberOfIncomingStudents = numberOfIncomingStudents;
    }

    public LocalDate getNextSpringSemesterStart() {
        return nextSpringSemesterStart;
    }

    public void setNextSpringSemesterStart(LocalDate nextSpringSemesterStart) {
        this.nextSpringSemesterStart = nextSpringSemesterStart;
    }

    public LocalDate getNextAutumnSemesterStart() {
        return nextAutumnSemesterStart;
    }

    public void setNextAutumnSemesterStart(LocalDate nextAutumnSemesterStart) {
        this.nextAutumnSemesterStart = nextAutumnSemesterStart;
    }

    @JsonIgnore
    public Link getSelfLink() {
        return selfLink;
    }

    public void setSelfLink(Link selfLink) {
        this.selfLink = selfLink;
    }

    @JsonIgnore
    public Link getModulesLink() {
        return modulesLink;
    }

    public void setModulesLink(Link modulesLink) {
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
