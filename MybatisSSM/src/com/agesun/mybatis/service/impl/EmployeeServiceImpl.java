package com.agesun.mybatis.service.impl;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agesun.mybatis.bean.Employee;
import com.agesun.mybatis.dao.EmployeeMapper;
import com.agesun.mybatis.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Resource
	EmployeeMapper em;
	
	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public List<Employee> getEmps() {
		System.out.println("--------------------");
		return em.getEmps();
	}

	@Override
	public Employee getEmpById() {
		
		return em.getEmpById(1);
	}

	//��������Ա��
	@Override
	public Integer batchEmp() {
		// TODO Auto-generated method stub
	
	        //��������ִ��ǰʱ��
			long start=System.currentTimeMillis();
	
			EmployeeMapper mapper=	sqlSession.getMapper(EmployeeMapper.class);
		    for (int i = 0; i < 10000; i++) {
				mapper.addEmp(new Employee(UUID.randomUUID().toString().substring(0,5),"b","1"));
	
		    }
		    long end=  System.currentTimeMillis();
		    long time2= end-start;
		    //��������ִ�к��ʱ��
		    System.out.println("ִ��ʱ��"+time2);
		    
		    
		    System.out.println("------------------------------------------------------------");
		    
		    //��������ִ��ǰʱ��
		 			/*long start2=System.currentTimeMillis();
		 		    for (int i = 0; i < 5000; i++) {
		 		    	em.addEmp(new Employee(UUID.randomUUID().toString().substring(0,5),"b","1"));
		 	
		 		    }
		 		    long end2=  System.currentTimeMillis();
		 		    long time2= end2-start2;
		 		    //��������ִ�к��ʱ��
		 		    System.out.println("ִ��ʱ��"+time2);*/
		    
		    
		  
		    
		    
		return (int) time2;
		
	}
	

}
