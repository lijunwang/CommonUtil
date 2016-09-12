package com.wlj.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import com.wlj.sort.BubbleUp;
import com.wlj.tools.XOut;

public class ReflectHelper {
	public static void main(String[] args) {
		ReflectHelper.call("com.wlj.sort.BubbleUp", "sort");
	}
	
	private void nomalReflectInvoke(){

		String className = "com.wlj.sort.BubbleUp";
		try {
			Class<?> sort = Class.forName(className);
			BubbleUp up = (BubbleUp) sort.newInstance();
			up.sort();
			
			Method test = sort.getDeclaredMethod("test");
			test.setAccessible(true);
			test.invoke(up);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			XOut.out("ClassNotFoundException ...");
		} catch (InstantiationException e) {
			e.printStackTrace();
			XOut.out("InstantiationException ...");
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			XOut.out("IllegalAccessException ...");
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			XOut.out("NoSuchMethodException ...");
		} catch (SecurityException e) {
			e.printStackTrace();
			XOut.out("SecurityException ...");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			XOut.out("IllegalArgumentException ...");
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			XOut.out("InvocationTargetException ...");
		}
	}
	
	public static void call(String className, String method, Object... args ){
		try {
			Class<?> c = Class.forName(className);
			Object o = c.newInstance();
			Method m = null;
			Method[] methods = c.getDeclaredMethods();
			for(Method mm : methods){
				XOut.out(mm.getName() + "," + mm.getParameterTypes().length + "," + args.length);
				Class<?>[] te = mm.getParameterTypes();
				for(Class<?> ct : te){
					XOut.out("\t" + ct.getName());
				}
				
				if(method.equals(mm.getName()) && args != null && args.length == mm.getParameterTypes().length){
					Class<?>[] type = mm.getParameterTypes();
					XOut.out("........ nani ........ " + mm.getName() + "," + args.length);
					boolean flag = true;
					for(int i=0; i<type.length; i++){
						XOut.out("fuck aa:" + i + "," + type[i].getName());
						XOut.out("fukc bb:"  + i + "," + args[i].getClass().getName());
						if(!isSameType(type[i].getName(), args[i].getClass().getName())){
							//we continue to compare next parameter type;
							flag = false;
							break;
						}
					}
					
					if(flag){
						XOut.out("------------aaaaaaaaaaa  find it -----------");
						m = mm;
						break;
					}
					
				}
			}
			if(m == null){
				throw new NoSuchMethodException();
			}
			m.setAccessible(true);
			m.invoke(o, args);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}
	
	private static boolean isSameType(String type1, String type2){
		ArrayList<String> list = new ArrayList<String>();
		list.add(short.class.getName());
		list.add(Short.class.getName());
		list.add("SSSS");
		
		list.add(int.class.getName());
		list.add(Integer.class.getName());
		list.add("IIII");
		
		list.add(float.class.getName());
		list.add(Float.class.getName());
		list.add("FFFF");
		
		list.add(double.class.getName());
		list.add(Double.class.getName());
		list.add("DDDD");
		
		list.add(long.class.getName());
		list.add(Long.class.getName());
		list.add("LLLL");
		
		list.add(byte.class.getName());
		list.add(Byte.class.getName());
		list.add("BBBB");
		
		list.add(char.class.getName());
		list.add(Character.class.getName());
		list.add("CCCC");
		
		
		if(type1 == null || type2 == null){
			XOut.out("should not compare null ... ");
			return false;
		}else if(Math.abs(list.indexOf(type1) - list.indexOf(type2)) == 1){
			XOut.out("hello you are the special one ... " + type1 + "," + type2);
			return true;
		}else if(type1.equals(type2)){
			return true;
		}else{
			return false;
		}
	}
}
