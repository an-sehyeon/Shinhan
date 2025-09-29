package com.shinhan.day07.LAB1;

public class Radio implements Volume {

	int VolLevel;

	@Override
	public void volumeUp(int Level) {
		VolLevel += Level;
			System.out.println(getClass().getSimpleName() + "볼륨 올립니다." + VolLevel);
	}

	@Override
	public void volumeDown(int Level) {
		VolLevel -= Level;
			System.out.println(getClass().getSimpleName() + "Speaker 볼륨 내립니다." + VolLevel);
	}

	

}
