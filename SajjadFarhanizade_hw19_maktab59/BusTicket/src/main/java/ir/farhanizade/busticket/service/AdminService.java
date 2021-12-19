package ir.farhanizade.busticket.service;

import ir.farhanizade.busticket.core.BaseService;
import ir.farhanizade.busticket.dao.AdminDao;
import ir.farhanizade.busticket.entity.Admin;

public class AdminService extends BaseService<Admin> {
    public AdminService() {
        baseDao = new AdminDao(entityManager);
    }
}
