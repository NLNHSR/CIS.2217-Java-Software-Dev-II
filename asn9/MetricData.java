package edu.institution.asn9;

public class MetricData implements Comparable<MetricData>{
	// the sort algorithm used to sort the data
	private SortAlgorithm sortAlgorithm;

	// the time complexity for the sort algorithm
	private TimeComplexity timeComplexity;
	
	// the time (in milliseconds) that it took to sort the data
	private long executionTime;
	
	public MetricData(SortAlgorithm alg) {
		sortAlgorithm = alg;
	}

	public SortAlgorithm getSortAlgorithm() {
		return sortAlgorithm;
	}

	public TimeComplexity getTimeComplexity() {
		return timeComplexity;
	}

	public long getExecutionTime() {
		return executionTime;
	}

	public void setTimeComplexity(TimeComplexity timeComplexity) {
		this.timeComplexity = timeComplexity;
	}

	public void setExecutionTime(long executionTime) {
		this.executionTime = executionTime;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sortAlgorithm == null) ? 0 : sortAlgorithm.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MetricData other = (MetricData) obj;
		if (sortAlgorithm != other.sortAlgorithm)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MetricData [sortAlgorithm=" + sortAlgorithm + ", timeComplexity=" + timeComplexity + ", executionTime="
				+ executionTime + "]";
	}

	@Override
	public int compareTo(MetricData arg0) {
		// TODO Auto-generated method stub
		if (executionTime > arg0.getExecutionTime()) {
			return 1;
		}else if(executionTime < arg0.getExecutionTime()) {
			return -1;
		}
		return 0;
	}
	
	
}
