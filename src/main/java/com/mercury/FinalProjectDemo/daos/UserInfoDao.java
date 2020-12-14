package com.mercury.FinalProjectDemo.daos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mercury.FinalProjectDemo.beans.UserInfo;

public interface UserInfoDao extends JpaRepository<UserInfo, Integer>{

	@Query("select u from UserInfo u where u.userId =:userId")
	public UserInfo findUserInfoByUserId(@Param("userId") int userId);
	
}
