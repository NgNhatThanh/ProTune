package protune.controller.log;

import protune.controller.io.FileIOSystem;
import protune.model.UserData;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private static List<UserData> userDataList = new ArrayList<>();

    public static void importList() throws IOException, ClassNotFoundException {
        userDataList = FileIOSystem.read("src/main/data/userlist.bin");
    }

    public static void exportList(){
        FileIOSystem.write(userDataList, "src/main/data/userlist.bin");
    }

    public static void add(UserData userData){
        userDataList.add(userData);
    }

    public static boolean find(UserData userData){
        for(var user : userDataList){
            if(user.equals(userData)) return true;
        }
        return false;
    }



}
