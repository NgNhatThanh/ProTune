package protune.controller.log;

import protune.model.UserData;

public class SignUpCheck implements SignCheck{
    @Override
    public String isValid(UserData userData) {
        if(!userData.isValid()) return "Username can't contain space";
        if(!UserManager.find(userData)) return "Username's already existed";

        UserManager.add(userData);
        return "accept";
    }
}
