package hongliang.com.mydouyinsuosou.presenter;
import hongliang.com.mydouyinsuosou.bean.MyDataBean;
import hongliang.com.mydouyinsuosou.model.MyDataModel;
import hongliang.com.mydouyinsuosou.myinterface.IMyDataPresenter;
import hongliang.com.mydouyinsuosou.myinterface.IMyDataView;


public class MyDataPresenter implements IMyDataPresenter {

    private IMyDataView iMyDataView;
    private final MyDataModel myDataModel;

    public MyDataPresenter(IMyDataView iMyDataView) {
        this.iMyDataView = iMyDataView;
        myDataModel = new MyDataModel();
    }
    public void receiveData(String cursor,String count,String retry_type,String iid,String device_id,String aid){
        myDataModel.receiveData(cursor,count,retry_type,iid,device_id,aid,this);
    }

    @Override
    public void getDataSuccess(MyDataBean myDataBean) {
        iMyDataView.getDataSuccess(myDataBean);
    }

    @Override
    public void getDataFailed() {

    }
}
