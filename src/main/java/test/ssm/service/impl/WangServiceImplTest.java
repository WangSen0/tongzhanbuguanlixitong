package test.ssm.service.impl; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ssm.service.WangService;

/** 
* WangServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>九月 17, 2017</pre> 
* @version 1.0 
*/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-mybatis.xml"})
public class WangServiceImplTest {
@Autowired
    WangService wangService;
@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: list() 
* 
*/ 
@Test
public void testList() throws Exception { 
//TODO: Test goes here...
    wangService.queryById(16);
} 


} 
