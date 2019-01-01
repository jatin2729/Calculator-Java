import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.util.logging.MemoryHandler;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JLabel;

public class Calc {

	private JFrame frmCalculator; 
	private JTextField textField;
	
	double num1;
	double num2;
	double result;
	int rslt;
	String operator;
	boolean  number1 =false;
//	
	boolean answer = false;
	/**
	 * 
	 * setting up window
	 * 
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calc window = new Calc();
					window.frmCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Calc() {
		initialize();
	}

	private void initialize() {
		frmCalculator = new JFrame();
		frmCalculator.setTitle("Calculator");
		frmCalculator.setBounds(100, 100, 425, 496);
		frmCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
		JPanel panel = new JPanel();
		frmCalculator.getContentPane().add(panel, BorderLayout.CENTER);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setBackground(Color.WHITE);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 22));
		textField.setEditable(false);
		textField.setBounds(30, 16, 342, 55);
		textField.setColumns(12);
		
		JButton btnAllClear = new JButton("A/C");
		btnAllClear.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnAllClear.setBounds(40, 99, 73, 47);
		
		btnAllClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				int h = frmCalculator.getX();
				int w = frmCalculator.getY();
				
				Calc k = new Calc();
				k.frmCalculator.setLocation(h, w);
				k.frmCalculator.setVisible(true);
				frmCalculator.dispose();
				
				
			}
		});
		
		JButton btnSign = new JButton("+/-");      //+ oor - button
		btnSign.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnSign.setBounds(213, 99, 72, 47);
		btnSign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {			
					String x = (String.valueOf(textField.getText()));
					double zero = Double.parseDouble(textField.getText());
					
					if(zero == 0.0) {
						textField.setText(textField.getText());
					}else if(zero>0.0) {
						textField.setText("-"+textField.getText());
					}
					else {
						double ngtv = zero*(-1.0);
						
						int ngtvint = (int) ngtv;
						
						if(ngtvint==ngtv) {
							if(textField.getText().contains(".")) {
								textField.setText(Integer.toString(ngtvint)+".");
							}
							else {
							textField.setText(Integer.toString(ngtvint));
							}
						}
						else {
							textField.setText(Double.toString(ngtv));
						}
					
					}
					
					
//					if(zero == 0.0) {
//						textField.setText(textField.getText());
//					}
//					
//					else if(!x.contains("-")) {
//						textField.setText("-"+textField.getText());
//					}
//					else{
//						textField.setText(textField.getText().replace("-", ""));
//					}
				}
				catch(Exception qwe) {
						
				}
				
//				String y = "-"+x ;
//				System.out.println(y);
//				double ops = Double.parseDouble(String.valueOf(textField.getText()));
//				ops =ops* (-1);
//				textField.setText(String.valueOf(ops));
				
			}
		});
		
		
		JButton btn_7 = new JButton("7");
		btn_7.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btn_7.setBounds(40, 162, 73, 55);
		
		btn_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
						if(answer == true) {
							textField.setText("");		
							answer = false;
						}
						if(textField.getText().equals("0") && !textField.getText().contains(".")) {
							textField.setText("");
						}
						String number = textField.getText()+ btn_7.getText(); 
						textField.setText(number);
				
						
			}
		});
		
		JButton btn_1 = new JButton("1");
		btn_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btn_1.setBounds(40, 303, 73, 55);
		btn_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(answer == true) {
					textField.setText("");		
					answer = false;
				}
				if(textField.getText().equals("0") && !textField.getText().contains(".")) {
					textField.setText("");
				}
					String number = textField.getText()+btn_1.getText(); 
					textField.setText(number);
				
			}
		});
		
		JButton btn_4 = new JButton("4");
		btn_4.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btn_4.setBounds(40, 233, 73, 54);
		btn_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(answer == true) {
					textField.setText("");
					
					
					answer = false;
				}
				if(textField.getText().equals("0") && !textField.getText().contains(".")) {
					textField.setText("");
				}
					String number = textField.getText()+btn_4.getText(); 
					textField.setText(number);
				
			}
		});
		
		JButton btn_0 = new JButton("0");
		btn_0.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btn_0.setBounds(128, 374, 70, 55);
		btn_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(answer == true) {
					textField.setText("");		
					answer = false;
				}
				try {
					if(textField.getText().isEmpty()) {
						textField.setText("0");
					}
					else if (textField.getText().length()==1 && textField.getText().equals("0")) {
						textField.setText(textField.getText());
					}
					else {
						String number = textField.getText()+btn_0.getText(); 
						textField.setText(number);
					}
//					if((operator == null && textField.getText().isEmpty() )){
//						textField.setText("");
//					}
//					else if(answer == true && textField.getText().isEmpty()) {
//						textField.setText("0");
//					}
//					
//					else {				
//						
//						String number = textField.getText()+btn_0.getText(); 
//						textField.setText(number);
//					}
					
				}
				catch(Exception exc) {
					
				}
				
			}
		});
		
		
		
		JButton btn_8 = new JButton("8");
		btn_8.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btn_8.setBounds(128, 162, 72, 55);
		btn_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(answer == true) {
					textField.setText("");
					
					
					answer = false;
				}
				if(textField.getText().equals("0") && !textField.getText().contains(".")) {
					textField.setText("");
				}
					String number = textField.getText()+ btn_8.getText(); 
					textField.setText(number);
				
			}
		});
		
		JButton btn_5 = new JButton("5");
		btn_5.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btn_5.setBounds(128, 233, 70, 54);
		btn_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(answer == true) {
					textField.setText("");
					
					
					answer = false;
				}
				if(textField.getText().equals("0") && !textField.getText().contains(".")) {
					textField.setText("");
				}
					String number = textField.getText()+btn_5.getText(); 
					textField.setText(number);
				
			}
		});
		
		JButton btn_2 = new JButton("2");
		btn_2.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btn_2.setBounds(128, 303, 72, 55);
		btn_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
				if(answer == true) {
					textField.setText("");
					
					
					answer = false;
				}
				if(textField.getText().equals("0") && !textField.getText().contains(".")) {
					textField.setText("");
				}
			
					String number = textField.getText()+btn_2.getText(); 
					textField.setText(number);
				
			}
		});
		
		JButton btnNewButton_9 = new JButton("");
		btnNewButton_9.setEnabled(false);
		btnNewButton_9.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnNewButton_9.setBounds(40, 374, 73, 55);
		btnNewButton_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
			}
		});
		
		JButton btn_9 = new JButton("9");
		btn_9.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btn_9.setBounds(213, 162, 72, 55);
		btn_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(answer == true) {
					textField.setText("");
					
					
					answer = false;
				}
				if(textField.getText().equals("0") && !textField.getText().contains(".")) {
					textField.setText("");
				}
					String number = textField.getText()+btn_9.getText(); 
					textField.setText(number);
				
			}
		});
		
		
		
		
		
		JButton btn_6 = new JButton("6");
		btn_6.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btn_6.setBounds(213, 233, 72, 54);
		btn_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(answer == true) {
					textField.setText("");
					
					
					answer = false;
				}
				if(textField.getText().equals("0") && !textField.getText().contains(".")) {
					textField.setText("");
				}
					String number =textField.getText()+  btn_6.getText(); 
					textField.setText(number);
				
			}
		});
		
		JButton btn_3 = new JButton("3");
		btn_3.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btn_3.setBounds(213, 303, 72, 55);
		btn_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(answer == true) {
					textField.setText("");
					
					
					answer = false;
				}
				if(textField.getText().equals("0") && !textField.getText().contains(".")) {
					textField.setText("");
				}
					String number = textField.getText()+btn_3.getText(); 
					textField.setText(number);
				
			}
		});
		
		JButton btnDot = new JButton(".");
		btnDot.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnDot.setBounds(213, 374, 72, 55);
		btnDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(answer == true) {
					textField.setText("");		
					answer = false;
				}
				if(textField.getText().isEmpty()) {
					textField.setText("0"+".");
					
				}
				else if(textField.getText().contains(".")) {
					String number = textField.getText();
					textField.setText(number);
				}
				else {
					String number = textField.getText() + btnDot.getText(); 
					textField.setText(number);
				}
				
				
			}
			
		});
		
		
		JButton btnSub = new JButton("-");
		btnSub.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnSub.setBounds(300, 233, 72, 55);
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				String x = textField.getText();
//				int y = x.length();
//				char z = x.charAt(y-1);
				try {
					num1= Double.parseDouble(textField.getText());
					//number1 = true;
				}
				catch(Exception num1) {
					
				}
//				
				
//				num1 = Double.parseDouble(textField.getText());
				operator = "1";
				textField.setText("");
//				String min = textField.getText();
//				System.out.println(min);
			}
		});
		
		JButton btnAdd = new JButton("+");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnAdd.setBounds(300, 303, 72, 55);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					num1= Double.parseDouble(textField.getText());
				
				}
				catch(Exception num1) {
					
				}
				
				
				operator = "2";
				textField.setText("");
				
			}
		});
		
		JButton btnMultiply = new JButton("*");
		btnMultiply.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnMultiply.setBounds(300, 162, 72, 54);
		btnMultiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					num1= Double.parseDouble(textField.getText());
				}
				catch(Exception num1) {
					
				}
//				num1= Double.parseDouble(textField.getText());
				operator = "3";
				textField.setText("");
				
			}
		});
		
		JButton btnDivide = new JButton("/");  //divide button
		btnDivide.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnDivide.setBounds(300, 99, 72, 49);
		btnDivide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				String x = textField.getText();
//				System.out.println(x);
				try {
					num1= Double.parseDouble(textField.getText());
				}
				catch(Exception num1) {
					
				}
//				num1= Double.parseDouble(textField.getText());
				operator = "4";
				textField.setText("");
				
			}
		});
		
		
		
		JButton btnEqual = new JButton("=");
		btnEqual.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnEqual.setBounds(300, 374, 72, 55);
		btnEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
//				String xx = (String.valueOf(textField.getText()));
//				if(xx.contains("+")||xx.contains("-")||xx.contains("/")||xx.contains("*")) {
//					System.out.println(xx);
//				}
				
			
					
				
			
				
				try{
					
					num2 = Double.parseDouble(textField.getText());
					
				}
				catch(Exception exp){
						return;
				
				}
				
				
//				if(result == num1) {
//					textField.setText("");
//					
//				}
			//	else {
				try {
					switch(operator){
					
					
						case "1":
		//				if(num2 == 0.0) {
		//					result = 0.0;
		//				}
		//				else {
							result =num1 - num2;
		//				}
						break;
		
						case "2": result = num1 + num2;
						break;
						case "3": result = num1 * num2;
						break;
						case "4": if(num2==0) {
										textField.setText("UNDEFINED");
										answer= true;
										return;
									}
									else{
										result = num1 / num2;
									}
									
						break;
						default:result=1;
					}
				
				
					rslt = (int) result;
					if(rslt==result) {
						textField.setText(""+rslt);
						answer = true;
					}
					else {
						textField.setText(""+result);
						answer = true;
					}
				}
					catch(Exception op) {
						
					}
				
			
			}
			
		});
		
		
		
		JButton btnClear = new JButton("C");
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnClear.setBounds(128, 99, 72, 47);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textField.setText(null);
			}
			
		});
		panel.setLayout(null);
		panel.add(textField);
		panel.add(btn_0);
		panel.add(btn_1);
		panel.add(btn_4);
		panel.add(btn_7);
		panel.add(btnAllClear);
		panel.add(btnDot);
		panel.add(btn_2);
		panel.add(btn_5);
		panel.add(btn_8);
		panel.add(btnSign);
		panel.add(btnEqual);
		panel.add(btn_3);
		panel.add(btn_6);
		panel.add(btn_9);
		panel.add(btnNewButton_9);
		panel.add(btnMultiply);
		panel.add(btnSub);
		panel.add(btnAdd);
		panel.add(btnClear);
		panel.add(btnDivide);
		

	}
}
