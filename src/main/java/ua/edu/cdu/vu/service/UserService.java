package ua.edu.cdu.vu.service;

import ua.edu.cdu.vu.database.Database;
import ua.edu.cdu.vu.domain.User;

public class UserService {

    private final Database database;

    public UserService(Database database) {
        this.database = database;
    }

    public long create(User user) {
        return database.save(user);
    }

    public User getById(long id) {
        return database.getById(id);
    }

    public void update(User user) {
        database.update(user);
    }
}
