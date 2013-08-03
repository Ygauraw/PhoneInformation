package com.bq.phoneinformation;

import java.util.ArrayList;
import java.util.HashMap;

import android.app.ActivityGroup;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class MainActivity extends ActivityGroup{
	SlidingMenuView slidingMenuView;
	ViewGroup tabcontent;
	private ListView lv;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        lv=(ListView) findViewById(R.id.lv);

        ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> map1 = new HashMap<String, String>();
        HashMap<String, String> map2 = new HashMap<String, String>();
        HashMap<String, String> map3 = new HashMap<String, String>();
        HashMap<String, String> map4 = new HashMap<String, String>();
        HashMap<String, String> map5 = new HashMap<String, String>();
        HashMap<String, String> map6 = new HashMap<String, String>();
        HashMap<String, String> map7 = new HashMap<String, String>();
        HashMap<String, String> map9 = new HashMap<String, String>();
        map1.put("title", "ϵͳ��Ϣ");
        map1.put("data", "ϵͳ�汾����Ӫ�̼�ϵͳ��Ϣ");
        map2.put("title", "Ӳ����Ϣ");
        map2.put("data", "CPU���ڴ��Ӳ����Ϣ");
        map3.put("title", "�������");
        map3.put("data", "�Ѱ�װ�������ϵͳ���");        
        map4.put("title", "����ʱ��Ϣ");
        map4.put("data", "�������еġ�����");        
        map5.put("title", "�ļ����");
        map5.put("data", "�ṩһ���ļ�����Ĺ���");
        map6.put("title", "�ֻ�");
        map6.put("data", android.os.Build.MODEL);
        map7.put("title", "����ϵͳ�汾");
        map7.put("data", android.os.Build.VERSION.RELEASE);
        map9.put("title", "����ʱ��");
        map9.put("data", getTimes());
        
        
        list.add(map1);
        list.add(map2);
        list.add(map3);
        list.add(map4);
        list.add(map5);
        list.add(map6);
        list.add(map7);
        list.add(map9);
        
        SimpleAdapter listAdapter = new SimpleAdapter(this, list,
				R.layout.item, new String[] { "title", "data" }, new int[] {
						R.id.title, R.id.data });	
		lv.setAdapter(listAdapter);
		lv.setCacheColorHint(0);
		lv.setOnItemClickListener(new MyClickListener());
		
	}
   
	public class MyClickListener implements OnItemClickListener {

		public void onItemClick(AdapterView<?> aV, View v, int p,
				long l) {
			Intent intent = new Intent();
			switch(p){
			case 0:{
			intent.setClass(MainActivity.this, SystemData.class);
			startActivity(intent);
			overridePendingTransition(R.anim.fade, R.anim.hold);
			finish();
			break;
			}
			case 1:{
				intent.setClass(MainActivity.this, HardWare.class);
				startActivity(intent);
				overridePendingTransition(R.anim.fade, R.anim.hold);
				finish();
				break;
				}
			
			case 2:{
				intent.setClass(MainActivity.this, GetappinfoActivity.class);
				startActivity(intent);
				overridePendingTransition(R.anim.fade, R.anim.hold);
				finish();
				break;
				}
			case 3:{
				intent.setClass(MainActivity.this, NowRunning.class);
				startActivity(intent);
				overridePendingTransition(R.anim.fade, R.anim.hold);
				finish();
				break;
				}
			case 4:{
				intent.setClass(MainActivity.this,com.android.FileBrowser.Main.class);
				startActivity(intent);
				overridePendingTransition(R.anim.fade, R.anim.hold);
				finish();
				break;
				}
			
			}		
		}
		
	}
        
	private String getTimes() {  
	    long ut = SystemClock.elapsedRealtime() / 1000;  
	    if (ut == 0) {  
	        ut = 1;  
	    }  
	    int m = (int) ((ut / 60) % 60);  
	    int h = (int) ((ut / 3600));  
	    return h + " " + "Сʱ" + m+"��";
	}
	 
	public void about() {
		new AlertDialog.Builder(MainActivity.this)
				.setTitle("���ڿ�����")
				.setMessage("��ӭ��ʹ��СQϵͳ��Ϣv1.0��\n     Designed by����ǿ")
				.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int whichButton) {
						// finish();
					}
				})
				.setNegativeButton("����", new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {

					}

				}).show();
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
