package com.bq.phoneinformation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.view.KeyEvent;
import android.widget.TextView;

public class NetData  extends Activity{
	private TextView tv;
	private TextView content;
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.systemdata);
        TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        StringBuilder sb = new StringBuilder();
        sb.append("\n�豸ID��" + tm.getDeviceId());
        sb.append("\n����汾�ţ�" + tm.getDeviceSoftwareVersion());
        sb.append("\nLine1Number��" + tm.getLine1Number());
        sb.append("\n����������Ҵ��룺 " + tm.getNetworkCountryIso());
        sb.append("\n����������룺" + tm.getNetworkOperator());
        sb.append("\n�����������ƣ�" + tm.getNetworkOperatorName());
        sb.append("\n���������������ͣ�" + tm.getNetworkType());
        sb.append("\n�������� �� " + tm.getPhoneType());
        sb.append("\nSim�������̹��Ҵ��� = " + tm.getSimCountryIso());
        sb.append("\nSim�������̴��룺 " + tm.getSimOperator());
        sb.append("\nSim������������ ��" + tm.getSimOperatorName());
        sb.append("\nSim������ �� " + tm.getSimSerialNumber());
        sb.append("\nSim��״̬ ��" + tm.getSimState());
        sb.append("\n�����ƶ��û�ʶ���룺 " + tm.getSubscriberId());
        sb.append("\n����������룺" + tm.getVoiceMailNumber());
        tv=(TextView) findViewById(R.id.tv);
    	content=(TextView) findViewById(R.id.content);
    	tv.setText("�����ֻ���Ӫ����Ϣ��");
    	content.setText(sb);
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
