package de.fhws.fiw.fds.suttondemo.server.database.inmemory;

import de.fhws.fiw.fds.sutton.server.database.DatabaseException;
import de.fhws.fiw.fds.sutton.server.database.SearchParameter;
import de.fhws.fiw.fds.sutton.server.database.results.CollectionModelResult;
import de.fhws.fiw.fds.suttondemo.server.api.models.Module;
import de.fhws.fiw.fds.suttondemo.server.api.models.PartnerUniversity;
import de.fhws.fiw.fds.suttondemo.server.database.PartnerUniversityModuleDao;
import de.fhws.fiw.fds.suttondemo.server.database.PartnerUniversityDao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PartnerUniversityModulesStorage implements PartnerUniversityModuleDao {

    private final PartnerUniversityDao partnerUniversityDao;
    private final List<Module> modules = new ArrayList<>();

    public PartnerUniversityModulesStorage(PartnerUniversityDao partnerUniversityDao) {
        this.partnerUniversityDao = partnerUniversityDao;
    }

    @Override
    public CollectionModelResult<Module> readModulesByUniversityId(long universityId, SearchParameter searchParameter) throws DatabaseException {
        // Ensure the university exists
        getUniversityById(universityId);

        List<Module> filteredModules = modules.stream()
                .filter(m -> m.getPartnerUniversityId() == universityId)
                .collect(Collectors.toList());

        // Implement filtering
        if (searchParameter.getModuleName() != null) {
            filteredModules = filteredModules.stream()
                    .filter(m -> m.getModuleName().equalsIgnoreCase(searchParameter.getModuleName()))
                    .collect(Collectors.toList());
        }

        if (searchParameter.getSemester() != null) {
            filteredModules = filteredModules.stream()
                    .filter(m -> m.getSemester() == searchParameter.getSemester())
                    .collect(Collectors.toList());
        }

        // Implement sorting if necessary based on searchParameter
        if (searchParameter.getOrderByAttribute().equalsIgnoreCase("moduleName")) {
            filteredModules.sort((m1, m2) -> searchParameter.isAscending() ?
                    m1.getModuleName().compareToIgnoreCase(m2.getModuleName()) :
                    m2.getModuleName().compareToIgnoreCase(m1.getModuleName()));
        }

        // Handle pagination
        int offset = searchParameter.getOffset();
        int size = searchParameter.getSize();
        List<Module> paginatedModules = filteredModules.stream()
                .skip(offset)
                .limit(size)
                .collect(Collectors.toList());

        CollectionModelResult<Module> result = new CollectionModelResult<>(paginatedModules);
        result.setTotalCount(filteredModules.size());
        return result;
    }

    @Override
    public void createModule(long universityId, Module module) throws DatabaseException {
        // Ensure the university exists
        getUniversityById(universityId);
        module.setPartnerUniversityId(universityId);
        modules.add(module);
    }

    @Override
    public Module updateModule(long universityId, long moduleId, Module updatedModule) throws DatabaseException {
        // Ensure the university exists
        getUniversityById(universityId);
        Module existingModule = getModuleById(moduleId);

        existingModule.setModuleName(updatedModule.getModuleName());
        existingModule.setSemester(updatedModule.getSemester());
        existingModule.setCreditPoints(updatedModule.getCreditPoints());
        existingModule.setPartnerUniversityId(universityId);
        return existingModule;
    }

    @Override
    public boolean deleteModule(long universityId, long moduleId) throws DatabaseException {
        // Ensure the university exists
        getUniversityById(universityId);
        return modules.removeIf(m -> m.getId() == moduleId);
    }

    private PartnerUniversity getUniversityById(long universityId) throws DatabaseException {
        return partnerUniversityDao.readById(universityId)
                .orElseThrow(() -> new DatabaseException("Partner University not found"));
    }

    private Module getModuleById(long moduleId) throws DatabaseException {
        return modules.stream()
                .filter(m -> m.getId() == moduleId)
                .findFirst()
                .orElseThrow(() -> new DatabaseException("Module not found"));
    }
}
