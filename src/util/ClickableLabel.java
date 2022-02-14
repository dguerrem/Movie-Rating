package util;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.JLabel;

public class ClickableLabel extends JLabel {

	private static final long serialVersionUID = 1L;

	public ClickableLabel() {
		this("");
	}

	public ClickableLabel(String label) {
		super(label);

		setForeground(Color.BLUE.darker());
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		g.setColor(Color.blue);

		Insets insets = getInsets();

		int left = insets.left;
		if (getIcon() != null) {
			left += getIcon().getIconWidth() + getIconTextGap();
		}

		g.drawLine(left, getHeight() - 1 - insets.bottom, (int) getPreferredSize().getWidth() - insets.right,
				getHeight() - 1 - insets.bottom);
	}

}