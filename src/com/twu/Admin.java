package com.twu;

import java.util.Scanner;

public class Admin {				//����Ա���Բ鿴���ѡ�������ѡ���ӳ�������
	//���ǹ���Ա���û���������
	String adname = "admin";
	String adpwd = "12345";
	hottopic ht = hottopic.getht();
	
	
	//��ȡ�û��������룬����ƥ��
		public void name_pwd() {
			System.out.println("�����������ǳƣ�");
			Scanner namesc = new Scanner(System.in);	
			String name = namesc.next();
			if(name.equals(this.adname)) {
				System.out.println("���������Ա���룺");
				Scanner pwdsc = new Scanner(System.in);	
				String pwd = namesc.next();
				if(pwd.equals(this.adpwd)) {
					System.out.println("��¼�ɹ�");
				}else {
					System.out.println("�������!");
					this.name_pwd();
				}
			}else {
				System.out.println("����Ա���û�������");
				this.name_pwd();
			}
			
		}
		//��ʾ����Ա��ʼ���棬����ת����������
		public void cando() {
			
			System.out.println("���ã�"+this.adname+"������ԣ�");
			System.out.println("1.�鿴�������а�");
			System.out.println("2.�������");
			System.out.println("3.��ӳ�������");
			System.out.println("4.�˳�");
			
			Scanner numsc = new Scanner(System.in);
			int num = numsc.nextInt();
			switch(num) {
				case 1:												//�鿴�������а�
					this.ht.overview();
					this.cando();
					break;	
								
				case 2:												//�������
					this.ht.addnormal();
					this.cando();
					break;										
				case 3:												//��ӳ�������
					this.ht.addsuper();
					this.cando();
					break;			
				case 4:Main.main(null);break;						//�˳�
				default:
					System.out.println("������������ȷ��ѡ��");
					this.cando();
			}
		}
}
