package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;


import model.Model.GenerationType;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;



public class View extends JFrame implements ChangeListener, KeyListener{
	MainPanel mainPanel;
	ViewTable table;
	private GraphUpdateListener listener;
	
	
	
	/* =======================================================================================
	 * = JFrame construction
	 * =======================================================================================
	 */
	public View(){ 
		super("Hypergeometric Probability Distribution");
		
		
		// JMenu
		JMenuBar menu = new JMenuBar();
		setJMenuBar(menu);
		
		JMenu File = new JMenu("File");
		menu.add(File);
		
		JMenuItem About = new JMenuItem("About");
		
		File.add(About);
		File.setMnemonic('A');
		
		About.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "This software was developed by Darren Sapalo, Marvin Bables, and Roberto Cruz for submission to ST-STAT.");
			}
		});
		
		
		// JTabbedPane
		
		JTabbedPane tabbedPane = new JTabbedPane();
         
        JComponent panel1 = mainPanel = new MainPanel();
        tabbedPane.addTab("Graph", panel1);
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
         
        JComponent panel2 = table = new ViewTable();
        tabbedPane.addTab("Table", panel2);
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
        
        add(tabbedPane);
        
        
        // Frame settings
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		requestFocus();
	}

	/* =======================================================================================
	 * = Listeners
	 * =======================================================================================
	 */

	public void addGraphListener(GraphUpdateListener listener) {
		this.listener = listener;
		mainPanel.addGraphListener(this);
	}
	

		public void stateChanged(ChangeEvent e) {
			Trigger(e.getSource());	
		}
		public void keyReleased(KeyEvent evt) {
			Trigger(evt.getSource());
		}
	
		
		public void keyPressed(KeyEvent evt) {}		
		public void keyTyped(KeyEvent evt) {}
		
	/* =======================================================================================
	 * = Update handling
	 * =======================================================================================
	 */

	public void Trigger(Object src) {
		try {
			ParameterPanel parameterPanel = mainPanel.parameterPanel;
			parameterPanel.clearErrors();
			int n = parameterPanel.getn(src);
			int u = parameterPanel.getUpperB();
			int l = parameterPanel.getLowerB();
			int N = parameterPanel.getN();
			if (parameterPanel.shouldDisplayGraph()){
				
				if (src instanceof JTextField){
					parameterPanel.setMaximumK(N);
				}
				
				Parameters newParam = new Parameters(n, N, u, l, parameterPanel.getMinimumK(), parameterPanel.getMaximumK(), GenerationType.Bimodal);
				
				listener.updatePerformed(new GraphUpdateEvent(src, newParam));
			}
		} catch(Exception e) {
			mainPanel.parameterPanel.clearErrors();
			
		}
	}
	
	public void UpdatePopulationGraph(double[][] data){
		CategoryDataset dataset = DatasetUtilities.createCategoryDataset(
	            "Series ", "", data
	        );
	        mainPanel.updatePopulationDomain(dataset);
	        table.updateTable(data);
	}
	
	
	
}
