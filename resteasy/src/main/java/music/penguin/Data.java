package music.penguin;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import music.penguin.bs.GrapeBS;
import music.penguin.bs.ORMUtils;
import music.penguin.bs.UserBS;
import music.penguin.bs.WineBS;
import music.penguin.domain.User;
import music.penguin.domain.Wine;
import music.penguin.dto.GrapeDTO;
import music.penguin.dto.WineDTO;

@Path("/services")
public class Data {
	@Inject ORMUtils ormUtils; 
	@Inject GrapeBS grapeBS;
	@Inject WineBS wineBS;
	@Inject UserBS userBS;

	public Data() {}
	
	@GET
	@Path("/grape")
	@Produces("application/json;charset=utf-8")
	public GrapeDTO getGrape() {
		GrapeDTO grape = grapeBS.retrieveGrape();
		return grape;
	}
	
	@GET
	@Path("/grapes")
	@Produces("application/json;charset=utf-8")
	public List<GrapeDTO> getGrapes() {
		List<GrapeDTO> grapes = grapeBS.retrieveAllGrapesDTO();
		if (grapes == null) {
			grapes = new ArrayList<GrapeDTO>();
		}
		return grapes;
	}
	
	@GET
	@Path("/wine")
	@Produces("application/json;charset=utf-8")
	public WineDTO getWine() {
		WineDTO wine = wineBS.getWineDTOById(61L);
		return wine;
	}
	
	@POST
	@Path("/wine")
	@Consumes("application/json")
	public void saveWine(Wine wine) {
		System.err.println("saveWine.id   :"+wine.getId());
		System.err.println("saveWine.name :"+wine.getName());
	}
	
	@GET
	@Path("/wine/user/{userId}")
	@Produces("application/json;charset=utf-8")
	public List<WineDTO> getWineUser(@PathParam("userId") Long id) {
		List<WineDTO> wine = wineBS.retrieveWineDTOList(id);
		return wine;
	}
	
	@GET
	@Path("/user")
	@Produces("application/json;charset=utf-8")
	public User getUser() {
		User user = userBS.retrieveUserById(2L);
		return user;
	}

}
