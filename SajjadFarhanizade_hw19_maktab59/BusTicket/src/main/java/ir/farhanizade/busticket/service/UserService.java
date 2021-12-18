package ir.farhanizade.busticket.service;

import ir.farhanizade.busticket.core.BaseService;
import ir.farhanizade.busticket.dao.UserDao;
import ir.farhanizade.busticket.entity.User;

public class UserService extends BaseService<User> {
    public UserService() {
        baseDao = new UserDao(entityManager);
    }
}
