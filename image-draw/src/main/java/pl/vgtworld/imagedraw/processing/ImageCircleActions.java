package pl.vgtworld.imagedraw.processing;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;

import pl.vgtworld.imagedraw.ImageDrawEntity;

class ImageCircleActions {

	void drawCircle(ImageDrawEntity image, Color color, Point startingPoint,int radius,float thick) {
		Graphics2D graphics = image.getImage().createGraphics();
		graphics.setColor(color);
		//获取默认的线条
		Stroke stroke = graphics.getStroke();
		graphics.setStroke(new BasicStroke(thick, BasicStroke.CAP_SQUARE, BasicStroke.JOIN_ROUND));
		graphics.drawOval(startingPoint.x, startingPoint.y, radius, radius);
		
		//还原
		graphics.setStroke(stroke);
		graphics.dispose();
	}

}
