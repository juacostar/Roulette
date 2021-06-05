package repositories;

import model.User;

public interface UserRepository {
    void save(User user);
    void update(User user);
    User findById(int id);
}
