package com.twu;

import java.util.Scanner;

public class User  {
	static String name;
	hottopic ht = hottopic.getht();
		
	int votenum = 10;
	
	//获取用户名
	public void getname() {
		System.out.println("请输入您的昵称：");
		Scanner namesc = new Scanner(System.in);	
		String name = namesc.next();
		User.name = name;
	}
	//显示用户初始界面，并跳转到其他功能
	public void cando() {
		
		System.out.println("您好，"+User.name+"，你可以：");
		System.out.println("1.查看热搜排行榜");
		System.out.println("2.给热搜事件投票");
		System.out.println("3.购买热搜");
		System.out.println("4.添加热搜");
		System.out.println("5.退出");
		
		Scanner numsc = new Scanner(System.in);
		int num = numsc.nextInt();
		switch(num) {
			case 1:												//查看热搜排行榜
				this.ht.overview();
				this.cando();
				break;	
			case 2:												//给热搜事件投票
				this.vote();
				this.ht.htsort(this.ht.hotlist);
				this.cando();
				break;										
			case 3:												//购买热搜
				this.ht.buyhot();
				this.cando();
				break;										
			case 4:												//添加热搜
				this.ht.addnormal();
				this.ht.htsort(this.ht.hotlist);
				this.cando();
				break;			
			case 5:Main.main(null);break;						//退出
			default:
				System.out.println("请重新输入正确的选择：");
				this.cando();
		}
	}
	//投票功能是用户的功能
	public void vote() {
		//选定要投票的热搜
		System.out.println("请输入你要投票的热搜名称");
		Scanner topicsc = new Scanner(System.in);	
		String topic_chosen = topicsc.next();
		
		System.out.println("请输入你要投票的数目（目前还有:"+this.votenum+"票）");
		Scanner numsc = new Scanner(System.in);	
		int num_chosen = numsc.nextInt();
		
		if( this.votenum < num_chosen) {
			System.out.println("投票失败！");
		}else {
			//查找匹配的热搜
			ht.addhot(topic_chosen,num_chosen);
			votenum -= num_chosen;
			System.out.println("投票成功");
		}
	}

}
