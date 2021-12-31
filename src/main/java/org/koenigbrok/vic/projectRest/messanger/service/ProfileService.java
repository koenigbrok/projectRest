package org.koenigbrok.vic.projectRest.messanger.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.koenigbrok.vic.projectRest.messanger.database.DatabaseClass;
import org.koenigbrok.vic.projectRest.messanger.model.Message;
import org.koenigbrok.vic.projectRest.messanger.model.Profile;

public class ProfileService {

	
	private Map<String, Profile> profiles =  DatabaseClass.getProfiles();
	
	


	public ProfileService() {

		profiles.put("vix", new Profile(1L, "vix", "victori", "victoria"));
		profiles.put("moxy", new Profile(2L, "mob", "bob", "victo"));
	}

	public List<Profile> getAllProfiles(){
		
		return new ArrayList<Profile>(profiles.values());
	}
	
	public Profile getProfile(String profileName) {
		return profiles.get(profileName);
	}
	
	public Profile addProfile(Profile profile) {
		
		profile.setId(profiles.size() + 1);
		profiles.put(profile.getProfileName(), profile);
		return profile;
		
	}
	
	public Profile updateProfile(Profile profile) {
		if(profile.getProfileName().isEmpty()) {
			return null;
		}
		profiles.put(profile.getProfileName(), profile);
		return profile;
	}
	
	public Profile removeProfile(String profileName) {
		return profiles.remove(profileName);
	}
}
