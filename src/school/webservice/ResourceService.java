package school.webservice;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import school.model.Image;
import school.model.Levelresource;
import school.model.Sound;

@Path("ResourcesService")
@Produces(MediaType.APPLICATION_JSON)
public class ResourceService {

	@Inject
	EntityManager em;
	private Query query;
	private String q_image = "SELECT p from " + "Image p";
	private String q_sound = "SELECT p from " + "Sound p";
	private String q_sound_id = q_sound + " where p.idsound=:id";
	private String q_level_resources = "SELECT p from " + "Levelresource p";
	private String q_image_name = q_image + " where p.path=:name";
	private String q_level_res_id = q_level_resources + " where p.idLevel=:id and p.type=:type";
	private String q_image_id = q_image + " where p.idimage=:id";

	public ResourceService() {
	}

	@SuppressWarnings("unchecked")
	@GET
	@Path("/getImages/{id}")
	public Response getImages(@PathParam("id") int id) {
		List<Image> images = new ArrayList<>();
		try {
			for (Levelresource lr : getResources(id, 1)) {
				query = em.createQuery(q_image_id);
				query.setParameter("id", lr.getIdResource());
				List<Image> imagesDB = query.getResultList();
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

	@SuppressWarnings("unchecked")
	@GET
	@Path("/getSounds/{id}")
	public Response getSounds(@PathParam("id") int id) {
		List<Sound> sounds = new ArrayList<>();
		try {
			for (Levelresource lr : getResources(id, 2)) {
				query = em.createQuery(q_sound_id);
				query.setParameter("id", lr.getIdResource());
				List<Sound> soundsDB = query.getResultList();
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

	@SuppressWarnings("unchecked")
	@GET
	@Path("/getImage/{name}")
	public Image getImage(@PathParam("name") String name) {
		try {
			query = em.createQuery(q_image_name);
			query.setParameter("name", name);
			List<Image> images = query.getResultList();
			if (images.size() > 0) {
				return images.get(0);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Levelresource> getResources(int id, int type) {
		try {
			query = em.createQuery(q_level_res_id);
			query.setParameter("id", id);
			query.setParameter("type", type);
			List<Levelresource> levelR = query.getResultList();
			if (levelR.size() > 0) {
				return levelR;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
}
