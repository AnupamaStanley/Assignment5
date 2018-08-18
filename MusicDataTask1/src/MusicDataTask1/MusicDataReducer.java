package MusicDataTask1;

import java.io.IOException;
import java.util.*;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapred.*;

public abstract class MusicDataReducer extends MapReduceBase implements Reducer<Text, Text, Text, Text> {
	public void reduce(Text text, Iterable<Text> values,OutputCollector<Text, Text> output, Reporter reporter) 
						throws IOException {
		Text key = text;
		for(Text value:values) {
			output.collect(key, value);
			break;
		}
	}
}

