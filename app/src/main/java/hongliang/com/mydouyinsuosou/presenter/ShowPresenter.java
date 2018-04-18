package hongliang.com.mydouyinsuosou.presenter;


import java.util.List;

import hongliang.com.mydouyinsuosou.bean.ShowBean;
import hongliang.com.mydouyinsuosou.model.ShowModel;
import hongliang.com.mydouyinsuosou.myinterface.IShowPresenter;
import hongliang.com.mydouyinsuosou.myinterface.IShowView;


public class ShowPresenter implements IShowPresenter {

    private ShowModel showModel;
    private IShowView iShowView;

    public ShowPresenter(IShowView iShowView) {
        showModel = new ShowModel();
        this.iShowView = iShowView;
    }

    public void receive(String retry_type, String iid, String device_id, String aid){
        showModel.receive(retry_type,iid,device_id,aid,this);
    }

    @Override
    public void onShowSuccess(List<ShowBean.BannerBean> banner) {
        iShowView.onShowSuccess(banner);
    }

    @Override
    public void onShowFailed() {

    }


}
