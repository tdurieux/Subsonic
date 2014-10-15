package github.daneren2005.dsub.service;

import static github.daneren2005.dsub.domain.PlayerState.COMPLETED;
import static github.daneren2005.dsub.domain.PlayerState.IDLE;
import static github.daneren2005.dsub.domain.PlayerState.PAUSED;
import static github.daneren2005.dsub.domain.PlayerState.STARTED;
import static github.daneren2005.dsub.domain.PlayerState.STOPPED;

import java.util.List;

import github.daneren2005.dsub.R;
import github.daneren2005.dsub.activity.SubsonicFragmentActivity;
import github.daneren2005.dsub.domain.PlayerState;
import android.content.Intent;
import android.os.IBinder;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ServiceTestCase;
import android.test.suitebuilder.annotation.MediumTest;
import android.test.suitebuilder.annotation.SmallTest;

public class DownloadServiceTest extends
		ActivityInstrumentationTestCase2<SubsonicFragmentActivity> {

	private SubsonicFragmentActivity activity;
	private DownloadService downloadService;

	public DownloadServiceTest() {
		super(SubsonicFragmentActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		activity = getActivity();
		downloadService = activity.getDownloadService();
		downloadService.clear();
	}

	public void testDownloadsWithoutDownloads() {
		downloadService.checkDownloads();
	}

	public void testSetVolume() {
		downloadService.setVolume(10);
	}

	public void testStartSleepTimer() {
		downloadService.startSleepTimer();
	}

	public void testGetPlayerDurationWithNothingToPlay() {
		int duration = downloadService.getPlayerDuration();
		assertEquals(0, duration);
	}

	public void testGetPlayerPositionWithNothingToPlay() {
		int position = downloadService.getPlayerPosition();
		assertEquals(0, position);
	}

	public void testNextWithoutPlayList() {
		downloadService.next();
	}

	public void testPreviousWithoutPlayList() {
		downloadService.previous();
	}

	public void testSeekTo() {
		// seek with negative
		downloadService.seekTo(Integer.MIN_VALUE);

		// seek with null
		downloadService.seekTo(0);

		// seek with big value
		downloadService.seekTo(Integer.MAX_VALUE);
	}
	
	public void testTogglePlayPause() {
		PlayerState oldPlayState = downloadService.getPlayerState();
		downloadService.togglePlayPause();
		PlayerState newPlayState = downloadService.getPlayerState();
		if (oldPlayState == PAUSED || oldPlayState == COMPLETED || oldPlayState == STOPPED) {
			assertEquals(STARTED, newPlayState);
		} else if (oldPlayState == STOPPED || oldPlayState == IDLE) {
			assertEquals(STARTED, newPlayState);
		} else if (oldPlayState == STARTED) {
			assertEquals(PAUSED, newPlayState);
		}
		
		downloadService.togglePlayPause();
		newPlayState = downloadService.getPlayerState();
		assertEquals(oldPlayState, newPlayState);
	}
	
	public void testGetDownloadsEmptyList() {
		List<DownloadFile> list = downloadService.getDownloads();
		assertEquals(0, list.size());
	}

}
