package xiaokaizh.newsbunch.Util;

/**
 * Created by Administrator on 2016/3/1.
 */
public interface HttpCallbackListener {
    void onFinish(String response);

    void onError(Exception e);
}
