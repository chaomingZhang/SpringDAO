# SpringDAO
      这是一个对SpringDAO的练习，其中通过applicationxml件配置对DB的访问，首先用DataSource的bean来将驱动，Url，用户名，密码都写好，再将
  DataSource引入到JdbcTemplate的bean，在UserDAOImpl类继承JdbcDaoSupport后，UserDAOImpl已经可以使用jdbcTemplate，因此将jdbcTemplate直接
  引入到UserDAOImpl的bean中即可，相对于JDBC代码更加便捷明了。
      之后对IUserDAO内所写的增删改查方法在UserDAOImpl内进行实现，如显示show(),将getJdbcTemplate使用queryForList方法执行  "select *from 
  user"语句的结果都放在用泛型<Map<String,Object>>约束好的List中，再实例化遍历器Iterator，用while循环输出结果.
  
