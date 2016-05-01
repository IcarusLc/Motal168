package javatext;

import java.awt.AWTException;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DAO.CoustomerDAO;
import DAO.LaundryListDAO;
import DAO.RoomDAO;
import DTO.CustomerDTO;
import DTO.LaundryListDTO;
import DTO.RoomDTO;


public class Main_ui extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_6;
	private JTextField textField_8;
	private JTextField textField_3;
	private JTextArea textArea;
	private TrayIcon trayIcon;//托盘图标
	private SystemTray systemTray;//系统托盘
	private static  WindowAdapter winAdap;
	public JButton[] bgroupJButtons = new JButton[80];
	public JButton[] bgroupJButtons2 = new JButton[80];
	public JButton[] bgroupJButtons3 = new JButton[100];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_ui frame = new Main_ui();
					frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
					frame.addWindowListener(winAdap);
					Image icon = Toolkit.getDefaultToolkit().getImage("Ikaros.gif");
					frame.setIconImage(icon);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param SMouseListener 
	 */

		

	
	public Main_ui() {
//		winAdap = new WindowAdapter() {
//			public void windowIconified(WindowEvent e){  
//				dispose();//窗口最小化时dispose该窗口
//			}  
//		};		
		systemTray = SystemTray.getSystemTray();//获得系统托盘的实例 
		 try {
	            trayIcon = new TrayIcon(ImageIO.read(new File("Icarus.jpg")));
	            systemTray.add(trayIcon);//设置托盘的图标，0.gif与该类文件同一目录
	        } 
		 catch (IOException e1) {e1.printStackTrace();}
	     catch (AWTException e2) {e2.printStackTrace();}
//		 this.addWindowListener(
//	                new WindowAdapter(){   
//	                    public void windowIconified(WindowEvent e){   
//	                        dispose();//窗口最小化时dispose该窗口 
//	                    }   
//	             });
//
		 trayIcon.displayMessage("通知：", "程序最小化到系统托盘", TrayIcon.MessageType.INFO);
		 trayIcon.addMouseListener(
	                new MouseAdapter(){
	                    public void mouseClicked(MouseEvent e){
	                            setExtendedState(Frame.NORMAL);
	                            setVisible(true);
	                    }
	                });       
	
         
		
		
		
		setTitle("\u5BA2\u623F\u7BA1\u7406\u7CFB\u7EDF");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1036);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("\u6DFB\u52A0\u6D88\u8D39");
		btnNewButton_1.setBounds(31, 27, 113, 27);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new change(1));
		
		
		JButton btnNewButton_2 = new JButton("\u6D88\u8D39\u660E\u7EC6");
		btnNewButton_2.setBounds(160, 27, 113, 27);
		contentPane.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new change(2));
		
		JButton btnNewButton_3 = new JButton("\u7269\u54C1\u5BC4\u5B58");
		btnNewButton_3.setBounds(304, 27, 113, 27);
		contentPane.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new change(3));
		
		JButton btnNewButton_4 = new JButton("\u7269\u54C1\u83B7\u53D6");
		btnNewButton_4.setBounds(445, 27, 113, 27);
		contentPane.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new change(4));
		

		JButton btnNewButton_5 = new JButton("\u6DFB\u52A0\u4F1A\u5458");
		btnNewButton_5.setBounds(583, 27, 113, 27);
		contentPane.add(btnNewButton_5);
		btnNewButton_5.addActionListener(new change(5));
		
		JButton btnNewButton_7 = new JButton("\u6E05\u9664\u9884\u5B9A");
		btnNewButton_7.setBounds(738, 27, 113, 27);
		contentPane.add(btnNewButton_7);
		btnNewButton_7.addActionListener(new change(7));
		
		JButton btnNewButton_8 = new JButton("\u9000\u51FA\u7CFB\u7EDF");
		btnNewButton_8.setBounds(889, 27, 113, 27);
		contentPane.add(btnNewButton_8);
		btnNewButton_8.addActionListener(new change(8));
	//TAB控件

		JPanel panel = new JPanel();
		panel.setBounds(14, 70, 2442,1845);
		JPanel panel_ = new JPanel();
		panel_.setBounds(14, 70, 2442,1845);
		JPanel panel$ = new JPanel();
		panel$.setBounds(14, 70, 2442,1845);
		
		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(8, 10, 15, 15));
		JPanel panel3 = new JPanel();
		panel3.setLayout(new GridLayout(8,10,15,15));
		JPanel panel4 = new JPanel();
		panel4.setLayout(new GridLayout(10,10,15,15));
		
		int hotelName = 1001;
		
	
		for(int i =0;i<80;i++){
			bgroupJButtons[i] = new JButton(hotelName+"");
			bgroupJButtons[i].setPreferredSize(new Dimension(130,130));
			hotelName++;
			panel2.add(bgroupJButtons[i]);
			bgroupJButtons[i].addMouseListener(new SMouseListener(i+1001));
		}
		hotelName=2001;
		for(int i =0;i<80;i++){
			bgroupJButtons2[i] = new JButton(hotelName+"");
			bgroupJButtons2[i].setPreferredSize(new Dimension(130,130));
			hotelName++;
			panel3.add(bgroupJButtons2[i]);
			bgroupJButtons2[i].addMouseListener(new SMouseListener(i+2001));
		}
		hotelName=3001;
		for(int i =0;i<100;i++){
			bgroupJButtons3[i] = new JButton(hotelName+"");
			bgroupJButtons3[i].setPreferredSize(new Dimension(130,130));
			hotelName++;
			panel4.add(bgroupJButtons3[i]);
			bgroupJButtons3[i].addMouseListener(new DMouseListener(i+3001));
		}
		Icon icon=new ImageIcon("Ikaros.gif");
		boolean[] rm = RoomDAO.Room();
		for(int i = 0;i<261;i++){
			if(i<80){
				if(rm[i])
					bgroupJButtons[i-1].setIcon(icon);
			}
			else if(i<160){
				if(rm[i])
					bgroupJButtons2[i-81].setIcon(icon);
			}
			else {
				if(rm[i])
					bgroupJButtons3[i-161].setIcon(icon);
			}
		}
		panel.add(panel2);
		panel_.add(panel3);
		panel$.add(panel4);
		
		JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setBounds(14, 60, 1500, 870);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        JScrollPane scrollPane2 = new JScrollPane(panel_);
        scrollPane2.setBounds(14, 60, 1500, 870);
        scrollPane2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        JScrollPane scrollPane3 = new JScrollPane(panel$);
        scrollPane3.setBounds(14, 60, 1500, 870);
        scrollPane3.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(14, 65, 1486, 865);
		tabbedPane_1.add(scrollPane,"单人房一层");
		tabbedPane_1.add(scrollPane2,"单人房二层");
		tabbedPane_1.add(scrollPane3,"双人房");
		contentPane.add(tabbedPane_1);
	
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(1528, 91, 360, 438);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("\u623F\u95F4\u53F7\uFF1A");
		label.setBounds(14, 13, 72, 18);
		panel_1.add(label);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(158, 10, 86, 24);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u5BA2\u6237\u59D3\u540D\uFF1A");
		label_1.setBounds(14, 57, 86, 18);
		panel_1.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setBounds(158, 54, 86, 24);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("\u8EAB\u4EFD\u8BC1\u53F7\uFF1A");
		label_2.setBounds(14, 99, 86, 18);
		panel_1.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setBounds(158, 99, 163, 24);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setBounds(158, 154, 163, 24);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel label_4 = new JLabel("\u5165\u4F4F\u65F6\u95F4\uFF1A");
		label_4.setBounds(14, 157, 86, 18);
		panel_1.add(label_4);
		
		JLabel lblNewLabel = new JLabel("\u5DF2\u4F4F\u65F6\u95F4\uFF1A");
		lblNewLabel.setBounds(14, 195, 86, 18);
		panel_1.add(lblNewLabel);
		
		textField_6 = new JTextField();
		textField_6.setEnabled(false);
		textField_6.setBounds(158, 192, 163, 24);
		panel_1.add(textField_6);
		textField_6.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u6D88\u8D39\u91D1\u989D\uFF1A");
		lblNewLabel_1.setBounds(14, 263, 86, 18);
		panel_1.add(lblNewLabel_1);
		
		textField_8 = new JTextField();
		textField_8.setEnabled(false);
		textField_8.setBounds(158, 260, 86, 24);
		panel_1.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u7528\u6237\u5907\u6CE8\uFF1A");
		lblNewLabel_2.setBounds(14, 334, 86, 18);
		panel_1.add(lblNewLabel_2);
		
		textField_3 = new JTextField();
		textField_3.setBounds(14, 366, 332, 59);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		textArea = new JTextArea();
		textArea.setRows(5);
		textArea.setBounds(1528, 577, 360, 353);
	    Font font = new Font("Serif",0,20);		
	    textArea.setFont(new Font("华文新魏", Font.PLAIN, 22));
		textArea.setText("\u914D\u6709\u7A7A\u8C03\u3001\u6DCB\u6D74\u8BBE\u5907\u300125\u82F1\u5BF8\u7ACB\u4F53\u5F69\r\n\u8272\u7535\u7F06\u7535\u89C6\u3001\u7535\u8BDD\u3001\u5B8C\u6574\u7684\u53A8\u623F\u3001\u70D8\r\n\u5E72\u673A\u3001\u5E26\u65F6\u949F\u7684\u6536\u97F3\u673A\u4EE5\u53CA\u623F\u5185\u7684\u5B89\r\n\u5168\u548C\u6025\u6551\u88C5\u5907\u3002");
		contentPane.add(textArea);
		
		JLabel label_8 = new JLabel("\u623F\u6001\u8BF4\u660E\uFF1A");
		label_8.setBounds(1528, 552, 82, 18);
		contentPane.add(label_8);
		
		

	}



