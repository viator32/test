package de.fhws.fiw.fds.suttondemo.server.database;

import de.fhws.fiw.fds.suttondemo.server.database.inmemory.PartnerUniversityStorage;
import de.fhws.fiw.fds.suttondemo.server.database.inmemory.ModuleStorage;
import de.fhws.fiw.fds.suttondemo.server.database.inmemory.PartnerUniversityModulesStorage;

public class DaoFactory {

    private static DaoFactory INSTANCE;

    public static DaoFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new DaoFactory();
        }

        return INSTANCE;
    }

    private final PartnerUniversityDao partnerUniversityDao;
    private final ModuleDao moduleDao;
    private final PartnerUniversityModuleDao partnerUniversityModuleDao;

    private DaoFactory() {
        this.partnerUniversityDao = new PartnerUniversityStorage();
        this.moduleDao = new ModuleStorage();
        this.partnerUniversityModuleDao = new PartnerUniversityModulesStorage(partnerUniversityDao);
    }

    public PartnerUniversityDao getPartnerUniversityDao() {
        return this.partnerUniversityDao;
    }

    public ModuleDao getModuleDao() {
        return this.moduleDao;
    }

    public PartnerUniversityModuleDao getPartnerUniversityModuleDao() {
        return this.partnerUniversityModuleDao;
    }
}
