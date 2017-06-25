package dao;
import java.util.List;

import common.HibernateSessionFactory;
import po.Emp;
public class EmpDao {

	
	@SuppressWarnings("unchecked")
	public List<Emp> findEmp(String hql,Emp emp){
		//hql参数为":"冒号的形式故使用的为setPropeties方法
		return HibernateSessionFactory.getSession().createQuery(hql)
			.setProperties(emp)
			.list()
		
		;
		
		
		
		
		
	}
	
	
	
}
