package com.sda.ro.silvestruradugabriel.bms.repository;

import com.sda.ro.silvestruradugabriel.bms.model.User;

public interface UserRepository extends BaseRepository <User , Integer>{

    void createUser(User user);

}
