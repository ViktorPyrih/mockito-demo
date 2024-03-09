package ua.edu.cdu.vu.service;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;
import ua.edu.cdu.vu.database.Database;
import ua.edu.cdu.vu.domain.User;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@MockitoSettings
class UserServiceTest {

    private static final long ID = 123;

    @Mock
    private Database database;

    @InjectMocks
    private UserService userService;

    @Test
    void create() {
        User user = createNewUser();
        given(database.save(user)).willReturn(ID);

        long id = userService.create(user);

        then(database).should().save(user);
        assertEquals(ID, id);
    }

    @Test
    void getById() {
        User user = createExistingUser();
        given(database.getById(ID)).willReturn(user);

        User userById = userService.getById(ID);

        then(database).should().getById(ID);
        assertSame(user, userById);
    }

    @Test
    void update() {
        User user = createExistingUser();
        willDoNothing().given(database).update(user);

        userService.update(user);

        then(database).should().update(user);
    }

    private static User createNewUser() {
        User user = new User();
        user.setName("Viktor");
        user.setSurname("Parker");
        user.setAge(21);
        return user;
    }

    private static User createExistingUser() {
        User user = new User();
        user.setId(ID);
        user.setName("Bob");
        user.setSurname("Jones");
        user.setAge(42);
        return user;
    }
}
