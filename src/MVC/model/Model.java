package MVC.model;

public interface Model {

    ModelData getModelData();
    void loadUsers();
    void loadDeletedUsers();
    void loadUserById(long userId);
    void deleteUserById(long userId);
    void changeUserData(String name, long Id, int level);
}
