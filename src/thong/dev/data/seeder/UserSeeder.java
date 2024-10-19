package thong.dev.data.seeder;

import com.github.javafaker.Faker;

import thong.dev.data.dao.UserDao;
import thong.dev.data.model.User;

public class UserSeeder {
	private Faker faker;
    private UserDao userDao;

    public UserSeeder(UserDao userDao) {
        this.faker = new Faker();
        this.userDao = userDao;
    }

    public void seedUsers(int count) {
        for (int i = 0; i < count; i++) {
            String email = faker.internet().emailAddress();
            String password = faker.internet().password(8, 16);
            String role = "user";

            User user = new User(email, password, role);
            userDao.insert(user);
        }
    }
}
