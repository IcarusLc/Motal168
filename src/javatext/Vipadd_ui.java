package javatext;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DAO.CoustomerDAO;

import DTO.CustomerDTO;

public class Vipadd_ui extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton button;
	private JButton button_1;
	private JComboBox comboBox;
	private CoustomerDAO cDao = new CoustomerDAO();
	private CustomerDTO cDto = new CustomerDTO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vipadd_ui frame = new Vipadd_ui();
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
	public Vipadd_ui() {
		setTitle("\u6DFB\u52A0VIP");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u59D3   \u540D");
		label.setBounds(90, 57, 54, 15);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(178, 54, 113, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u8EAB\u4EFD\u8BC1");
		label_1.setBounds(90, 114, 54, 15);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(178, 111, 113, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		button = new JButton("\u6DFB\u52A0");
		button.addActionListener(new addVIP());
		button.setBounds(67, 211, 93, 23);
		contentPane.add(button);
		
		button_1 = new JButton("\u53D6\u6D88");
		button_1.addActionListener(new addVIP());
		button_1.setBounds(226, 211, 93, 23);
		contentPane.add(button_1);
		
		JLabel label_2 = new JLabel("性  别");
		label_2.setBounds(90, 165, 54, 15);
		contentPane.add(label_2);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"男", "女"}));
		comboBox.setBounds(178, 160, 76, 21);
		contentPane.add(comboBox);
	}
	class addVIP implements ActionListener{
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
				String IDNum = textField_1.getText().trim();
				String sex = comboBox.getSelectedItem().toString();
				if(name.length() == 0)
				{
					JOptionPane.showMessageDialog(null,"姓名不能为空!");
				}
				else if(IDNum.length() == 0)
				{
					JOptionPane.showMessageDialog(null,"身份证不能为空!");
				}
				else
				{
					cDto.setF_Name(name);
					cDto.setF_IDNum(IDNum);
					cDto.setF_Sex(sex);
					int a =cDao.AddVIP(cDto);
					if(a == 1)
					{
						JOptionPane.showMessageDialog(null,"该用户已经是会员！");	
					}
					else if(a == 2 || a == 3)
					{
						JOptionPane.showMessageDialog(null,"添加成功！");	
						dispose();
					}
					else
						JOptionPane.showMessageDialog(null,"添加失败！");	
				}
			}
			
		}
	}
}
