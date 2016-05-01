package com.happy.form;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import com.happy.dto.*;
import com.happy.dao.*;

public class HappyLoginGUI extends JFrame
{
	//定义数据访问对象和数据传输对象
	private UserInfoDAO udao;
	private UserInfoDTO udto;
	private JLabel userNameLabel,passwordLabel;
	private JTextField userNameTextField;
	private JPasswordField passwordField;
	private JButton exitButton,loginButton;
	private GridBagLayout gbl;
	private GridBagConstraints gbc;
	public HappyLoginGUI()
	{
		super("Happy用户登录");
		udao=new UserInfoDAO();
		udto=new UserInfoDTO();
		Container c = this.getContentPane();
		gbl = new GridBagLayout();
		c.setLayout(gbl);
		gbc = new GridBagConstraints();
		userNameLabel = new JLabel("用户名:");
		passwordLabel = new JLabel("密  码:");
		userNameTextField = new JTextField(20);
		passwordField = new JPasswordField(20);
		exitButton = new JButton("退  出");
		loginButton = new JButton("登  录");
		// 创建事件监听器对象
		ButtonListener bListener = new ButtonListener();
		// 按钮注册事件监听器
		exitButton.addActionListener(bListener);
		loginButton.addActionListener(bListener);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbl.setConstraints(userNameLabel,gbc);
		c.add(userNameLabel);
		
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbl.setConstraints(userNameTextField,gbc);
		c.add(userNameTextField);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbl.setConstraints(passwordLabel,gbc);
		c.add(passwordLabel);
		
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbl.setConstraints(passwordField,gbc);
		c.add(passwordField);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbl.setConstraints(exitButton,gbc);
		c.add(exitButton);
		
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.fill=GridBagConstraints.BOTH;
		gbl.setConstraints(loginButton,gbc);
		c.add(loginButton);
		
		this.setSize(350,150);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	// 定义事件监听器类
	class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			// 获取事件源
			JButton source = (JButton)e.getSource();
			if(source == exitButton)
			{
				System.exit(0);
			}
			else if(source == loginButton)
			{
				String userID = userNameTextField.getText().trim();
				String pw = passwordField.getText();
				if(userID.length() == 0)
				{
					JOptionPane.showMessageDialog(null,"用户名不能为空!");
				}
				else if(pw.length() == 0)
				{
					JOptionPane.showMessageDialog(null,"密码不能为空!");
				}
				else
				{
					//给DTO对象赋值
					udto.setUserID(userID);
					udto.setUserPassword(pw);
				    boolean flag=udao.findUser(udto);
				    if(flag)
				    {	
				      	new HappyRegisterGUI();
				      	
				    }
				    else
				    {
				    	JOptionPane.showMessageDialog(null,"用户名或密码有误!");	
				    }
				}
			}
			
		}
	}
	public static void main(String[] a)
	{
		new HappyLoginGUI();
	}
}
