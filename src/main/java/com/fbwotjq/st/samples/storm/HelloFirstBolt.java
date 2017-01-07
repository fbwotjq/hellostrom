package com.fbwotjq.st.samples.storm;

import backtype.storm.topology.BasicOutputCollector;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseBasicBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import backtype.storm.tuple.Values;

public class HelloFirstBolt extends BaseBasicBolt {
	 
    public void execute(Tuple tuple, BasicOutputCollector collector) {
    	String value = tuple.getStringByField("say");
    	collector.emit(new Values(value + " add plugin "));
    	System.out.println("HelloFirstBolt :: Tuple value is "+value);
    }

    public void declareOutputFields(OutputFieldsDeclarer declarer) {
    	declarer.declare(new Fields("second-say"));
    }

}