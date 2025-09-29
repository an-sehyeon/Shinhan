package com.shinhan.sbroject.servicefinal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shinhan.sbroject.repository.ProfileRepository;

import jakarta.transaction.Transactional;

@Service
public class ProfileService {
	
	@Autowired
	ProfileRepository proRepo;
	
	@Transactional
	public void f1(String fullName) {
		proRepo.deleteByFname(fullName);
	}

}
