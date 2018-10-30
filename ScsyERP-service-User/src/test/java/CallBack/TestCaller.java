package CallBack;

import org.junit.Test;

import java.util.Date;

public class TestCaller {
    @Test
    public void test(){
        System.out.println(new Date().getTime());
        final Button button = new Button("test");
        button.OnClick(new OnClickListener() {
            public void clickCallBack(String button_name) {
                System.out.println("In callBackMethod:"+button_name+" is on click");
            }
        });
    }
}
