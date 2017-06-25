package test;

import java.text.DateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import biz.EmpBiz;
import po.Emp;

public class Test {
	
	
	public static void main(String[] args){
		
		EmpBiz biz = new EmpBiz();
		
		Map<String,Object> emp = new HashMap<String,Object>();
		
		/*emp.put("job", "CLERK");
		emp.put("sal", 1000.00);
		
		
		//1985-1-3 留 14:12:15 不留
		DateFormat fmt = DateFormat.getDateInstance();
		//只转换日期部分
		
		
		//DateFormat.getDateTimeInstance();
		//完整时间精确到秒
		
		
		try{
		emp.put("begin", fmt.parse("1981-4-1"));
		//emp.put("end", fmt.parse("1985-9-9"));
		}catch(Exception e){
			
			e.printStackTrace();
			
			
		}*/
		
		
		List<Emp> result = biz.findEmpByConditions(emp);
		List<Emp> resultByPage = biz.findByPage(null);
		
		for(Emp e:result){
			
			System.out.println(e.getEname());
			
			
		}
		System.out.println("--------------------------------");
		for(Emp split:resultByPage){
			
			
			System.out.println(split.getEname()+"   "+split.getDeptno()+"    "+split.getJob()+"    "+split.getComm()+"    "+split.getEmpno());
			
			
			
		}
	}
	
	
}
