package kh.java;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import kh.java.Shape.Tetrominoes;

public class Board extends JPanel implements ActionListener {

	final int BoardWidth = 10;
	final int BoardHeight = 25;

	Timer timer;
	boolean isFallingFinished = false;
	boolean isStarted = false;
	boolean isPaused = false;
	int numLinesRemoved = 0;
	int curX = 0;
	int curY = 0;
	int score = 0, point = 0;
	JLabel statusbar;
	Shape curPiece;
	Tetrominoes[] board;
	Random r = new Random();
	
	public Board(Tetris parent) 
	{
		setFocusable(true);
		curPiece = new Shape();
		timer = new Timer(100, this);
		timer.start();
		statusbar = parent.getStatusBar();
		board = new Tetrominoes[BoardWidth * BoardHeight];
		addKeyListener(new TAdapter());
		clearBoard();
	}

	public void actionPerformed(ActionEvent e) 
	{
		if (isFallingFinished) 
		{
			isFallingFinished = false;
			newPiece(); // 새로운 블록 생성
		} 
		else 
		{
			oneLineDown(); // 한 줄 내림
		}
	}

	int squareWidth() //가로
	{
		return (int) getSize().getWidth() / BoardWidth;
	}

	int squareHeight() //높이
	{
		return (int) getSize().getHeight() / BoardHeight;
	}

	Tetrominoes shapeAt(int x, int y) 
	{
		return board[(y * BoardWidth) + x];
	}

	public void start() // 시작할 경우
	{
		if (isPaused)
			return;
		isStarted = true;
		isFallingFinished = false;
		statusbar.setText("현재 제거된 줄 수 : " + numLinesRemoved + " 점수 : " + point);
		numLinesRemoved = 0;
		clearBoard(); //블록 청소
		newPiece(); // 새로운 블록
		timer.start();
	}
	public void restart()
	{
		timer.stop();
		// 버튼 누르면 재시작
	}
	private void pause() 
	{
		if (!isStarted)
			return;
		isPaused = !isPaused;
		if (isPaused) 
		{
			timer.stop();
			statusbar.setText("paused");
		} 
		else 
		{
			timer.start();
			statusbar.setText("현재 제거된 줄 수 : " + numLinesRemoved + " 점수 : " + point);
		}
		repaint();
	}

	public void paint(Graphics g) 
	{
		super.paint(g);

		Dimension size = getSize();
		int boardTop = (int) size.getHeight() - BoardHeight * squareHeight();

		for (int i = 0; i < BoardHeight; ++i) 
		{
			for (int j = 0; j < BoardWidth; ++j) 
			{
				Tetrominoes shape = shapeAt(j, BoardHeight - i - 1);
				if (shape != Tetrominoes.NoShape)
					drawSquare(g, 0 + j * squareWidth(), boardTop + i * squareHeight(), shape);
			}
		}

		if (curPiece.getShape() != Tetrominoes.NoShape) 
		{
			for (int i = 0; i < 4; ++i) 
			{
				int x = curX + curPiece.x(i);
				int y = curY - curPiece.y(i);
				drawSquare(g, 0 + x * squareWidth(), boardTop + (BoardHeight - y - 1) * squareHeight(),
						curPiece.getShape());
			}
		}
	}

	private void dropDown() 
	{
		int newY = curY;
		while (newY > 0) 
		{
			if (!tryMove(curPiece, curX, newY - 1))
				break;
			--newY;
		}
		pieceDropped();
	}
	private void Shadow()
	{
		int newY = curY;
		while(newY >0)
		{
			//if
		}
	}
	private void oneLineDown() 
	{
		if (!tryMove(curPiece, curX, curY - 1))
			pieceDropped();
	}

	private void clearBoard() 
	{
		for (int i = 0; i < BoardHeight * BoardWidth; ++i)
			board[i] = Tetrominoes.NoShape;
	}

