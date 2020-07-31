package com.example.pruebalivedatamvvm.login;

public interface LoginRepository {
    void saveUser(UserPojo user);

    UserPojo getUser();
}
