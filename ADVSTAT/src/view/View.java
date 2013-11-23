package view;
import java.awt.Dimension;
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
import model.Sample;

import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;

import view.GraphUpdateEvent.UpdateType;



public class View extends JFrame implements ChangeListener, KeyListener, ActionListener{
	MainPanel mainPanel;
	ViewTable table;
	private GraphUpdateListener listener;
	private static final boolean HideParameterPanelWhenError = true;
	
	
	
	/* =======================================================================================
	 * = JFrame construction
	 * =======================================================================================
	 */
	public View(){ 
		super("Sampling Distribution");
		setResizable(false);
		setPreferredSize(new Dimension(900,800));
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
				JOptionPane.showMessageDialog(null, "This software was developed by Darren Sapalo, Marvin Bables, and Jefferson Cordero for submission to ADVSTAT.");
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
			Object src = e.getSource();
			ParameterPanel parameterPanel = mainPanel.parameterPanel;
			
			if (src instanceof JSlider){
				int N = parameterPanel.getPopulationSize();
				int n = Sample.Size = parameterPanel.getSampleSize();
				parameterPanel.updatePopulation(N);
				parameterPanel.updateSample(n);
			}
		}
		public void keyReleased(KeyEvent evt) {
			// Trigger(evt.getSource());
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			Trigger(e.getSource());
		}
		
		public void keyPressed(KeyEvent evt) {}		
		public void keyTyped(KeyEvent evt) {}
		
	/* =======================================================================================
	 * = Update handling
	 * =======================================================================================
	 */

	public void Trigger(Object src) {
		ParameterPanel parameterPanel = mainPanel.parameterPanel;
		try {
			parameterPanel.clearErrors();
			int u = parameterPanel.getUpperB();
			int l = parameterPanel.getLowerB();
			int N;

			N = parameterPanel.getN();
			parameterPanel.setPopulation(N);
			parameterPanel.setSample(Sample.Size);
			parameterPanel.updatePopulation(N);
			parameterPanel.updateSample(Sample.Size);
			UpdateType type = parameterPanel.getType(src);
			if (parameterPanel.isInputValid() && parameterPanel.shouldDisplayGraph()){
				Parameters newParam = new Parameters(Sample.Size, N, u, l, parameterPanel.getGenerationType());
				if (HideParameterPanelWhenError)parameterPanel.sliderPanel.setVisible(true);
				listener.updatePerformed(new GraphUpdateEvent(src, newParam, type));
			}
		} catch(Exception e) {
			if (HideParameterPanelWhenError)parameterPanel.sliderPanel.setVisible(false);
			parameterPanel.clearErrors();
			parameterPanel.setError(e.getMessage());
			
		}
	}
	
	public void UpdatePopulationGraph(CategoryDataset dataset){
	        mainPanel.updatePopulationDomain(dataset);
	}

	public void UpdateSampleGraph(CategoryDataset dataset) {
		mainPanel.updateSamplingDomain(dataset);
		
	}

	
	
}
