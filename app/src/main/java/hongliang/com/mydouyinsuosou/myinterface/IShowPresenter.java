package hongliang.com.mydouyinsuosou.myinterface;


import java.util.List;

import hongliang.com.mydouyinsuosou.bean.ShowBean;


public interface IShowPresenter {

    void onShowSuccess(List<ShowBean.BannerBean> banner);

    void onShowFailed();

}
