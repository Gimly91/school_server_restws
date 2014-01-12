package school.webservice;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import school.db.ResourceDAO;
import school.model.Image;
import school.model.Levelresource;
import school.model.Sound;

@Path("ResourcesService")
@Produces(MediaType.APPLICATION_JSON)
public class ResourceService {

	@Inject
	EntityManager em;
	private ResourceDAO resourceDAO;
	public final int ONE = 1;
	public final int TWO = 2;

	public ResourceService() {
	}

	public ResourceService(ResourceDAO uD) {
		this.resourceDAO = uD;
	}

	@GET
	@Path("/getImages/{id}")
	public Response getImages(@PathParam("id") int id) {
		List<Image> images = new ArrayList<>();
		try {
			List<Levelresource> lrs = getResources(id, ONE);
			for (Levelresource lr : lrs) {
				resourceDAO.setEm(em);
				List<Image> imagesDB = resourceDAO.getImages(lr.getIdResource());
				if (imagesDB.size() > 0) {
					images.add(imagesDB.get(0));
				}
			}
			if (images.size() > 0) {
				GenericEntity<List<Image>> ge = new GenericEntity<List<Image>>(images) {
				};
				return Response.status(Status.BAD_REQUEST).entity(ge).build();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@GET
	@Path("/getSounds/{id}")
	public Response getSounds(@PathParam("id") int id) {
		List<Sound> sounds = new ArrayList<>();
		try {
			List<Levelresource> lrs = getResources(id, TWO);
			for (Levelresource lr : lrs) {
				resourceDAO.setEm(em);
				List<Sound> soundsDB = resourceDAO.getSounds(lr.getIdResource());
				if (soundsDB.size() > 0) {
					sounds.add(soundsDB.get(0));
				}
			}

			if (sounds.size() > 0) {
				GenericEntity<List<Sound>> ge = new GenericEntity<List<Sound>>(sounds) {
				};
				return Response.status(Status.BAD_REQUEST).entity(ge).build();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@GET
	@Path("/getImage/{name}")
	public Image getImage(@PathParam("name") String name) {
		try {
			if (name != null) {
				resourceDAO.setEm(em);
				return resourceDAO.getImage(name);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public List<Levelresource> getResources(int id, int type) {
		try {
			resourceDAO.setEm(em);
			List<Levelresource> levelR = resourceDAO.getResources(id, type);
			if (levelR.size() > 0) {
				return levelR;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
