package protune.controller.log;

import protune.model.UserData;

public class SignInCheck implements SignCheck{
    @Override
    public String isValid(UserData userData) {



        return "accept";
    }
}
