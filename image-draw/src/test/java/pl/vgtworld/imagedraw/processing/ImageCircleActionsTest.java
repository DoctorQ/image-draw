package pl.vgtworld.imagedraw.processing;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.junit.Test;

import pl.vgtworld.imagedraw.ImageDrawEntity;
import pl.vgtworld.imagedraw.ImageType;

public class ImageCircleActionsTest {

	@Test
	public void drawImageCircle() throws IOException {
		ImageProcessing image = new ImageProcessing();
		image.open("/Users/wuxian/Downloads/android-cts/repository/logs/2015.05.22_11.27.45/screenshot-2015-05-22_11-28-04_8029502909957939937.png");
		image.drawCircle(Color.RED, new Point(200, 300), 100, 5f);
		image.save("/Users/wuxian/Desktop/123.png");
	}

	@Test
	public void drawImageText() throws IOException {
		ImageProcessing image = new ImageProcessing();
		image.open("/Users/wuxian/Downloads/android-cts/repository/logs/2015.05.26_16.07.59/screenshot-2015-05-26_16-08-03_4545836982605861953.png");
		image.drawText("HelloWorld", Color.RED, new Font("SansSerif",
				Font.BOLD, 50), 50, 100);
		image.save("/Users/wuxian/Desktop/123.png");
	}

	@Test
	public void drawImageArrowHead() throws IOException {
		ImageProcessing image = new ImageProcessing();
		image.open("/Users/wuxian/Downloads/android-cts/repository/logs/2015.05.27_15.43.26/screenshot-2015-05-27_15-44-31_2016855949075528211.png");
		image.drawArrowHead(Color.RED, new Point(400, 400),
				new Point(100, 100), 2f);
		image.drawArrowHead(Color.RED, new Point(800, 400),
				new Point(100, 100), 2f);
		image.save("/Users/wuxian/Desktop/123.png");
	}

}
