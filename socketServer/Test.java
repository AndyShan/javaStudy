package _3_2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Test {
	public static void main(String args[]) throws IOException{
		System.out.println("��ʼ");
		try {
			int i = 1;
			ServerSocket s = new ServerSocket(8189);
			while(true) {//ѭ���ȴ��ͻ����������
				Socket incoming = s.accept();//ʶ�𵽿ͻ��˵�����
				System.out.println("Spawning" + i);
				Runnable r = new ThreadedEchoHnadler(incoming);//��socket��Ϊ����������̣߳��½��߳�
				Thread t = new Thread(r);
				t.start();//��ʼ�߳�
				i++;
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
