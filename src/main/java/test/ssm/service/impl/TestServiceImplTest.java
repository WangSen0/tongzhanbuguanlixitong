package test.ssm.service.impl; 

import org.junit.Test; 
import org.junit.Before; 
import org.junit.After;
import org.springframework.beans.factory.annotation.Autowired;
import ssm.mapper.TestMapper;

/** 
* TestServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>九月 17, 2017</pre> 
* @version 1.0 
*/ 
public class TestServiceImplTest extends  AbstractTestCase {
@Autowired
    TestMapper testMapper;

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
    testMapper.list();
//TODO: Test goes here... 
} 


} 
