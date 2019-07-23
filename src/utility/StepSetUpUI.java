package utility;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Paint;
import java.awt.RenderingHints;
import java.awt.Stroke;
import java.text.DecimalFormat;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class StepSetUpUI extends JFrame{
	private static final long serialVersionUID = 1L;
	
	int originX = 10;
	int originY = 235;
	int treadDepth = 250;
	int treadThickness = 36;
	int treadGap = 10;
	int nosing = 60;
	int riserThickness = 40;
	int riserHeight = 140;
	double slopeNum = Math
			.round(Math.toDegrees(Math.atan((double) riserHeight / ((double) treadGap + (double) treadDepth))));
	DecimalFormat df = new DecimalFormat("0.0");
	String slope = df.format(slopeNum);

	JLabel labelnameTreadGap = new JLabel("Tread gap");
	JLabel labelnameTreadDepth = new JLabel("Step length");
	JLabel labelnameNosing = new JLabel("Nosing length");
	JLabel labelnameTreadThickness = new JLabel("Step thickness");
	JLabel labelnameRiserHeight = new JLabel("Riser height");
	JLabel labelnameRiserThickness = new JLabel("Riser thickness");

	ColourRectangleOutline rectTreadGap = new ColourRectangleOutline(originX, originY, treadGap, treadThickness,
			Color.LIGHT_GRAY);
	ColourRectangle rectTreadDepth = new ColourRectangle(originX + treadGap, originY, treadDepth, treadThickness,
			Color.DARK_GRAY);
	ColourRectangle rectNosing = new ColourRectangle(originX + treadGap + treadDepth, originY,
			nosing - (treadThickness / 2), treadThickness, Color.DARK_GRAY);
	ColourRectangle rectRiserIntersect = new ColourRectangle(originX + treadGap + treadDepth - riserThickness,
			originY + riserHeight, riserThickness, treadThickness, Color.DARK_GRAY);
	ColourRectangle rectRiser = new ColourRectangle(originX + treadGap + treadDepth - riserThickness,
			originY + treadThickness, riserThickness, riserHeight, Color.DARK_GRAY);
	ColourArc arcNose = new ColourArc(originX + treadGap + treadDepth + nosing - treadThickness, originY,
			treadThickness / 2, Color.DARK_GRAY);
	ColourRectangleOutline rectTreadGap2 = new ColourRectangleOutline(originX + treadGap + treadDepth,
			originY + riserHeight, treadGap, treadThickness, Color.LIGHT_GRAY);
	ColourRectangleOutline rectTreadDepth2 = new ColourRectangleOutline(originX + 2 * treadGap + treadDepth,
			originY + riserHeight, treadDepth, treadThickness, Color.DARK_GRAY);
	ColourRectangleOutline rectNosing2 = new ColourRectangleOutline(originX + 2 * treadGap + 2 * treadDepth,
			originY + riserHeight, nosing - (treadThickness / 2), treadThickness, Color.DARK_GRAY);
	ColourArcOutline arcNose2 = new ColourArcOutline(originX + 2 * treadGap + 2 * treadDepth + nosing - treadThickness,
			originY + riserHeight, treadThickness / 2, Color.DARK_GRAY);
	ColourLine slopeline = new ColourLine(2 * originX + treadGap + treadDepth + nosing, originY,
			2 * originX + 2 * treadGap + 2 * treadDepth + nosing, originY + riserHeight, Color.GREEN);
	ColourText slopeValue = new ColourText("\u0398 " + slope + "\u00B0", 3 * originX + treadGap + treadDepth + nosing,
			originY, Color.BLACK);

	JSlider jsliderTreadDepth = new JSlider();
	JSlider jsliderTreadGap = new JSlider();
	JSlider jsliderTreadThickness = new JSlider();
	JSlider jsliderNosing = new JSlider();
	JSlider jsliderRiserHeight = new JSlider();
	JSlider jsliderRiserThickness = new JSlider();

	final JLabel labelvalueTreadGap = new JLabel(((double) treadGap / 10) + " cm");
	final JLabel labelvalueTreadDepth = new JLabel(((double) treadDepth / 10) + " cm");
	final JLabel labelvalueNosing = new JLabel(((double) nosing / 10) + " cm");
	final JLabel labelvalueTreadThickness = new JLabel(((double) treadThickness / 10) + " cm");
	final JLabel labelvalueRiserHeight = new JLabel(((double) riserHeight / 10) + " cm");
	final JLabel labelvalueRiserThickness = new JLabel(((double) riserThickness / 10) + " cm");

	public StepSetUpUI() {
		createAndShowGui();
	}

	final JPanel panel = new JPanel() {
		private static final long serialVersionUID = 1L;

		@Override
		protected void paintComponent(Graphics grphcs) {
			super.paintComponent(grphcs);

			Graphics2D g2d = (Graphics2D) grphcs;
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

			setBackground(Color.white);
			setForeground(Color.black);

			g2d.setStroke(new BasicStroke(3));
			float dash1[] = { 3.0f };
			float dash2[] = { 8.0f };
			final BasicStroke dashed = new BasicStroke(1.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1,
					0.0f);
			final BasicStroke otherDashed = new BasicStroke(4.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f,
					dash2, 0.0f);

			g2d.setFont(g2d.getFont().deriveFont(23f));
			rectTreadGap.draw(g2d, dashed);
			rectTreadDepth.draw(g2d);
			rectNosing.draw(g2d);
			arcNose.draw(g2d);
			rectRiserIntersect.draw(g2d, otherDashed);
			rectRiser.draw(g2d);
			rectTreadGap2.draw(g2d, dashed);
			rectTreadDepth2.draw(g2d);
			rectNosing2.draw(g2d);
			arcNose2.draw(g2d);
			slopeline.draw(g2d, otherDashed);
			slopeValue.draw(g2d);
		}

		@Override
		public Dimension getPreferredSize() {
			return new Dimension(800, 600);
		}
	};

	private void createAndShowGui() {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		jsliderTreadGap.setValue(treadGap);
		jsliderTreadGap.setMinimum(0);
		jsliderTreadGap.setMaximum(30);
		jsliderTreadGap.setMinorTickSpacing(5);
		jsliderTreadGap.setMajorTickSpacing(10);
		jsliderTreadGap.setPaintTicks(true);
		jsliderTreadGap.setPaintLabels(true);
		jsliderTreadGap.setLabelTable(jsliderTreadGap.createStandardLabels(10));
		jsliderTreadGap.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent ce) {
				JSlider slider = (JSlider) ce.getSource();
				treadGap = slider.getValue();
				updateElements();
			}
		});

		jsliderTreadDepth.setValue(treadDepth);
		jsliderTreadDepth.setMinimum(150);
		jsliderTreadDepth.setMaximum(450);
		jsliderTreadDepth.setMinorTickSpacing(10);
		jsliderTreadDepth.setMajorTickSpacing(50);
		jsliderTreadDepth.setPaintTicks(true);
		jsliderTreadDepth.setPaintLabels(true);
		jsliderTreadDepth.setLabelTable(jsliderTreadDepth.createStandardLabels(150));
		jsliderTreadDepth.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent ce) {
				JSlider slider = (JSlider) ce.getSource();
				treadDepth = slider.getValue();
				updateElements();
			}
		});
		jsliderTreadThickness.setValue(treadThickness);
		jsliderTreadThickness.setMinimum(0);
		jsliderTreadThickness.setMaximum(300);
		jsliderTreadThickness.setMinorTickSpacing(25);
		jsliderTreadThickness.setMajorTickSpacing(100);
		jsliderTreadThickness.setPaintTicks(true);
		jsliderTreadThickness.setPaintLabels(true);
		jsliderTreadThickness.setLabelTable(jsliderTreadThickness.createStandardLabels(100));
		jsliderTreadThickness.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent ce) {
				JSlider slider = (JSlider) ce.getSource();
				treadThickness = slider.getValue() == 0 ? 1 : slider.getValue();
				updateElements();
			}
		});

		jsliderNosing.setValue(nosing);
		jsliderNosing.setMinimum(0);
		jsliderNosing.setMaximum(300);
		jsliderNosing.setMinorTickSpacing(25);
		jsliderNosing.setMajorTickSpacing(100);
		jsliderNosing.setPaintTicks(true);
		jsliderNosing.setPaintLabels(true);
		jsliderNosing.setLabelTable(jsliderNosing.createStandardLabels(100));
		jsliderNosing.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent ce) {
				JSlider slider = (JSlider) ce.getSource();
				nosing = slider.getValue();
				updateElements();
			}
		});

		jsliderRiserHeight.setValue(riserHeight);
		jsliderRiserHeight.setMinimum(100);
		jsliderRiserHeight.setMaximum(300);
		jsliderRiserHeight.setMinorTickSpacing(10);
		jsliderRiserHeight.setMajorTickSpacing(50);
		jsliderRiserHeight.setPaintTicks(true);
		jsliderRiserHeight.setPaintLabels(true);
		jsliderRiserHeight.setLabelTable(jsliderRiserHeight.createStandardLabels(50));
		jsliderRiserHeight.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent ce) {
				JSlider slider = (JSlider) ce.getSource();
				riserHeight = slider.getValue();
				updateElements();
			}
		});

		jsliderRiserThickness.setValue(riserThickness);
		jsliderRiserThickness.setMinimum(0);
		jsliderRiserThickness.setMaximum(100);
		jsliderRiserThickness.setMinorTickSpacing(5);
		jsliderRiserThickness.setMajorTickSpacing(25);
		jsliderRiserThickness.setPaintTicks(true);
		jsliderRiserThickness.setPaintLabels(true);
		jsliderRiserThickness.setLabelTable(jsliderRiserThickness.createStandardLabels(25));
		jsliderRiserThickness.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent ce) {
				JSlider slider = (JSlider) ce.getSource();
				riserThickness = slider.getValue();
				updateElements();
			}
		});

		GridBagConstraints gbc = new GridBagConstraints();
		GridBagLayout layout = new GridBagLayout();
		gbc.insets = new Insets(0, 3, 0, 8);
		gbc.ipadx = 12;
		gbc.ipady = 12;
		gbc.anchor = GridBagConstraints.FIRST_LINE_END;

		final JPanel jcontrolpanel = new JPanel();
		jcontrolpanel.setFont(jcontrolpanel.getFont().deriveFont(13));
		jcontrolpanel.setLayout(layout);

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.NONE;
		jcontrolpanel.add(labelnameTreadGap, gbc);
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		jcontrolpanel.add(jsliderTreadGap, gbc);
		gbc.gridx = 2;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.NONE;
		gbc.weightx = .1;
		jcontrolpanel.add(labelvalueTreadGap, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		jcontrolpanel.add(labelnameTreadDepth, gbc);
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.weightx = 1;
		jcontrolpanel.add(jsliderTreadDepth, gbc);
		gbc.gridx = 2;
		gbc.gridy = 1;
		gbc.fill = GridBagConstraints.NONE;
		jcontrolpanel.add(labelvalueTreadDepth, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		jcontrolpanel.add(labelnameTreadThickness, gbc);
		gbc.gridx = 1;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		jcontrolpanel.add(jsliderTreadThickness, gbc);
		gbc.gridx = 2;
		gbc.gridy = 2;
		gbc.fill = GridBagConstraints.NONE;
		jcontrolpanel.add(labelvalueTreadThickness, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		jcontrolpanel.add(labelnameNosing, gbc);
		gbc.gridx = 1;
		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		jcontrolpanel.add(jsliderNosing, gbc);
		gbc.gridx = 2;
		gbc.gridy = 3;
		gbc.fill = GridBagConstraints.NONE;
		jcontrolpanel.add(labelvalueNosing, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		jcontrolpanel.add(labelnameRiserHeight, gbc);
		gbc.gridx = 1;
		gbc.gridy = 4;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		jcontrolpanel.add(jsliderRiserHeight, gbc);
		gbc.gridx = 2;
		gbc.gridy = 4;
		gbc.fill = GridBagConstraints.NONE;
		jcontrolpanel.add(labelvalueRiserHeight, gbc);

		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.weightx = 0;
		jcontrolpanel.add(labelnameRiserThickness, gbc);
		gbc.gridx = 1;
		gbc.gridy = 5;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		jcontrolpanel.add(jsliderRiserThickness, gbc);
		gbc.gridx = 2;
		gbc.gridy = 5;
		gbc.fill = GridBagConstraints.NONE;
		jcontrolpanel.add(labelvalueRiserThickness, gbc);

		frame.add(jcontrolpanel, BorderLayout.WEST);
		frame.add(panel, BorderLayout.EAST);

		frame.pack();
		frame.setVisible(true);

		System.out.println(panel.getWidth());
		System.out.println(panel.getHeight());
	}

	public void updateElements() {
		originY = panel.getHeight() / 2 - (treadThickness + riserHeight) / 2;
		slopeNum = Math
				.round(Math.toDegrees(Math.atan((double) riserHeight / ((double) treadGap + (double) treadDepth))));
		slope = df.format(slopeNum);
		rectTreadGap.setXYWH(originX, originY, treadGap, treadThickness);
		rectTreadDepth.setXYWH(originX + treadGap, originY, treadDepth, treadThickness);
		rectNosing.setXYWH(originX + treadGap + treadDepth, originY, nosing - (treadThickness / 2), treadThickness);
		rectRiserIntersect.setXYWH(originX + treadGap + treadDepth - riserThickness, originY + riserHeight,
				riserThickness, treadThickness);
		rectRiser.setXYWH(originX + treadGap + treadDepth - riserThickness, originY + treadThickness, riserThickness,
				riserHeight);
		arcNose.setXYRadius(originX + treadGap + treadDepth + nosing - treadThickness, originY,
				(double) treadThickness / 2);
		rectTreadGap2.setXYWH(originX + treadGap + treadDepth, originY + riserHeight, treadGap, treadThickness);
		rectTreadDepth2.setXYWH(originX + 2 * treadGap + treadDepth, originY + riserHeight, treadDepth, treadThickness);
		rectNosing2.setXYWH(originX + 2 * treadGap + 2 * treadDepth, originY + riserHeight,
				nosing - (treadThickness / 2), treadThickness);
		arcNose2.setXYRadius(originX + 2 * treadGap + 2 * treadDepth + nosing - treadThickness, originY + riserHeight,
				(double) treadThickness / 2);
		if (slopeNum < 20 || slopeNum > 45) {
			slopeline.setX1Y1X2Y2Color(2 * originX + treadGap + treadDepth + nosing, originY,
					2 * originX + 2 * treadGap + 2 * treadDepth + nosing, originY + riserHeight, Color.ORANGE);
		} else {
			slopeline.setX1Y1X2Y2Color(2 * originX + treadGap + treadDepth + nosing, originY,
					2 * originX + 2 * treadGap + 2 * treadDepth + nosing, originY + riserHeight, Color.GREEN);
		}
		slopeValue.setStringXYColor("\u0398 " + slope + "\u00B0", 3 * originX + treadGap + treadDepth + nosing,
				originY + riserHeight / 2, Color.BLACK);

		labelvalueTreadGap.setText(((double) jsliderTreadGap.getValue() / 10) + " cm");
		labelvalueTreadDepth.setText(((double) jsliderTreadDepth.getValue() / 10) + " cm");
		labelvalueNosing.setText(((double) jsliderNosing.getValue() / 10) + " cm");
		labelvalueTreadThickness.setText(((double) jsliderTreadThickness.getValue() / 10) + " cm");
		labelvalueRiserHeight.setText(((double) jsliderRiserHeight.getValue() / 10) + " cm");
		labelvalueRiserThickness.setText(((double) jsliderRiserThickness.getValue() / 10) + " cm");

		panel.repaint();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				for (Map.Entry<Object, Object> entry : javax.swing.UIManager.getDefaults().entrySet()) {
					Object key = entry.getKey();
					Object value = javax.swing.UIManager.get(key);
					if (value != null && value instanceof javax.swing.plaf.FontUIResource) {
						javax.swing.plaf.FontUIResource fr = (javax.swing.plaf.FontUIResource) value;
						javax.swing.plaf.FontUIResource f = new javax.swing.plaf.FontUIResource(fr.getFamily(),
								fr.getStyle(), 19);
						javax.swing.UIManager.put(key, f);
					}
				}
				new StepSetUpUI();
			}
		});
	}

	class ColourText {
		private String string;
		private int x, y;
		private Color color;

		public ColourText(String string, int x, int y, Color color) {
			this.string = string;
			this.x = x;
			this.y = y;
			this.color = color;
		}

		void draw(Graphics2D g2d) {
			Color prevState = g2d.getColor();
			g2d.setColor(color);
			g2d.drawString(string, x, y);
			g2d.setColor(prevState);
		}

		void draw(Graphics2D g2d, Stroke stroke) {
			Stroke prevStroke = g2d.getStroke();
			Color prevState = g2d.getColor();
			g2d.setStroke(stroke);
			g2d.setColor(color);
			g2d.drawString(string, x, y);
			g2d.setColor(prevState);
			g2d.setStroke(prevStroke);
		}

		public void setX(int x) {
			this.x = x;
		}

		public void sety(int y) {
			this.y = y;
		}

		public void setString(String string) {
			this.string = string;
		}

		public void setStringXYColor(String string, int x, int y, Color color) {
			this.x = x;
			this.y = y;
			this.string = string;
			this.color = color;
		}
	}

	class ColourLine {
		private int x1, y1, x2, y2;
		private Color color;

		public ColourLine(int x1, int y1, int x2, int y2, Color color) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
			this.color = color;
		}

		void draw(Graphics2D g2d) {
			Color prevState = g2d.getColor();
			g2d.setColor(color);
			g2d.drawLine(x1, y1, x2, y2);
			g2d.setColor(prevState);
		}

		void draw(Graphics2D g2d, Stroke stroke) {
			Stroke prevStroke = g2d.getStroke();
			Color prevState = g2d.getColor();
			g2d.setStroke(stroke);
			g2d.setColor(color);
			g2d.drawLine(x1, y1, x2, y2);
			g2d.setColor(prevState);
			g2d.setStroke(prevStroke);
		}

		public void setX1(int x1) {
			this.x1 = x1;
		}

		public void setX2(int x2) {
			this.x2 = x2;
		}

		public void sety1(int y1) {
			this.y1 = y1;
		}

		public void sety2(int y2) {
			this.y2 = y2;
		}

		public void setX1Y1X2Y2(int x1, int y1, int x2, int y2) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
		}

		public void setX1Y1X2Y2Color(int x1, int y1, int x2, int y2, Color color) {
			this.x1 = x1;
			this.y1 = y1;
			this.x2 = x2;
			this.y2 = y2;
			this.color = color;
		}
	}

	class ColourArc {
		private int x, y;
		private double radius;
		private final Color color;

		public ColourArc(int x, int y, double radius, Color color) {
			this.x = x;
			this.y = y;
			this.radius = radius;
			this.color = color;
		}

		void draw(Graphics2D g2d) {
			Color prevState = g2d.getColor();
			Paint prevPaint = g2d.getPaint();
			g2d.setColor(color);
			g2d.setPaint(color);
			int radius2 = (int) (2 * radius);
			g2d.fillArc(x, y, radius2, radius2, -90, 180);
			g2d.setColor(prevState);
			g2d.setPaint(prevPaint);
		}

		void draw(Graphics2D g2d, Stroke stroke) {
			Stroke prevStroke = g2d.getStroke();
			Color prevState = g2d.getColor();
			Paint prevPaint = g2d.getPaint();
			g2d.setStroke(stroke);
			g2d.setPaint(color);
			g2d.setColor(color);
			int radius2 = (int) (2 * radius);
			g2d.fillArc(x, y, radius2, radius2, -90, 180);
			g2d.setColor(prevState);
			g2d.setPaint(prevPaint);
			g2d.setStroke(prevStroke);
		}

		public void setX(int x) {
			this.x = x;
		}

		public void setY(int y) {
			this.y = y;
		}

		public void setRadius(double radius) {
			this.radius = radius;
		}

		public void setXYRadius(int x, int y, double radius) {
			this.x = x;
			this.y = y;
			this.radius = radius;
		}
	}

	class ColourArcOutline {
		private int x, y;
		private double radius;
		private final Color color;

		public ColourArcOutline(int x, int y, double radius, Color color) {
			this.x = x;
			this.y = y - 2;
			this.radius = radius;
			this.color = color;
		}

		void draw(Graphics2D g2d) {
			Color prevState = g2d.getColor();
			Paint prevPaint = g2d.getPaint();
			g2d.setColor(color);
			g2d.setPaint(color);
			int radius2 = (int) (2 * radius);
			g2d.drawArc(x, y, radius2, radius2, -90, 180);
			g2d.setColor(prevState);
			g2d.setPaint(prevPaint);
		}

		void draw(Graphics2D g2d, Stroke stroke) {
			Stroke prevStroke = g2d.getStroke();
			Color prevState = g2d.getColor();
			Paint prevPaint = g2d.getPaint();
			g2d.setStroke(stroke);
			g2d.setPaint(color);
			g2d.setColor(color);
			int radius2 = (int) (2 * radius);
			g2d.drawArc(x, y, radius2, radius2, -90, 180);
			g2d.setColor(prevState);
			g2d.setPaint(prevPaint);
			g2d.setStroke(prevStroke);
		}

		public void setX(int x) {
			this.x = x;
		}

		public void setY(int y) {
			this.y = y - 2;
		}

		public void setRadius(double radius) {
			this.radius = radius;
		}

		public void setXYRadius(int x, int y, double radius) {
			this.x = x;
			this.y = y - 2;
			this.radius = radius;
		}
	}

	class ColourRectangle {
		private int x, y, width, height;
		private final Color color;

		public ColourRectangle(int x, int y, int w, int h, Color color) {
			this.x = x;
			this.y = y;
			this.width = w;
			this.height = h;
			this.color = color;
		}

		void draw(Graphics2D g2d) {
			Color prevState = g2d.getColor();
			g2d.setColor(color);
			g2d.fillRect(x, y, width, height);
			g2d.setColor(prevState);
		}

		void draw(Graphics2D g2d, Stroke stroke) {
			Stroke prevStroke = g2d.getStroke();
			Color prevState = g2d.getColor();
			g2d.setStroke(stroke);
			g2d.setColor(color);
			g2d.fillRect(x, y, width, height);
			g2d.setColor(prevState);
			g2d.setStroke(prevStroke);
		}

		public void setX(int x) {
			this.x = x;
		}

		public void setY(int y) {
			this.y = y;
		}

		public void setWidth(int w) {
			this.width = w;
		}

		public void setHeight(int h) {
			this.height = h;
		}

		public void setXYWH(int x, int y, int w, int h) {
			this.x = x;
			this.y = y;
			this.width = w;
			this.height = h;
		}

	}

	class ColourRectangleOutline {
		private int x, y, width, height;
		private final Color color;

		public ColourRectangleOutline(int x, int y, int w, int h, Color color) {
			this.x = x;
			this.y = y - 2;
			this.width = w;
			this.height = h;
			this.color = color;
		}

		void draw(Graphics2D g2d) {
			Color prevState = g2d.getColor();
			g2d.setColor(color);
			g2d.drawRect(x, y, width, height);
			g2d.setColor(prevState);
		}

		void draw(Graphics2D g2d, Stroke stroke) {
			Stroke prevStroke = g2d.getStroke();
			Color prevState = g2d.getColor();
			g2d.setStroke(stroke);
			g2d.setColor(color);
			g2d.drawRect(x, y, width, height);
			g2d.setColor(prevState);
			g2d.setStroke(prevStroke);
		}

		public void setX(int x) {
			this.x = x;
		}

		public void setY(int y) {
			this.y = y - 2;
		}

		public void setWidth(int w) {
			this.width = w;
		}

		public void setHeight(int h) {
			this.height = h;
		}

		public void setXYWH(int x, int y, int w, int h) {
			this.x = x;
			this.y = y - 2;
			this.width = w;
			this.height = h;
		}
	}

}