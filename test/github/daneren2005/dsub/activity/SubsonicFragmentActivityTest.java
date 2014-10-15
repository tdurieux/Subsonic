package github.daneren2005.dsub.activity;

import github.daneren2005.dsub.R;
import android.test.*;

public class SubsonicFragmentActivityTest extends
		ActivityInstrumentationTestCase2<SubsonicFragmentActivity> {

	private SubsonicFragmentActivity activity;

	public SubsonicFragmentActivityTest() {
		super(SubsonicFragmentActivity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
	    activity = getActivity();
	}

	public void testLayout() {
		assertNotNull(activity.findViewById(R.id.content_frame));
	}

}
