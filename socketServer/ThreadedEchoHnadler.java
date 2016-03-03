package _3_2;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class ThreadedEchoHnadler implements Runnable {

	private Socket incoming;

	public ThreadedEchoHnadler(Socket i) {
		incoming = i;//构造方法
	}

	@Override
	public void run() {
		try {
			try {
				InputStream inStream = incoming.getInputStream();//获取客户端输入流
				OutputStream outStream = incoming.getOutputStream();//获取输出流

				Scanner in = new Scanner(inStream);
				PrintWriter out = new PrintWriter(outStream, true);
				out.println("hello,enter 1 to begin");
				boolean done = false;
				while (!done && in.hasNext()) {
					String line = in.nextLine();
					out.println("Echo:" + line);
					if (line.trim().equals("2")) {
						done = true;
						System.out.println("结束");
					}
				}

			} finally {
				incoming.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
