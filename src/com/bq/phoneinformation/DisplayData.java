package com.bq.phoneinformation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.widget.TextView;

public class DisplayData  extends Activity{
	private TextView tv;
	private TextView content;
	@Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.systemdata);
	tv=(TextView) findViewById(R.id.tv);
	content=(TextView) findViewById(R.id.content);
	DisplayMetrics metric=new DisplayMetrics();
	getWindowManager().getDefaultDisplay().getMetrics(metric);
	int width=metric.widthPixels;//��Ļ���[����]
	int height=metric.heightPixels;//��Ļ�߶�[����]
	float density=metric.density;//��Ļ�ܶ�[0.75|1.0|1.5]
	int densityDpi=metric.densityDpi;//��Ļ�ܶ�[120|160|240]
	tv.setText("�����ֻ���ʾ����Ϣ��");
	content.setText("��Ļ��ȣ�"+String.valueOf(width)+"����\n"+"��Ļ�߶ȣ�"+String.valueOf(height)+"����\n"+"��Ļ�ܶȣ�"+String.valueOf(density)+"\n"+"��Ļ�ܶȣ�"+String.valueOf(densityDpi)+"��ÿӢ���ж��ٸ���ʾ�㣩");
	
}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
				Intent inte= new Intent(this,Show.class);
				startActivity(inte);
				overridePendingTransition(R.anim.fade, R.anim.hold);
				finish();// ǿ���˳�
			
			return true;// ���ó�false��backʧЧ ��true��ʾ ��ʧЧ
		} else {
			return super.onKeyDown(keyCode, event);
		}
	}
}