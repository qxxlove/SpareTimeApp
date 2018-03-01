package com.tjbool.httpwww.sparetimeapp.utils;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.PendingIntent;
import android.app.PendingIntent.CanceledException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.tjbool.httpwww.sparetimeapp.BaseApplication;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;



/**
 * @author txb
 * @version 1.0.0
 * @ClassName BaseUtils
 * @Description TODO(工具类)
 * @Date 2016年12月8日 下午12:01:20
 */
public class BaseUtils {
    public static BaseApplication mApplcation = BaseApplication.getApplication();





    /**
     * @param context
     * @param number
     * @param body
     * @Description (调用系统发送短信并附带短信内容)
     */
    public static void sendSmsWithBody(Context context, String number, String body) {
        Intent sendIntent = new Intent(Intent.ACTION_SENDTO);
        sendIntent.setData(Uri.parse("smsto:" + number));
        sendIntent.putExtra("sms_body", body);
        context.startActivity(sendIntent);
    }

    /**
     * @param context
     * @param phone
     * @Description (打电话)
     */
    public static void callPhone(Context context, String phone) {
        // 用intent启动拨打电话
        Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + phone));
        //context.startActivity(intent);
    }

    /**
     * @param packageName
     * @return
     * @Description (判断APK是否安装)
     */
    public static boolean checkApkExist(String packageName) {
        if (packageName == null || "".equals(packageName)) {
            return false;
        }
        try {
            ApplicationInfo info = mApplcation.getPackageManager().getApplicationInfo(packageName,
                    PackageManager.GET_UNINSTALLED_PACKAGES);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    /**
     * 根据文件名称得到Id
     *
     * @param imgName
     * @return
     */
    public static int getIdByName(String imgName, String fileName) {
        try {
            return mApplcation.getResources().getIdentifier(imgName, fileName, mApplcation.getPackageName());
        } catch (Exception e) {
            return -1;
        }
    }

    /**
     * @param name
     * @return
     * @Description (根据name得到String)
     */
    public static String getString(String name) {
        try {
            return mApplcation.getString(BaseUtils.getIdByName(name == null ? "" : name, "string"));
        } catch (Exception e) {
            return name;
        }
    }

    /**
     * @param resId
     * @return
     * @Description (根据id得到String)
     */
    public static String getString(int resId) {
        return mApplcation.getString(resId);
    }

    /**
     * 得到DrawId 根据name
     *
     * @param name
     * @return
     */
    public static int getDrawId(String name) {
        int drawId = -1;
        try {
            if (isEmpty(name)) {
                return -1;
            }
            drawId = BaseUtils.getIdByName(name, "drawable");
        } catch (Exception e) {
            drawId = -1;
        }
        return drawId;
    }

    /**
     * @param arg0
     * @return
     * @Description (判断是否为空串)
     */
    public static boolean isEmpty(String arg0) {
        return arg0 == null || arg0.trim().length() == 0;
    }




    /**
     * 判断Lists
     *
     * @return 如果包含元素返回true
     */
    @SuppressWarnings("rawtypes")
    public static boolean isListEmpty(Collection collection) {
        return !(collection == null || collection.isEmpty());
    }

    /**
     * @param view
     * @param max
     * @Description (设置最大可输入多少)
     */
    public static void setFilters(EditText view, int max) {
        InputFilter[] filters = {new InputFilter.LengthFilter(max)};
        view.setFilters(filters);
    }

    /**
     * @param context
     * @param layoutId
     * @return
     * @Description (根据布局id加载布局)
     */
    public static View inflate(Context context, int layoutId) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return inflater.inflate(layoutId, null);
    }

    /**
     * @param context
     * @return
     * @Description (获取屏幕宽度)
     */
    public static int getScreenWidth(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.widthPixels;
    }

    /**
     * @param context
     * @return
     * @Description (获取屏幕高度)
     */
    public static int getScreenHeight(Context context) {
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics outMetrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(outMetrics);
        return outMetrics.heightPixels;
    }


    public static boolean isApplicationBroughtToBackground(final Context context) {
        ActivityManager am = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        List<RunningTaskInfo> tasks = am.getRunningTasks(1);
        if (!tasks.isEmpty()) {
            ComponentName topActivity = tasks.get(0).topActivity;
            if (!topActivity.getPackageName().equals(context.getPackageName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * @return获取手机MAC地址
     */
    public static String getMac() {
        String str = "";
        String macSerial = "";
        try {
            Process pp = Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address ");
            InputStreamReader ir = new InputStreamReader(pp.getInputStream());
            LineNumberReader input = new LineNumberReader(ir);

            for (; null != str; ) {
                str = input.readLine();
                if (str != null) {
                    macSerial = str.trim();// 去空格
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (macSerial == null || "".equals(macSerial)) {
            try {
                return loadFileAsString("/sys/class/net/eth0/address").toUpperCase().substring(0, 17);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        return macSerial;
    }

    public static String loadFileAsString(String fileName) throws Exception {
        FileReader reader = new FileReader(fileName);
        String text = loadReaderAsString(reader);
        reader.close();
        return text;
    }

    public static String loadReaderAsString(Reader reader) throws Exception {
        StringBuilder builder = new StringBuilder();
        char[] buffer = new char[4096];
        int readLength = reader.read(buffer);
        while (readLength >= 0) {
            builder.append(buffer, 0, readLength);
            readLength = reader.read(buffer);
        }
        return builder.toString();
    }



    /**
     * 检查是否有网络
     */
    public static boolean isNetworkAvailable() {
        NetworkInfo info = getNetworkInfo();
        if (info != null) {
            return info.isAvailable();
        }
        return false;
    }

    /**
     * 检查是否是WIFI
     */
    public static boolean isWifi() {
        NetworkInfo info = getNetworkInfo();
        if (info != null) {
            if (info.getType() == ConnectivityManager.TYPE_WIFI) {
                return true;
            }
        }
        return false;
    }

    /**
     * 检查是否是移动网络
     */
    public static boolean isMobile() {
        NetworkInfo info = getNetworkInfo();
        if (info != null) {
            if (info.getType() == ConnectivityManager.TYPE_MOBILE) {
                return true;
            }

        }
        return false;
    }

    /**
     * 判断网络是否可用
     *
     * @return
     */
    public static boolean isNetWorkUse() {
        if (isWifi()) {
            return isWifiConnected();
        }
        if (isMobile()) {
            return isMobileConnected();
        }
        return true;
    }

    /**
     * 判断wifl是否可用
     *
     * @return
     */
    public static boolean isWifiConnected() {
        ConnectivityManager mConnectivityManager = (ConnectivityManager) mApplcation
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mWiFiNetworkInfo = mConnectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
        if (mWiFiNetworkInfo != null) {
            return mWiFiNetworkInfo.isAvailable();
        }
        return false;
    }

    /**
     * 打开网络设置界面
     */
    public static void openSetting(Activity activity) {
        Intent intent = new Intent("/");
        ComponentName cm = new ComponentName("com.android.settings", "com.android.settings.WirelessSettings");
        intent.setComponent(cm);
        intent.setAction("android.intent.action.VIEW");
        activity.startActivityForResult(intent, 0);
    }

    /**
     * 判断网络是否连接
     *
     * @return
     */
    public static boolean isConnected() {
        ConnectivityManager connectivity = (ConnectivityManager) mApplcation
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (null != connectivity) {
            NetworkInfo info = connectivity.getActiveNetworkInfo();
            if (null != info && info.isConnected()) {
                if (info.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断网络是否可用
     *
     * @return
     */
    public static boolean isMobileConnected() {
        ConnectivityManager mConnectivityManager = (ConnectivityManager) mApplcation
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo mMobileNetworkInfo = mConnectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
        if (mMobileNetworkInfo != null) {
            return mMobileNetworkInfo.isAvailable();
        }
        return false;
    }

    private static NetworkInfo getNetworkInfo() {
        ConnectivityManager cm = (ConnectivityManager) mApplcation.getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm.getActiveNetworkInfo();
    }

    public static String getSuffix(String filePath) {
        if (filePath == null) {
            return "";
        }
        String suffix = filePath.substring(filePath.lastIndexOf(".") + 1);
        return suffix;
    }



    public static int getVersionCode() {
        int versionCode = 0;
        try {
            // 获取软件版本号，对应AndroidManifest.xml下android:versionCode
            versionCode = mApplcation.getPackageManager().getPackageInfo(mApplcation.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionCode;
    }

    /**
     * Bitmap对象保存味图片文件
     */
    public static String USER_CONFIG = Environment.getExternalStorageDirectory() + "/bool";// 获取SD卡根目录

    public static File saveBitmapFile(Bitmap bitmap) {
        File file = new File(USER_CONFIG + "/phone.jpg");// 将要保存图片的路径
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bos);
            bos.flush();
            bos.close();
            return file;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * @param listView
     * @Description (高度动态设置ITEM的高度)
     */
    public static void setListViewHeightBasedOnChildren(ListView listView) {
        // 获取ListView对应的Adapter
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null) {
            // pre-condition
            return;
        }

        int totalHeight = 0;
        for (int i = 0, len = listAdapter.getCount(); i < len; i++) { // listAdapter.getCount()返回数据项的数目
            View listItem = listAdapter.getView(i, null, listView);
            listItem.measure(0, 0); // 计算子项View 的宽高
            totalHeight += listItem.getMeasuredHeight(); // 统计所有子项的总高度
        }

        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        // listView.getDividerHeight()获取子项间分隔符占用的高度
        // params.height最后得到整个ListView完整显示需要的高度
        listView.setLayoutParams(params);
    }



    /**
     * 验证手机格式 正确返回false
     */
    public static boolean isMobileNO(String mobiles) {
        /*
		 * 移动：134、135、136、137、138、139、150、151、157(TD)、158、159、187、188
		 * 联通：130、131、132、152、155、156、185、186 电信：133、153、180、189、（1349卫通）
		 * 总结起来就是第一位必定为1，第二位必定为3或5或8，其他位置的可以为0-9
		 */
        String telRegex = "[1][3456789]\\d{9}";// "[1]"代表第1位为数字1，"[3578]"代表第二位可以为3、5、8中的一个，"\\d{9}"代表后面是可以是0～9的数字，有9位。
        if (TextUtils.isEmpty(mobiles)) {
            return false;
        } else {
            return mobiles.matches(telRegex);
        }
    }



    /**
     * 判断GPS是否开启，GPS或者AGPS开启一个就认为是开启的
     *
     * @param context
     * @return true 表示开启
     */
    public static final boolean isOPen(final Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        // 通过GPS卫星定位，定位级别可以精确到街（通过24颗卫星定位，在室外和空旷的地方定位准确、速度快）
        boolean gps = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
        // 通过WLAN或移动网络(3G/2G)确定的位置（也称作AGPS，辅助GPS定位。主要用于在室内或遮盖物（建筑群或茂密的深林等）密集的地方定位）
        boolean network = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        if (gps || network) {
            return true;
        }

        return false;
    }

    /**
     * 强制帮用户打开GPS
     *
     * @param context
     */
    public static final void openGPS(Context context) {
        Intent GPSIntent = new Intent();
        GPSIntent.setClassName("com.android.settings", "com.android.settings.widget.SettingsAppWidgetProvider");
        GPSIntent.addCategory("android.intent.category.ALTERNATIVE");
        GPSIntent.setData(Uri.parse("custom:3"));
        try {
            PendingIntent.getBroadcast(context, 0, GPSIntent, 0).send();
        } catch (CanceledException e) {
            e.printStackTrace();
        }
    }

    public static String getNameByPath(String path) {
        if (path == null)
            return "";
        return path.substring(path.lastIndexOf("/") + 1, path.length());
    }

    /**
     * timeString型毫秒值转时间格式
     *
     * @param time
     * @return
     */
    public static String timet(String time) {
        SimpleDateFormat sdr = new SimpleDateFormat("yyyy-MM-dd");
        long ltime = Long.valueOf(time);
        String times = sdr.format(new Date(ltime));
        return times;

    }

    /**
     * long型毫秒转时间格式
     */
    public static String timeList(long time) {
        SimpleDateFormat sdrs = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String timeLists = sdrs.format(new Date(time));
        return timeLists;
    }

    /**
     * long型毫秒转时间格式
     */
    public static String time(long time) {
        SimpleDateFormat sdrs = new SimpleDateFormat("yyyy-MM-dd");

        String timeLists = sdrs.format(new Date(time));
        return timeLists;
    }



    public static void installApk(File file) {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        mApplcation.startActivity(intent);
    }

    public static boolean isEmojiCharacter(char codePoint) {
        return !((codePoint == 0x0) || (codePoint == 0x9) || (codePoint == 0xA) || (codePoint == 0xD)
                || ((codePoint >= 0x20) && codePoint <= 0xD7FF)) || ((codePoint >= 0xE000) && (codePoint <= 0xFFFD))
                || ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));
    }


    public static String getTime(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return format.format(date);
    }

    /**
     * 获取App具体设置的意图
     *
     * @param packageName 包名
     * @return intent
     */
    public static Intent getAppDetailsSettingsIntent(final String packageName) {
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.parse("package:" + packageName));
        return intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    }


    /**
     * 测量View的宽高
     *
     * @param view View
     */
    public static void measureWidthAndHeight(View view) {
        int widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        int heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        view.measure(widthMeasureSpec, heightMeasureSpec);
    }



      public  static  boolean compareToTime (String startTime ,String endTime){
          SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
          try {
              Date date1 = dateFormat.parse(startTime);
              Date date2 = dateFormat.parse(endTime);
              if (date2.getTime()<date1.getTime()){
                   return  false ;
              }else if (date2.getTime()==date1.getTime()){
                   return  false;
              }else if (date2.getTime()>date1.getTime()){
                  return  true;
              }
          } catch (ParseException e1) {
              e1.printStackTrace();
          }
          return  true ;
      }

    public  static  boolean compareToTimeNow (String currentTime ,String selectTime){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            Date date1 = dateFormat.parse(currentTime);
            Date date2 = dateFormat.parse(selectTime);
            if (date2.getTime()<date1.getTime()){
                return  false ;
            }else if (date2.getTime()==date1.getTime()){
                return  true;
            }else if (date2.getTime()>date1.getTime()){
                return  true;
            }
        } catch (ParseException e1) {
            e1.printStackTrace();
        }
        return  true ;
    }



    /**
     * double 相减
     * @param v1
     * @param v2
     * @return
     */
    public static Double sub(Double v1,Double v2){
        BigDecimal b1 = new BigDecimal(v1.toString());
        BigDecimal b2 = new BigDecimal(v2.toString());
        return b1.subtract(b2).doubleValue();
        }

    /**
     * 调用拨号界面
     * @param phone 电话号码
     */
    public   static void call(Context context,String phone) {
        Intent intent = new Intent(Intent.ACTION_DIAL,Uri.parse("tel:"+phone));
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
