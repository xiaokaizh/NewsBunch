package xiaokaizh.newsbunch.Util;

import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import xiaokaizh.newsbunch.MainApplication;

/**
 * Created by Administrator on 2016/3/1.
 */
public class HttpUtil {
    public static void sendHttpRequest(final String address,final HttpCallbackListener listener){
        if (!isNetWorkAvailable()){
            Toast.makeText(MainApplication.getContext(),"网络不可用",Toast.LENGTH_SHORT).show();
            return;
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection=null;
                try {
                    URL url=new URL(address);
                    connection=(HttpURLConnection)url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    // 设置当前Url可以用于输入输出
                    connection.setReadTimeout(8000);
                    connection.setDoInput(true);

                    InputStream in=connection.getInputStream();
                    BufferedReader reader=new BufferedReader(new InputStreamReader(in));
                    StringBuilder response=new StringBuilder();
                    String line;
                    while ((line=reader.readLine())!=null){
                        response.append(line);
                    }

                    if (listener!=null){
                        //
                        listener.onFinish(response.toString());
                    }
                }catch (Exception e){

                    if (listener!=null){
                        //回调onError() 方法
                        listener.onError(e);
                    }
                }finally {
                    if (connection!=null){
                        connection.disconnect();
                    }

                }
            }
        }).start();
    }

    private static boolean isNetWorkAvailable() {
        //TODO 检测网络是否可用

        return false;
    }
}
