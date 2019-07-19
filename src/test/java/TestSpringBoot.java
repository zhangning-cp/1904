import com.xcy.MySpringBoot;
import com.xcy.pojo.User;
import com.xcy.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = MySpringBoot.class)
public class TestSpringBoot {

    @Autowired
    UserService userService;

    @Test
    public void testSelectUser(){
        List<User> allUser = userService.getAllUser();
        System.out.println(allUser);
    }
}
