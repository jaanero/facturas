package jaanero.facturas.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Results;

import jaanero.facturas.model.Client;

public interface ClientMapper {
   @Select("SELECT * FROM CLIENT WHERE CLIENT_KEY = #{clientId}")
   @Results(value = { @Result(property = "id", column = "CLIENT_KEY"),
         @Result(property = "name", column = "CLIENT_NAME") })
   public Client getClient(@Param("clientId") String clientId);

   @Insert("INSERT INTO CLIENT (CLIENT_NAME) VALUES (#{name})")
   public void insertClient(Client client);

   @Select("SELECT * FROM CLIENT WHERE CLIENT_NAME = #{name}")
   @Results(value = { @Result(property = "id", column = "CLIENT_KEY"),
         @Result(property = "name", column = "CLIENT_NAME") })

   public Client findByName(String name);

}
