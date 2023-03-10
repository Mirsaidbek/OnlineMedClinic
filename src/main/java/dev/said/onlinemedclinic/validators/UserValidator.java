package dev.said.onlinemedclinic.validators;

import dev.said.onlinemedclinic.dao.UserDAO;
import dev.said.onlinemedclinic.domains.User;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UserValidator {
    private static final ThreadLocal<UserValidator> threadLocal = ThreadLocal.withInitial(UserValidator::new);
    public static UserValidator getInstance(){
        return threadLocal.get();
    }

    public static boolean isDuplicateUsername(String username) {
        List<User> users = UserDAO.getInstance().getAll();
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }


}
