package com.IBatisConfigurationThroughXml.Repository;



import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.IBatisConfigurationThroughXml.Entity.UserDetails;
import com.IBatisConfigurationThroughXml.Entity.UserRequest;

public interface ProductMapper {

    void insertUserRequest(UserRequest userRequest);
    UserRequest getUserRequestById(Long id);
    List<UserRequest>getAllUsers();
    void deleteUserById(Long id);
    void updateUser(UserRequest userRequest);
    List<UserRequest> callStoredProcedure(Map<String, Object> parameters);        
    @MapKey("id")
    List<List<Map<String, Object>>> multiResultSetStored(@Param("id") int id);
    List<UserDetails> multiResultSetStoredWith(String name);
    
    
    
}
