package hongliang.com.mydouyinsuosou.model;


import java.util.List;
import hongliang.com.mydouyinsuosou.bean.ShowBean;
import hongliang.com.mydouyinsuosou.myinterface.IShowPresenter;
import hongliang.com.mydouyinsuosou.utils.IRetrofitServices;
import hongliang.com.mydouyinsuosou.utils.RetrofitUtil;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class ShowModel {

    public void receive(String retry_type, String iid, String device_id, String aid, final IShowPresenter iShowPresenter) {
        /**
         * 拼接api地址请求网络
         */
        IRetrofitServices retrofitServices = RetrofitUtil.getInstance("http://api.amemv.com/aweme/v1/").create(IRetrofitServices.class);
        retrofitServices.getLoginMsg(retry_type, iid, device_id, aid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ShowBean>() {
                    @Override
                    public void accept(ShowBean showBean) throws Exception {//解析出来的数据
                        if (showBean != null) {
                            List<ShowBean.BannerBean> banner = showBean.getBanner();
                            if (banner != null) {
                                iShowPresenter.onShowSuccess(banner);
                            } else {
                            }
                        } else {
                        }
                    }
                });
    }
}
