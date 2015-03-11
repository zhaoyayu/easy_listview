package zyy.ticket.activity;

import zyy.ticket.application.MyApplication;
import zyy.ticket.manager.EngineFactory;
import zyy.ticket.manager.JsonHelper;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

/**
 * activity基类
 */
public class BaseActivity extends FragmentActivity {

	/** 引擎部分变量 **/
	public JsonHelper jsonHelper;
	public LayoutInflater inflater;
	public Context context;

	/**
	 * 当fragment和activity关联之后，调用这个方法
	 */
	@Override
	public void onAttachFragment(Fragment fragment) {
		super.onAttachFragment(fragment);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		MyApplication.getInstance().addActivity(this);
		inflater = LayoutInflater.from(this);
		context = EngineFactory.initContext(this);
		jsonHelper = EngineFactory.getInstance().jsonHelper;
	}

	@Override
	public View onCreateView(String name, Context context, AttributeSet attrs) {
		return super.onCreateView(name, context, attrs);
	}

	@Override
	protected void onStart() {
		super.onStart();
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	protected void onStop() {
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		MyApplication.getInstance().removeActivity(this);
	}

	@Override
	protected void onRestart() {
		super.onRestart();
	}

}
