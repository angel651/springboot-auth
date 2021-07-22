package cn.itsource.springboot.serivce;

import cn.itsource.springboot.ApplicationConfig;
import cn.itsource.springboot.domain.Menu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationConfig.class)
public class MenuServiceImplTest {

    @Autowired
    private IMenuService menuService;

    @Test
    public void getMenuByLoginUser() {

    }
}