package de.fhws.fiw.fds.suttondemo.server.api.states.partnerUniversityModules;

import de.fhws.fiw.fds.suttondemo.Start;

public interface PartnerUniversityModulesUri {
    String PATH_ELEMENT = "partnerUniversities/{universityId}/modules";
    String REL_PATH = Start.CONTEXT_PATH + "/api/" + PATH_ELEMENT;
    String REL_PATH_ID = REL_PATH + "/{moduleId}";
}
