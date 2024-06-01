package de.fhws.fiw.fds.suttondemo.server.database;

import de.fhws.fiw.fds.sutton.server.database.DatabaseException;
import de.fhws.fiw.fds.sutton.server.database.SearchParameter;
import de.fhws.fiw.fds.sutton.server.database.results.CollectionModelResult;
import de.fhws.fiw.fds.suttondemo.server.api.models.Module;

public interface ModuleDao {

    CollectionModelResult<Module> readByPartnerUniversityId(long partnerUniversityId, SearchParameter searchParameter) throws DatabaseException;

    void createModule(Module module);

    Module updateModule(long id, Module updatedModule) throws DatabaseException;

    boolean deleteModule(long id);

    void resetDatabase();
}
