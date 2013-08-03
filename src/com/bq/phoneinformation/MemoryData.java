package com.bq.phoneinformation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.MemoryInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.Formatter;
import android.view.KeyEvent;
import android.widget.TextView;

public class MemoryData extends Activity{
	private TextView tv;
	private TextView content;
	StringBuffer stringBuffer = new StringBuffer();
	@Override
    public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.systemdata);
	tv=(TextView) findViewById(R.id.tv);
	content=(TextView) findViewById(R.id.content);
	try {
		execCommand("cat /proc/meminfo");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	tv.setText("�����ֻ��ڴ���ϸ��Ϣ��");
	content.setText("Android�豸��ǰ�����ڴ��С"+"\n"+getAvailMemory()+"\n"+stringBuffer.toString());
}
	private String getAvailMemory() {// ��ȡandroid��ǰ�����ڴ��С     
        
        ActivityManager am = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);    
        MemoryInfo mi = new MemoryInfo();    
        am.getMemoryInfo(mi);    
        //mi.availMem; ��ǰϵͳ�Ŀ����ڴ�     
    
        return Formatter.formatFileSize(getBaseContext(), mi.availMem);// ����ȡ���ڴ��С���     
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
public void execCommand(String command) throws IOException {

	Runtime runtime = Runtime.getRuntime();
	Process proc = runtime.exec(command);
	try {
		if (proc.waitFor() != 0) {
			System.err.println("exit value = " + proc.exitValue());
			
		}
		BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		
		String line = null;
		while ((line = in.readLine()) != null) {
			stringBuffer.append(line+"\n");
		}
		System.out.println(stringBuffer.toString());
		tv.setText("�����ֻ��ڴ���ϸ��Ϣ��");
		content.setText(stringBuffer.toString());
	} catch (InterruptedException e) {
		System.err.println(e);
	}
}

}
