package school.db;

import static school.webservice.WSUtils.Q_IMAGE_ID;
import static school.webservice.WSUtils.Q_IMAGE_NAME;
import static school.webservice.WSUtils.Q_LEVEL_RES_ID;
import static school.webservice.WSUtils.Q_SOUND_ID;

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
		query = em.createQuery(Q_IMAGE_ID);
		query.setParameter("id", id);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Sound> getSounds(int id) {
		query = em.createQuery(Q_SOUND_ID);
		query.setParameter("id", id);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<Levelresource> getResources(int id, int type) {
		query = em.createQuery(Q_LEVEL_RES_ID);
		query.setParameter("id", id);
		query.setParameter("type", type);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public Image getImage(String name) {
		query = em.createQuery(Q_IMAGE_NAME);
		query.setParameter("name", name);
		List<Image> images = query.getResultList();
		if (!images.isEmpty()) {
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
