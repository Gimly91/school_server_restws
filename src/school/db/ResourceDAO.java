package school.db;

import static school.webservice.WSUtils.q_image_id;
import static school.webservice.WSUtils.q_image_name;
import static school.webservice.WSUtils.q_level_res_id;
import static school.webservice.WSUtils.q_sound_id;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import school.model.Image;
import school.model.Levelresource;
import school.model.Sound;

public class ResourceDAO {
	private EntityManager em;
	private Query query;

	public ResourceDAO() {
	}

	public ResourceDAO(EntityManager em) {
		this.em = em;
	}

	@SuppressWarnings("unchecked")
	public List<Image> getImages(int id) {
		query = em.createQuery(q_image_id);
		query.setParameter("id", id);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Sound> getSounds(int id) {
		query = em.createQuery(q_sound_id);
		query.setParameter("id", id);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Levelresource> getResources(int id, int type) {
		query = em.createQuery(q_level_res_id);
		query.setParameter("id", id);
		query.setParameter("type", type);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public Image getImage(String name) {
		query = em.createQuery(q_image_name);
		query.setParameter("name", name);
		List<Image> images = query.getResultList();
		if (images.size() > 0) {
			return images.get(0);
		}
		return null;
	}

	public Query getQuery() {
		return query;
	}

	public void setQuery(Query query) {
		this.query = query;
	}

	public EntityManager getEm() {
		return em;
	}

	public void setEm(EntityManager em) {
		this.em = em;
	}
}
