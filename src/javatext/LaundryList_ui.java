package javatext;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DAO.LaundryListDAO;
import DBUtil.MyTableLaundryList;

public class LaundryList_ui extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private ArrayList list=null;
	private MyTableLaundryList tableModel;
	private LaundryListDAO line;
	private JScrollPane scrollPane;
	private String Room;
	private JTextField Ps;
	JButton button,button_2,button_1 ;
	private JScrollPane scrollPane_1;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LaundryList_ui frame = new LaundryList_ui();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LaundryList_ui() {
		setTitle("\u6D88\u8D39\u8BB0\u5F55");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 572, 439);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		scrollPane=new JScrollPane();
		scrollPane.setBounds(30, 61, 500, 260);
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(53, 65, 493, 231);
		contentPane.add(scrollPane_1);
		
		
		table = new JTable(10,6);
		
		 line=new LaundryListDAO();
		//��ʾ�Ǳ��
		 line = new LaundryListDAO();
			
	        list = line.LaundryRoom(null);// ����������õ�ʱ����Nul  �������϶����еģ���Ϊ���ѯ�ļ�¼��0�У����Իᱨ��ָ���쳣
	      //  JOptionPane.showMessageDialog(null, list.size());
	        //��������������жϣ���Ϊһ��ʼ����û����������ģ����Կ϶���null
	        
	            int rows=list.size();	//��Ϊlist��ʵ��null null��û��.size������
	            
	            table = new JTable(rows,6);
	    		table.setBounds(0, 0, 439, 231);
//	            
	    		tableModel=new MyTableLaundryList(list);		
	    	//	list.settitle= new String[]{"����", "�����", "��������", "���ѽ��", "����ʱ��","״̬"};
	    		table.setModel(tableModel);
//	    		
	    		table.setRowHeight(20);
	        
	    		//��������ӹ�����
	          
	         // //�����ʲô��.... �������ʾ�������������������������ĸ߶ȣ��ͻ���ֹ�����
	        //  table.setShowHorizontalLines(true);
	    		scrollPane_1.add(table);
	    		scrollPane_1.setViewportView(table);
	    		//scrollBar.add(table);
	    			//scrollPane_1.add(scrollBar);
	    		
	          
	   		   table.setVisible(true);
	        
	   		
			
		
		//��������ʲô��С��
	
		 button = new JButton("\u9000\u623F");
		 button.setBounds(143, 367, 93, 23);
		contentPane.add(button);
		
		 button_1 = new JButton("\u53D6\u6D88");
		 button_1.setBounds(319, 367, 93, 23);
		contentPane.add(button_1);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(147, 17, 152, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		 button_2 = new JButton("\u786E\u5B9A");
		button_2.setBounds(329, 16, 93, 23);
		contentPane.add(button_2);
		
		JLabel label = new JLabel("\u623F\u95F4\u540D");
		label.setBounds(85, 20, 54, 15);
		contentPane.add(label);

		
		
		
		JLabel label_1 = new JLabel("\u5171\u8BA1");
		label_1.setBounds(98, 324, 54, 15);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(147, 323, 66, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("\u4F1A\u5458\u4EF7");
		label_2.setBounds(289, 324, 54, 15);
		contentPane.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(342, 323, 66, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_3 = new JLabel("\u5143");
		label_3.setBounds(225, 324, 54, 15);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("\u5143");
		label_4.setBounds(418, 324, 54, 15);
		contentPane.add(label_4);
		
		
	
		
		 MyActionListener al = new MyActionListener();

		 button.addActionListener(al);

		 button_2.addActionListener(new MyActionListener());
		 button_1.addActionListener(al);
		 
		 
	}
	
	
	
	//���
//	public void display(String str)
//    {
//		
//		line = new LaundryListDAO();
//		
//        list = line.LaundryRoom(str);// ����������õ�ʱ����Nul  �������϶����еģ���Ϊ���ѯ�ļ�¼��0�У����Իᱨ��ָ���쳣
//        JOptionPane.showMessageDialog(null, list.size());
//        //��������������жϣ���Ϊһ��ʼ����û����������ģ����Կ϶���null
//        	System.out.println("====");
//            int rows=list.size();	//��Ϊlist��ʵ��null null��û��.size������
//            
//            
//    		table.setBounds(30, 61, 480, 250);
////            
//    		tableModel=new MyTableLaundryList(list);		
//    		table.setModel(tableModel);
////    		
//    		table.setRowHeight(20);
//            table.addMouseListener(new MyMouseListener());
//    		//��������ӹ�����
//            
//          scrollPane.setViewportView(table);//�����ʲô��.... �������ʾ�������������������������ĸ߶ȣ��ͻ���ֹ�����
//          table.setShowHorizontalLines(true);
// 
//          contentPane.add(table);
//   		   
//   		   table.setVisible(true);
//        
//        //��������Ĵ���û��д�ð���scrollPanelû��add���table?
//        //����Ĵ�������д�ģ�û���Ǹ�
//        
//    }

	    private class MyActionListener implements ActionListener
	    {
	    	private static final int YES_NO_CANCEL_OPTION = 0;

			public void actionPerformed(ActionEvent e)
	    	{
	    		JButton buttonx = (JButton)e.getSource();
	    		
			
	    	
	    		
	    		
	    		//ȷ������
	    		 if ( button_2 == buttonx)
	    		{
	    	
	    			String a = textField.getText().trim();
	    			line = new LaundryListDAO();
	    			
	    	        list = line.LaundryRoom(a); 
	    	        tableModel=new MyTableLaundryList(list);
	    	        table.setModel(tableModel);
	    	        table.repaint();
	    	        table.updateUI();
	    	     

	    		//��ʾ����
	    	        
	    	        
	    	        
	    	    
	    	        	
	    	        LaundryListDAO money = new LaundryListDAO();
	    	        double s = money.getsum(a);
	    	        String list1=String.valueOf(money.getsum(a));
	    	        
	    	        double money_ture = s * 0.88;
	    	        //JOptionPane.showConfirmDialog(null, money_ture);
	    	        String list2=String.valueOf(money_ture);
	    	        
	    	        //JOptionPane.showConfirmDialog(null, a);
	    	        
	    	        
	    	        
	    	        
	    	        
	    	        textField_1.setText(list1);
	    	        textField_1.setEditable(false);
	    	        
	    	        
	    	        
	    	        //����ǻ�Ա��8.8��
	    	    
	    	        textField_2.setText(list2);
	    	        textField_2.setEditable(false);
	    	        
	    		 
	    		 
	    		 
	    		}
	    		
	    		
	    		
	    		
	    		
	    		//�˷�
	    		else if ( button == buttonx)
	    		{	
	    			String b = textField.getText().trim();
	    			LaundryListDAO lDao = new LaundryListDAO();
	    			int ifadd=JOptionPane.showConfirmDialog(null, "ȷ���˷�?", "��ʾ",JOptionPane.YES_NO_OPTION); 
					if(ifadd==JOptionPane.YES_OPTION){
						lDao.Cancel(b);
						dispose();
					}
				else{ 
					JOptionPane.showMessageDialog(null, "������ֹ");
					System.exit(0);
				}
	    		}
	    		
	    		//ȡ��
	    		else if ( button_1 == buttonx)
	    		{	
	    			
	    			dispose();

	    		
	    		}
	    		
	    		
	    	}
	    }
}
