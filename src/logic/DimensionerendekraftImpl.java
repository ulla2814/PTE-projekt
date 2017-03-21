package logic;

public class DimensionerendekraftImpl implements Dimensionerendekraft {

	private double kg;
	private double newton;
	private String mellemRegning;

	@Override
	public double setNewton(double newton) {
		// TODO Auto-generated method stub
		return 0;
	}
	public void setVaegt(double vaegt, Enhed enhed){
		switch(enhed){
		case TON:
			setKg(vaegt/1000);
			break;
		case KG:
			setKg(vaegt);
			break;
		case GRAM:
			setKg(vaegt*1000);
			break;
		case NEWTON:
			setKg(vaegt/tyngdekraft);
			break;
		}
	}
	public double getNewton() {
		return kg * tyngdekraft;
	}

	@Override
	public void setKg(double kg) {
		this.kg = kg;
		newton = kg * tyngdekraft;
		setMellemRegning("FDim = kg * g +" +"\n" + getNewton() + "=" + getKg() + "*" + tyngdekraft);
	}

	@Override
	public double getKg() {
		return kg;
	}

	@Override
	public void setMellemRegning(String mellemRegning) {
		this.mellemRegning = mellemRegning;
	}

	@Override
	public String getMellemRegning() {
		return mellemRegning;
	}
}
