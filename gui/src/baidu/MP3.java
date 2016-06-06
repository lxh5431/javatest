package baidu;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
import javax.media.bean.playerbean.*; //�����Ҫ�õ�JMF

public class MP3 extends JFrame implements Runnable {
public JLabel shijian;

private JSlider sldDiameter;

public MediaPlayer soumd1;

public JButton playSound, loopSound, stopsound;

public JButton tjian, shanc, baocun, duqu;

public JPanel jp1, jp2, jp3, jp4;

public JList jl;

int zongmiao=0;

public Vector vector, mingcheng;

boolean fo = false, geshi = false;

JLabel jl1, jl2, sj1, sj2;

JTextField jt1, jt2;

JButton queding, xiugai;

int zong = 0;

int a = 0, b = 0, you = 1,mm=0;

int fenzhong, miaozhong;

public MP3() {
  super("java�����ֲ�����");
  soumd1 = new MediaPlayer();
  Container c = getContentPane();
  c.setLayout(new FlowLayout());
  mingcheng = new Vector();
  jp1 = new JPanel();
  shijian = new JLabel();
  jp1.add(shijian);
  c.add(jp1);
  playSound = new JButton("��ʼ����");
  loopSound = new JButton("ѭ������");
  stopsound = new JButton("ֹͣ����");
  jp2 = new JPanel();
  jp2.add(playSound);
  jp2.add(loopSound);
  jp2.add(stopsound);
  c.add(jp2);
  jp4 = new JPanel();
  sj1 = new JLabel();
  sj2 = new JLabel();
  sldDiameter = new JSlider(SwingConstants.HORIZONTAL, 0, 100, 0);
  sldDiameter.setMajorTickSpacing(1);
  sldDiameter.setPaintTicks(true);
  jp4.add(sj1);
  jp4.add(sldDiameter);
  jp4.add(sj2);
  c.add(jp4);
  vector = new Vector();
  jl = new JList(mingcheng);
  jl.setVisibleRowCount(5);
  jl.setFixedCellHeight(40);
  jl.setFixedCellWidth(265);
  jl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
  c.add(new JScrollPane(jl));
  tjian = new JButton("���");
  shanc = new JButton("ɾ��");
  duqu = new JButton("��ȡ");
  baocun = new JButton("����");
  jp3 = new JPanel();
  jp3.add(tjian);
  jp3.add(shanc);
  jp3.add(baocun);
  jp3.add(duqu);
  c.add(jp3);

  try {
   String s="" ;
   ObjectInputStream input = new ObjectInputStream(
     new FileInputStream(s));
   lujin a1 = (lujin) input.readObject();
   mingcheng = a1.b;
   vector = a1.a;
   jl.setListData(mingcheng);
  } catch (Exception e) {
   System.out.println("c��û�б��������ļ�");
   //e.printStackTrace();
  }

  baocun.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent event) {
    JFileChooser fileChooser = new JFileChooser(); // ʵ�����ļ�ѡ����
    fileChooser
      .setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // �����ļ�ѡ��ģʽ,�˴�Ϊ�ļ���Ŀ¼����
    if (fileChooser.showSaveDialog(MP3.this) == JFileChooser.APPROVE_OPTION) { // �����ļ�ѡ����,���ж��Ƿ����˴򿪰�ť
     String fileName = fileChooser.getSelectedFile()
       .getAbsolutePath(); // �õ�ѡ���ļ���Ŀ¼�ľ���·��
     mmm(vector, mingcheng, fileName);
    }
   }
  });
  duqu.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent event) {
    JFileChooser fileChooser = new JFileChooser(); // ʵ�����ļ�ѡ����
    fileChooser
      .setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // �����ļ�ѡ��ģʽ,�˴�Ϊ�ļ���Ŀ¼����
    if (fileChooser.showOpenDialog(MP3.this) == JFileChooser.APPROVE_OPTION) { // �����ļ�ѡ����,���ж��Ƿ����˴򿪰�ť
     String fileName = fileChooser.getSelectedFile()
       .getAbsolutePath(); // �õ�ѡ���ļ���Ŀ¼�ľ���·��
     try {
      ObjectInputStream input = new ObjectInputStream(
        new FileInputStream(fileName));
      lujin a1 = (lujin) input.readObject();
      mingcheng = a1.b;
      vector = a1.a;
      jl.setListData(mingcheng);
     } catch (Exception e) {
      e.printStackTrace();
     }
    }
   }
  });
  playSound.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    if (jl.getSelectedIndex() >= 0) {
     String yy = (String) vector.get(jl.getSelectedIndex());
     File ff = new File(yy);
     if (ff.exists()) {
      if (yy.matches("[]*.mp3")|| yy.matches("[]*.MP3")) {
       if (soumd1 != null) {
        a = 0;
        b = 0;
        you = 0;
        soumd1.stop();
       }
          soumd1.setMediaLocation("file:/" + yy);
       fo = true;
       soumd1.start();
       geshi=true;
       try {
        Thread.sleep(500);
       } catch (InterruptedException eee) {
       }
       zongmiao=(int)soumd1.getDuration().getSeconds();
       if(zongmiao>10000)
       {
        try {
         Thread.sleep(500);
        } catch (InterruptedException ew) {
        }
       zongmiao=(int)soumd1.getDuration().getSeconds();
       }
       zongmiao=(int)soumd1.getDuration().getSeconds();
       String aa=fen(zongmiao);
          sj2.setText(aa);
      } else
       JOptionPane.showMessageDialog(null,
         "�����ļ���ʽ���д�,�޷����� ����ɾ��");
     } else
      JOptionPane.showMessageDialog(null,
        "�˸����ļ��Ѿ�������,����ɾ��");
    }
    else
     JOptionPane.showMessageDialog(null, "��ѡ�������ļ�");
   }
  });
  loopSound.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    if (jl.getSelectedIndex() >= 0) {
     String yy = (String) vector.get(jl.getSelectedIndex());
     File ff = new File(yy);
     if (ff.exists()) {
      if (yy.matches("[]*.mp3")|| yy.matches("[]*.MP3")) {
       if (soumd1 != null) {
        a = 0;
        b = 0;
        you = 0;
        soumd1.stop();
       }
          soumd1.setMediaLocation("file:/" + yy);
       fo = true;
       soumd1.start();
       geshi=true;
       try {
        Thread.sleep(500);
       } catch (InterruptedException we) {
       }
       zongmiao=(int)soumd1.getDuration().getSeconds();
       if(zongmiao>10000)
       {
        try {
         Thread.sleep(500);
        } catch (InterruptedException we) {
        }
       zongmiao=(int)soumd1.getDuration().getSeconds();
       }
       zongmiao=(int)soumd1.getDuration().getSeconds();
       String aa=fen(zongmiao);
          sj2.setText(aa);
      } else
       JOptionPane.showMessageDialog(null,
         "�����ļ���ʽ���д�,�޷����� ����ɾ��");
     } else
      JOptionPane.showMessageDialog(null,
        "�˸����ļ��Ѿ�������,����ɾ��");

    }
    else
     JOptionPane.showMessageDialog(null, "��ѡ�������ļ�");
   }
  });
  stopsound.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent e) {
    a = 0;
    b = 0;
    you = 0;
    mm=0;
    geshi=false;
    fo = false;
    sldDiameter.setMaximum(100);
    sldDiameter.setValue(0);
    sj1.setText(null);
    sj2.setText(null);
    if (jl.getSelectedIndex() >= 0)
      soumd1.stop();

   }
  });
  tjian.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent event) {
    JFileChooser fileChooser = new JFileChooser(); // ʵ�����ļ�ѡ����
    fileChooser
      .setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); // �����ļ�ѡ��ģʽ,�˴�Ϊ�ļ���Ŀ¼����
    fileChooser.setCurrentDirectory(new File(".")); // �����ļ�ѡ������ǰĿ¼
    fileChooser
      .setFileFilter(new javax.swing.filechooser.FileFilter() {
       public boolean accept(File file) { // �ɽ��ܵ��ļ�����
        String name = file.getName().toLowerCase();
        return name.endsWith(".mp3")
          || file.isDirectory();
       }
       public String getDescription() { // �ļ�����
        return "�����ļ�(*.mp3)";
       }
      });
    if (fileChooser.showOpenDialog(MP3.this) == JFileChooser.APPROVE_OPTION) { // �����ļ�ѡ����,���ж��Ƿ����˴򿪰�ť
     String fileName = fileChooser.getSelectedFile()
       .getAbsolutePath(); // �õ�ѡ���ļ���Ŀ¼�ľ���·��
     vector.add(fileName);
     StringBuffer buffer = daoxu(fileName);
     mingcheng.add(buffer);
    }
   }
  });
  shanc.addActionListener(new ActionListener() {
   public void actionPerformed(ActionEvent event) {
    if (jl.getSelectedIndex() >= 0) {
     mingcheng.removeElementAt(jl.getSelectedIndex());
     vector.removeElementAt(jl.getSelectedIndex());
     jl.setListData(mingcheng);
    }
   }
  });
  jl.addMouseListener(new MouseAdapter() {
   public void mousePressed(MouseEvent event) {
    if (event.getClickCount() == 2) {
     if (jl.getSelectedIndex() >= 0) {
      String yy = (String) vector.get(jl.getSelectedIndex());
      File ff = new File(yy);
      if (ff.exists()) {
       if (yy.matches("[]*.mp3")|| yy.matches("[]*.MP3")) {
        if (soumd1 != null) {
         a = 0;
         b = 0;
         you = 0;
         soumd1.stop();
        }
           soumd1.setMediaLocation("file:/" + yy);
        fo = true;
        soumd1.start();
        geshi=true;
        try {
         Thread.sleep(500);
        } catch (InterruptedException e) {
        }
        zongmiao=(int)soumd1.getDuration().getSeconds();
        if(zongmiao>10000)
        {
         try {
          Thread.sleep(500);
         } catch (InterruptedException e) {
         }
        zongmiao=(int)soumd1.getDuration().getSeconds();
        }
        String aa=fen(zongmiao);
           sj2.setText(aa);
       } else
        JOptionPane.showMessageDialog(null,
          "�����ļ���ʽ���д�,�޷����� ����ɾ��");
      } else
       JOptionPane.showMessageDialog(null,
         "�˸����ļ��Ѿ�������,����ɾ��");

     }
    }
   if (event.isMetaDown()) {
     if (jl.getSelectedIndex() >= 0) {
      int a = jl.getSelectedIndex();
      xiugai x = new xiugai();
      jt1.setText(mingcheng.get(jl.getSelectedIndex()) + "");
      jt2.setText(vector.get(jl.getSelectedIndex()) + "");
     }
    }
   }
  });
  addWindowListener(new WindowAdapter() {
   public void windowClosing(WindowEvent e) {
    String s = "";
    mmm(vector, mingcheng, s);
    System.exit(0);
     }
  });
  setSize(300, 400);
  setVisible(true);
}

