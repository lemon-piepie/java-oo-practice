package com.twu;

import java.util.Scanner;

public class User  {
	static String name;
	hottopic ht = hottopic.getht();
		
	int votenum = 10;
	
	//��ȡ�û���
	public void getname() {
		System.out.println("�����������ǳƣ�");
		Scanner namesc = new Scanner(System.in);	
		String name = namesc.next();
		User.name = name;
	}
	//��ʾ�û���ʼ���棬����ת����������
	public void cando() {
		
		System.out.println("���ã�"+User.name+"������ԣ�");
		System.out.println("1.�鿴�������а�");
		System.out.println("2.�������¼�ͶƱ");
		System.out.println("3.��������");
		System.out.println("4.�������");
		System.out.println("5.�˳�");
		
		Scanner numsc = new Scanner(System.in);
		int num = numsc.nextInt();
		switch(num) {
			case 1:												//�鿴�������а�
				this.ht.overview();
				this.cando();
				break;	
			case 2:												//�������¼�ͶƱ
				this.vote();
				this.ht.htsort(this.ht.hotlist);
				this.cando();
				break;										
			case 3:												//��������
				this.ht.buyhot();
				this.cando();
				break;										
			case 4:												//�������
				this.ht.addnormal();
				this.ht.htsort(this.ht.hotlist);
				this.cando();
				break;			
			case 5:Main.main(null);break;						//�˳�
			default:
				System.out.println("������������ȷ��ѡ��");
				this.cando();
		}
	}
	//ͶƱ�������û��Ĺ���
	public void vote() {
		//ѡ��ҪͶƱ������
		System.out.println("��������ҪͶƱ����������");
		Scanner topicsc = new Scanner(System.in);	
		String topic_chosen = topicsc.next();
		
		System.out.println("��������ҪͶƱ����Ŀ��Ŀǰ����:"+this.votenum+"Ʊ��");
		Scanner numsc = new Scanner(System.in);	
		int num_chosen = numsc.nextInt();
		
		if( this.votenum < num_chosen) {
			System.out.println("ͶƱʧ�ܣ�");
		}else {
			//����ƥ�������
			ht.addhot(topic_chosen,num_chosen);
			votenum -= num_chosen;
			System.out.println("ͶƱ�ɹ�");
		}
	}

}
