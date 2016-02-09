package com.yihuan.util;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.yihuan.entity.Entity;

public class Util {
	public static Map<Long,List<Object[]>> sort4Service(List<Object[]> entity4Table){
		
		long classify=(Integer)entity4Table.get(0)[0]/10;
		Map<Long,List<Object[]>> map=new HashMap<Long,List<Object[]>>();
		List<Object[]> $entity4Table=new ArrayList<Object[]>();
		for(Object[] entity:entity4Table){
			long index=(Integer)entity[0]/10;
			if(index==classify){
				$entity4Table.add(entity);
			}else{
				map.put((Long)classify,$entity4Table);
				classify=index;
				$entity4Table=new ArrayList<Object[]>();
				$entity4Table.add(entity);
			}
		}
		map.put((Long)classify,$entity4Table);
		return map;
	}
	
	public static Map<Long,List<?>> sort4Service_E(List<?> entity4Table){
		long classify=(Integer)((Entity)entity4Table.get(0)).getClassify()%10;
		Map<Long,List<?>> map=new HashMap<Long,List<?>>();
		List $entity4Table=new ArrayList();
		
		for(int i=0;i<entity4Table.size();i++){
			Entity ents=(Entity)entity4Table.get(i);
System.out.println("classify:"+classify);
System.out.println("原类别："+ents.getClassify());
			long index=(Integer)ents.getClassify()%10;
System.out.println("个位数："+index);
			if(index==classify){
				$entity4Table.add(entity4Table.get(i));
			}else{
System.out.println("map值："+classify+" , "+$entity4Table);
				map.put((Long)classify,$entity4Table);
				classify=index;
				$entity4Table=new ArrayList<Object[]>();
				$entity4Table.add(entity4Table.get(i));
			}
		}
		map.put((Long)classify,$entity4Table);
System.out.println("完整的map："+map);
		return map;
	}
	
	public static Result_Mes setResult_Mes4Query(List<?> entity4Table){
		Result_Mes result_Mes=new Result_Mes();
		if(entity4Table==null || entity4Table.size()==0){
			result_Mes.setMessage("查询为空！");
			result_Mes.setStatus(1);
		}else{
			if(entity4Table.get(0) instanceof Object[]){
				Map<Long,List<Object[]>> map=Util.sort4Service((List<Object[]>)entity4Table);
				result_Mes.setResult_Val(map);
			}else{
				Map<Long,List<?>> map=Util.sort4Service_E(entity4Table);
				result_Mes.setResult_Val(map);
			}
			result_Mes.setStatus(0);
			result_Mes.setMessage("查询成功！");
		}
		return result_Mes;
	}
	
	public static Result_Mes setResult_Mes4Query_Entity(List<?> entity4Table){
		Result_Mes result_Mes=new Result_Mes();
		if(entity4Table==null || entity4Table.size()==0){
			result_Mes.setMessage("查询为空！");
			result_Mes.setStatus(1);
		}else{
			result_Mes.setStatus(0);
			result_Mes.setMessage("查询成功！");
			result_Mes.setResult_Val(entity4Table);
		}
		return result_Mes;
	}
	
	public static Result_Mes setResult_Mes4Error(String error,int status){
		Result_Mes result_Mes=new Result_Mes();
		result_Mes.setMessage(error);
		result_Mes.setStatus(status);
		return result_Mes;
	}
	
	public static Result_Mes setResult_MesAddVal(String error,int status,Object val){
		Result_Mes result_Mes=setResult_Mes4Error(error, status);
		result_Mes.setResult_Val(val);
		return result_Mes;
	}
	
	public static String ajaxDecode(String val){
		if(val==null){
			return val;
		}
		String str=null;
		try {
			str=URLDecoder.decode(val, "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return str;
	}
	
	public static void log2Error(String mes,Exception e){
		BaseLog.logger.error(mes+e);
		StackTraceElement[] st = e.getStackTrace();
		for(StackTraceElement el : st){
			BaseLog.logger.error(el);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(43%10);
	}
	
}
