package JpanelsEvent;

import java.awt.Color;

import javax.swing.JPanel;

public class JpanelMouseEvent {
	private JPanel panel;
	public JpanelMouseEvent(JPanel panel) {
		this.panel = panel;
	}
	public void AccueilpnMouseEntered(java.awt.event.MouseEvent evt) {
		panel.setForeground(Color.black);
		panel.setBackground(new Color(13,190,255));
    }
	public void AccueilpnMouseExited(java.awt.event.MouseEvent evt) {
		panel.setForeground(Color.black);

		panel.setBackground(Color.white);
    }
	
}
