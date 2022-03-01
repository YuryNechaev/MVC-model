package MVC.model;

import MVC.bean.User;
import MVC.model.service.UserService;
import MVC.model.service.UserServiceImpl;

import java.util.List;

public class MainModel implements Model {

    private ModelData modelData = new ModelData();
    private UserService userService = new UserServiceImpl();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        List<User> list = getAllUsers();
        modelData.setUsers(list);
        modelData.setDisplayDeletedUserList(false);
    }

    public void loadDeletedUsers() {
        List<User> users = userService.getAllDeletedUsers();
        modelData.setUsers(users);
        modelData.setDisplayDeletedUserList(true);
    }

    public void loadUserById(long userId) {
        User user = userService.getUsersById(userId);
        modelData.setActiveUser(user);
    }

    public void deleteUserById(long userId) {
        userService.deleteUser(userId);
        List<User> users = getAllUsers();
        //refresh model data
        modelData.setUsers(users);
    }
    public void changeUserData(String name, long id, int level){
        userService.createOrUpdateUser(name, id, level);
        List<User> users = getAllUsers();
        modelData.setUsers(users);

    }
    private List<User> getAllUsers() {
        List<User> allUsers = userService.getUsersBetweenLevels(1,100);
        allUsers = userService.filterOnlyActiveUsers(allUsers);
        return allUsers;
    }

}