public void run() {
  while (true) {
   Date now = new Date();
   shijian.setText("��ǰʱ��: " + now.toString());
   try {
    Thread.sleep(1000);
   } catch (InterruptedException e) {
   }
   if(geshi){
   you=(int)soumd1.getMediaTime().getSeconds();
    mm =you%60;
     if(you!=0)
    if(you%60==0)
    {
     b++;
    }
     sj1.setText(b+":"+mm);
   sldDiameter.setMaximum(zongmiao);
   if(you!=zongmiao)
     sldDiameter.setValue(you);
   else {
     sldDiameter.setValue(0);
    mm=0;
       b=0;
   }
    }
  }
}

public StringBuffer daoxu(String fileName) {
  String mc = "";
  for (int i = fileName.length(); i >= 1; i--) {
   if (fileName.charAt(i - 1) == 'c')
    break;
   mc += fileName.charAt(i - 1);
  }
  StringBuffer buffer = new StringBuffer(mc);
  StringBuffer mm = buffer.reverse();
  return mm;
}

public void mmm(Vector vector, Vector mingcheng, String lujin) {
  lujin a = new lujin(vector, mingcheng);
  try {
   ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(lujin));
   output.writeObject(a);
   output.flush();
   output.close();
  } catch (Exception e) {

  }
}
public String fen(int yy) {
   fenzhong = (int) yy / 60;
   miaozhong = (int) yy % 60;
   String sss = fenzhong + ":" + miaozhong;
   return sss;
}

