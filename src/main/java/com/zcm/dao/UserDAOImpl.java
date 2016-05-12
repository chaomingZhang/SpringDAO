package com.zcm.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.zcm.vo.User;
import com.zcm.vo.UserMapper;

public class UserDAOImpl  extends JdbcDaoSupport implements IUserDAO {

	@Override
	//显示所有用户
	public void show() {
		// TODO Auto-generated method stub
			List<Map<String,Object>> list=this.getJdbcTemplate().queryForList("select *from user");
			Iterator<Map<String,Object>>it=list.iterator();
			while(it.hasNext()){
				Map<String,Object>map=it.next();
				System.out.println(map.get("username")+"---"+map.get("password"));
			}
			
			
	}
	@Override
	//按名字查询用户
	public void queryByUsername() {
		// TODO Auto-generated method stub
		List<Map<String,Object>> list=this.getJdbcTemplate().queryForList("select * from user where username like ? and password like?", new Object[]{"C%","1234"}, new int[]{java.sql.Types.VARCHAR,java.sql.Types.VARCHAR});
		Iterator<Map<String,Object>>it=list.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		UserDAOImpl user=(UserDAOImpl)ctx.getBean("udao");
		user.del();
		user.show();

	}
	@Override
	//查询
	public void show1() {
		// TODO Auto-generated method stub
		List<User> list=this.getJdbcTemplate().query("select * from user where username like ?", 
				new Object[]{"C%"},new UserMapper() );
		Iterator<User>it=list.iterator();
		while(it.hasNext()){
			User user=it.next();
			System.out.println(user.getUsername());
		}
		
	}
	@Override
	//增加用户
	public void add() {
		// TODO Auto-generated method stub
		this.getJdbcTemplate().update("insert into user(username,password) value(?,?)", new PreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				
				ps.setString(1, "Victus");
				ps.setString(2, "666");
				ps.setString(1, "enZuo");
				ps.setString(2, "8899");
				System.out.println("addSuccess");
			}
		});
		
	}
	@Override
	//删除用户
	public void del() {
		// TODO Auto-generated method stub
		this.getJdbcTemplate().update("delete from user where username=?", new PreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setInt(1, 111);
				System.out.println("delSuccess");
			}
		});
		
	}
	@Override
	//更新用户信息
	public void update() {
		// TODO Auto-generated method stub
		this.getJdbcTemplate().update("update user set username=? , password=? where id=?", new PreparedStatementSetter(){

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				// TODO Auto-generated method stub
				ps.setString(1, "Lulu");
				ps.setString(2, "444");
				ps.setInt(3,1);
				System.out.println("updateSuccess");
			}
			
		});
		
	}


}
