import java.awt.*;
import java.awt.event.*;

/*
	2.8.	Да се състави Applit или Application на Java, имащ следната функционалност:
			1) начертава една окръжност (с радиус около 100 пиксела)
			2) при щракване с мишката вътре в кръга той сменя цвета си, а вън от него - не.
*/
public class CircleChangesColor extends Frame implements MouseListener {

	private static int _diameter = 200;
	private static int _circleX = 300;
	private static int _circleY = 200;
	private static int _currentColorIndex;
	private static Color[] _colors = new Color[] { Color.RED, Color.YELLOW, Color.BLUE, Color.GREEN, Color.WHITE, Color.CYAN, Color.BLACK, Color.ORANGE, Color.PINK };;
	
	public static void main(String[] args) {
		_currentColorIndex = 0;
		CircleChangesColor frame = new CircleChangesColor();
		frame.setTitle("Кръг, който сменя цвета си при натискане с мишката върху него");
		frame.setLocation(400, 300);
		frame.setSize(800, 600);
		frame.setBackground(Color.LIGHT_GRAY);
		frame.addWindowListener(new WindowClosingAdapter(false));
		frame.setVisible(true);
		frame.addMouseListener(frame);
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(_colors[_currentColorIndex]);
		g.fillOval(_circleX, _circleY, _diameter, _diameter);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (!MouseIsInCircle(e.getX(), e.getY())) {
			return;
		}
		
		_currentColorIndex++;
		if (_currentColorIndex >= _colors.length) {
			_currentColorIndex = 0;
		}

		repaint();
	}
	
	private static Boolean MouseIsInCircle(int mouseX, int mouseY) {
		int radius = _diameter / 2;
		int centerX = _circleX + radius;
		int centerY = _circleY + radius;
		
		int yDiff = Math.abs(centerY - mouseY);
		int xDiff = Math.abs(centerX - mouseX);
		
		return Math.pow(radius, 2) >= Math.pow(xDiff, 2) + Math.pow(yDiff, 2);
	}

	@Override
	public void mousePressed(MouseEvent e) {}

	@Override
	public void mouseReleased(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}
}
