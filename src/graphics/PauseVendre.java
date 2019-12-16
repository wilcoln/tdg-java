package graphics;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

import element.actif.Obstacle;
import graphics.TerrainGraphique;
import jeu.Partie;

public class PauseVendre{

	private JFrame frame;
	private JComboBox obstacles;
	private Partie partie;

	/**
	 * Create the application.
	 */
	public PauseVendre(Partie p) {
		this.partie = p;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 200, 100);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();

		obstacles = new JComboBox(partie.getObstaclesPresents().toArray());
		panel.add(obstacles);

		JButton bouton = new JButton("Valider");
		bouton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				partie.getJoueur().vendreObstacle(((Obstacle) obstacles.getSelectedItem()).clone());
				frame.setVisible(false);
			}
		});
		panel.add(bouton);
		frame.setContentPane(panel);
		frame.setVisible(true);

	}
}