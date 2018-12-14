package com.tjbool.httpwww.sparetimeapp.activity.viewstub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;

import com.tjbool.httpwww.sparetimeapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 *  参考： https://www.jianshu.com/p/175096cd89ac
 *
 *     ViewStub
 *    状态属兔切换 我们使用 显示或者隐藏 会消耗过多资源
 *     而 android.view.ViewStub，是一个大小为0 ，默认不可见的控件，
 *     只有给他设置成了View.Visible或调用了它的inflate()之后才会填充布局资源，
 *     也就是说占用资源少。所以，推荐使用viewStub
 *
 *
 *     注意： 当ViewStub被设置成可见，或者它的inflate() 方法被调用的时候，
 *                  布局资源才会被填充，然后ViewStub本身就会被填充起来的布局资源替换掉
 *
 *            inflate 方法只能被调用一次；
 *
 *            为什么 viewStub.setVisibility(View.VISIBLE) 调用多次，也不会报错呢?;
 *             因为 setVisibility 做了引用处理
 *
 *      include之 Merge
 *         <merge />标签用于减少View树的层次来优化Android的布局.
 *        <merge>根节点内的控件布局取决于<include>这个布局的父布局是哪个布局：
 *         使用场景： 父布局是帧布局时
 *                    或者线性布局
 *        那相对布局呢？
 *            应该不会使用，一般开发中，我们的布局可能会相对复杂，位置很难确定，所以在相对布局中，应该没法用
 *
 *        网络状态参考
 *           https://blog.csdn.net/gdutxiaoxu/article/details/53008266
 *           https://blog.csdn.net/qq_15807167/article/details/51792620
 *           需要实践
 *
 *
 */

public class ViewStubActivity extends AppCompatActivity {

    @BindView(R.id.text_show)
    TextView textShow;
    @BindView(R.id.text_change)
    TextView textChange;
    @BindView(R.id.text_hide)
    TextView textHide;
    @BindView(R.id.viewStub)
    ViewStub viewStub;
    @BindView(R.id.text_loading)
    TextView textLoading;

    TextView textViewEmpty;
    ImageView imageEmpty;

    private View iv_vsContent;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_stub);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.text_show,R.id.text_change,R.id.text_hide})
    public void initClick(View view){
        switch (view.getId()) {
            case R.id.text_show:
                //inflate 方法只能被调用一次，因为调用后viewStub对象就被移除了视图树，
                //           导致他的父布局为空，而inflate 父布局不为空，才可以执行里面的填充逻辑；
                // 所以，如果此时再次点击显示按钮，就会崩溃，错误信息：ViewStub must have a non-null ViewGroup viewParent；
                // 所以使用try catch ,当此处发现exception 的时候，在catch中使用setVisibility()重新显示
               try {
                    View iv_vsContent = viewStub.inflate();     //inflate 方法只能被调用一次，
                    textViewEmpty =  ButterKnife.findById(iv_vsContent,R.id.tv_empty);
                    imageEmpty = ButterKnife.findById(iv_vsContent, R.id.iv_empty);
                } catch (Exception e) {
                    viewStub.setVisibility(View.VISIBLE);
                } finally {
                    imageEmpty.setImageResource(R.mipmap.bg_no_data);
                    textViewEmpty.setText("没有相关数据，请点击加载");
                }

                /**方案二*/
               // showEmptyOrErrorView("没有相关数据，请点击加载",R.mipmap.bg_no_data);



                break;
            case R.id.text_change:
                //showEmptyOrErrorView("没网了，请检查网络",R.mipmap.bg_no_net);

                imageEmpty.setImageResource(R.mipmap.bg_no_net);
                textViewEmpty.setText("没网了，请检查网络");
                break;
            case R.id.text_hide:
                viewStub.setVisibility(View.GONE);
                break;
            default:
        }
    }


    public void showEmptyOrErrorView(String text, int img) {
        if (iv_vsContent == null){
          //  iv_vsContent = findViewById(R.id.viewStub);
            iv_vsContent =  viewStub.inflate();
        }
        iv_vsContent.setVisibility(View.VISIBLE);
        textViewEmpty =  ButterKnife.findById(iv_vsContent,R.id.tv_empty);
        textViewEmpty.setText(text);
        imageEmpty = ButterKnife.findById(iv_vsContent, R.id.iv_empty);
        imageEmpty.setImageResource(img);
    }


}
