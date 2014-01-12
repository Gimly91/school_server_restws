package school.db;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static school.webservice.WSUtils.Q_IMAGE_ID;
import static school.webservice.WSUtils.Q_IMAGE_NAME;
import static school.webservice.WSUtils.Q_LEVEL_RES_ID;
import static school.webservice.WSUtils.Q_SOUND_ID;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import school.model.Image;
import school.model.Levelresource;
import school.model.Sound;

public class TestResourceDAO {

	private static List<Image> images = new ArrayList<>();
	private static List<Image> images2 = new ArrayList<>();
	private static List<Sound> sounds = new ArrayList<>();
	private static List<Sound> sounds2 = new ArrayList<>();
	private static List<Levelresource> levelResources = new ArrayList<>();
	private static Levelresource lr1 = new Levelresource();
	private static Image image1 = new Image();
	private static Image image2 = new Image();
	private static Sound sound1 = new Sound();
	private static Sound sound2 = new Sound();

	@BeforeClass
	public static void setUp() {
		image1.setIdimage(1);
		image1.setPath("1.jpg");
		image1.setIdimage(2);
		image1.setPath("2.jpg");
		lr1.setIdLevel(1);
		lr1.setIdResource(2);
		lr1.setType(2);
		levelResources.add(lr1);
		sound1.setIdsound(1);
		sound1.setIdsound(2);
	}

	@Test
	public void testgetImages() {
		EntityManager em = Mockito.mock(EntityManager.class);
		Query query = Mockito.mock(Query.class);

		ResourceDAO rD = new ResourceDAO(em);
		rD.setQuery(query);

		Mockito.when(em.createQuery(Q_IMAGE_ID)).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(images);

		assertEquals(images, rD.getImages(image1.getIdimage()));
	}

	@Test
	public void testgetSounds() {
		EntityManager em = Mockito.mock(EntityManager.class);
		Query query = Mockito.mock(Query.class);

		ResourceDAO rD = new ResourceDAO(em);
		rD.setQuery(query);

		Mockito.when(em.createQuery(Q_SOUND_ID)).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(sounds);

		assertEquals(sounds, rD.getSounds(sound1.getIdsound()));
	}

	@Test
	public void testgetLevelResources() {
		EntityManager em = Mockito.mock(EntityManager.class);
		Query query = Mockito.mock(Query.class);

		ResourceDAO rD = new ResourceDAO(em);
		rD.setQuery(query);

		Mockito.when(em.createQuery(Q_LEVEL_RES_ID)).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(levelResources);

		assertEquals(levelResources, rD.getResources(lr1.getIdLevel(), 1));
	}

	@Test
	public void testgetImage() {
		EntityManager em = Mockito.mock(EntityManager.class);
		Query query = Mockito.mock(Query.class);

		ResourceDAO rD = new ResourceDAO(em);
		rD.setQuery(query);
		images.add(image1);
		Mockito.when(em.createQuery(Q_IMAGE_NAME)).thenReturn(query);
		Mockito.when(query.getResultList()).thenReturn(images);

		assertEquals(image1, rD.getImage(image1.getPath()));

		Mockito.when(query.getResultList()).thenReturn(images2);
		assertNull(rD.getImage(image1.getPath()));
	}
}