	private void pieceDropped() 
	{
		for (int i = 0; i < 4; ++i) 
		{
			int x = curX + curPiece.x(i);
			int y = curY - curPiece.y(i);
			board[(y * BoardWidth) + x] = curPiece.getShape();
		}
		removeFullLines();
		if (!isFallingFinished)
			newPiece();
	}
	private void newPiece() 
	{
		curPiece.setRandomShape();
		curX = BoardWidth / 2 + 1;
		curY = BoardHeight - 1 + curPiece.minY();
		if (!tryMove(curPiece, curX, curY)) 
		{
			curPiece.setShape(Tetrominoes.NoShape);
			timer.stop();
			isStarted = false;
			statusbar.setText("game over");
			statusbar.setText("game over " +", 총 제거된 줄 수 : " + numLinesRemoved + ", 총 점수 : " + point);
		}
	}
	private boolean tryMove(Shape newPiece, int newX, int newY) 
	{
		for (int i = 0; i < 4; ++i) 
		{
			int x = newX + newPiece.x(i);
			int y = newY - newPiece.y(i);
			if (x < 0 || x >= BoardWidth || y < 0 || y >= BoardHeight)
				return false;
			if (shapeAt(x, y) != Tetrominoes.NoShape)
				return false;
		}
		curPiece = newPiece;
		curX = newX;
		curY = newY;
		repaint();
		return true;
	}
	private void removeFullLines() 
	{
		int numFullLines = 0;
		score = r.nextInt(50) + 1;
		for (int i = BoardHeight - 1; i >= 0; --i) 
		{
			boolean lineIsFull = true;
			point += score;
			for (int j = 0; j < BoardWidth; ++j) 
			{
				if (shapeAt(j, i) == Tetrominoes.NoShape) 
				{
					lineIsFull = false;
					break;
				}
			}
			if (lineIsFull) 
			{
				++numFullLines;
				for (int k = i; k < BoardHeight - 1; ++k) 
				{
					for (int j = 0; j < BoardWidth; ++j)
						board[(k * BoardWidth) + j] = shapeAt(j, k + 1);
				}
			}
		}
		if (numFullLines > 0) 
		{
			numLinesRemoved += numFullLines;
			statusbar.setText("현재 제거된 줄 수 : " + String.valueOf(numLinesRemoved) + " 점수 : " + point);
			isFallingFinished = true;
			curPiece.setShape(Tetrominoes.NoShape);
			repaint();
		}
	}
	private void drawSquare(Graphics g, int x, int y, Tetrominoes shape) 
	{
		Color colors[] = { new Color(0, 0, 0), // NoShape 배경색
				new Color(255, 0, 0), // ZShape
				new Color(89, 218, 80), // SShape
				new Color(0, 216, 255), // LineShape
				new Color(128, 65, 217), // TShape
				new Color(255, 225, 0), // SquareShape
				new Color(255, 170, 0), // LShape
				new Color(1, 0, 253) // MirroredLShape
	};
		Color color = colors[shape.ordinal()];
		g.setColor(color);
		g.fillRect(x + 1, y + 1, squareWidth() - 2, squareHeight() - 2);
		g.setColor(color.brighter());
		g.drawLine(x, y + squareHeight() - 1, x, y);
		g.drawLine(x, y, x + squareWidth() - 1, y);
		g.setColor(color.darker());
		g.drawLine(x + 1, y + squareHeight() - 1, x + squareWidth() - 1, y + squareHeight() - 1);
		g.drawLine(x + squareWidth() - 1, y + squareHeight() - 1, x + squareWidth() - 1, y + 1);
	}
	class TAdapter extends KeyAdapter 
	{
		public void keyPressed(KeyEvent e) 
		{
			if (!isStarted || curPiece.getShape() == Tetrominoes.NoShape) 
			{
				return;
			}
			int keycode = e.getKeyCode();
			if (keycode == 27 || keycode == 27) 
			{
				pause();
				return;
			}
			if (isPaused)
				return;
			switch (keycode) 
			{
			case KeyEvent.VK_LEFT:
				tryMove(curPiece, curX - 1, curY);
				break;
			case KeyEvent.VK_RIGHT:
				tryMove(curPiece, curX + 1, curY);
				break;
			case KeyEvent.VK_DOWN:
				oneLineDown();
				break;
			case KeyEvent.VK_UP:
				tryMove(curPiece.rotateLeft(), curX, curY);
				break;
			case KeyEvent.VK_SPACE:
				dropDown();
				break;
			}
		}
	}
}