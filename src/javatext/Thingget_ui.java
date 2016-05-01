package javatext;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

public class Thingget_ui extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
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
					Thingget_ui frame = new Thingget_ui();
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
	public Thingget_ui() {
		setTitle("\u53D6\u7269");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u7F16\u53F7");
		label.setBounds(72, 59, 54, 15);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(207, 56, 66, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801");
		label_1.setBounds(72, 116, 54, 15);
		contentPane.add(label_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(207, 113, 66, 21);
		contentPane.add(passwordField);
		
		button = new JButton("\u786E\u5B9A");
		button.addActionListener(new get());
		button.setBounds(85, 179, 93, 23);
		contentPane.add(button);
		
		button_1 = new JButton("\u53D6\u6D88");
		button_1.addActionListener(new get());
		button_1.setBounds(229, 179, 93, 23);
		contentPane.add(button_1);
	}
	
	class get implements ActionListener{
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
				int id = Integer.parseInt(textField.getText().trim());
				String pwd = passwordField.getText().trim();
				if(textField.getText().trim().length() == 0)
				{
					JOptionPane.showMessageDialog(null,"编号不能为空!");
				}
				else if(pwd.length() == 0)
				{
					JOptionPane.showMessageDialog(null,"密码不能为空!");
				}
				else
				{
					tDto.setF_ID(id);
					tDto.setF_PWD(pwd);
					boolean flag=tDao.Get(tDto);
					if(flag)
					{
						JOptionPane.showMessageDialog(null,"密码正确！");	
						dispose();
					}
					else
						JOptionPane.showMessageDialog(null,"操作失败！密码错误或者密码已失效！");	
				}
			}
			
		}
	}
}
