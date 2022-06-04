package services;

import entity.User;
import interfaces.Authenticator;

public class NewAccountService {
    private Authenticator authenticator;

    public NewAccountService(Authenticator authenticator) {
        this.authenticator = authenticator;
    }

    public Boolean authenticateUser(User user) {
        return this.authenticator.addNewUser(user);
    }

}
