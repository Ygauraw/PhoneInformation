package com.bq.phoneinformation;


import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class About extends Activity{
	private WebView webview; 
	@Override
	public void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.about);
	webview = (WebView) findViewById(R.id.webview); 
    //����WebView���ԣ��ܹ�ִ��Javascript�ű� 
    webview.getSettings().setJavaScriptEnabled(true); 
    //������Ҫ��ʾ����ҳ 
    webview.loadUrl("file:///android_asset/about.htm"); 
	}

}
