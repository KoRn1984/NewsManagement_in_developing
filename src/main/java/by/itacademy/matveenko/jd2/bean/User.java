package by.itacademy.matveenko.jd2.bean;

import com.google.common.base.Objects;
import by.itacademy.matveenko.jd2.bean.User;


public class User {
	private Integer id;
	private String login;
    private String password;
	private String userName;
    private String userSurname;
    private String email;    
    private UserRole role;

    public User() {
    }
     
    public static class Builder {
        private User newUser;

        public Builder() {
            this.newUser = new User();
        }
        
        public Builder withId(Integer id){
            newUser.setId(id);
            return this;
        }

        public Builder withLogin(String login){
            newUser.setLogin(login);
            return this;
        }
        public Builder withPassword(String password){
            newUser.setPassword(password);
            return this;
        }
        public Builder withName(String name){
            newUser.setUserName(name);
            return this;
        }
        public Builder withSurname(String surname){
            newUser.setUserSurname(surname);
            return this;
        }

        public Builder withEmail(String email){
            newUser.setEmail(email);
            return this;
        }

        public Builder withRole(UserRole role){
            newUser.setRole(role);
            return this;
        }

        public User build(){
            return newUser;
        }
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return this.id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSurname() {
        return userSurname;
    }

    public void setUserSurname(String userSurname) {
        this.userSurname = userSurname;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        User that = (User) obj;
        return Objects.equal(id, that.id) && Objects.equal(userName, that.userName) && Objects.equal(userSurname, that.userSurname) && Objects.equal(email, that.email)
        	   && Objects.equal(login, that.login) && Objects.equal(password, that.password) && Objects.equal(role, that.role);
    }
    
    @Override
	public int hashCode() {
    	int result = (int) (id ^ (id >>> 32));
    	result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (userSurname != null ? userSurname.hashCode() : 0);		
		result = 31 * result + (email == null ? 0 : email.hashCode());
		result = 31 * result + (role == null ? 0 : role.hashCode());
		return result;
	}

	@Override
    public String toString() {
        return "User{" +
        		"id='" + id + '\'' +
        		", login='" + login + '\'' +
                ", password=" + password +
                ", userName='" + userName + '\'' +
                ", userSurname='" + userSurname + '\'' +
                ", email='" + email + '\'' +                
                ", role='" + role + '\'' +
                '}';
    }  
}