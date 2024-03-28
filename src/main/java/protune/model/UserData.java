package protune.model;

import java.io.File;
import java.io.IOException;

public class UserData {
    private String firstName, lastName, username, password;

    private File listSongPath;

    public UserData(){
        listSongPath = new File("src/main/data/usersong" + username + ".bin");
        try {
            listSongPath.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public UserData(String firstName, String lastName, String username, String password){
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    public UserData(String username, String password){
        this.username = username;
        this.password = password;
    }

    public boolean equals(UserData other){
        return this.username.equals(other.username);
    }

    public boolean isValid(){
        return !username.contains(" ");
    }
}
