package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InitialPage extends JFrame {

	private OnScheduleListener actionListener;
	
	private JPanel contentPane;
	private JTextField inputCName;
	private JTextField inputCHour;
	private JTextField inputDate;

	/**
	 * Create the frame.
	 */
	public InitialPage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		inputCName = new JTextField();
		inputCName.setBounds(52, 88, 104, 20);
		contentPane.add(inputCName);
		inputCName.setColumns(10);
		
		inputCHour = new JTextField();
		inputCHour.setBounds(166, 88, 104, 20);
		contentPane.add(inputCHour);
		inputCHour.setColumns(10);
		
		JLabel lblClassName = new JLabel("Class Name");
		lblClassName.setBounds(52, 63, 104, 14);
		contentPane.add(lblClassName);
		
		JLabel lblClassHour = new JLabel("Class Hour");
		lblClassHour.setBounds(166, 59, 104, 23);
		contentPane.add(lblClassHour);
		
		JLabel lblexOr = new JLabel(" (Hour must be like: 09:30 or 21:05)");
		lblexOr.setBounds(79, 134, 272, 14);
		contentPane.add(lblexOr);
		
		JLabel lblexBodypumpOr = new JLabel(" (Class must be like: BODYPUMP or V-RPM)");
		lblexBodypumpOr.setBounds(79, 118, 272, 14);
		contentPane.add(lblexBodypumpOr);
		
		JLabel lblLazyfitness = new JLabel("LazyFitness");
		lblLazyfitness.setFont(new Font("Copperplate Gothic Light", Font.BOLD, 14));
		lblLazyfitness.setBounds(168, 11, 172, 23);
		contentPane.add(lblLazyfitness);
		
		inputDate = new JTextField();
		inputDate.setColumns(10);
		inputDate.setBounds(282, 88, 104, 20);
		contentPane.add(inputDate);
		
		JLabel lblDate = new JLabel("Date ");
		lblDate.setBounds(282, 59, 104, 23);
		contentPane.add(lblDate);
		
		JLabel lbldateEx = new JLabel(" (Date must be like: 01/02/2018 or 23/10/2018)");
		lbldateEx.setBounds(79, 148, 272, 14);
		contentPane.add(lbldateEx);
		
		JButton btnNewButton = new JButton("Schedule Reservation");
		btnNewButton.setBounds(144, 173, 163, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(actionListener != null){
					if(inputCName.getText().length() >= 3 && inputCHour.getText().length() == 5 && inputDate.getText().length() == 10) {
						actionListener.onActionSchedule(inputCName.getText(), inputCHour.getText(), inputDate.getText());
						inputCName.setText(null);
						inputCHour.setText(null);
						inputDate.setText(null);
					}
				}
			}
		});
		contentPane.add(btnNewButton);
		
		JButton btnDeleteLastSchedule = new JButton("Delete Last Schedule");
		btnDeleteLastSchedule.setBounds(144, 207, 163, 23);
		btnDeleteLastSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(actionListener != null){
					actionListener.onDeleteSchedule();
				}
			}
		});
		contentPane.add(btnDeleteLastSchedule);

	}
	
	public void setOnScheduleListener(OnScheduleListener listener){
		actionListener = listener;
	}
}
