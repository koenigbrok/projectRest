package org.koenigbrok.vic.projectRest.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.koenigbrok.vic.projectRest.messanger.model.*;
import org.koenigbrok.vic.projectRest.messanger.service.ProfileService;


@Path("/profiles")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProfileResource {

	private ProfileService ps = new ProfileService();
	
	
	@GET
	public List<Profile> getProfile(){
		return ps.getAllProfiles();
	}
	
	@POST
	public Profile addProfile(Profile profile) {
		return ps.addProfile(profile);
	}
	
	@GET
	@Path("/{profileName}")
	public Profile getProfile(@PathParam("profileName")String profileName) {
		return ps.getProfile(profileName);
	}
	
	@PUT
	@Path("/{profileName}")
	public Profile updateProfile(@PathParam("profileName")String profileName, Profile profile)  {
		profile.setProfileName(profileName);
		return ps.updateProfile(profile);
	}
	
	@DELETE
	@Path("/{profileName}")
	public void deleteProfile(@PathParam("profileName")String profileName) {
		ps.removeProfile(profileName);
	}
}
