package javatext;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javatext.Login_ui.denglu;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import DAO.ThingDAO;
import DTO.ThingDTO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Thingstore_ui extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JButton button;
	private JButton button_1;
	private ThingDAO tDao = new ThingDAO();
	private ThingDTO tDto = new ThingDTO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Thingstore_ui frame = new Thingstore_ui();
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
	public Thingstore_ui() {
		setTitle("\u7269\u54C1\u5BC4\u5B58");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 430, 320);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u59D3\u540D");
		label.setBounds(105, 50, 54, 15);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(230, 47, 78, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u623F\u95F4");
		label_1.setBounds(105, 100, 54, 15);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(230, 100, 78, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_3 = new JLabel("\u53D6\u7269\u5BC6\u7801");
		label_3.setBounds(105, 150, 54, 15);
		contentPane.add(label_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(230, 150, 78, 21);
		contentPane.add(passwordField);
		
		button = new JButton("\u786E\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.addActionListener(new store());
		button.setBounds(105, 200, 93, 23);
		contentPane.add(button);
		
		button_1 = new JButton("\u53D6\u6D88");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_1.addActionListener(new store());
		button_1.setBounds(230, 200, 93, 23);
		contentPane.add(button_1);
	}
	class store implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			// 获取事件源
			JButton source = (JButton)e.getSource();
			if(source == button_1)
			{
				dispose();
			}
			else if(source == button)
			{
				String name = textField.getText().trim();
				String num = textField_1.getText().trim();
				String pwd = passwordField.getText().trim();
				if(name.length() == 0)
				{
					JOptionPane.showMessageDialog(null,"客户名不能为空!");
				}
				else    if(num.length() == 0)
				{
					JOptionPane.showMessageDialog(null,"房号不能为空!");
				}
				else    if(pwd.length() == 0)
				{
					JOptionPane.showMessageDialog(null,"密码不能为空!");
				}
				else
				{
					//给DTO对象赋值
					tDto.setF_Name(name);
					tDto.setF_PWD(pwd);;
					tDto.setF_Room(num);
					int a =tDao.Store(tDto);
					if(a>0)
					{	
						int b = a % 100;
						JOptionPane.showMessageDialog(null,"储存成功！您的储物编号是:"+b);	
					    dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null,"储存失败！");
						textField.setText("");
						textField_1.setText("");
						passwordField.setText("");
					}
				}
			}
			
		}
	}
}
