package test.ssm.service.impl; 

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ssm.entity.User;
import ssm.service.PersonService;
import ssm.service.TestService;
import ssm.service.UserService;
import ssm.service.WangService;

import javax.resource.spi.ConfigProperty;

import java.util.List;

import static com.sun.xml.internal.ws.dump.LoggingDumpTube.Position.Before;

/** 
* UserServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 14, 2017</pre> 
* @version 1.0 
*/

public class UserServiceImplTest extends AbstractTestCase{
    private static Logger logger = Logger.getLogger(UserServiceImplTest.class);
    @Autowired
    UserService userService;
    @Autowired
    TestService testService;
    @Autowired
    WangService wangService;
@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

@Test
public void testNewUser() throws Exception { 
User user=new User();
user.setName("19920914");
user.setPassword("19920914");
int i=userService.newUser(user);
} 

@Test
public void testDelById() throws Exception { 
int id=2;
userService.delById(id);
} 

@Test
public void testListAllPerson() throws Exception { 
 List<User> list= userService.listAllPerson();
} 

@Test
public void testQueryById() throws Exception { 
//User user=userService.queryById(16);
wangService.queryById(16);
//logger.info(JSON.toJSONString(user));
} 

@Test
public void testUpdate() throws Exception {

    User user=new User();
    user.setName("wangsen");
    user.setPassword("123456");
    user.setId(2);
    userService.update(user);
}
@Test
public void testQueryByNameAndPassword()throws Exception{
    User user=new User();
    user=userService.queryByNameAndPassword("345","345");
    logger.info(user.toString());
}
@Test
    public void testQueryByName()throws Exception{

        //wangService.queryById(16);

    User user=userService.queryByName("345");
}
} 
