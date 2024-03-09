package ua.edu.cdu.vu.database;

import ua.edu.cdu.vu.domain.User;

public interface Database {

    long save(User user);

    User getById(long id);

    void update(User user);
}
