package datastructure;

public class Reward {
	private double[] features;
	private int featureLength;
	
	public Reward(int featureLength) {
		this.features = new double[featureLength];
		this.featureLength = featureLength;
	}
	
	public Reward(double[] features, int featureLength) {
		this.features = features;
		this.featureLength = featureLength;
	}

	public double calculateImmediateReward(double[] weights) {
		double reward = 0;
		if (features.length != featureLength) {
			System.out.println("Error. Different feature and weight lengths");
		} else {
			for (int i = 0; i < featureLength; i++) {
				reward += features[i] * weights[i];
			}
		}
		return reward;
	}
}