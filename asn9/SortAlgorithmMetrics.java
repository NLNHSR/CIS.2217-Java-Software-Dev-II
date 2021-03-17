package edu.institution.asn9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortAlgorithmMetrics {
	 public List<MetricData> retrieveMetrics(String filePath) { 
		 List<Integer> numbers = new ArrayList<Integer>(); // assume this contains the list of 80000 Integers.
		 List<MetricData> metricData = new ArrayList<MetricData>();
		 
		 File file = new File(filePath);
		 BufferedReader reader = null;
		 try {
			    reader = new BufferedReader(new FileReader(file));
			    String text = null;

			    while ((text = reader.readLine()) != null) {
			        numbers.add(Integer.parseInt(text));
			    }
			} catch (FileNotFoundException e) {
			    e.printStackTrace();
			} catch (IOException e) {
			    e.printStackTrace();
			} finally {
			    try {
			        if (reader != null) {
			            reader.close();
			        }
			    } catch (IOException e) {
			    }
			}
		 Collections.shuffle(numbers);
		 
		 List<Integer> numBubble = new ArrayList<Integer>();
		 System.arraycopy(numbers, 0, numBubble, 0, numbers.size());
		 List<Integer> numHeap = new ArrayList<Integer>();
		 System.arraycopy(numbers, 0, numHeap, 0, numbers.size());
		 List<Integer> numInsertion = new ArrayList<Integer>();
		 System.arraycopy(numbers, 0, numInsertion, 0, numbers.size());
		 List<Integer> numMerge = new ArrayList<Integer>();
		 System.arraycopy(numbers, 0, numMerge, 0, numbers.size());
		 List<Integer> numQuick = new ArrayList<Integer>();
		 System.arraycopy(numbers, 0, numQuick, 0, numbers.size());
		 
		 long elapsedMilliseconds;
		 LocalTime end;
		 LocalTime start;
		 Integer[] template = {};
		 
		 //bubble sort
		 MetricData bubble = new MetricData(SortAlgorithm.BUBBLE_SORT);
		 bubble.setTimeComplexity(TimeComplexity.QUADRATIC);
		 Integer[] intBubble = numBubble.toArray(template);
		 BubbleSort bsort = new BubbleSort();
		 start = LocalTime.now();
		 bsort.bubbleSort(intBubble);
		 end = LocalTime.now();
		 elapsedMilliseconds = Duration.between(start, end).toMillis(); 
		 bubble.setExecutionTime(elapsedMilliseconds);
		 metricData.add(bubble);
		 
		//heap sort
		 MetricData heap = new MetricData(SortAlgorithm.HEAP_SORT);
		 heap.setTimeComplexity(TimeComplexity.LOGARITHMIC);
		 Integer[] intHeap= numHeap.toArray(template);
		 HeapSort hsort = new HeapSort();
		 start = LocalTime.now();
		 hsort.heapSort(intHeap);
		 end = LocalTime.now();
		 elapsedMilliseconds = Duration.between(start, end).toMillis(); 
		 heap.setExecutionTime(elapsedMilliseconds);
		 metricData.add(heap);
		 
		//insertion sort
		 MetricData insertion = new MetricData(SortAlgorithm.INSERTION_SORT);
		 insertion.setTimeComplexity(TimeComplexity.QUADRATIC);
		 Integer[] intInsertion = numInsertion.toArray(template);
		 InsertionSort isort = new InsertionSort();
		 start = LocalTime.now();
		 isort.insertionSort(intInsertion);
		 end = LocalTime.now();
		 elapsedMilliseconds = Duration.between(start, end).toMillis(); 
		 insertion.setExecutionTime(elapsedMilliseconds);
		 metricData.add(insertion);
		 
		//merge sort
		 MetricData merge = new MetricData(SortAlgorithm.MERGE_SORT);
		 merge.setTimeComplexity(TimeComplexity.LOGARITHMIC);
		 Integer[] intMerge = numMerge.toArray(template);
		 MergeSort msort = new MergeSort();
		 start = LocalTime.now();
		 msort.mergeSort(intMerge);
		 end = LocalTime.now();
		 elapsedMilliseconds = Duration.between(start, end).toMillis(); 
		 merge.setExecutionTime(elapsedMilliseconds);
		 metricData.add(merge);
		 
		//quick sort
		 MetricData quick = new MetricData(SortAlgorithm.QUICK_SORT);
		 quick.setTimeComplexity(TimeComplexity.QUADRATIC);
		 Integer[] intQuick = numQuick.toArray(template);
		 QuickSort qsort = new QuickSort();
		 start = LocalTime.now();
		 qsort.quickSort(intQuick);
		 end = LocalTime.now();
		 elapsedMilliseconds = Duration.between(start, end).toMillis(); 
		 quick.setExecutionTime(elapsedMilliseconds);
		 metricData.add(quick);
		 
		 Collections.sort(metricData);
		 
		 return metricData; 
	 }
}


