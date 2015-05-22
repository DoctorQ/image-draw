package pl.vgtworld.imagedraw.processing;

import java.awt.Color;
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
		image.drawCircle(Color.RED, new Point(200, 300), 100);
		image.save("/Users/wuxian/Desktop/123.png");
	}

	private ImageDrawEntity createValidImageEntity() throws IOException {
		BufferedImage image = ImageIO.read(getClass().getResourceAsStream(
				"/image-100-100.jpg"));
		return new ImageDrawEntity(image, ImageType.JPEG);
	}

}
