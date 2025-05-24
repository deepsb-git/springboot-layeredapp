package com.digi;

import com.digi.controller.MainController;
import com.digi.vo.EmployeeVO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class BootDiLayerdappAutoconfigProj4Application {

	public static void main(String[] args) {


		//read inputs from enduser
		Scanner sc=new Scanner(System.in);
		System.out.println("Desgs count::");
		int count=sc.nextInt();
		String[] desgs=null;
		if(count>=1)
			desgs=new String[count];

		else {
			System.out.println("Invalid desg count");
			return;
		}

		for (int i=0;i<count;++i){
			System.out.println("enter desg"+ (i+1));
			String desg=sc.next();
			desgs[i]=desg;
		}

		//get IOC container
		ApplicationContext ctx=SpringApplication.run(BootDiLayerdappAutoconfigProj4Application.class, args);

		//get Controller class object
		MainController controller = ctx.getBean("controller", MainController.class);

		//invoke b.method

		try{
			List<EmployeeVO> listVO =controller.showEmpsByDesgs(desgs);
			System.out.println("Emp details having " + Arrays.toString(desgs));
			listVO.forEach(vo->{
				System.out.println(vo);
			});
		}//try
		catch (Exception e){
			e.printStackTrace();
			System.out.println("Some Internal problem::" + e.getMessage());
		}
		//close IOC container
		((org.springframework.context.ConfigurableApplicationContext) ctx).close();

	}

}
