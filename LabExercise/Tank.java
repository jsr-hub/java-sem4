import java.awt.event.*;
import java.awt.*;
import java.applet.*;
import java.io.*;

/*<applet code="Tank" width="1000" height="1000">  
</applet> */
public class Tank extends Applet implements ActionListener,Runnable
{
	Button Start, Stop, Suspend, Resume;

	boolean suspendflag=false;
	boolean stopflag=false;
	int height =0;
	public void init()
	{
		Start=new Button("Start");
		add(Start);
		Start.addActionListener(this);
		Stop=new Button("Stop");
		add(Stop);
		Stop.addActionListener(this);
		Suspend=new Button("Suspend");
		add(Suspend);
		Suspend.addActionListener(this);
		Resume=new Button("Resume");
		add(Resume);
		Resume.addActionListener(this);
	}
	public void run()
	{
		try
		{
			while(!stopflag)
			{
				if(!suspendflag)
				{
					height+=10;
					if(height>200)
						height=0;
						repaint();
				}
				Thread.sleep(500);
			}
		} catch(Exception e)
		{
			System.out.println(e);
		}
	}

public void paint(Graphics g)
{	g.setColor(Color.RED);
	g.drawLine(100,300,300,300);
	g.drawLine(100,300,100,100);
	g.drawLine(300,300,300,100);
	g.setColor(Color.CYAN);
	g.fillRect(100, 300-height,200,height);
}
public void actionPerformed(ActionEvent ae)
{
	Thread t = new Thread(this);
	Object o;
	o=ae.getSource();
	if(o==Start)
	{
		height=0;
		stopflag=false;
		Resume.setEnabled(false);
		Stop.setEnabled(true);
		Suspend.setEnabled(true);
		t.start();
	}
	if(o==Stop)
	{
		stopflag=true;
		Resume.setEnabled(false);
		Start.setEnabled(true);
		Suspend.setEnabled(false);
	}
	if(o==Resume)
	{
		suspendflag=false;
		stopflag=false;
		Start.setEnabled(false);
		Stop.setEnabled(true);
		Suspend.setEnabled(true);
	}
	if(o==Suspend)
	{
		suspendflag=true;
		Resume.setEnabled(true);
		Start.setEnabled(false);
		Stop.setEnabled(false);
	}
}
}