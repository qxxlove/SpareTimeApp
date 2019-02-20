package com.tjbool.httpwww.sparetimeapp.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.widget.TextView;

import com.tjbool.httpwww.sparetimeapp.R;
import com.tjbool.httpwww.sparetimeapp.base.BaseFragment;
import com.tjbool.httpwww.sparetimeapp.utils.BaseUtils;
import com.tjbool.httpwww.sparetimeapp.utils.NetWorkUtils;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import butterknife.BindView;

/**
 * description: 关注
 * autour: TMM
 * date: 2018/1/16 18:04
 * update: 2018/1/16
 * version:
 */

public class AttentionFragment extends BaseFragment {
    private static final String TAG = "AttentionFragment";
    @BindView(R.id.text_within_ip)
    TextView textWithinIp;
    @BindView(R.id.text_abroad_ip)
    TextView textAbroadIp;
    @BindView(R.id.text_time_deal)
    TextView textViewTime;
    @BindView(R.id.text_number_sort)
    TextView textViewSortNumber;
    @BindView(R.id.text_split_color)
    TextView textViewSpacingColor;
    @BindView(R.id.text_double_decimal)
    TextView textDoubleDecimal;



    public static AttentionFragment newInstance(String title) {
        AttentionFragment f = new AttentionFragment();
        Bundle args = new Bundle();
        args.putString("title", title);
        f.setArguments(args);
        return f;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        textWithinIp.setText("内网IP:" + NetWorkUtils.getWithinIp());
        //  textAbroadIp.setText("外网IP:"+NetWorkUtils.getAbraodIp());
        textAbroadIp.setText("IP:" + NetWorkUtils.getIPAddress(getActivity()));
        initTime();
        initSortNumberTwo("0,");
        initSpacingColor();
        initDecimal();
    }

    private void initDecimal() {
        String lat= "38.1234000";
        Log.e("结果",Double.parseDouble(lat)+"");
        Log.e("结果2",Double.valueOf(lat)+"");
        double one =  BaseUtils.doubleDecimalFormat(30.087900);
        double two =  BaseUtils.doubleDecimalFormat(30.123456) ;
        int  number = BaseUtils.getNumberDecimalDigits(30.087900);
        if (number <=4){
            double addNumber =  30.0879+0.000000;
            Log.e("小数",addNumber+"");
        }
        int  number1 = BaseUtils.getNumberDecimalDigits(30.123456);
        Log.e("位数",number+":"+number1);
        Log.e("结果1",one+"\n"+two);
    }

    /**
     * https://www.cnblogs.com/wzqnxd/p/9342622.html
     * 分别有 Spanned.SPAN_EXCLUSIVE_EXCLUSIVE(前后都不包括)、
     * Spanned.SPAN_INCLUSIVE_EXCLUSIVE(前面包括，后面不包括)
     * 、Spanned.SPAN_EXCLUSIVE_INCLUSIVE(前面不包括，后面包括)、
     * Spanned.SPAN_INCLUSIVE_INCLUSIVE(前后都包括)。
     */
    private void initSpacingColor() {
        String result = "本日已经行驶12345678945645645612051561561公里";
        char[] chars = result.toCharArray();
        SpannableStringBuilder builder = new SpannableStringBuilder(result);
        ForegroundColorSpan redSpan = new ForegroundColorSpan(Color.parseColor("#FF5959"));
        builder.setSpan(redSpan, 6, chars.length - 2, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        textViewSpacingColor.setText(builder);
    }

    private void initSortNumberTwo(String content) {
        //将字符串进行分割，转成字符串数组
        String[] c = content.split(",");
        Log.e("AttentionFragment:", "处理后数组的大小：" + c.length);
        int[] candidates = new int[c.length];
        for (int i = 0; i < c.length; i++) {
            //将字符串中的元素转成int数据类型并储存到int数组中去
            candidates[i] = Integer.parseInt(c[i]);
        }

        HashSet<Integer> hashSet = new HashSet<Integer>(); // 去重
        for (int i = 0; i < candidates.length; i++) {
            hashSet.add(candidates[i]);
        }
        Set<Integer> set = new TreeSet(hashSet);            // 利用TreeSet排序
        Integer[] integers = set.toArray(new Integer[]{});

        StringBuffer stringBuffer = new StringBuffer();
        String[] result = new String[integers.length];            // 我们排序、去重后的结果数组
        for (int i = 0; i < integers.length; i++) {
            result[i] = integers[i].intValue() + "";
            if (i == integers.length - 1) {
                stringBuffer.append(result[i]);
                break;
            }
            stringBuffer.append(result[i] + ",");
        }

        textViewSortNumber.setText(stringBuffer.toString().trim());
    }


    /**
     * 时间格式处理
     */
    private void initTime() {
        String currentTime = BaseUtils.timeList(System.currentTimeMillis());
        if (!BaseUtils.isEmpty(currentTime)) {
            String resultTime[] = currentTime.split(" ");
            String finalResult = resultTime[0] + "20%" + resultTime[1];
            textViewTime.setText(finalResult);
        }

    }


    @Override
    protected void initView() {

    }

    @Override
    public int setFragmentLayoutID() {
        return R.layout.fragment_attention;
    }

    @Override
    protected void lazyLoadData() {
        super.lazyLoadData();
        if (isViewCreated) {
            Log.e(getClass().getSimpleName(), "AttentionFragment 的 lazyLoadData");
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.e(TAG, "AttentionFragment 的onHiddenChanged = " + hidden);
    }




    @Override
    public void onDestroyView() {
        super.onDestroyView();
      
    }
}
