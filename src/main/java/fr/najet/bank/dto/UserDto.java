package fr.najet.bank.dto;

import fr.najet.bank.entities.User;

public class UserDto {
    protected int userId;
    protected String userName;
    protected String password;
    protected int role;

    public UserDto(){}

    public UserDto(String userName, String password, int role){
        this.userName = userName;
        this.password = password;
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public static User addUser(UserDto userDto) {
        User user = new User(userDto.getUserName(),userDto.getRole(), userDto.getPassword());
        return user;
    }
}
