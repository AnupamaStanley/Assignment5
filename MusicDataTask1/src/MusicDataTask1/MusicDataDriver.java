package MusicDataTask1;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapred.*;

public class MusicDataDriver{
		public static void main(String[] args) { 
			JobClient my_client = new JobClient();
			JobConf job_conf = new JobConf(MusicDataReducer.class);
			job_conf.setJobName("Unique Users");
			job_conf.setOutputKeyClass(Text.class);
			job_conf.setOutputValueClass(IntWritable.class);
			job_conf.setMapperClass(MusicDataTask1.MusicDataMapper.class);
			job_conf.setReducerClass(MusicDataTask1.MusicDataReducer.class);
			job_conf.setInputFormat(TextInputFormat.class);
			job_conf.setOutputFormat(TextOutputFormat.class);
			FileInputFormat.setInputPaths(job_conf, new Path(args[0]));
			FileOutputFormat.setOutputPath(job_conf, new Path(args[1]));

			my_client.setConf(job_conf);
			try {
				JobClient.runJob(job_conf);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}

