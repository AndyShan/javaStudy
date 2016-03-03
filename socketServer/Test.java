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
		System.out.println("开始");
		try {
			int i = 1;
			ServerSocket s = new ServerSocket(8189);
			while(true) {//循环等待客户端你的连接
				Socket incoming = s.accept();//识别到客户端的连接
				System.out.println("Spawning" + i);
				Runnable r = new ThreadedEchoHnadler(incoming);//将socket作为参数传入多线程，新建线程
				Thread t = new Thread(r);
				t.start();//开始线程
				i++;
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
