package com.ssafy.hw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.hw.model.dto.SearchCondition;
import com.ssafy.hw.model.dto.User;
import com.ssafy.hw.model.service.UserService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/userapi")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST })
public class UserRestController {

	@Autowired
	UserService userService;

	@GetMapping("/user")
	@ApiOperation(value = "등록된 모든 사용자 정보를 반환한다.", response = User.class)
	public ResponseEntity<?> selectAll() {
		try {
			List<User> users = userService.selectAll();
			if (users == null || users.size() == 0) {
				return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
			} else {
				return new ResponseEntity<List<User>>(users, HttpStatus.OK);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}

	@GetMapping("/user/{id}")
	@ApiOperation(value = "{id}에 해당하는 사용자 정보를 반환한다.", response = User.class)
	public ResponseEntity<?> select(@PathVariable String id) {
		 try {
		 	User user = userService.searchById(id);
		 	if (user == null) {
		 		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		 	} else {
		 		return new ResponseEntity<User>(user, HttpStatus.OK);
		 	}
		 } catch (Exception e) {
		 	return exceptionHandling(e);
		 }
	}

	@GetMapping("/user/search")
	@ApiOperation(value = "SearchCondition 에 부합하는 조건을 가진 사용자 목록을 반환한다.", response = User.class)
	public ResponseEntity<?> search(SearchCondition con) {
		 try {
		 	List<User> users = userService.searchByCondition(con);
		 	if (users == null || users.isEmpty()) {
		 		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		 	} else {
		 		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
		 	}
		 } catch (Exception e) {
		 	return exceptionHandling(e);
		 }
	}

	@PostMapping("/user")
	@ApiOperation(value = "사용자 정보를 삽입한다.", response = Integer.class)
	public ResponseEntity<?> insert(User user) {
		 try {
		 	int result = userService.insert(user);
		 	if (result > 0) {
		 		return new ResponseEntity<Integer>(result, HttpStatus.CREATED);
		 	} else {
		 		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		 	}
		 } catch (Exception e) {
		 	return exceptionHandling(e);
		 }
	}

	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Sorry: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
