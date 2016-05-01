package com.happy.form;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import com.happy.dto.*;
import com.happy.dao.*;

public class HappyRegisterGUI extends JFrame
{
	//�������
	JLabel userNameLab;
	JLabel passwordLab;
	JLabel pwTipLab;
	JLabel repPwLab;
	JLabel sexLab;
	JLabel ageLab;
	JLabel provinceLab;
	JLabel joyLab;
	JLabel introLab;	
	JTextField userNameTf;
	JTextField ageTf;
	JPasswordField passwordField;
	JPasswordField repPwField;
	JButton checkUserNameButton;
	JButton regButton;
	JRadioButton maleRb,femaleRb;
	ButtonGroup bg;
	JComboBox provinceCb;
	JCheckBox musicCb,danceCb,swimCb,shoppingCb;
	JTextArea introduceTa;
	
	
	GridBagLayout gbl;
	GridBagConstraints gbc;
	public HappyRegisterGUI()
	{
		super("Happy�û�ע��");
		Container c = this.getContentPane();
		c.setLayout(new FlowLayout());
		//�������
		userNameLab = new JLabel("�û�����");
		passwordLab = new JLabel("��    �룺");
		pwTipLab = new JLabel("���벻����6λ");
		repPwLab = new JLabel("�����ظ���");
		sexLab = new JLabel("��    ��");
		ageLab = new JLabel("��    �䣺");
		provinceLab = new JLabel("����ʡ�ݣ�");
		joyLab = new JLabel("���˰��ã�");
		introLab = new JLabel("����˵����");				
		userNameTf = new JTextField(15);
		ageTf = new JTextField(15);
		passwordField = new JPasswordField(15);
		repPwField = new JPasswordField(15);
		Image img = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/pictures/check.gif"));
		checkUserNameButton = new JButton(new ImageIcon(img));
		checkUserNameButton.setToolTipText("����û���");
		regButton = new JButton("   ע    ��   ");
		maleRb = new JRadioButton("��",true);
		femaleRb = new JRadioButton("Ů",false);
		bg = new ButtonGroup();
		bg.add(maleRb);
		bg.add(femaleRb);		
		provinceCb = new JComboBox();
		provinceCb.addItem("����");
		provinceCb.addItem("ɽ��");
		provinceCb.addItem("����");
		provinceCb.addItem("����");
		provinceCb.addItem("����");
		provinceCb.addItem("����");
		provinceCb.addItem("�Ĵ�");
		provinceCb.addItem("����");
		musicCb = new JCheckBox("����");
		danceCb = new JCheckBox("�赸");
		swimCb = new JCheckBox("��Ӿ");
		shoppingCb = new JCheckBox("����");
		introduceTa = new JTextArea(8,30);
		//����GridBagLayout����
		gbl = new GridBagLayout();
		c.setLayout(gbl);		
		gbc = new GridBagConstraints();
		
		gbc.anchor = GridBagConstraints.NORTHWEST;
		gbc.insets.set(1,1,1,1);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbl.setConstraints(userNameLab,gbc);
		c.add(userNameLab);
		
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.gridwidth = 3;
		gbl.setConstraints(userNameTf,gbc);
		c.add(userNameTf);
		
		gbc.gridx = 5;
		gbc.gridy = 1;
		gbc.gridwidth = 1;
		gbl.setConstraints(checkUserNameButton,gbc);
		c.add(checkUserNameButton);
		
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbl.setConstraints(passwordLab,gbc);
		c.add(passwordLab);
		
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.gridwidth = 3;
		gbl.setConstraints(passwordField,gbc);
		c.add(passwordField);
		
		gbc.gridx = 5;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		gbl.setConstraints(pwTipLab,gbc);
		c.add(pwTipLab);
		
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		gbl.setConstraints(repPwLab,gbc);
		c.add(repPwLab);
		
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.gridwidth = 3;
		gbl.setConstraints(repPwField,gbc);
		c.add(repPwField);
		
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		gbl.setConstraints(sexLab,gbc);
		c.add(sexLab);
		
		gbc.gridx = 2;
		gbc.gridy = 4;		
		gbl.setConstraints(maleRb,gbc);
		c.add(maleRb);
		
		gbc.gridx = 3;
		gbc.gridy = 4;
		gbl.setConstraints(femaleRb,gbc);
		c.add(femaleRb);
				
		
		gbc.gridx = 1;
		gbc.gridy = 5;		
		gbl.setConstraints(ageLab,gbc);
		c.add(ageLab);
		
		gbc.gridx = 2;
		gbc.gridy = 5;
		gbc.gridwidth = 2;	
		gbl.setConstraints(ageTf,gbc);
		c.add(ageTf);
		
		gbc.gridx = 1;
		gbc.gridy = 6;
		gbc.gridwidth = 1;
		gbl.setConstraints(provinceLab,gbc);
		c.add(provinceLab);
		
		gbc.gridx = 2;
		gbc.gridy = 6;
		gbl.setConstraints(provinceCb,gbc);
		c.add(provinceCb);
		
		gbc.gridx = 1;
		gbc.gridy = 7;
		gbl.setConstraints(joyLab,gbc);
		c.add(joyLab);
		
		gbc.gridx = 2;
		gbc.gridy = 8;
		gbl.setConstraints(musicCb,gbc);
		c.add(musicCb);
		
		gbc.gridx = 3;
		gbc.gridy = 8;
		gbl.setConstraints(danceCb,gbc);
		c.add(danceCb);
		
		gbc.gridx = 4;
		gbc.gridy = 8;
		gbl.setConstraints(swimCb,gbc);
		c.add(swimCb);
		
		gbc.gridx = 5;
		gbc.gridy = 8;
		gbl.setConstraints(shoppingCb,gbc);
		c.add(shoppingCb);
		
		gbc.gridx = 1;
		gbc.gridy = 9;
		gbl.setConstraints(introLab,gbc);
		c.add(introLab);
		
		gbc.gridx = 1;
		gbc.gridy = 10;
		gbc.gridwidth = 5;
		gbl.setConstraints(introduceTa,gbc);
		c.add(introduceTa);
		
		gbc.gridx = 3;
		gbc.gridy = 11;
		gbc.gridwidth = 2;
		gbl.setConstraints(regButton,gbc);
		c.add(regButton);

		this.setSize(430,480);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		regButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JButton tempButton=(JButton)e.getSource();
				if(tempButton==regButton)
				{
					if(userNameTf.getText().length()==0)
					{
					  JOptionPane.showMessageDialog(null,"�û�������Ϊ�գ�"); 
			    	}
				  	else
					{
					  //����DTO���󣬷�װ�û�ע����Ϣ
						UserInfoDTO user=new UserInfoDTO();
						user.setUserID(userNameTf.getText());
						user.setUserPassword(passwordField.getText());
						
						
						
						//����DAO���󣬲������ݿ�
					    UserInfoDAO userdao=new UserInfoDAO();
				        int i=userdao.addUser(user);
				        if(i>0)
				        {
				        	JOptionPane.showMessageDialog(null,"ע��ɹ���");
				        }
				        else
				        {
				        	JOptionPane.showMessageDialog(null,"ע��ʧ�ܣ�");
				        }	
					}
			}
		}});
	}
	
	public static void main (String[] args) 
	{
		new HappyRegisterGUI();
    }
}

