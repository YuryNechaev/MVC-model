package MVC.model;

import MVC.bean.User;

import java.util.LinkedList;
import java.util.List;

public class FakeModel implements Model{

    private ModelData modelData = new ModelData();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        List<User> list = new LinkedList<User>();
        list.add(new User("Bob",1,3));
        list.add(new User("Tom",2,4));
        modelData.setUsers(list);

    }

    @Override
    public void loadDeletedUsers() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void loadUserById(long userId) {
        throw new UnsupportedOperationException();

    }

    @Override
    public void deleteUserById(long userId) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void changeUserData(String name, long Id, int level) {
        throw new UnsupportedOperationException();
    }
}
