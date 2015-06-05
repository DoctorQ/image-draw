package pl.vgtworld.imagedraw.processing;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Stroke;
import java.awt.geom.GeneralPath;

import pl.vgtworld.imagedraw.ImageDrawEntity;

public class ImageArrowheadActions {

	void drawArrowHead(ImageDrawEntity image, Color color, Point startingPoint,
			Point endingPoint, float thick) {
		Graphics2D graphics = image.getImage().createGraphics();
		graphics.setColor(color);
		// 获取默认的线条
		Stroke stroke = graphics.getStroke();
		graphics.setStroke(new BasicStroke(thick, BasicStroke.CAP_SQUARE,
				BasicStroke.JOIN_ROUND));
		drawAL(startingPoint.x, startingPoint.y, endingPoint.x, endingPoint.y,
				graphics);

		// 还原
		graphics.setStroke(stroke);
		graphics.dispose();
	}

	private void drawAL(int sx, int sy, int ex, int ey, Graphics2D g2) {

		double H = Math.sqrt((ex - sx) * (ex - sx) + (ey - sy) * (ey - sy)) / 10; // 箭头高度
		double L = H * 2 / 5; // 底边的一半
		int x3 = 0;
		int y3 = 0;
		int x4 = 0;
		int y4 = 0;
		double awrad = Math.atan(L / H); // 箭头角度
		double arraow_len = Math.sqrt(L * L + H * H); // 箭头的长度
		double[] arrXY_1 = rotateVec(ex - sx, ey - sy, awrad, true, arraow_len);
		double[] arrXY_2 = rotateVec(ex - sx, ey - sy, -awrad, true, arraow_len);
		double x_3 = ex - arrXY_1[0]; // (x3,y3)是第一端点
		double y_3 = ey - arrXY_1[1];
		double x_4 = ex - arrXY_2[0]; // (x4,y4)是第二端点
		double y_4 = ey - arrXY_2[1];

		Double X3 = new Double(x_3);
		x3 = X3.intValue();
		Double Y3 = new Double(y_3);
		y3 = Y3.intValue();
		Double X4 = new Double(x_4);
		x4 = X4.intValue();
		Double Y4 = new Double(y_4);
		y4 = Y4.intValue();
		// 画线
		g2.drawLine(sx, sy, ex, ey);
		// 绘制剪头
		GeneralPath triangle = new GeneralPath();
		triangle.moveTo(ex, ey);
		triangle.lineTo(x3, y3);
		triangle.lineTo(x4, y4);
		triangle.closePath();
		// 实心箭头
		// g2.fill(triangle);
		// 非实心箭头
		g2.draw(triangle);

	}

	// 计算
	private double[] rotateVec(int px, int py, double ang, boolean isChLen,
			double newLen) {

		double mathstr[] = new double[2];
		// 矢量旋转函数，参数含义分别是x分量、y分量、旋转角、是否改变长度、新长度
		double vx = px * Math.cos(ang) - py * Math.sin(ang);
		double vy = px * Math.sin(ang) + py * Math.cos(ang);
		if (isChLen) {
			double d = Math.sqrt(vx * vx + vy * vy);
			vx = vx / d * newLen;
			vy = vy / d * newLen;
			mathstr[0] = vx;
			mathstr[1] = vy;
		}
		return mathstr;
	}
}