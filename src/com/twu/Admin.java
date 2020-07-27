package com.twu;

import java.util.Scanner;

public class Admin {				//管理员可以查看热搜、添加热搜、添加超级热搜
	//这是管理员的用户名和密码
	String adname = "admin";
	String adpwd = "12345";
	hottopic ht = hottopic.getht();
	
	
	//获取用户名和密码，进行匹配
		public void name_pwd() {
			System.out.println("请输入您的昵称：");
			Scanner namesc = new Scanner(System.in);	
			String name = namesc.next();
			if(name.equals(this.adname)) {
				System.out.println("请输入管理员密码：");
				Scanner pwdsc = new Scanner(System.in);	
				String pwd = namesc.next();
				if(pwd.equals(this.adpwd)) {
					System.out.println("登录成功");
				}else {
					System.out.println("密码错误!");
					this.name_pwd();
				}
			}else {
				System.out.println("管理员的用户名错误！");
				this.name_pwd();
			}
			
		}
		//显示管理员初始界面，并跳转到其他功能
		public void cando() {
			
			System.out.println("您好，"+this.adname+"，你可以：");
			System.out.println("1.查看热搜排行榜");
			System.out.println("2.添加热搜");
			System.out.println("3.添加超级热搜");
			System.out.println("4.退出");
			
			Scanner numsc = new Scanner(System.in);
			int num = numsc.nextInt();
			switch(num) {
				case 1:												//查看热搜排行榜
					this.ht.overview();
					this.cando();
					break;	
								
				case 2:												//添加热搜
					this.ht.addnormal();
					this.cando();
					break;										
				case 3:												//添加超级热搜
					this.ht.addsuper();
					this.cando();
					break;			
				case 4:Main.main(null);break;						//退出
				default:
					System.out.println("请重新输入正确的选择：");
					this.cando();
			}
		}
}
