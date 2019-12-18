package Ислам;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
@SuppressWarnings("serial")
public class formula extends JFrame {

	private static final int WIDTH = 500;
	private static final int HEIGHT = 500;
	Double sum=0.0;
	private double t=0;
	private JTextField textFieldX;
	private JTextField textFieldY;
	private JTextField textFieldZ;
	private JTextField textFieldResult; 
	private JTextField memoryTextField;
	private ButtonGroup radioButtons=new ButtonGroup();
	private ButtonGroup radioMemoryButtons = new ButtonGroup();
	private Box hboxFormulaType=Box.createHorizontalBox();
	private Box hBoxMemoryType = Box.createHorizontalBox();
	private int formulaID=1;
	private int memoryId= 1;

	private Double mem1 = new Double(0);
	private Double mem2 = new Double(0);
	private Double mem3 = new Double(0);
	private Double calculate1 (Double x, Double y,Double z) {
		return (Math.sin(y)+y*y+Math.exp(Math.cos(y)))*(Math.pow((Math.log(z)+Math.sin(Math.PI*x*x)),1/4));
	}
	private Double calculate2 (Double x, Double y, Double z) {
		return (Math.pow((y+x*x*x), 1/z))/Math.log(z);
	}
	private void addRadioButton(String buttonName,final int formulaID) {
		JRadioButton button=new JRadioButton(buttonName);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				formula.this.formulaID=formulaID;
			}
		});
		radioButtons.add(button);
		hboxFormulaType.add(button);
	}
	private void addMemoryRadioButton (String buttonName, final int memoryId)	{
		JRadioButton button = new JRadioButton(buttonName);
		
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event)	{
				formula.this.memoryId = memoryId;
				if (memoryId == 1)	memoryTextField.setText(mem1.toString());
				if (memoryId == 2)	memoryTextField.setText(mem2.toString());
				if (memoryId == 3)	memoryTextField.setText(mem3.toString());
			}
		});
		
		radioMemoryButtons.add(button);
		hBoxMemoryType.add(button);
	}
	public formula() {
		super("Вычисление формулы");
		setSize(WIDTH,HEIGHT);
		Toolkit kit=Toolkit.getDefaultToolkit();
		setLocation((kit.getScreenSize().width-WIDTH)/2,(kit.getScreenSize().height-HEIGHT)/2);
		
		hboxFormulaType.add(Box.createHorizontalGlue());
		addRadioButton("формула 1",1);
		addRadioButton("формула 2",2);
		radioButtons.setSelected(radioButtons.getElements().nextElement().getModel(), true);
		hboxFormulaType.add(Box.createHorizontalGlue());
		hboxFormulaType.setBorder(BorderFactory.createLineBorder(Color.YELLOW));
		
		
		
		JLabel labelForX=new JLabel("X:");
		textFieldX=new JTextField("0",10);
		textFieldX.setMaximumSize(textFieldX.getPreferredSize());
		JLabel labelForY=new JLabel("Y:");
		textFieldY=new JTextField("0",10);
		textFieldY.setMaximumSize(textFieldY.getPreferredSize());
		JLabel labelForZ=new JLabel("Z:");
		textFieldZ=new JTextField("0",10);
		textFieldZ.setMaximumSize(textFieldZ.getPreferredSize());
		Box hboxVariables = Box.createHorizontalBox();
		hboxVariables.setBorder(
		BorderFactory.createLineBorder(Color.RED));
		hboxVariables.add(Box.createHorizontalGlue());
		hboxVariables.add(labelForX);
		hboxVariables.add(Box.createHorizontalStrut(10));
		hboxVariables.add(textFieldX);
		hboxVariables.add(Box.createHorizontalStrut(10));
		hboxVariables.add(labelForY);
		hboxVariables.add(Box.createHorizontalStrut(10));
		hboxVariables.add(textFieldY);
		hboxVariables.add(Box.createHorizontalStrut(10));
		hboxVariables.add(labelForZ);
		hboxVariables.add(Box.createHorizontalStrut(10));
		hboxVariables.add(textFieldZ);
		hboxVariables.add(Box.createHorizontalGlue());
		
		JLabel labelForResult = new JLabel("результат:");
		textFieldResult = new JTextField("0", 15);
		textFieldResult.setMaximumSize(textFieldResult.getPreferredSize());
		Box hboxResult = Box.createHorizontalBox();
		hboxResult.add(Box.createHorizontalGlue());
		hboxResult.add(labelForResult);
		hboxResult.add(Box.createHorizontalStrut(10));
		hboxResult.add(textFieldResult);
		hboxResult.add(Box.createHorizontalGlue());
		hboxResult.setBorder(BorderFactory.createLineBorder(Color.BLUE));
		
		JButton buttonCalc = new JButton("вычислить");
		buttonCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
					try {
							Double x = Double.parseDouble(textFieldX.getText());
							Double y = Double.parseDouble(textFieldY.getText());
							Double z = Double.parseDouble(textFieldZ.getText());
							Double result;
							if (formulaID==1)
								
								result = calculate1(x, y,z);
							else
								result = calculate2(x, y,z);
							t=result;
							sum=result;
							textFieldResult.setText(result.toString());
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(formula.this,
								"Ошибка в формате записи числа с плавающей точкой", "Ошибочный формат числа",
								JOptionPane.WARNING_MESSAGE);
					}
			}
		});
		hBoxMemoryType.add(Box.createHorizontalGlue());
		addMemoryRadioButton("формула 1", 1);
		addMemoryRadioButton("формула 2", 2);
		addMemoryRadioButton("формула 3", 3);
		radioMemoryButtons.setSelected(radioMemoryButtons.getElements().nextElement().getModel(), true); 
		hBoxMemoryType.add(Box.createHorizontalGlue()); 
		hBoxMemoryType.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		JButton sumButton=new JButton("M+");
		sumButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ev) {
				try {
					Double result = Double.parseDouble(textFieldResult.getText());
					if (memoryId == 1) 	
					{
						mem1 += result;memoryTextField.setText(mem1.toString());
					}
					if (memoryId == 2)
					{
						mem2 += result;memoryTextField.setText(mem2.toString());
					}
					if (memoryId == 3)
					{
						mem3 += result;memoryTextField.setText(mem3.toString());
					}
					sum+=t;
				textFieldResult.setText(sum.toString());
				}catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(formula.this,
							"Ошибка в формате записи числа с плавающей точкой", "Ошибочный формат числа",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		JButton buttonReset = new JButton("Очистить поля");
		buttonReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				textFieldX.setText("0");
				textFieldY.setText("0");
				textFieldZ.setText("0");
				textFieldResult.setText("0");
				sum=0.0;
				t=0;
			}
		});
		JButton buttonMC=new JButton("MC");
		buttonMC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				t=0;
				sum=0.0;
				if (memoryId == 1)	mem1 = (double) 0;
				if (memoryId == 2)	mem2 = (double) 0;
				if (memoryId == 3)	mem3 = (double) 0;
				memoryTextField.setText("0.0");
				textFieldResult.setText("0");
			}
		});
		memoryTextField = new JTextField("0.0", 15);
		memoryTextField.setMaximumSize(memoryTextField.getPreferredSize());
		
		Box hBoxMemoryField = Box.createHorizontalBox();
		hBoxMemoryField.add(Box.createHorizontalGlue());
		hBoxMemoryField.add(memoryTextField);
		hBoxMemoryField.add(Box.createHorizontalGlue());
		Box hboxButtons = Box.createHorizontalBox();
		hboxButtons.add(Box.createHorizontalGlue());
		hboxButtons.add(buttonCalc);
		hboxButtons.add(Box.createHorizontalStrut(30));
		hboxButtons.add(buttonReset);
		hboxButtons.add(Box.createHorizontalStrut(30));
		hboxButtons.add(sumButton);
		hboxButtons.add(Box.createHorizontalStrut(30));
		hboxButtons.add(buttonMC);
		hboxButtons.add(Box.createHorizontalGlue());
		hboxButtons.setBorder(
		BorderFactory.createLineBorder(Color.GREEN));
		
		Box contentBox = Box.createVerticalBox();
		contentBox.add(Box.createVerticalGlue());
		contentBox.add(hboxFormulaType);
		contentBox.add(hboxVariables);
		contentBox.add(hBoxMemoryType);
		contentBox.add(hBoxMemoryField); 
		contentBox.add(hboxResult);
		contentBox.add(hboxButtons);
		contentBox.add(Box.createVerticalGlue());
		getContentPane().add(contentBox, BorderLayout.CENTER);
		}

	
}
