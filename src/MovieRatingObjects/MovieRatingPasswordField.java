package MovieRatingObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPasswordField;

public class MovieRatingPasswordField extends JPasswordField {
	private static final long serialVersionUID = 1L;
	private Icon prefixIcon;
	private Icon suffixIcon;

	public MovieRatingPasswordField() {
		setBorder(javax.swing.BorderFactory.createEmptyBorder(7, 10, 7, 10));
	}

	public void setPrefixIcon(Icon prefixIcon) {
		this.prefixIcon = prefixIcon;
		initBorder();
	}

	public void setSuffixIcon(Icon suffixIcon) {
		this.suffixIcon = suffixIcon;
		initBorder();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		paintIcon(g);
		// paint border
		if (isFocusOwner()) {
			g.setColor(new Color(6, 135, 196));
			g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
			g.drawRect(1, 1, getWidth() - 3, getHeight() - 3);
		} else {
			g.setColor(new Color(76, 181, 195));
			g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
			g.drawRect(1, 1, getWidth() - 3, getHeight() - 3);
		}
	}

	private void paintIcon(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		if (prefixIcon != null) {
			Image prefix = ((ImageIcon) prefixIcon).getImage();
			int y = (getHeight() - prefixIcon.getIconHeight()) / 2;
			g2.drawImage(prefix, 3, y, this);
		}
		if (suffixIcon != null) {
			Image suffix = ((ImageIcon) suffixIcon).getImage();
			int y = (getHeight() - suffixIcon.getIconHeight()) / 2;
			g2.drawImage(suffix, getWidth() - suffixIcon.getIconWidth() - 3, y, this);
		}
	}

	private void initBorder() {
		int left = 5;
		int right = 5;

		if (prefixIcon != null) {
			left = prefixIcon.getIconWidth() + 10;
		}
		if (suffixIcon != null) {
			right = suffixIcon.getIconWidth() + 10;
		}
		setBorder(javax.swing.BorderFactory.createEmptyBorder(7, left, 7, right));
	}
	
	public void formatoErroneo(Graphics g) {
		if (isFocusOwner()) {
			g.setColor(new Color(196, 6, 6));
			g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
			g.drawRect(1, 1, getWidth() - 3, getHeight() - 3);
		} else {
			g.setColor(new Color(195, 76, 76));
			g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
			g.drawRect(1, 1, getWidth() - 3, getHeight() - 3);
		}
	}
}
