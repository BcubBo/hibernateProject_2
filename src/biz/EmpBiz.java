package biz;

import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Transaction;

import common.HibernateSessionFactory;
import dao.EmpDao;
import po.Emp;

public class EmpBiz {
	private EmpDao dao = new EmpDao();
	public List<Emp>findEmpByConditions(Map<String,Object> emp){
		
		/*StringBuilder hql = new StringBuilder("from Emp e where 1=1");
		
		if(emp != null){
			
			
			if(emp.get("job")!=null){
				
				
				hql.append(" and e.job = :job");
				
				
			}
			if(emp.get("sal") != null){
				
				hql.append(" and e.sal = :sal");
				
			}
			
			if(emp.get("begin") != null){
				
				hql.append(" and e.hiredate > :begin");
				
				
			}
			
			if(emp.get("end") != null){
				
				hql.append(" and e.hiredate < :end");
				
				
				
			}
			//内层值非空判断
			
		}//外层emp非空判断
*/		StringBuilder hql = new StringBuilder("from Emp e");

		if(emp != null){
			
			boolean isFirst = true;
			if(emp.get("job")!=null){
				
				if(isFirst){
					
					hql.append(" where ");
					
					isFirst = false;
				}else{
					
					hql.append(" and ");
					
				}//内层判断起始位置
				hql.append("e.job = :job");
			}
			
			if(emp.get("sal")!=null){
				if(isFirst){
					
					hql.append(" where ");
					
					isFirst = false;
				}else{
					
					hql.append(" and ");
					
				}
				hql.append("e.sal > :sal");
				
			}
			if(emp.get("begin")!=null){
				if(isFirst){
					
					hql.append(" where ");
					
					isFirst = false;
				}else{
					
					hql.append(" and ");
					
				}
				
				hql.append("e.hiredate > :begin");
				
				
			}
			
			if(emp.get("end")!=null){
				if(isFirst){
					
					hql.append(" where ");
					
					isFirst = false;
				}else{
					
					hql.append(" and ");
					
				}				
				
				hql.append("e.hiredate < :end");
				
				
			}
		}
		Transaction tx = null;
		
		
		List<Emp> result = null;
		
		
		try{
			tx = HibernateSessionFactory.getSession().beginTransaction();
			result = dao.findEmp(hql.toString(),emp,1,5)	;
			//进行了分页操作
			
						tx.commit();
		}catch(HibernateException e){
			
			
			e.printStackTrace();
			
			if(tx !=null){
				
				
				tx.rollback();
				
			}
		}
		
		return result;
		
	}//方法findEmpByConditions结尾
	
	public List<Emp>findByPage(Map<String,Object> emp){
		StringBuilder hql = new StringBuilder("from Emp e");		
		if(emp != null){
					
					boolean isFirst = true;
					if(emp.get("job")!=null){
						
						if(isFirst){
							
							hql.append(" where ");
							
							isFirst = false;
						}else{
							
							hql.append(" and ");
							
						}//内层判断起始位置
						hql.append("e.job = :job");
					}
					
					if(emp.get("sal")!=null){
						if(isFirst){
							
							hql.append(" where ");
							
							isFirst = false;
						}else{
							
							hql.append(" and ");
							
						}
						hql.append("e.sal > :sal");
						
					}
					if(emp.get("begin")!=null){
						if(isFirst){
							
							hql.append(" where ");
							
							isFirst = false;
						}else{
							
							hql.append(" and ");
							
						}
						
						hql.append("e.hiredate > :begin");
						
						
					}
					
					if(emp.get("end")!=null){
						if(isFirst){
							
							hql.append(" where ");
							
							isFirst = false;
						}else{
							
							hql.append(" and ");
							
						}				
						
						hql.append("e.hiredate < :end");
						
						
					}
				}
			
	
			
			Transaction tx = null;
			
			
			List<Emp> result = null;
			
			
			try{
				tx = HibernateSessionFactory.getSession().beginTransaction();
				//hql.insert(0, "select count(id) ");或者时此种方法进行插入但是小心语句间的关联	
				result = dao.findEmp(hql.toString(), emp,1,5);
				
				hql.insert(0, "select count(id) ");
				int count = dao.getCountOfEmps(hql.toString(),emp).intValue();
				
				
				System.out.println("总共:"+count+" 条记录");
				//(count + size -1)/size
				//count % size ==0  or count % size != 0 +1
				//进行了分页操作
				
				tx.commit();
			}catch(HibernateException e){
				
				
				e.printStackTrace();
				
				if(tx !=null){
					
					
					tx.rollback();
					
				}
			}
			
			return result;
			
		}//方法findByPage结尾
		
	public List<Object[]> findTest1(){

			
	
			
			Transaction tx = null;
			
			
			List<Object[]> result = null;
			
			
			try{
				tx = HibernateSessionFactory.getSession().beginTransaction();
			
				String hql = "select e.ename,e.job from Emp e ";//where name = like :name";
				result = dao.findEmp1(hql, null);
				tx.commit();
			}catch(HibernateException e){
				
				
				e.printStackTrace();
				
				if(tx !=null){
					
					
					tx.rollback();
					
				}
			}
			
		return result;
	}//findTest1结尾
	public List<Object> findTest2(){

		
		
		
		Transaction tx = null;
		
		
		List<Object> result = null;
		
		
		try{
			tx = HibernateSessionFactory.getSession().beginTransaction();
		
			String hql = "select e.ename from Emp e ";//where name = like :name";
			result = dao.findEmp2(hql, null);
			tx.commit();
		}catch(HibernateException e){
			
			
			e.printStackTrace();
			
			if(tx !=null){
				
				
				tx.rollback();
				
			}
		}
		
	return result;
	}//findTest2结尾
	
	
	
	
	
	public List<Emp> findTest3(){

		
		
		
		Transaction tx = null;
		
		
		List<Emp> result = null;
		
		
		try{
			tx = HibernateSessionFactory.getSession().beginTransaction();
		
			String hql = "select new Emp(e.ename,e.job) from Emp e ";//where name = like :name";
			result = dao.findEmp3(hql, null);
			tx.commit();
		}catch(HibernateException e){
			
			
			e.printStackTrace();
			
			if(tx !=null){
				
				
				tx.rollback();
				
			}
		}
		
	return result;
	}//findTest3结尾
	
	
	
	
	
}//end of this class
