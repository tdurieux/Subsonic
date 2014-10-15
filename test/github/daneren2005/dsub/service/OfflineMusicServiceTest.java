package github.daneren2005.dsub.service;

import android.graphics.Bitmap;
import junit.framework.Assert;
import junit.framework.TestCase;

public class OfflineMusicServiceTest extends TestCase{

	public void testPing() {

	}

	public void testIsLicenseValid() {

	}

	public void testGetIndexes() {

	}

	public void testGetMusicDirectory() {

	}

	public void testGetArtist() {
		try {
			OfflineMusicService offlineService = new OfflineMusicService();
			offlineService.getArtist(null, null, false, null, null);
			Assert.fail("Should have thrown OfflineException exception");
		} catch (OfflineException e) {
			// success
		} catch (Exception e) {
			Assert.fail("Should have thrown OfflineException exception");
		}
	}
	
	public void testGetAlbum() {
		try {
			OfflineMusicService offlineService = new OfflineMusicService();
			offlineService.getAlbum(null, null, false, null, null);
			Assert.fail("Should have thrown OfflineException exception");
		} catch (OfflineException e) {
			// success
		} catch (Exception e) {
			Assert.fail("Should have thrown OfflineException exception");
		}
	}
	
	public void testGetNameWithNullValue() throws Exception{
		OfflineMusicService offlineService = new OfflineMusicService();
		Bitmap result = offlineService.getCoverArt(null, null, 0, null, null);
		assertEquals(null, result);
		result = offlineService.getCoverArt(null, null, 0, null, null);
		assertEquals(null, result);
	}
}
