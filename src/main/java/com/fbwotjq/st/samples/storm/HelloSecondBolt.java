package com.fbwotjq.st.samples.storm;

import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Tuple;

public class HelloSecondBolt extends BaseBasicBolt {

	@Override
	public void execute(Tuple tuple, BasicOutputCollector collector) {
		String value = tuple.getStringByField("second-say");
		System.out.println("HelloSecondBolt :: Tuple value is "+value);
	}

	@Override
	public void declareOutputFields(OutputFieldsDeclarer declarer) {
		// TODO Auto-generated method stub
		
	}

}
