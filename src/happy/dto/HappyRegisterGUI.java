package com.happy.form;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import com.happy.dto.*;
import com.happy.dao.*;

public class HappyRegisterGUI extends JFrame
{
	//声明组件
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
		super("Happy用户注册");
		Container c = this.getContentPane();
		c.setLayout(new FlowLayout());
		//定义组件
		userNameLab = new JLabel("用户名：");
		passwordLab = new JLabel("密    码：");
		pwTipLab = new JLabel("密码不少于6位");
		repPwLab = new JLabel("密码重复：");
		sexLab = new JLabel("性    别：");
		ageLab = new JLabel("年    龄：");
		provinceLab = new JLabel("所在省份：");
		joyLab = new JLabel("个人爱好：");
		introLab = new JLabel("个人说明：");				
		userNameTf = new JTextField(15);
		ageTf = new JTextField(15);
		passwordField = new JPasswordField(15);
		repPwField = new JPasswordField(15);
		Image img = Toolkit.getDefaultToolkit().getImage(this.getClass().getResource("/pictures/check.gif"));
		checkUserNameButton = new JButton(new ImageIcon(img));
		checkUserNameButton.setToolTipText("检测用户名");
		regButton = new JButton("   注    册   ");
		maleRb = new JRadioButton("男",true);
		femaleRb = new JRadioButton("女",false);
		bg = new ButtonGroup();
		bg.add(maleRb);
		bg.add(femaleRb);		
		provinceCb = new JComboBox();
		provinceCb.addItem("北京");
		provinceCb.addItem("山西");
		provinceCb.addItem("吉林");
		provinceCb.addItem("安徽");
		provinceCb.addItem("湖北");
		provinceCb.addItem("湖南");
		provinceCb.addItem("四川");
		provinceCb.addItem("广西");
		musicCb = new JCheckBox("音乐");
		danceCb = new JCheckBox("舞蹈");
		swimCb = new JCheckBox("游泳");
		shoppingCb = new JCheckBox("购物");
		introduceTa = new JTextArea(8,30);
		//创建GridBagLayout对象
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
					  JOptionPane.showMessageDialog(null,"用户名不能为空！"); 
			    	}
				  	else
					{
					  //定义DTO对象，封装用户注册信息
						UserInfoDTO user=new UserInfoDTO();
						user.setUserID(userNameTf.getText());
						user.setUserPassword(passwordField.getText());
						
						
						
						//定义DAO对象，操作数据库
					    UserInfoDAO userdao=new UserInfoDAO();
				        int i=userdao.addUser(user);
				        if(i>0)
				        {
				        	JOptionPane.showMessageDialog(null,"注册成功！");
				        }
				        else
				        {
				        	JOptionPane.showMessageDialog(null,"注册失败！");
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

