package de.fhws.fiw.fds.suttondemo.server.database;

import de.fhws.fiw.fds.sutton.server.database.DatabaseException;
import de.fhws.fiw.fds.sutton.server.database.SearchParameter;
import de.fhws.fiw.fds.sutton.server.database.results.CollectionModelResult;
import de.fhws.fiw.fds.suttondemo.server.api.models.PartnerUniversity;

import java.util.Optional;

public interface PartnerUniversityDao {
    Optional<PartnerUniversity> readById(long id) throws DatabaseException;

    CollectionModelResult<PartnerUniversity> readByUniversityNameAndCountry(String universityName, String country, SearchParameter searchParameter) throws DatabaseException;

    void createPartnerUniversity(PartnerUniversity partnerUniversity);

    PartnerUniversity updatePartnerUniversity(long id, PartnerUniversity updatedPartnerUniversity) throws DatabaseException;

    boolean deletePartnerUniversity(long id);

    void resetDatabase();
}
