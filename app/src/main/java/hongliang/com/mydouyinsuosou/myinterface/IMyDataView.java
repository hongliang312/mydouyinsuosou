package hongliang.com.mydouyinsuosou.myinterface;


import hongliang.com.mydouyinsuosou.bean.MyDataBean;

public interface IMyDataView {

    void getDataSuccess(MyDataBean myDataBean);

    void getDataFailed();

}
