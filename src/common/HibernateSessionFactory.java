package common;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
//为hibernate包中的类！！！

public class HibernateSessionFactory {
	
	private static Configuration cfg;
	private static SessionFactory sessionFactory;
	
	static{
		try{
		cfg = new Configuration().configure();
		sessionFactory = cfg.buildSessionFactory();
		
		}catch(HibernateException e){
			
			throw new RuntimeException("hibernate初始化失败",e);
			
			
			
		}
		
	}//
	
	
	public static Session getSession(){
		//旧版本方法 sessionFactory.openSession();
		//和线程进行了绑定，避免多用户取得同一会话，要保证唯一性
		return sessionFactory.getCurrentSession();
		
		
		
		
	}
	
}
////
