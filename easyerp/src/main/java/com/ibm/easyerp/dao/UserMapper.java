package com.ibm.easyerp.dao;

import com.ibm.easyerp.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
	
    int select(User user);

    int selectCount();

    User select2(String username);
    
    List<User> getAll(User user);
	
    void update(User user);
    
    void update2(User user);
    
    void insert(User user);
    
    void delete(String username);

}