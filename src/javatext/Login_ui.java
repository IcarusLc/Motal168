package javatext;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DAO.MangerDAO;
import DTO.MangerDTO;


public class Login_ui extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	JButton btnNewButton;
	JButton btnNewButton_1;
	MangerDTO mDto;
	MangerDAO mDao;
	/**
	 * Create the frame.
	 */
	public Login_ui() {
		mDto = new MangerDTO();
		mDao = new MangerDAO();
		setTitle("\u7BA1\u7406\u5458\u767B\u9646");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(800, 350, 352, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel.setBounds(64, 57, 54, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6  \u7801\uFF1A");
		lblNewLabel_1.setBounds(64, 101, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(128, 54, 117, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setColumns(10);
		passwordField.setBounds(128, 98, 117, 21);
		contentPane.add(passwordField);
		
		btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.addActionListener(new denglu());
		btnNewButton.setBounds(46, 148, 93, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("\u9000\u51FA");
		btnNewButton_1.addActionListener(new denglu());
		btnNewButton_1.setBounds(174, 148, 93, 23);
		contentPane.add(btnNewButton_1);
	}
	class denglu implements ActionListener{
		public void actionPerformed(ActionEvent e)
		{
			// 获取事件源
			JButton source = (JButton)e.getSource();
			if(source == btnNewButton_1)
			{
				System.exit(0);
			}
			else if(source == btnNewButton)
			{
				String userID = textField.getText().trim();
				@SuppressWarnings("deprecation")
				String pw = passwordField.getText().trim();
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
					mDto.setF_UserID(userID);
					mDto.setF_PWD(pw);
					boolean flag=mDao.findUser(mDto);
					if(flag)
					{	
						Main_ui a = new Main_ui();
						a.setVisible(true);
					    dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null,"用户名或密码有误!");	
					}
				}
			}
			
		}
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {

			//javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
			//javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");//很浅绿
			//javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");//灰色
			//javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");//太黄了
			//javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");//全黑
			javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
			//javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
			///javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");//buhk
			///javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
			///javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.noire.NoireLookAndFeel"); 
			} 
		catch (Exception ex) {
			ex.printStackTrace();
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
		public void run() {
		new Login_ui().setVisible(true);
		}
		});
		}
		
	}
	

		
		
		
