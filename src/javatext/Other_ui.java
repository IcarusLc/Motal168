package javatext;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DAO.LaundryListDAO;
import DTO.LaundryListDTO;

public class Other_ui extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JButton button;
	private JButton button_1;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private ButtonGroup group = new ButtonGroup();
	LaundryListDAO lDao = new LaundryListDAO();
	LaundryListDTO lDto = new LaundryListDTO();
	private JTextField textField_2;
	
	/**
	 * Create the frame.
	 */
	public Other_ui() {
		setTitle("\u5176\u4ED6\u670D\u52A1");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u5BA2 \u6237 \u540D\uFF1A");
		label.setBounds(74, 29, 74, 15);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(163, 26, 149, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u670D\u52A1\u7C7B\u578B\uFF1A");
		label_1.setBounds(74, 117, 74, 15);
		contentPane.add(label_1);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u9152\u5427", "\u7F51\u5427", "\u9910\u5385", "\u5496\u5561\u5385", "\u79DF\u8F66", "\u5176\u4ED6"}));
		comboBox.setBounds(163, 114, 126, 21);
		contentPane.add(comboBox);
		
		JLabel label_2 = new JLabel("\u6D88\u8D39\u91D1\u989D\uFF1A");
		label_2.setBounds(74, 161, 74, 15);
		contentPane.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_1.setBounds(163, 158, 54, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_3 = new JLabel("\u5143");
		label_3.setBounds(227, 161, 54, 15);
		contentPane.add(label_3);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"预定", "消费"}));
		comboBox_1.setBounds(306, 114, 76, 21);
		contentPane.add(comboBox_1);
		
		button = new JButton("\u786E\u5B9A");
		button.addActionListener(new add());
		button.setBounds(74, 205, 93, 23);
		contentPane.add(button);
		
		button_1 = new JButton("\u53D6\u6D88");
		button_1.addActionListener(new add());
		button_1.setBounds(219, 205, 93, 23);
		contentPane.add(button_1);
		
		JLabel label_4 = new JLabel("\u623F \u95F4 \u53F7\uFF1A");
		label_4.setBounds(74, 73, 74, 15);
		contentPane.add(label_4);
		
		textField_2 = new JTextField();
		textField_2.setBounds(163, 70, 149, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
	}
	class add implements ActionListener{
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
				String name	= textField.getText().trim();
				String num = textField_2.getText().trim();
				String type = comboBox.getSelectedItem().toString();
				String money = textField_1.getText().trim();
				String yuding = comboBox_1.getSelectedItem().toString();
				if(name.length() == 0)
				{
					JOptionPane.showMessageDialog(null,"客户名不能为空!");
				}
				else    if(num.length() == 0)
				{
					JOptionPane.showMessageDialog(null,"房号不能为空!");
				}
				else    if(money.length() == 0)
				{
					JOptionPane.showMessageDialog(null,"消费金额不能为空!");
				}
				else {
					lDto.setF_Name(name);
					lDto.setF_Num(num);
					lDto.setF_Type(type);
					lDto.setF_Ps(yuding);
					lDto.setF_Money(Double.parseDouble(money));
					boolean flag=lDao.Add(lDto);
					if(flag)
					{	
						JOptionPane.showMessageDialog(null,"添加成功！");
					    dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null,"添加失败!");	
					}
				}
			}
			
		}
	}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Other_ui frame = new Other_ui();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
