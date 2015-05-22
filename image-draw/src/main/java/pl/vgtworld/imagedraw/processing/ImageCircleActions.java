package pl.vgtworld.imagedraw.processing;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

import pl.vgtworld.imagedraw.ImageDrawEntity;

class ImageCircleActions {

	void drawCircle(ImageDrawEntity image, Color color, Point startingPoint,int radius) {
		Graphics2D graphics = image.getImage().createGraphics();
		graphics.setColor(color);
		graphics.drawOval(startingPoint.x, startingPoint.y, radius, radius);

		graphics.dispose();
	}

}
