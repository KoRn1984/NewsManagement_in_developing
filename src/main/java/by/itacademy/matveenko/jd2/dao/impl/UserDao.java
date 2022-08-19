package by.itacademy.matveenko.jd2.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.itacademy.matveenko.jd2.bean.User;
import by.itacademy.matveenko.jd2.bean.UserRole;
import by.itacademy.matveenko.jd2.dao.DaoException;
import by.itacademy.matveenko.jd2.dao.IUserDao;
import by.itacademy.matveenko.jd2.dao.connectionpool.ConnectionPool;
import by.itacademy.matveenko.jd2.dao.connectionpool.ConnectionPoolException;

public class UserDao implements IUserDao{
	
    @Override
    public User findUserByLoginAndPassword(String login, String password) throws DaoException {
        String selectUserData = "SELECT login, password, name, surname, email, roles.role as role FROM users JOIN roles on roles.id = users.role WHERE login=? and password=?";
        User user = new User();
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
            PreparedStatement ps = connection.prepareStatement(selectUserData)) {
            ps.setString(1, login);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                	user.setLogin(rs.getString("login"));
                	user.setPassword(rs.getString("password"));
                	user.setUserName(rs.getString("name"));
                	user.setUserSurname(rs.getString("surname"));
                	user.setEmail(rs.getString("email"));
                	user.setRole(UserRole.valueOf(rs.getString("role").toUpperCase()));
                    return user;
                }
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        } catch (ConnectionPoolException e) {
            throw new DaoException(e);
        }
        return null;
    }

    @Override
    public boolean saveUser(User user) throws DaoException {
        String insertRegistrationData = "INSERT INTO users(login, password, name, surname, email, role) VALUES (?,?,?,?,?,?)";
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
            PreparedStatement ps = connection.prepareStatement(insertRegistrationData)) {
        	ps.setString(1, user.getLogin());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getUserName());
            ps.setString(4, user.getUserSurname());
            ps.setString(5, user.getEmail());
            ps.setInt(6, user.getRole().getRole());
            ps.executeUpdate();
        } catch (SQLException e) {            
        	throw new DaoException(e);
        } catch (ConnectionPoolException e) {
            throw new DaoException(e);
        }
        return true;
    }
    
    @Override
    public User findById(Integer id) throws SQLException, DaoException {
    	String selectDataFindById = "SELECT users.id as id, name, surname, login, password, email, roles.role_name as role" +
                "from users join roles on roles.id = users.role\n" + "where users.id=?";
        try (Connection connection = ConnectionPool.getInstance().takeConnection();
             PreparedStatement ps = connection.prepareStatement(selectDataFindById)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new User.Builder()
                            .withId(rs.getInt("id"))
                            .withName(rs.getString("name"))
                            .withSurname(rs.getString("surname"))
                            .withLogin(rs.getString("login"))
                            .withPassword(rs.getString("password"))
                            .withEmail(rs.getString("email"))
                            .withRole(UserRole.valueOf(rs.getString("role")))
                            .build();
                }
            } catch (SQLException e) {
            	throw new DaoException(e);
            }
        } catch (ConnectionPoolException e) {
            throw new DaoException();
        }
        return null;
    }    
}