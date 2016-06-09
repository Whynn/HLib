package com.hlib.service;

import org.springframework.stereotype.Service;

@Service("HomeService")
public class HomeService {
	
	private final String managerID = "admin";
	private final String managerPW = "admin";
	
	public boolean isManager(String ID, String PW){
		if(ID.equals(managerID) && PW.equals(managerPW)){
			return true;
		}
		else{
			return false;
		}
	}
}
