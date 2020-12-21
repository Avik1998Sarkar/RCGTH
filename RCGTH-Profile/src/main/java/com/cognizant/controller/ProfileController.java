package com.cognizant.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.entity.Profile;
import com.cognizant.exception.ProfileAlreadyExistException;
import com.cognizant.exception.ProfileNotFoundException;
import com.cognizant.redis.ProfileDaoCache;

@RestController
@RequestMapping("/profile")
public class ProfileController {

	@Autowired
	private transient ProfileDaoCache cache;

	@GetMapping("/")
	public List<Profile> getAllProfiles() {
		return cache.getAllProfiles();
	}

	@PostMapping("/")
	public Profile insertProfiles(@Valid @RequestBody Profile profile) throws ProfileAlreadyExistException {
		return cache.insertProfiles(profile);
	}

	@PutMapping("/")
	public Profile updateProfiles(@RequestBody Profile profile) throws ProfileNotFoundException {
		return cache.updateProfiles(profile);
	}

	@DeleteMapping("/{str}")
	public void deleteProfiles(@PathVariable String str) throws ProfileNotFoundException {
		cache.deleteProfiles(str);
	}

}
