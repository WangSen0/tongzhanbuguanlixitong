package test.ssm.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ssm.entity.InformationCondition;
import ssm.entity.Person;
import ssm.service.PersonInformationService;

import java.util.List;

/**
 * 职责
 *
 * @author wangsen
 * @time 2017/12/15
 */
public class Information extends AbstractTestCase {
    @Autowired
    PersonInformationService personInformationService;
    @Test
    public void test(){
        InformationCondition informationCondition=new InformationCondition();
        informationCondition.setName("安载鹤");
        int count=0;
        try{
            count=personInformationService.queryCountByCondition(informationCondition,0,100);
        }catch (Exception e){
            System.out.println(e.toString());
        }
    }
}