//房间BUTTON监听器
	
	class  SMouseListener implements MouseListener{
		int num;
		int nnn;
		
				
		public SMouseListener(int i){
			num = i;
			if(num>3000)
				nnn = num%1000+159;
			else if (num>2000) {
				nnn = num%1000+79;
			}
			else
				nnn= num%1000;
		}
		public void mouseReleased(MouseEvent arg0) {
		}			
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseExited(MouseEvent arg0) {
		}
		public void mouseEntered(MouseEvent arg0) {
		}
		 public void mouseClicked(MouseEvent e)
          {
            int clickCount = e.getClickCount();            
            if (clickCount == 1) {
            	boolean[] rm = RoomDAO.Room();
            	if(num>3000)
    				nnn = num%1000+159;
    			else if (num>2000) {
    				nnn = num%1000+79;
    			}
    			else
    				nnn= num%1000;
            	System.out.println(nnn);
            	
            	if(rm[nnn]){
					textField.setText(num+"");
					CustomerDTO cDto = new CustomerDTO();
					cDto.setF_Num(num+"");
					cDto=CoustomerDAO.findAll(cDto);
					textField_1.setText(cDto.getF_Name());
					textField_2.setText(cDto.getF_IDNum());
					LaundryListDTO lDto = new LaundryListDTO();
					lDto.setF_Num(num+"");
					lDto = LaundryListDAO.findTP(lDto);
					lDto = LaundryListDAO.findSum(lDto);
					
				
				
					if(lDto.getF_Time() != null){
						textField_4.setText(lDto.getF_Time());
						
						SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						Date date = null;
						try {
							date = sdf.parse(lDto.getF_Time());
						} 
						catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						Date date2 = new Date(); 
						
						long startT = date.getTime();
						long endT = date2.getTime();
						
		
						long   mint=(endT-startT)/(1000);   
		                int   hor=(int)mint/3600;   
		                int   secd=(int)mint%3600/60;   
		                int   day=(int)hor/24;   
			
						textField_6.setText(day+"天" +hor+"小时" +secd + "分钟");
					}
				else{
					textField_4.setText(null);
					textField_6.setText(null);
				}
				

				textField_8.setText(lDto.getF_Money()+"");
				textField_3.setText("");
            	}	
				else{
					textField.setText(num+"");
					textField_1.setText(null);
					textField_2.setText(null);
					textField_4.setText(null);
					textField_6.setText(null);
					textField_8.setText(null);
					
				}
			}
            else if (clickCount == 2)
            {
            	Inone_ui one = new Inone_ui(num);
				one.setVisible(true);
				
				Icon icon=new ImageIcon("Ikaros.gif");
				if(num>3000){
					bgroupJButtons3[--nnn].setIcon(icon);
				}
				else if (num>2000) {
					bgroupJButtons2[--nnn].setIcon(icon);
				}
				else
					bgroupJButtons[--nnn].setIcon(icon);
			}
            }
          }

	class  DMouseListener implements MouseListener{
		int num;
		int nnn;
		public DMouseListener(int i ){
			num = i;
			nnn = i%1000+160;
		}
		public void mouseReleased(MouseEvent arg0) {
		}			
		public void mousePressed(MouseEvent arg0) {
		}
		public void mouseExited(MouseEvent arg0) {
		}
		public void mouseEntered(MouseEvent arg0) {
		}
		 public void mouseClicked(MouseEvent e)
		 {
	            int clickCount = e.getClickCount();      
	            boolean[] rm = RoomDAO.Room();
	            if(rm[nnn]){
	            if (clickCount == 1) {
					textField.setText(num+"");
					CustomerDTO cDto = new CustomerDTO();
					cDto.setF_Num(num+"");
					cDto=CoustomerDAO.findAll(cDto);
					textField_1.setText(cDto.getF_Name());
					textField_2.setText(cDto.getF_IDNum());
					LaundryListDTO lDto = new LaundryListDTO();
					lDto.setF_Num(num+"");
					lDto = LaundryListDAO.findTP(lDto);
					
					
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式				
					String dateStr =lDto.getF_Time();//数据库入住时间
					textField_4.setText(dateStr);

					long startT = 0;
					long endT = 0;
					try {
						startT = (df.parse(lDto.getF_Time())).getTime();
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					try {
						endT = (df.parse(df.format(new Date()))).getTime();
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					long   mint=(endT-startT)/(1000);   
	                int   hor=(int)mint/3600;   
	                int   secd=(int)mint%3600/60;   
	                int   day=(int)hor/24;   
		
					textField_6.setText(day+"天" +hor+"小时" +secd + "分钟");
					
					

					textField_8.setText(lDto.getF_Money()+"");
					textField_3.setText("");
					
				}
	            else {
	            	textField.setText(num+"");
					textField_1.setText(null);
					textField_2.setText(null);
					textField_4.setText(null);
					textField_6.setText(null);
					textField_8.setText(null);
				}}
	           else if (clickCount == 2)
	          {
	             Intwo_ui two = new Intwo_ui(num);
	             two.setVisible(true);
	          }
          }
	}
//上方按钮监听器
	class change implements ActionListener{
		int num;
		public change(int i ){
			num = i;	
		}
		public void actionPerformed(ActionEvent ex){
			if(num == 1){
				Other_ui a = new Other_ui();
				a.setVisible(true);
			}
			else if(num == 2){
				LaundryList_ui b = new LaundryList_ui();
				b.setVisible(true);			
			}
			else if(num == 3){
				Thingstore_ui c = new Thingstore_ui();
				c.setVisible(true);
			}
			else if(num == 4){
				Thingget_ui d = new Thingget_ui();
				d.setVisible(true);
			}
			else if(num == 5){
				Vipadd_ui e = new Vipadd_ui();
				e.setVisible(true);
			}
			else if(num == 7){
				int ifadd=JOptionPane.showConfirmDialog(null, "确认清除?", "提示",JOptionPane.YES_NO_OPTION); 
				
				
				//每天的房费
				
				
				
				
				if(ifadd==JOptionPane.YES_OPTION){
					RoomDAO rDao = new RoomDAO();
					RoomDTO rDto = new RoomDTO();
					boolean flag = rDao.Clear(rDto);
					if(flag){
						JOptionPane.showMessageDialog(null, "清除成功！");
					}
					else{
						JOptionPane.showMessageDialog(null, "已清空！");
					}
				}
				else{
				}
				  
			}
			else if(num == 8){
				int ifadd=JOptionPane.showConfirmDialog(null, "确认退出?", "提示",JOptionPane.YES_NO_OPTION); 
				if(ifadd==JOptionPane.YES_OPTION){
					System.exit(0);
				}
				else{
				}
				
			}
			else{ 
				JOptionPane.showMessageDialog(null, "意外终止");
				System.exit(0);
			}
			}
		}
}	
	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	