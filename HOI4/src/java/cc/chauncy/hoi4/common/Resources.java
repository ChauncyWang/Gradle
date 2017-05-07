package cc.chauncy.hoi4.common;

/**
 * 地区资源
 * Created by Chauncy on 2017/5/5.
 */
public class Resources {
	private int oil = 0;//石油
	private int steel = 0;//钢铁
	private int aluminum = 0;//铝
	private int tungsten = 0;//钨
	private int chromium = 0;//铬
	private int rubber = 0;//橡胶

	public Resources() {
	}

	@Override
	public String toString() {
		return "{\n" +
				"oil = " + oil + "\n" +
				"steel = " + steel + "\n" +
				"aluminum = " + aluminum + "\n" +
				"tungsten = " + tungsten + "\n" +
				"chromium = " + chromium + "\n" +
				"rubber = " + rubber + "\n" +
				'}';
	}

	/////////////////////////
	/// getter and setter
	////////////////////////
	public int getOil() {
		return oil;
	}

	public void setOil(int oil) {
		this.oil = oil;
	}

	public int getSteel() {
		return steel;
	}

	public void setSteel(int steel) {
		this.steel = steel;
	}

	public int getAluminum() {
		return aluminum;
	}

	public void setAluminum(int aluminum) {
		this.aluminum = aluminum;
	}

	public int getTungsten() {
		return tungsten;
	}

	public void setTungsten(int tungsten) {
		this.tungsten = tungsten;
	}

	public int getChromium() {
		return chromium;
	}

	public void setChromium(int chromium) {
		this.chromium = chromium;
	}

	public int getRubber() {
		return rubber;
	}

	public void setRubber(int rubber) {
		this.rubber = rubber;
	}
}
