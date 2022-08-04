package com.example.Eadmission.Model;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.*;
import org.hibernate.id.IdentifierGenerator;
public class IDGenerator implements IdentifierGenerator {
	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		int count=0;
		String prefix="UEA2022";
		String suffix="";
	    Connection connection = session.connection();
	    try {
	        Statement statement=connection.createStatement();

	        ResultSet rs=statement.executeQuery("select left(FLOOR(RAND() * 999999+1000),4)");
	        count++;

	        if(rs.next())
	        {
	            int id=rs.getInt(1);
	            suffix = String.valueOf(id);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return prefix+String.valueOf(count)+suffix;
	}

}
