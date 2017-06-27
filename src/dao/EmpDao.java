package dao;
import java.util.List;
import java.util.Map;

import common.HibernateSessionFactory;
import po.Emp;
public class EmpDao {
	
	public Long getCountOfEmps(String hql,Map<String,Object> emp){
		//select count(id) from Emp where ..... order by ...
		return (Long)HibernateSessionFactory.getSession().createQuery(hql)
				

			.setProperties(emp)
			.uniqueResult();
			//直接返回单一结果
		
		
		
		
		
		
	}
	@SuppressWarnings("unchecked")
	public List<Emp> findEmp(String hql,Map<String,Object> emp,int page,int size){
		//进行了分页相关的更改
		return HibernateSessionFactory.getSession().createQuery(hql)
			.setProperties(emp)
			.setFirstResult((page-1)*size)//分页起始设置
			.setMaxResults(size)//每页最大数量
			.list();
		
		
		
		
		
		
		
	}
	@SuppressWarnings("unchecked")
	public List<Object[]> findEmp1(String hql,Map<String,Object> emp){
		//hql参数为":"冒号的形式故使用的为setPropeties方法
		//进行了分页相关的更改
		return HibernateSessionFactory.getSession().createQuery(hql)
			.setProperties(emp)//普通对象传递
			//.setProperties(emp)//Map对象传递
			//.setFirstResult((page-1)*size)//分页起始设置
			//.setMaxResults(size)//每页最大数量
			.list();
		
		
		
		
		
		
		
	}//findEmp结尾
	
	@SuppressWarnings("unchecked")
	public List<Object> findEmp2(String hql,Map<String,Object> emp){
		//hql参数为":"冒号的形式故使用的为setPropeties方法
		//进行了分页相关的更改
		return HibernateSessionFactory.getSession().createQuery(hql)
			.setProperties(emp)//普通对象传递
			//.setProperties(emp)//Map对象传递
			//.setFirstResult((page-1)*size)//分页起始设置
			//.setMaxResults(size)//每页最大数量
			.list();
		
		
		
		
		
		
		
	}//findEmp结尾

	@SuppressWarnings("unchecked")
	public List<Emp> findEmp3(String hql,Map<String,Object> emp){
		//hql参数为":"冒号的形式故使用的为setPropeties方法
		//进行了分页相关的更改
		return HibernateSessionFactory.getSession().createQuery(hql)
			.setProperties(emp)//普通对象传递
			//.setProperties(emp)//Map对象传递
			//.setFirstResult((page-1)*size)//分页起始设置
			//.setMaxResults(size)//每页最大数量
			.list();
		
		
		
		
		
		
		
	}//findEmp3结尾
	

	
	
	
	
	
	

	
}
