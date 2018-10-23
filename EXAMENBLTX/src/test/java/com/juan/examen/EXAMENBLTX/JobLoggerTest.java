package com.juan.examen.EXAMENBLTX;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.Before;
import org.junit.AfterClass;
import org.junit.After;
import com.juan.examen.EXAMENBLTX.JobLogger;

public class JobLoggerTest {

		 
	 @BeforeClass
	 public static void beforeClass() {
		System.out.println("Antes de todas");
		JobLogger jobLogger = new JobLogger(false,true,false,false,false,false);
	 	try {
	 		
			jobLogger.LogMessage("prueba test");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	 }
	 
	 @Before
	 public void before() {
	 System.out.println("Antes de cada una");
	 }
	 
	 @Test
	 public void isGreaterTest() {
	 System.out.println("La Prueba");
	 
	 File af = new File("File.log");
	 
	 assertTrue("Si existe el archivo", af.exists());
	 }
	 
	 @After
	 public void after() {
	 System.out.println("Despues de cada una");
	 }
	 
	 @AfterClass
	 public static void afterClass() {
	 System.out.println("Despues de todas");
	 }

}
