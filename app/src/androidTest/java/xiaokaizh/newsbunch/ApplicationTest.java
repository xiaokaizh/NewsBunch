package xiaokaizh.newsbunch;

import android.app.Application;
import android.test.ApplicationTestCase;

import xiaokaizh.newsbunch.act.LoginActivity;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    //在测试用例执行之前调用  初始化操作
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testAddActivity(){
        assertEquals(0,MainActivity.activityList.size());
        LoginActivity loginActivity=new LoginActivity();
        MainActivity.addActivity(loginActivity);
        assertEquals(1, MainActivity.activityList.size());
        MainActivity.addActivity(loginActivity);
        assertEquals(1, MainActivity.activityList.size());
    }

    //在测试用例执行后调用 资源释放
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}