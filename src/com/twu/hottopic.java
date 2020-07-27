package com.twu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

final public class hottopic {
	public int num;			//热搜排名
	public String topic;	//热搜名称
	public int votenum;		//热搜热度
	public boolean type;	//普通热搜0还是超级热搜1
	public int usemoney;	//购买热搜使用的金额
	
	List<hottopic> hotlist = new ArrayList<hottopic>();		//存放热搜排行榜的ArrayList
	
	private hottopic() {
		// TODO Auto-generated constructor stub
	}
	private static hottopic ht = new hottopic();
	public static hottopic getht() {
		return ht;
	}

	
	private hottopic(String next_topic) {
		// 有参构造函数
		this.num = 1;
		this.topic = next_topic;
		this.votenum = 0;
		this.type = false;
		this.usemoney = 0;
	}

	//添加普通热搜
	public hottopic addnormal() {
		System.out.println("请添加热搜名称：");
		Scanner sc = new Scanner(System.in);
		String topic = sc.next();
		System.out.println("添加成功！");
		//创建一个新热搜
		hottopic newadd = new hottopic(topic);
		//将热搜添加到热搜排行榜中
		this.hotlist.add(newadd);	
		return newadd;
	}
	//添加超级热搜，该hottopic的type为超级热搜
	public hottopic addsuper() {
		System.out.println("请添加热搜名称：");
		Scanner sc = new Scanner(System.in);
		String topic = sc.next();
		System.out.println("添加成功！");
		//创建一个新热搜
		hottopic newadd = new hottopic(topic);
		newadd.type = true;
		//将热搜添加到热搜排行榜中
		this.hotlist.add(newadd);	
		return newadd;
	}
	
	//增加热度
	public void addhot(String topic, int i) {
		for(int j = 0; j < this.hotlist.size(); j++) {
			if(this.hotlist.get(j).topic.equals(topic)) {
				hottopic reset = new hottopic();
				reset = this.hotlist.get(j);
				if(this.hotlist.get(j).type) {
					reset.votenum = reset.votenum + 2*i;
				}else {
					reset.votenum += i;
				}
				this.hotlist.set(j,reset);
			}
		}
	}
	
	//热搜排序
	public void htsort(List<hottopic> list){
		  Collections.sort(list, new Comparator<Object>(){
			  public int compare(Object o1, Object o2) {
				  hottopic ht1 = (hottopic)o1;
				  hottopic ht2 = (hottopic)o2;
				  if(ht1.votenum > ht2.votenum) {
					  return -1;
				  }else if(ht1.votenum == ht2.votenum) {
					  return 0;
				  }else {
					  return 1;
				  }
			  }
		  });
	}
	//购买热搜
	public void buyhot() {
		System.out.println("请输入要购买的热搜：");
		Scanner buytopicsc = new Scanner(System.in);
		String target = buytopicsc.next();
		
		for(int j = 0; j < this.hotlist.size(); j++) {
			if(this.hotlist.get(j).topic.equals(target)) {
				System.out.println("您想购买到第几位：");
				Scanner numsc = new Scanner(System.in);
				int targetnum = (numsc.nextInt()-1);
				//购买金额
				System.out.println("请输入购买的金额：");
				Scanner moneysc = new Scanner(System.in);
				int money = moneysc.nextInt();
				if(this.hotlist.get(targetnum).usemoney == 0) {		//现有目标位置的热搜并不是购买的热搜
					//将指定热搜插入到目标位置
					System.out.println("购买成功！");
					this.hotlist.add(targetnum,this.hotlist.get(j));
					this.hotlist.remove(j+1);
					this.hotlist.get(j).usemoney = money;
					break;
				}else {												//开始竞拍
					if(this.hotlist.get(targetnum).usemoney >= money) {
						System.out.println("竞拍失败，价格不足以购买该热搜位置！");
						this.buyhot();
					}else {											//竞拍成功后热搜取代，旧热搜删除
						System.out.println("恭喜，竞拍成功，购买成功！");
						this.hotlist.remove(targetnum);
						this.hotlist.add(targetnum,this.hotlist.get(j));
						this.hotlist.get(j).usemoney = money;
						break;
					}
				}
			}
		}
	}
	

	//查看热搜排行榜
	public void overview() {
		// TODO Auto-generated method stub
		for (int i = 0; i < this.hotlist.size(); i++) {
			String show = new String();
			show = (i+1)+"."+this.hotlist.get(i).topic+"热度"+this.hotlist.get(i).votenum;
            System.out.println(show);
        }
	}
	
}