public static void main(String agrs[]) {
  MP3 s = new MP3();
  Thread t1 = new Thread(s);
  t1.start();
  s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}

class xiugai extends JFrame {
  public xiugai() {
   jl1 = new JLabel("�ļ���");
   jt1 = new JTextField(20);
   jl2 = new JLabel("�ļ�·��");
   jt2 = new JTextField(20);
   xiugai = new JButton("�޸�");
   Container c = getContentPane();
   c.setLayout(new GridLayout(3, 1));
   JPanel j1 = new JPanel();
   JPanel j2 = new JPanel();
   JPanel j3 = new JPanel();
   j1.add(jl1);
   j1.add(jt1);
   j2.add(jl2);
   j2.add(jt2);
   j3.add(xiugai);
   c.add(j1);
   c.add(j2);
   c.add(j3);
   xiugai.addActionListener(new ActionListener() {
    public void actionPerformed(ActionEvent event) {
     mingcheng.setElementAt(jt1.getText(), jl.getSelectedIndex());
     vector.setElementAt(jt2.getText(), jl.getSelectedIndex());
     jl.setListData(mingcheng);
     dispose();
    }
   });
   setSize(300, 120);
   setVisible(true);
  }
}
}

class lujin implements Serializable {

Vector a = new Vector();

Vector b = new Vector();

public lujin(Vector vector, Vector mingcheng) {
  a = vector;
  b = mingcheng;
}

}