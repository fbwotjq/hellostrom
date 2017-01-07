package com.fbwotjq.st.samples.storm;

import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.topology.TopologyBuilder;
import backtype.storm.utils.Utils;

public class HelloTopologyLocal {

	public static void main(String arg[]){
		
		TopologyBuilder builder = new TopologyBuilder();
		builder.setSpout("HelloSpout", new HelloSpout(),2);
        builder.setBolt("HelloFirstBolt", new HelloFirstBolt(),4).shuffleGrouping("HelloSpout");
        builder.setBolt("HelloSecondBolt", new HelloSecondBolt(),4).shuffleGrouping("HelloFirstBolt");
        
        Config conf = new Config();
        conf.setDebug(false);
        LocalCluster cluster = new LocalCluster();
        
        cluster.submitTopology("HelloTopologyLocal", conf,builder.createTopology());
        Utils.sleep(10000);
        
        // kill the LearningStormTopology
        cluster.killTopology("HelloTopologyLocal");
        // shutdown the storm test cluster	
        cluster.shutdown();         
        
	}
	
}
