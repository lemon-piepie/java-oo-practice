package com.twu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
		
    public static void main(String[] args) {
    	
    	
    	System.out.println("��ӭ�����������а����ǣ�");
    	System.out.println("1.�û�");
    	System.out.println("2.����Ա");
    	System.out.println("3.�˳�");
    	
    	Scanner sc = new Scanner(System.in);
    	int input = sc.nextInt();
    	
    	User user = new User();
    	Admin admin = new Admin();
    	    	   	
    	if(input == 1) {
    		user.getname();
    		user.cando();
    		
    	}else if(input == 2) {
    		admin.name_pwd();
    		admin.cando();
    	}else if(input == 3) {
    		System.exit(0);
    	}else {
    		System.out.println("������������ȷѡ��!");
    		Main.main(null);
    	}
    }
}
