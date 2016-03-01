package xiaokaizh.newsbunch;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 2016/3/1.
 */
public class MainApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        context=getApplicationContext();
    }

    public static Context getContext(){
        return context;
    }
}
