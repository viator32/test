package de.fhws.fiw.fds.suttondemo.server.database.inmemory;

import de.fhws.fiw.fds.sutton.server.database.DatabaseException;
import de.fhws.fiw.fds.sutton.server.database.SearchParameter;
import de.fhws.fiw.fds.sutton.server.database.results.CollectionModelResult;
import de.fhws.fiw.fds.suttondemo.server.api.models.Module;
import de.fhws.fiw.fds.suttondemo.server.database.ModuleDao;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ModuleStorage implements ModuleDao {

    private final List<Module> modules = new ArrayList<>();

    @Override
    public CollectionModelResult<Module> readByPartnerUniversityId(long partnerUniversityId, SearchParameter searchParameter) throws DatabaseException {
        List<Module> filteredModules = modules.stream()
                .filter(m -> m.getPartnerUniversityId() == partnerUniversityId)
                .collect(Collectors.toList());

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
    public void createModule(Module module) {
        modules.add(module);
    }

    @Override
    public Module updateModule(long id, Module updatedModule) throws DatabaseException {
        Module existingModule = modules.stream()
                .filter(m -> m.getId() == id)
                .findFirst()
                .orElseThrow(() -> new DatabaseException("Module not found"));
        // Update fields of existing module
        existingModule.setModuleName(updatedModule.getModuleName());
        existingModule.setSemester(updatedModule.getSemester());
        existingModule.setCreditPoints(updatedModule.getCreditPoints());
        existingModule.setPartnerUniversityId(updatedModule.getPartnerUniversityId());
        return existingModule;
    }

    @Override
    public boolean deleteModule(long id) {
        return modules.removeIf(m -> m.getId() == id);
    }

    @Override
    public void resetDatabase() {
        modules.clear();
    }
}
