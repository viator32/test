package de.fhws.fiw.fds.suttondemo.server.database;

import de.fhws.fiw.fds.sutton.server.database.DatabaseException;
import de.fhws.fiw.fds.sutton.server.database.SearchParameter;
import de.fhws.fiw.fds.sutton.server.database.results.CollectionModelResult;
import de.fhws.fiw.fds.suttondemo.server.api.models.Module;

public interface PartnerUniversityModuleDao {

    CollectionModelResult<Module> readModulesByUniversityId(long universityId, SearchParameter searchParameter) throws DatabaseException;

    void createModule(long universityId, Module module) throws DatabaseException;

    Module updateModule(long universityId, long moduleId, Module updatedModule) throws DatabaseException;

    boolean deleteModule(long universityId, long moduleId) throws DatabaseException;
}
