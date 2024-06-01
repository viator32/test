package de.fhws.fiw.fds.suttondemo.server.api.queries;

import de.fhws.fiw.fds.sutton.server.api.queries.AbstractQuery;
import de.fhws.fiw.fds.sutton.server.api.queries.PagingBehaviorUsingOffsetSize;
import de.fhws.fiw.fds.sutton.server.database.DatabaseException;
import de.fhws.fiw.fds.sutton.server.database.SearchParameter;
import de.fhws.fiw.fds.sutton.server.database.results.CollectionModelResult;
import de.fhws.fiw.fds.suttondemo.server.api.models.PartnerUniversity;
import de.fhws.fiw.fds.suttondemo.server.database.DaoFactory;

/**
 * Query class to search for partner universities by name and country,
 * including ordering capabilities.
 */
public class QueryByUniversityNameAndCountry<R> extends AbstractQuery<R, PartnerUniversity> {

    private String universityName;
    private String country;

    public QueryByUniversityNameAndCountry(String universityName, String country, int offset, int size) {
        this.universityName = universityName;
        this.country = country;
        this.pagingBehavior = new PagingBehaviorUsingOffsetSize<>(offset, size);
    }

    public String getUniversityName() {
        return this.universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    protected CollectionModelResult<PartnerUniversity> doExecuteQuery(SearchParameter searchParameter) throws DatabaseException {
        return DaoFactory.getInstance().getPartnerUniversityDao().readByUniversityNameAndCountry(
                this.universityName,
                this.country,
                searchParameter);
    }
}
