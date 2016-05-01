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
import DAO.RoomDAO;
import DTO.CustomerDTO;
import DTO.RoomDTO;

public class Inone_ui extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JButton button;
	private JButton button_1;
	private JComboBox  comboBox;
	/**
	 * Launch the application.
	 */
	public static void main (String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Inone_ui frame = new Inone_ui(1000);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @return 
	 */
	public Inone_ui (int num) {
		setTitle("\u5355\u4EBA\u623F\u5165\u4F4F");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 450, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u59D3 \u540D");
		label.setBounds(101, 25, 54, 15);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setBounds(208, 22, 99, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u8EAB\u4EFD\u8BC1");
		label_1.setBounds(101, 65, 54, 15);
		contentPane.add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(208, 62, 99, 21);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("\u62BC \u91D1");
		label_2.setBounds(101, 148, 54, 15);
		contentPane.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(208, 98, 99, 21);
		textField_2.setText(num+"");
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		
		JLabel label_3 = new JLabel("\u5165\u4F4F\u623F\u95F4");
		label_3.setBounds(101, 102, 76, 15);
		contentPane.add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(208, 144, 67, 21);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_4 = new JLabel("\u5143");
		label_4.setBounds(289, 148, 24, 15);
		contentPane.add(label_4);
		
		button = new JButton("\u786E\u5B9A");
		button.setBounds(84, 218, 93, 23);
		button.addActionListener(new change());
		contentPane.add(button);
		
		button_1 = new JButton("\u53D6\u6D88");
		button_1.setBounds(251, 218, 93, 23);
		button_1.addActionListener(new change());
		contentPane.add(button_1);
		
		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u5165\u4F4F", "\u9884\u5B9A"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(208, 186, 99, 24);
		contentPane.add(comboBox);
	}


		class change implements ActionListener{
			public void actionPerformed(ActionEvent ex){
				JButton source = (JButton)ex.getSource();
				if(source == button){
					CustomerDTO ccDto = new CustomerDTO();
					ccDto.setF_Name(textField.getText().trim());
					String a = textField_1.getText().trim();
					RoomDTO rDto = new RoomDTO();
					
					String yuding = comboBox.getSelectedItem().toString();
					rDto.setF_State(yuding);
					rDto.setF_Num(textField_2.getText().trim());
					RoomDAO.setState(rDto);
					ccDto.setF_Type(yuding);
					ccDto.setF_IDNum(a);
					long i = Long.parseLong(a);
					if(i%2 == 0)
						ccDto.setF_Sex("男");
					else 
						ccDto.setF_Sex("女");
					ccDto.setF_Num(textField_2.getText().trim());
					ccDto.setF_Recharge(textField_3.getText().trim());
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