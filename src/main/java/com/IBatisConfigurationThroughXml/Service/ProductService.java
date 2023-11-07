package com.IBatisConfigurationThroughXml.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.IBatisConfigurationThroughXml.Entity.ConsolidateDataForUserandROle;
import com.IBatisConfigurationThroughXml.Entity.Role;
import com.IBatisConfigurationThroughXml.Entity.UserDetails;
import com.IBatisConfigurationThroughXml.Entity.UserRequest;
import com.IBatisConfigurationThroughXml.Repository.ProductMapper;

@Service
public class ProductService {
	private final ProductMapper productMapper;

	public ProductService(ProductMapper productMapper, SqlSession sqlSession) {
		this.productMapper = productMapper;
	}

	public void addUserRequest(UserRequest userRequest) {
		productMapper.insertUserRequest(userRequest);
	}

	public UserRequest getUserRequestById(Long id) {
		return productMapper.getUserRequestById(id);
	}

	public List<UserRequest> getAllUsers() {
		return productMapper.getAllUsers();

	}

	public void deleteUserById(Long id) {
		productMapper.deleteUserById(id);
	}

	public void updateUser(UserRequest userRequest) {
		productMapper.updateUser(userRequest);
	}

	public List<UserRequest> callStoredProcedure(Long id) {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("id", id);
		return productMapper.callStoredProcedure(parameters);
	}

	public List<UserDetails> getparameterFromAnotherSP(int id) {
		List<UserDetails> userDetailsList = new ArrayList<>();
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("id", id);
		List<UserRequest> firstSP = productMapper.callStoredProcedure(parameters);
		for (UserRequest de : firstSP) {
			String name = de.getUsername();
			List<UserDetails> userDetails = productMapper.multiResultSetStoredWith(name);
			userDetailsList.addAll(userDetails);
		}
		return userDetailsList;
	}

	public ConsolidateDataForUserandROle getMultipleResultSets(int id) {
		List<List<Map<String, Object>>> result = productMapper.multiResultSetStored(id);
		List<UserDetails> user = processUserResultSet(result.get(0));
		List<Role> roles = processRoleResultSet(result.get(1));
		ConsolidateDataForUserandROle consolidateDataForUserandROle = new ConsolidateDataForUserandROle(user, roles);
		return consolidateDataForUserandROle;
	}

	public List<UserDetails> processUserResultSet(List<Map<String, Object>> resultSet) {
		List<UserDetails> users = new ArrayList<>();
		for (Map<String, Object> row : resultSet) {
			UserDetails user = new UserDetails();
			user.setId((int) row.get("id"));
			user.setUsername((String) row.get("username"));
			users.add(user);
		}
		return users;
	}

	public List<Role> processRoleResultSet(List<Map<String, Object>> resultSet) {
		List<Role> roles = new ArrayList<>();
		for (Map<String, Object> row : resultSet) {
			Role role = new Role();
			role.setId((int) row.get("id"));
			role.setName((String) row.get("name"));
			roles.add(role);
		}
		return roles;
	}
}
