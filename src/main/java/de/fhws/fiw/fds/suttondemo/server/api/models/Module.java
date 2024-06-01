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

/**
 * Model class representing a Module offered by a Partner University.
 */
@JsonRootName("module")
@JsonInclude(JsonInclude.Include.NON_NULL)
@XmlRootElement(name = "module")
public class Module extends AbstractModel {

    @NotBlank(message = "Module name is mandatory")
    @Size(max = 100, message = "Module name must be less than 100 characters")
    private String moduleName;

    @Min(value = 1, message = "Semester must be 1 for spring or 2 for autumn")
    private int semester;

    @Min(value = 1, message = "Number of credit points must be > 0")
    private int creditPoints;

    @NotNull(message = "Partner University ID is mandatory")
    private long partnerUniversityId;

    @SuttonLink(
            value = "modules/${id}",
            rel = "self"
    )
    private transient Link selfLink;

    @SuttonLink(
            value = "partnerUniversities/${partnerUniversityId}",
            rel = "getPartnerUniversity"
    )
    private transient Link partnerUniversityLink;

    // Default constructor for JPA
    public Module() {
    }

    // Parameterized constructor
    public Module(final String moduleName, final int semester, final int creditPoints, final long partnerUniversityId) {
        this.moduleName = moduleName;
        this.semester = semester;
        this.creditPoints = creditPoints;
        this.partnerUniversityId = partnerUniversityId;
    }

    // Getters and Setters

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(final String moduleName) {
        this.moduleName = moduleName;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(final int semester) {
        this.semester = semester;
    }

    public int getCreditPoints() {
        return creditPoints;
    }

    public void setCreditPoints(final int creditPoints) {
        this.creditPoints = creditPoints;
    }

    public long getPartnerUniversityId() {
        return partnerUniversityId;
    }

    public void setPartnerUniversityId(final long partnerUniversityId) {
        this.partnerUniversityId = partnerUniversityId;
    }

    public Link getSelfLink() {
        return selfLink;
    }

    public void setSelfLink(final Link selfLink) {
        this.selfLink = selfLink;
    }

    public Link getPartnerUniversityLink() {
        return partnerUniversityLink;
    }

    public void setPartnerUniversityLink(final Link partnerUniversityLink) {
        this.partnerUniversityLink = partnerUniversityLink;
    }

    @Override
    public String toString() {
        return "Module{" +
                "id=" + id +
                ", moduleName='" + moduleName + '\'' +
                ", semester=" + semester +
                ", creditPoints=" + creditPoints +
                ", partnerUniversityId=" + partnerUniversityId +
                '}';
    }
}
