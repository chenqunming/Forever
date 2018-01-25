package com.codeqm.forever.mvp.view;

import com.codeqm.forever.bean.TestBean;
import com.codeqm.forever.mvp.model.BaseModel;

/**
 * Created by chenqm on 2016/12/15.
 */
public interface MainView extends BaseView {

    void getDataSuccess(BaseModel<TestBean> model);

    void getDataFail(String msg);

}
