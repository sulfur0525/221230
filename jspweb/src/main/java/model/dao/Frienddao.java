package model.dao;

public class Frienddao extends Dao{
	private static Frienddao frienddao = new Frienddao();
	public static Frienddao getInstance() {return frienddao;}
	private Frienddao () {};
}
