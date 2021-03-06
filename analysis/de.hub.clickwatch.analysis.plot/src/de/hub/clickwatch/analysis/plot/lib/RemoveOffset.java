package de.hub.clickwatch.analysis.plot.lib;

public class RemoveOffset implements MathTransformation<Double, Double> {

	private final MovingAvg mavg;
	
	public RemoveOffset(int windowSize) {
		mavg = new MovingAvg(windowSize);
	}

	@Override
	public Double transform(Double value) {
		return value - mavg.transform(value);
	}
}
