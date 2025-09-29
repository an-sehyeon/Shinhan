package com.shinhan.day07.inter;

// DAO : (Data Access Object)




interface DataAccessObject{
	void select();
	void insert();
	void update();
	void delete();
}

class OracleDao implements DataAccessObject{

	@Override
	public void select() {
		System.out.println(getClass().getSimpleName() + " DB 검색(read)");
	}

	@Override
	public void insert() {
		System.out.println(getClass().getSimpleName() + " DB 입력(create)");
		
	}

	@Override
	public void update() {
		System.out.println(getClass().getSimpleName() + " DB 수정(update)");
		
	}

	@Override
	public void delete() {
		System.out.println(getClass().getSimpleName() + " DB 삭제(delete)");
		
	}}

class MySqlDao implements DataAccessObject{

	@Override
	public void select() {
		System.out.println(getClass().getSimpleName() + " DB 검색(read)");
	}

	@Override
	public void insert() {
		System.out.println(getClass().getSimpleName() + " DB 입력(create)");
		
	}

	@Override
	public void update() {
		System.out.println(getClass().getSimpleName() + " DB 수정(update)");
		
	}

	@Override
	public void delete() {
		System.out.println(getClass().getSimpleName() + " DB 삭제(delete)");
		
	}}
public class DaoExample {
	 public static void dbWork(DataAccessObject dao) {
	 dao.select();
	 dao.insert();
	 dao.update();
	 dao.delete();
	 }
	 

public static void main(String[] args) {
	dbWork(new OracleDao());
	dbWork(new MySqlDao());
	
}
}