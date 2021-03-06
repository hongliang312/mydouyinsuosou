package hongliang.com.mydouyinsuosou.utils;



import hongliang.com.mydouyinsuosou.bean.MyDataBean;
import hongliang.com.mydouyinsuosou.bean.ShowBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IRetrofitServices {

    @GET("find/")
    Observable<ShowBean> getLoginMsg(@Query("retry_type") String retry_type, @Query("iid") String iid, @Query("device_id") String device_id, @Query("aid") String aid);


    @GET("category/list/")
    Observable<MyDataBean> getMyData(@Query("cursor") String cursor, @Query("count") String count, @Query("retry_type") String retry_type, @Query("iid") String iid, @Query("device_id") String device_id, @Query("aid") String aid);

}
