package com.happy.form;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import com.happy.dto.*;
import com.happy.dao.*;

public class HappyLoginGUI extends JFrame
{
	//�������ݷ��ʶ�������ݴ������
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
		super("Happy�û���¼");
		udao=new UserInfoDAO();
		udto=new UserInfoDTO();
		Container c = this.getContentPane();
		gbl = new GridBagLayout();
		c.setLayout(gbl);
		gbc = new GridBagConstraints();
		userNameLabel = new JLabel("�û���:");
		passwordLabel = new JLabel("��  ��:");
		userNameTextField = new JTextField(20);
		passwordField = new JPasswordField(20);
		exitButton = new JButton("��  ��");
		loginButton = new JButton("��  ¼");
		// �����¼�����������
		ButtonListener bListener = new ButtonListener();
		// ��ťע���¼�������
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
	// �����¼���������
	class ButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			// ��ȡ�¼�Դ
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
					JOptionPane.showMessageDialog(null,"�û�������Ϊ��!");
				}
				else if(pw.length() == 0)
				{
					JOptionPane.showMessageDialog(null,"���벻��Ϊ��!");
				}
				else
				{
					//��DTO����ֵ
					udto.setUserID(userID);
					udto.setUserPassword(pw);
				    boolean flag=udao.findUser(udto);
				    if(flag)
				    {	
				      	new HappyRegisterGUI();
				      	
				    }
				    else
				    {
				    	JOptionPane.showMessageDialog(null,"�û�������������!");	
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
