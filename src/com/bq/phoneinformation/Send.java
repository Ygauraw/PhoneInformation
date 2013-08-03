package com.bq.phoneinformation;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Send extends Activity implements OnClickListener {
	 private EditText content;
	 public void onCreate(Bundle savedInstanceState) { 
	        super.onCreate(savedInstanceState); 
	        setContentView(R.layout.send);
	        Button sendBtn=(Button) findViewById(R.id.send_btn); 
	        //ע���¼� 
	        sendBtn.setOnClickListener(this); 
	        content=(EditText) findViewById(R.id.send_data);
	    } 
	    public void onClick(View v) { 
	        //��Ϣ������� 
	        SmsManager smsManager=SmsManager.getDefault(); 
	        //��ͼ      �����������������     ������      ��ͨ����ͼ       ״̬ 
	        PendingIntent intent=PendingIntent.getBroadcast(Send.this, 0, new Intent(), 0); 
	        //������Ϣ 
	        smsManager.sendTextMessage("18740414439", null, content.getText().toString(), 
	                intent, null); 
	        //��ʾ��Ϣ���ͳɹ� 
	        Toast.makeText(Send.this, "��Ϣ���ͳɹ�����л���Ĳ���", Toast.LENGTH_LONG).show(); 
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
