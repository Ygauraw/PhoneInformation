package com.bq.phoneinformation;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.util.Log;

public class PakageInfoProvider {
	private Context context;
	private List<AppInfo> appInfos;
	private AppInfo appInfo;

	public PakageInfoProvider(Context context) {
		super();
		this.context = context;
	}

	public List<AppInfo> getAppInfo() {
		PackageManager pm = context.getPackageManager();
		List<PackageInfo> pakageinfos = pm.getInstalledPackages(PackageManager.GET_UNINSTALLED_PACKAGES);
		appInfos = new ArrayList<AppInfo>();
		for (PackageInfo packageInfo : pakageinfos) {
			appInfo = new AppInfo();
			
			//��ȡ�ַ�������
			context.getString(R.string.app_name);
			context.getResources().getString(R.string.app_name);
			//��ȡ�ߴ���Դ����
			context.getResources().getDimension(R.dimen.test);
			//��ȡxml�ļ����ҷ��ص���XmlResourceParse�࣬��̳���XmlPullParse
			XmlResourceParser xmlrp = context.getResources().getXml(R.xml.yo);
			// ��ȡӦ�ó�������ƣ����ǰ����������嵥�ļ��е�labelname
			String str_name = packageInfo.applicationInfo.loadLabel(pm).toString();
			appInfo.setAppName(str_name);

			// ��ȡӦ�ó���İ汾����
			String version = packageInfo.versionName;
			appInfo.setAppVersion(version);

			// ��ȡӦ�ó���Ŀ�ݷ�ʽͼ��
			Drawable drawable = packageInfo.applicationInfo.loadIcon(pm);
			appInfo.setDrawable(drawable);

			// ��ȡӦ�ó����Ƿ��ǵ�����Ӧ�ó���
			appInfo.setIsUserApp(filterApp(packageInfo.applicationInfo));
			
			//��һͬ�������ð���
			appInfo.setPackageName(packageInfo.packageName);

			appInfos.add(appInfo);
			appInfo = null;
		}

		return appInfos;
	}

	/**
	 * ����Ӧ�ó���Ĺ�����
	 * 
	 * @param info
	 * @return true ����Ӧ�� false ϵͳӦ��
	 */
	public boolean filterApp(ApplicationInfo info) {
		if ((info.flags & ApplicationInfo.FLAG_UPDATED_SYSTEM_APP) != 0) {
			// �������ϵͳ��Ӧ��,���Ǳ��û�������. �û�Ӧ��
			return true;
		} else if ((info.flags & ApplicationInfo.FLAG_SYSTEM) == 0) {
			// ������û���Ӧ��
			return true;
		}
		return false;
	}

}