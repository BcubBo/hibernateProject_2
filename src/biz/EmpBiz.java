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
			result = dao.findEmp(hql.toString(),null,1,5)	;
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
				result = dao.findEmp(hql.toString(),null,3,5)	;
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
		
	
	
}//end of this class
