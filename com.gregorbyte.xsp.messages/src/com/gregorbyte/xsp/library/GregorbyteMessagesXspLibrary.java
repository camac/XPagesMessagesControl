package com.gregorbyte.xsp.library;

import com.ibm.xsp.library.AbstractXspLibrary;

public class GregorbyteMessagesXspLibrary extends AbstractXspLibrary {

	public static final String PLUGIN_ID = "com.gregorbyte.xsp.messages";
	public static final String LIBRARY_ID = "com.gregorbyte.xsp.messages.library";

	@Override
	public String[] getDependencies() {

		return new String[] { "com.ibm.xsp.core.library", "com.ibm.xsp.extsn.library" };

	}

	@Override
	public String getLibraryId() {
		return LIBRARY_ID;
	}

	@Override
	public String getPluginId() {
		return PLUGIN_ID;
	}

	@Override
	public String[] getFacesConfigFiles() {

		String[] files = new String[] { "com/gregorbyte/xsp/config/gregorbyte-messages-faces-config.xml", };

		return files;

	}

	@Override
	public String[] getXspConfigFiles() {

		String[] files = new String[] { "com/gregorbyte/xsp/config/gregorbyte-messages.xsp-config", };

		return files;

	}

}
