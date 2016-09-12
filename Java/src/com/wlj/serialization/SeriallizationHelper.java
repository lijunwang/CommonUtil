package com.wlj.serialization;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.wlj.tools.XOut;

public class SeriallizationHelper {
	
	public static boolean serialization(Object obj, String savePath){
		File saveFile = new File(savePath, obj.getClass().getSimpleName() + "_" + System.currentTimeMillis());
		FileOutputStream fos = null;
		ObjectOutputStream oos = null;
		try {
			fos = new FileOutputStream(saveFile);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(obj);
		} catch (FileNotFoundException e) {
			XOut.out("FileNotFoundException ... " + e.getMessage());
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			XOut.out("IOException ... " + e.getMessage());
			return false;
		}finally{
			try {
				if(fos != null){
					fos.close();
				}
				if(fos != null){
					fos.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return true;
	}
	
	public static Object deSerialization(File serializedFile){
		FileInputStream fis = null;
		ObjectInputStream ois = null;
		try {
		    fis = new FileInputStream(serializedFile);
		    ois = new ObjectInputStream(fis);
		    return ois.readObject();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			XOut.out("FileNotFoundException ... " + e);
		} catch (IOException e) {
			e.printStackTrace();
			XOut.out("IOException ... " + e);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			XOut.out("ClassNotFoundException ... " + e);
		}finally{
			try {
				if(fis != null){
					fis.close();
				}
				
				if(ois != null){
					ois.close();
				}
			} catch (Exception e2) {
			}
		}
		
		return null;
	}
	public static void main(String[] args) {
		Student ss = new Student();
//		boolean result = SeriallizationHelper.serialization(ss, "D:\\mtk");
//		XOut.out("result :" + result);
		
		Student s2 = (Student) SeriallizationHelper.deSerialization(new File("D:\\mtk\\Student"));
		System.out.println(s2);
	}
}
