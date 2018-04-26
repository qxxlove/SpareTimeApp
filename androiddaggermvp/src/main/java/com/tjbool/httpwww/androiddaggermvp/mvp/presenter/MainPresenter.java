package com.tjbool.httpwww.androiddaggermvp.mvp.presenter;

import com.tjbool.httpwww.androiddaggermvp.mvp.contract.MainContract;
import com.tjbool.httpwww.androiddaggermvp.mvp.model.MainModel;
import com.tjbool.httpwww.androiddaggermvp.mvp.view.MainActivity;

import javax.inject.Inject;

/**
 * 描述 ：
 * 作者：Created by SEELE on 2018/4/26.
 * 邮箱：123123@163.com
 */

public class MainPresenter  implements MainContract.Presenter {

    private final MainActivity view;
    private final MainModel model;

    @Inject
    public MainPresenter(MainActivity view, MainModel model) {
        this.view = view;
        this.model = model;
    }

    public void requestHttp() {
        view.onGetMessage(model.requestMessage());
    }


}
