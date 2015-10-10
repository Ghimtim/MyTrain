package com.mytrain.test;

import com.mytrain.bean.Train;
import com.mytrain.dao.TrainDao;
import com.mytrain.utils.DatabaseHelper;


import android.test.AndroidTestCase;

public class TrainCase extends AndroidTestCase {
	public void testCreate() {
		DatabaseHelper dbhelper = new DatabaseHelper(this.getContext());
		dbhelper.getWritableDatabase();
	}

	public void testSave() {
		TrainDao td = new TrainDao(this.getContext());
		Train train = new Train();
		train.setTrainType("G233");
		train.setOrigin_station("广州南");
		train.setTerminal_station("深圳北");
		train.setStart_time(2015,9,24,8,20); 
		train.setReach_time(2015,9,24,9,32);
		train.setTicket_price(74);
		train.setSeat_total_num(800);
		train.setSeat_remain_num(150);
		train.setState(0);
		td.addTrain(train);
		
		train.setTrainType("G110");
		train.setOrigin_station("广州南");
		train.setTerminal_station("深圳北");
		train.setStart_time(2015,10,24,8,20); 
		train.setReach_time(2015,10,24,9,32);
		train.setTicket_price(74);
		train.setSeat_total_num(800);
		train.setSeat_remain_num(651);
		train.setState(0);
		td.addTrain(train);
		
		train.setTrainType("G123");
		train.setOrigin_station("珠海");
		train.setTerminal_station("广州南");
		train.setStart_time(2015,8,24,8,20); 
		train.setReach_time(2015,8,24,9,32);
		train.setTicket_price(50);
		train.setSeat_total_num(800);
		train.setSeat_remain_num(245);
		train.setState(0);
		td.addTrain(train);
		
		train.setTrainType("G666");
		train.setOrigin_station("上海");
		train.setTerminal_station("北京南");
		train.setStart_time(2015,8,1,8,20); 
		train.setReach_time(2015,8,1,9,32);
		train.setTicket_price(200);
		train.setSeat_total_num(800);
		train.setSeat_remain_num(310);
		train.setState(0);
		td.addTrain(train);
		
		train.setTrainType("G110");
		train.setOrigin_station("顺德");
		train.setTerminal_station("广州南");
		train.setStart_time(2015,7,28,9,20); 
		train.setReach_time(2015,7,28,9,32);
		train.setTicket_price(15);
		train.setSeat_total_num(800);
		train.setSeat_remain_num(51);
		train.setState(0);
		td.addTrain(train);
		
		train.setTrainType("G222");
		train.setOrigin_station("广州南");
		train.setTerminal_station("珠海");
		train.setStart_time(2015,7,28,10,20); 
		train.setReach_time(2015,7,28,11,32);
		train.setTicket_price(50);
		train.setSeat_total_num(800);
		train.setSeat_remain_num(737);
		train.setState(0);
		td.addTrain(train);
		
		train.setTrainType("G456");
		train.setOrigin_station("珠海");
		train.setTerminal_station("广州南");
		train.setStart_time(2015,8,24,11,20); 
		train.setReach_time(2015,8,25,9,32);
		train.setTicket_price(74);
		train.setSeat_total_num(800);
		train.setSeat_remain_num(300);
		train.setState(0);
		td.addTrain(train);
		
		train.setTrainType("G123");
		train.setOrigin_station("珠海");
		train.setTerminal_station("广州南");
		train.setStart_time(2015,8,24,17,20); 
		train.setReach_time(2015,8,25,9,32);
		train.setTicket_price(74);
		train.setSeat_total_num(800);
		train.setSeat_remain_num(300);
		train.setState(0);
		td.addTrain(train);

	}
}
