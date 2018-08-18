package MusicDataTask1;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;

public abstract class MusicDataMapper extends MapReduceBase implements Mapper<LongWritable, Text, Text, IntWritable> {
	private final static IntWritable one = new IntWritable(1);
	public void map(LongWritable key, Text value,OutputCollector<Text, IntWritable> output, Reporter reporter)
				throws IOException {
		String line = value.toString();
		if( line.length() > 0 )
		{
			String[] MusicData = line.split("\\|");
			output.collect(new Text( MusicData[0] ), one);
		}
	}
}
