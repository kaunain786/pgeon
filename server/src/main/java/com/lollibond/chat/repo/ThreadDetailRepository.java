package com.lollibond.chat.repo;

import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Row;
import com.datastax.driver.core.Session;
import com.lollibond.chat.domain.ThreadDetail;

public class ThreadDetailRepository {

	String serverIp = "127.0.0.1";
	String keyspace = "pigeon";
	Cluster cluster = Cluster.builder().addContactPoints(serverIp).withPort(9042).build();
	Session session = cluster.connect(keyspace);

	public void saveThreadDetail(ThreadDetail threadDetail) {
		StringBuilder builder = new StringBuilder();
		builder.append("insert into thread_detail (tid,participants_list,name,admins_list) values('")
				.append(threadDetail.getTid()).append("','").append(threadDetail.getParticipants_list()).append("','")
				.append(threadDetail.getName()).append("','").append(threadDetail.getAdmins_list()).append("');");
		session.execute(builder.toString());
		System.out.println(builder.toString());
	}

	public ThreadDetail fetchThreadDetail(String tid) {
		StringBuilder builder = new StringBuilder("Select * from thread_detail where tid='");
		builder.append(tid).append("';");
		ThreadDetail threadDetail = new ThreadDetail();

		for (Row row : session.execute(builder.toString())) {
			threadDetail.setTid(row.getString("tid"));
			threadDetail.setName(row.getString("name"));
			threadDetail.setParticipants_list(row.getString("participants_list"));
			threadDetail.setAdmins_list(row.getString("admins_list"));
		}
		return threadDetail;
	}

	public void updateThreadDetail(ThreadDetail threadDetail) {

		StringBuilder builder = new StringBuilder();
		builder.append("update thread_list set participants_list='").append(threadDetail.getParticipants_list())
				.append("', name='").append(threadDetail.getName()).append("', admins_list='")
				.append(threadDetail.getAdmins_list()).append("' where tid='").append(threadDetail.getTid())
				.append("');");
		session.execute(builder.toString());
		System.out.println(builder.toString());

	}
	
	public void updateParticipantsList(String participantsList, String tid) {

		StringBuilder builder = new StringBuilder();
		builder.append("update thread_list set participants_list='").append(participantsList)
				.append("' where tid='").append(tid)
				.append("');");
		session.execute(builder.toString());
		System.out.println(builder.toString());

	}
	
	public void updateAdminsList(String adminsList, String tid) {

		StringBuilder builder = new StringBuilder();
		builder.append("update thread_list set admins_list='").append(adminsList)
				.append("' where tid='").append(tid)
				.append("');");
		session.execute(builder.toString());
		System.out.println(builder.toString());

	}

}
