import java.io.*;
import java.awt.*;
import java.util.*;

/*
	1.8 В един текстов файл са зададени данни за отсечки. В един ред са данните Х и У за първата точка, последвани от Х и У за втората точка.
	Като разделител служи интервал. Да се състави Application на Java за прочитане на този файл и графично представяне на отсечките.
*/
public class LinesFromTextCoordinates extends Frame {
	
	private static ArrayList<Line> _lines = new ArrayList<Line>();
	
	public LinesFromTextCoordinates() {
		this.setLocation(400, 300);
		this.setSize(800, 600);
		this.setBackground(Color.LIGHT_GRAY);
		this.addWindowListener(new WindowClosingAdapter(false));
		this.setVisible(true);
		this.setTitle("Отсечки, чиито координати са прочетени от LineCoordinates.txt");
	}
	
	public static void main(String[] args) throws IOException {
		LinesFromTextCoordinates frame = new LinesFromTextCoordinates();
		readCoordinates();
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.BLACK);
		
		for (int i = 0; i < _lines.size(); i++) {
			g.drawLine(_lines.get(i).fromX,
					   _lines.get(i).fromY, 
					   _lines.get(i).toX, 
					   _lines.get(i).toY);
		}
	}
	
	private static void readCoordinates() throws IOException {
		FileReader fileReader = new FileReader("src\\LineCoordinates.txt");
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String textLine = bufferedReader.readLine();
		while (textLine != null)
		{
			String[] textCoordinates = textLine.split(" ");
			Line line = new Line(Integer.parseInt(textCoordinates[0]), 
								 Integer.parseInt(textCoordinates[1]), 
								 Integer.parseInt(textCoordinates[2]), 
								 Integer.parseInt(textCoordinates[3]));
			_lines.add(line);
			textLine = bufferedReader.readLine();
		}
	}
}

class Line {
	public int fromX;
	public int fromY;
	public int toX;
	public int toY;
	
	public Line(int fromX, int fromY, int toX, int toY) {
		this.fromX = fromX;
		this.fromY = fromY;
		this.toX = toX;
		this.toY = toY;
	}
}
