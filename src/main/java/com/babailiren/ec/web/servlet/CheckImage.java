package com.babailiren.ec.web.servlet;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.*;

import com.babailiren.ec.enumeration.SessionName;

public class CheckImage extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private int width;

	private int height;

	private int codeCount;

	private int x;

	private int fontHeight;

	private int codeY;

	char codeSequence[] = { '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B',
	'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q',
	'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

	//char codeSequence[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

	public CheckImage() {
		width = 80;
		height = 25;
		codeCount = 4;
		x = 0;
	}

	public void init() throws ServletException {
		String strWidth = getInitParameter("width");
		String strHeight = getInitParameter("height");
		String strCodeCount = getInitParameter("codeCount");
		try {
			if (strWidth != null && strWidth.length() != 0)
				width = Integer.parseInt(strWidth);
			if (strHeight != null && strHeight.length() != 0)
				height = Integer.parseInt(strHeight);
			if (strCodeCount != null && strCodeCount.length() != 0)
				codeCount = Integer.parseInt(strCodeCount);
		} catch (NumberFormatException numberformatexception) {
		}
		x = width / (codeCount + 2);
		fontHeight = height - 2;
		codeY = height - 4;
	}

	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		BufferedImage buffImg = new BufferedImage(width, height, 1);
		Graphics2D g = buffImg.createGraphics();
		Random random = new Random();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, width, height);
		Font font = new Font("MiscFixed", 0, fontHeight);
		g.setFont(font);
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, width - 1, height - 1);
		g.setColor(Color.BLACK);
		StringBuffer randomCode = new StringBuffer();
		int red = 0;
		int green = 0;
		int blue = 0;
		for (int i = 0; i < codeCount; i++) {
			String strRand = String.valueOf(codeSequence[random
					.nextInt(codeSequence.length)]);
			red = random.nextInt(255);
			green = random.nextInt(255);
			blue = random.nextInt(255);
			g.setColor(new Color(red, green, blue));
			g.drawString(strRand, (i + 1) * this.x, codeY);
			randomCode.append(strRand);
		}

		HttpSession session = req.getSession();
		session.setAttribute(SessionName.VERIFYCODE.toString(), randomCode.toString());
		resp.setHeader("Pragma", "no-cache");
		resp.setHeader("Cache-Control", "no-cache");
		resp.setDateHeader("Expires", 0L);
		resp.setContentType("image/jpeg");
		ServletOutputStream sos = resp.getOutputStream();
		ImageIO.write(buffImg, "jpeg", sos);
		sos.close();
	}
}
