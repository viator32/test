package de.fhws.fiw.fds.suttondemo.client.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import de.fhws.fiw.fds.sutton.client.converters.ClientLinkJsonConverter;
import de.fhws.fiw.fds.sutton.client.model.AbstractClientModel;
import de.fhws.fiw.fds.sutton.client.utils.Link;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ModuleClientModel extends AbstractClientModel {

    private String moduleName;
    private int semester;
    private int creditPoints;
    private long partnerUniversityId;

    @JsonDeserialize(using = ClientLinkJsonConverter.class)
    private Link selfLink;

    @JsonDeserialize(using = ClientLinkJsonConverter.class)
    private Link partnerUniversityLink;

    public ModuleClientModel() {
    }

    public ModuleClientModel(final String moduleName, final int semester, final int creditPoints, final long partnerUniversityId) {
        this.moduleName = moduleName;
        this.semester = semester;
        this.creditPoints = creditPoints;
        this.partnerUniversityId = partnerUniversityId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getCreditPoints() {
        return creditPoints;
    }

    public void setCreditPoints(int creditPoints) {
        this.creditPoints = creditPoints;
    }

    public long getPartnerUniversityId() {
        return partnerUniversityId;
    }

    public void setPartnerUniversityId(long partnerUniversityId) {
        this.partnerUniversityId = partnerUniversityId;
    }

    @JsonIgnore
    public Link getSelfLink() {
        return selfLink;
    }

    public void setSelfLink(Link selfLink) {
        this.selfLink = selfLink;
    }

    @JsonIgnore
    public Link getPartnerUniversityLink() {
        return partnerUniversityLink;
    }

    public void setPartnerUniversityLink(Link partnerUniversityLink) {
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
