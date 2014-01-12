package school.webservices;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import school.db.ResourceDAO;
import school.model.Image;
import school.model.Levelresource;
import school.model.Sound;
import school.webservice.ResourceService;

public class TestResourceService {

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
	public void getImages() {
		images.add(image1);
		Query query = Mockito.mock(Query.class);
		ResourceDAO resDao = Mockito.mock(ResourceDAO.class);
		resDao.setQuery(query);

		ResourceService lb = new ResourceService(resDao);

		Mockito.when(resDao.getImages(image1.getIdimage())).thenReturn(images);
		Mockito.when(resDao.getImages(image2.getIdimage())).thenReturn(images2);
		Mockito.when(resDao.getResources(image1.getIdimage(), lb.ONE)).thenReturn(levelResources);

		assertNotNull(lb.getImages(image1.getIdimage()));
		assertNull(lb.getImages(image2.getIdimage()));
	}

	@Test
	public void getSounds() {
		sounds.add(sound1);
		Query query = Mockito.mock(Query.class);
		ResourceDAO resDao = Mockito.mock(ResourceDAO.class);
		resDao.setQuery(query);

		ResourceService lb = new ResourceService(resDao);

		Mockito.when(resDao.getSounds(sound1.getIdsound())).thenReturn(sounds);
		Mockito.when(resDao.getSounds(sound2.getIdsound())).thenReturn(sounds2);
		Mockito.when(resDao.getResources(sound1.getIdsound(), lb.TWO)).thenReturn(levelResources);

		assertNotNull(lb.getSounds(sound1.getIdsound()));
		assertNull(lb.getSounds(sound2.getIdsound()));
	}

	@Test
	public void getImage() {
		Query query = Mockito.mock(Query.class);
		ResourceDAO resDao = Mockito.mock(ResourceDAO.class);
		resDao.setQuery(query);

		ResourceService lb = new ResourceService(resDao);

		Mockito.when(resDao.getImage(image1.getPath())).thenReturn(image1);

		assertEquals(image1, lb.getImage(image1.getPath()));
		assertNull(lb.getImage(null));
	}
}
