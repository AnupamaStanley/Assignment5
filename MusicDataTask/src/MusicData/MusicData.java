package MusicData;

import org.apache.hadoop.mapreduce.*;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import java.io.IOException;

public class MusicData {
	public static class MyMapper extends Mapper<LongWritable, Text, IntWritable, IntWritable>{
		private final static IntWritable one = new IntWritable(1);
		public void map( LongWritable key,Text value, Context context)
			throws IOException, InterruptedException{
			String line = value.toString();
			String[] Users = line.split("\\|");
			IntWritable UserId = new IntWritable(Integer.parseInt(Users[0]));
			context.write(UserId, one);
		}
	}
	
	public static class MyReducer extends Reducer<IntWritable, IntWritable, IntWritable, NullWritable >{
		public void reduce( IntWritable key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException{

			context.write(key, NullWritable.get());
		}
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException{
		Job job = new Job();
		job.setJarByClass(MusicData.class);
		job.setJobName("Fetch Unique users");
		job.setMapperClass(MyMapper.class);
		job.setReducerClass(MyReducer.class);
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, new Path(args[1]));
		job.setOutputKeyClass(IntWritable.class);
		job.setOutputValueClass(IntWritable.class);
		job.waitForCompletion(true);
	}	
}