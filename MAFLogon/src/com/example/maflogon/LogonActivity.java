package com.example.maflogon;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import com.sap.maf.tools.logon.logonui.api.LogonListener;
import com.sap.maf.tools.logon.logonui.api.LogonUIFacade;
import com.sap.maf.tools.logon.manager.LogonContext;

public class LogonActivity extends Activity implements LogonListener {
	
	private final String LOG_TAG = "MAFLogon";
	private final String APPLICATIONID = "com.sap.maf.test.adr.logonapp";
	private LogonUIFacade logonUIFacade;
	private Activity act;
	private Context ctx;
	

	@Override
	public void objectFromSecureStoreForKey() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onApplicationSettingsUpdated() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onBackendPasswordChanged(boolean arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onLogonFinished(String arg0, boolean arg1, LogonContext arg2) {
		//hides MAFLogonUI when logon finished  and returns to main activity 
		finish();

	}

	@Override
	public void onSecureStorePasswordChanged(boolean arg0, String arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		//get an instance of the LogonUIFacade
		logonUIFacade = LogonUIFacade.getInstance();
		//set activity reference
		act = this;
		//set context reference
		ctx = this;
		//init LogonUIFacede
		logonUIFacade.init(this, ctx, APPLICATIONID);
		//ask LogonUIFacede to present the logon screen
		//set the resulting view as the content view for this activity
		setContentView(logonUIFacade.logon());
	}

	@Override
	public void onUserDeleted() {
		// TODO Auto-generated method stub

	}

	@Override
	public void registrationInfo() {
		// TODO Auto-generated method stub

	}
}
