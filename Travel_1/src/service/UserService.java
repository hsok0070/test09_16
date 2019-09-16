package service;

import java.util.List;

import vo.UserVO;

public interface UserService {
	
	 
	int insertUser(UserVO user);
	int UpdateUser(UserVO user);
	UserVO LoginUser(UserVO vo);
	
	

}
