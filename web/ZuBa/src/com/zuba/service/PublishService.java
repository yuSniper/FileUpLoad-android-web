package com.zuba.service;

import com.zuba.dao.PublishDao;
import com.zuba.dao.PublishDaoImple;
import com.zuba.moclass.Publish;

public class PublishService {

	public Publish insert_info(Publish publish) {
		PublishDao insertdao = new PublishDaoImple();
		return insertdao.insertPublish(publish);
	}
}
