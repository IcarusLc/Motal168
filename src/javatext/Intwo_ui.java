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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DAO.CoustomerDAO;
import DAO.RoomDAO;
import DTO.CustomerDTO;
import DTO.RoomDTO;

public class Intwo_ui extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JButton  button;
	private JButton  button_1;
	private JComboBox comboBox;
		
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Intwo_ui frame = new Intwo_ui(3000);
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
	public Intwo_ui(int num) {
		setTitle("\u53CC\u4EBA\u623F\u5165\u4F4F");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 386);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u59D3\u540D");
		label.setBounds(50, 49, 54, 15);
		contentPane.add(label);
		
		JLabel lblNewLabel = new JLabel("\u59D3\u540D");
		lblNewLabel.setBounds(50, 106, 54, 15);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(104, 46, 66, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(104, 103, 66, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_1 = new JLabel("\u8EAB\u4EFD\u8BC1");
		label_1.setBounds(216, 49, 54, 15);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u8EAB\u4EFD\u8BC1");
		label_2.setBounds(216, 106, 54, 15);
		contentPane.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(280, 46, 116, 21);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(280, 103, 116, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_3 = new JLabel("\u5165\u4F4F\u623F\u95F4");
		label_3.setBounds(104, 163, 54, 15);
		contentPane.add(label_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(216, 159, 88, 21);
		textField_4.setText(num+"");
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel label_6 = new JLabel("\u62BC\u91D1");
		label_6.setBounds(104, 218, 54, 15);
		contentPane.add(label_6);
		
		textField_5 = new JTextField();
		textField_5.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_5.setBounds(216, 214, 66, 21);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel label_7 = new JLabel("\u5143");
		label_7.setBounds(296, 218, 54, 15);
		contentPane.add(label_7);
		
		button = new JButton("\u786E\u5B9A");
		button.setBounds(77, 281, 93, 23);
		button.addActionListener(new change());
		contentPane.add(button);
		
		button_1 = new JButton("\u53D6\u6D88");
		button_1.setBounds(239, 281, 93, 23);
		button_1.addActionListener(new change());
		contentPane.add(button_1);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u5165\u4F4F", "\u9884\u5B9A"}));
		comboBox.setBounds(173, 248, 73, 24);
		contentPane.add(comboBox);
	}
	
	class change implements ActionListener{
		public void actionPerformed(ActionEvent ex){
			JButton source = (JButton)ex.getSource();
			if(source == button){
				CustomerDTO ccDto = new CustomerDTO();
				ccDto.setF_Name(textField.getText().trim()+"、"+textField_1.getText().trim());
				String a = textField_2.getText().trim();
				String b = textField_3.getText().trim();
				
				String yuding = comboBox.getSelectedItem().toString();
				RoomDTO rDto = new RoomDTO();
				rDto.setF_State(yuding);
				rDto.setF_Num(textField_2.getText().trim());
				RoomDAO.setState(rDto);
				ccDto.setF_Type(yuding);
				ccDto.setF_IDNum(a);
				long i = Long.parseLong(a);
				ccDto.setF_IDNum(b);
				long j = Long.parseLong(b);
				if(i%2 == 0&&j%2==0)
					ccDto.setF_Sex("男,男");
				else if(i%2 == 0 && j%2 == 1)
					ccDto.setF_Sex("男,女");
				else if(i%2 == 1 && j%2 == 0)
					ccDto.setF_Sex("女,男");
				else 
					ccDto.setF_Sex("女,女");
				ccDto.setF_Num(textField_4.getText().trim());
				ccDto.setF_Recharge(textField_5.getText().trim());
				int re = CoustomerDAO.setAll(ccDto);
				if(re == 1){
					JOptionPane.showMessageDialog(null, "成功");
					dispose();
				}
				else 
					JOptionPane.showMessageDialog(null, "输入有误");
			}
		
			else{ 
				dispose();
			}
			}
	}

}
