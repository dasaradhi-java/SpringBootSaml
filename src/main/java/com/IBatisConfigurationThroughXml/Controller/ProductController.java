package com.IBatisConfigurationThroughXml.Controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.IBatisConfigurationThroughXml.Entity.ConsolidateDataForUserandROle;
import com.IBatisConfigurationThroughXml.Entity.ResponseWrapper;
import com.IBatisConfigurationThroughXml.Entity.UserDetails;
import com.IBatisConfigurationThroughXml.Entity.UserRequest;
import com.IBatisConfigurationThroughXml.Service.ProductService;

@RestController
@RequestMapping("/xml/products")
public class ProductController {

	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping
	public ResponseEntity<List<UserRequest>> getAllUsers() {
		List<UserRequest> users = productService.getAllUsers();

		return ResponseEntity.ok(users);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserRequest> getUserRequestById(@PathVariable Long id) {
		UserRequest userRequest = productService.getUserRequestById(id);
		System.out.println();

		if (userRequest != null) {
			return ResponseEntity.ok(userRequest);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	@PostMapping("/create")
	public ResponseEntity<String> createUser(@RequestBody UserRequest userRequest) {
		productService.addUserRequest(userRequest);
		return ResponseEntity.status(HttpStatus.CREATED).body("User created successfully");
	}

	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<String> deleteUserById(@PathVariable Long id) {
		try {
			productService.deleteUserById(id);
			return ResponseEntity.ok("User deleted successfully");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete user");
		}
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<String> updateUserById(@PathVariable int id, @RequestBody UserRequest userRequest) {
		try {
			userRequest.setId(id);
			productService.updateUser(userRequest);
			return ResponseEntity.ok("User updated successfully");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update user");
		}
	}

	@GetMapping("/SP/{id}")
	public ResponseEntity<List<UserRequest>> callStoredProcedure(@PathVariable Long id) {
		try {
			List<UserRequest> result = productService.callStoredProcedure(id);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			e.printStackTrace(); // Log the exception for debugging purposes
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping("/multipleResultSets/{id}")
	public ResponseEntity<ResponseWrapper> getMultipleResultSets(@PathVariable int id) {
		ConsolidateDataForUserandROle result = productService.getMultipleResultSets(id);
		ResponseWrapper responseWrapper = new ResponseWrapper();
		responseWrapper.setUserAndRoleData(result);
		return ResponseEntity.ok(responseWrapper);
	}

	@GetMapping("/SPW/{id}")
	public ResponseEntity<List<UserDetails>> storedProcedureWithParms(@PathVariable int id) {
		try {
			List<UserDetails> result = productService.getparameterFromAnotherSP(id);
			return ResponseEntity.ok(result);
		} catch (Exception e) {
			e.printStackTrace(); // Log the exception for debugging purposes
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}