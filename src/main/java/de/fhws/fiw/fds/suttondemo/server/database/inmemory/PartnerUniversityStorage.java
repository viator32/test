package de.fhws.fiw.fds.suttondemo.server.database.inmemory;

import de.fhws.fiw.fds.sutton.server.database.DatabaseException;
import de.fhws.fiw.fds.sutton.server.database.SearchParameter;
import de.fhws.fiw.fds.sutton.server.database.results.CollectionModelResult;
import de.fhws.fiw.fds.suttondemo.server.api.models.PartnerUniversity;
import de.fhws.fiw.fds.suttondemo.server.database.PartnerUniversityDao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class PartnerUniversityStorage implements PartnerUniversityDao {

    private final List<PartnerUniversity> universities = new ArrayList<>();

    @Override
    public Optional<PartnerUniversity> readById(long id) {
        return universities.stream().filter(u -> u.getId() == id).findFirst();
    }

    @Override
    public CollectionModelResult<PartnerUniversity> readByUniversityNameAndCountry(String universityName, String country, SearchParameter searchParameter) throws DatabaseException {
        List<PartnerUniversity> filteredUniversities = universities.stream()
                .filter(u -> (universityName == null || u.getUniversityName().equalsIgnoreCase(universityName)) &&
                        (country == null || u.getCountry().equalsIgnoreCase(country)))
                .collect(Collectors.toList());

        // Implement sorting if necessary based on searchParameter
        if (searchParameter.getOrderByAttribute().equalsIgnoreCase("universityName")) {
            filteredUniversities.sort((u1, u2) -> searchParameter.isAscending() ?
                    u1.getUniversityName().compareToIgnoreCase(u2.getUniversityName()) :
                    u2.getUniversityName().compareToIgnoreCase(u1.getUniversityName()));
        }

        // Handle pagination
        int offset = searchParameter.getOffset();
        int size = searchParameter.getSize();
        List<PartnerUniversity> paginatedUniversities = filteredUniversities.stream()
                .skip(offset)
                .limit(size)
                .collect(Collectors.toList());

        CollectionModelResult<PartnerUniversity> result = new CollectionModelResult<>(paginatedUniversities);
        result.setTotalCount(filteredUniversities.size());
        return result;
    }

    @Override
    public void createPartnerUniversity(PartnerUniversity partnerUniversity) {
        universities.add(partnerUniversity);
    }

    @Override
    public PartnerUniversity updatePartnerUniversity(long id, PartnerUniversity updatedPartnerUniversity) throws DatabaseException {
        PartnerUniversity existingUniversity = readById(id)
                .orElseThrow(() -> new DatabaseException("Partner University not found"));
        // Update fields of existing university
        existingUniversity.setUniversityName(updatedPartnerUniversity.getUniversityName());
        existingUniversity.setCountry(updatedPartnerUniversity.getCountry());
        existingUniversity.setDepartmentName(updatedPartnerUniversity.getDepartmentName());
        existingUniversity.setDepartmentUrl(updatedPartnerUniversity.getDepartmentUrl());
        existingUniversity.setContactPerson(updatedPartnerUniversity.getContactPerson());
        existingUniversity.setNumberOfOutgoingStudents(updatedPartnerUniversity.getNumberOfOutgoingStudents());
        existingUniversity.setNumberOfIncomingStudents(updatedPartnerUniversity.getNumberOfIncomingStudents());
        existingUniversity.setNextSpringSemesterStart(updatedPartnerUniversity.getNextSpringSemesterStart());
        existingUniversity.setNextAutumnSemesterStart(updatedPartnerUniversity.getNextAutumnSemesterStart());
        return existingUniversity;
    }

    @Override
    public boolean deletePartnerUniversity(long id) {
        return universities.removeIf(u -> u.getId() == id);
    }

    @Override
    public void resetDatabase() {
        universities.clear();
    }
}
