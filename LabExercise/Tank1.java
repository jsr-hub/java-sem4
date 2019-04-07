import java.applet.*;
import java.awt.*;
import java.awt.event.*;
/*<applet code="Tank" width=400 height=400>
</applet>*/
public class Tank extends Applet implements Runnable, ActionListener{

	Button Start, Stop, Suspend, Resume;
	int height=0;
	boolean stopFlag=false, SuspendFlag=false;
	Thread t;
	Graphics g;
	
	public void init(){
		setLayout(new BorderLayout());
		g=this.getGraphics();
		Start = new Button("Start");
		Stop = new Button("Stop");
		Suspend = new Button("Suspend");
		Resume = new Button("Resume");
		Start.addActionListener(this);
		Stop.addActionListener(this);
		Suspend.addActionListener(this);
		Resume.addActionListener(this);
		Panel p1 = new Panel();
		p1.add(Start);
		p1.add(Stop);
		p1.add(Suspend);
		p1.add(Resume);
		add(p1, BorderLayout.SOUTH);
	}
	
	public void run(){
		synchronized(this){
		try{
			while (!stopFlag){
				if (SuspendFlag)
					wait();
				height += 10;
				if (height>200) height=0;
				repaint();
				Thread.sleep(1000);
			}
		}
		catch(InterruptedException e){e.printStackTrace();}
		}
	}
	
	public void mySuspend(){
		SuspendFlag=true;
	}
	
	synchronized public void myResume(){
		SuspendFlag=false;
		notifyAll();
	}
	
	public void actionPerformed(ActionEvent ae){
		Object o = ae.getSource();
		if (o==Start){
			t=new Thread(this);
			stopFlag=false;
			height=0;
			t.start();
		}
		if (o==Stop)
			stopFlag=true;
		if (o==Suspend)	mySuspend();
		if (o==Resume) myResume();
	}
	
	public void paint(Graphics g){
		g.drawLine(100, 300, 300, 300);
		g.drawLine(100, 300, 100, 100);
		g.drawLine(300, 300, 300, 100);
		g.setColor(Color.BLUE);
		g.fillRect(100, 300-height, 200, height);
	}
	
}
