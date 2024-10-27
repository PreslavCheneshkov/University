import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Exam extends Frame implements ActionListener {

	private static ArrayList<Integer> _baseSizes;
	private static int _shapeCode;
	private static int _centerX;
	private static int _centerY;
	
	private static int _lastFigureCenterX;
	private static int _lastFigureCenterY;
	
	private TextField _upTextField;
	private TextField _downTextField;
	private TextField _leftTextField;
	private TextField _rightTextField;
	
	private static int _upCount;
	private static int _downCount;
	private static int _rightCount;
	private static int _leftCount;
	
	public Exam(int windowWidth, int windowHeight) {
		this.setBackground(Color.LIGHT_GRAY);
		this.setSize(windowWidth, windowHeight);
		this.setTitle("Преслав Бисеров Ченешков 10");
		this.setVisible(true);
		this.addWindowListener(new WindowClosingAdapter(true));
		this.setLayout(new FlowLayout());
		
		_upTextField = new TextField(Integer.toString(_upCount));
		_downTextField = new TextField(Integer.toString(_downCount));
		_leftTextField = new TextField(Integer.toString(_leftCount));
		_rightTextField = new TextField(Integer.toString(_rightCount));
		
		setLayout(new BorderLayout());
		Panel panel = new Panel();
		panel.setLayout(new GridLayout(4, 2, 20, 20));
		
		addButton("Нагоре", panel, _upTextField);
		addButton("Надолу", panel, _downTextField);
		addButton("Наляво", panel, _leftTextField);
		addButton("Надясно", panel, _rightTextField);
		
		add(panel, BorderLayout.EAST);
	}
	
	private void addButton(String label, Panel panel, TextField textField) {
		Button btn = new Button(label);
		btn.addActionListener(this);
		panel.add(btn);
		panel.add(textField);
	}
	
	public static void main(String[] args) throws IOException {
	
		_upCount = 0;
		_downCount = 0;
		_rightCount = 0;
		_leftCount = 0;
		
		FileReader fileReader = new FileReader("src\\AlaBala.txt");
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		String textLine = bufferedReader.readLine();
		String[] splitLine = textLine.split(" ");
		int width = Integer.parseInt(splitLine[0]);
		int height = Integer.parseInt(splitLine[1]);
		
		String facultyNumber = bufferedReader.readLine();
		
		_shapeCode = Integer.parseInt(bufferedReader.readLine());
		
		textLine = bufferedReader.readLine();
		splitLine = textLine.split(" ");
		_centerX = Integer.parseInt(splitLine[0]);
		_centerY = Integer.parseInt(splitLine[1]);
		
		_lastFigureCenterX = _centerX;
		_lastFigureCenterY = _centerY;
		
		_baseSizes = new ArrayList<Integer>();
		
		textLine = bufferedReader.readLine();
		
		while (textLine != null) {
			_baseSizes.add(Integer.parseInt(textLine));
			textLine = bufferedReader.readLine();
		}
		
		Exam exam = new Exam(width, height);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case "Нагоре": 
				
				if (_upCount < 10) {
					_lastFigureCenterY -= 10;
					_upCount++;
					_upTextField.setText(Integer.toString(_upCount));
				}
				break;
			case "Надолу": 
				if (_downCount < 10) {
					_lastFigureCenterY += 10;
					_downCount++;
					_downTextField.setText(Integer.toString(_downCount));
				}
				break;
			case "Наляво": 
				if (_leftCount < 10) {
					_lastFigureCenterX -= 10; 
					_leftCount++;
					_leftTextField.setText(Integer.toString(_leftCount));
				}
				break;
			case "Надясно":
				if (_rightCount < 10) {
					_lastFigureCenterX += 10; 
					_rightCount++;
					_rightTextField.setText(Integer.toString(_rightCount));
				}
				break;
		}
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		int currentCenterX, currentCenterY;
		g.setColor(Color.YELLOW);
		for (int i = 0; i < _baseSizes.size(); i++) {
			if (i != _baseSizes.size() - 1) {
				currentCenterX = _centerX;
				currentCenterY = _centerY;
			} else {
				currentCenterX = _lastFigureCenterX;
				currentCenterY = _lastFigureCenterY;
			}
			int currentSize = _baseSizes.get(i);
			switch (_shapeCode) {
				case 1: 
					g.setColor(Color.YELLOW);
					g.fillOval(currentCenterX - currentSize + 1, currentCenterY - currentSize + 1, (currentSize * 2) - 2, (currentSize * 2) - 2);
					g.setColor(Color.RED);
					g.drawOval(currentCenterX - currentSize, currentCenterY - currentSize, currentSize * 2, currentSize * 2);
					break;
				case 2: 
					g.setColor(Color.YELLOW);
					g.fillRect(currentCenterX - currentSize + 1, currentCenterY - (currentSize / 2) + 1, (2 * currentSize) - 2, currentSize - 2);
					g.setColor(Color.RED);
					g.drawRect(currentCenterX - currentSize, currentCenterY - (currentSize / 2), 2 * currentSize, currentSize);
					break;
				case 3: 
					g.setColor(Color.YELLOW);
					g.fillRect(currentCenterX - (currentSize / 2) + 1, currentCenterY - (currentSize / 2) + 1, currentSize - 2, currentSize - 2);
					g.setColor(Color.RED);
					g.drawRect(currentCenterX - (currentSize / 2), currentCenterY - (currentSize / 2), currentSize, currentSize);
					break;
			}
		}	
	}
}
