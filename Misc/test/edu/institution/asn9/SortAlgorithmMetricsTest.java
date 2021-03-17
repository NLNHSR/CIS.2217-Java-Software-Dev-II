package edu.institution.asn9;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

public class SortAlgorithmMetricsTest {

	@Test
	public void sortTest() {
		SortAlgorithmMetrics algs = new SortAlgorithmMetrics();
		List<MetricData> metrics = algs.retrieveMetrics("/java2-shettigar-neel/src/edu/institution/asn9/asn9-numbers.txt");
		assertTrue(metrics.size() == 5);
		assertEquals(metrics.get(0).getSortAlgorithm(), SortAlgorithm.BUBBLE_SORT);
		assertEquals(metrics.get(1).getSortAlgorithm(), SortAlgorithm.HEAP_SORT);
		assertEquals(metrics.get(2).getSortAlgorithm(), SortAlgorithm.INSERTION_SORT);
		assertEquals(metrics.get(3).getSortAlgorithm(), SortAlgorithm.MERGE_SORT);
		assertEquals(metrics.get(4).getSortAlgorithm(), SortAlgorithm.QUICK_SORT);

		assertEquals(metrics.get(0).getTimeComplexity(), TimeComplexity.QUADRATIC);
		assertEquals(metrics.get(1).getTimeComplexity(), TimeComplexity.LOGARITHMIC);
		assertEquals(metrics.get(2).getTimeComplexity(), TimeComplexity.QUADRATIC);
		assertEquals(metrics.get(3).getTimeComplexity(), TimeComplexity.LOGARITHMIC);
		assertEquals(metrics.get(4).getTimeComplexity(), TimeComplexity.QUADRATIC);
		
	}
	
	
}
