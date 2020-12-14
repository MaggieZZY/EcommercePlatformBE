package com.mercury.FinalProjectDemo.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mercury.FinalProjectDemo.beans.Profile;

public interface ProfileDao extends JpaRepository<Profile, Integer>{

}
