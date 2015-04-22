package cronmanagement.bean;

import java.io.Serializable;

import com.pubmatic.coreutils.commoninterfaces.PubmaticEntity;
import com.pubmatic.coreutils.commoninterfaces.Visitor;

public class CronManagement implements PubmaticEntity<Long> , Serializable {
    //Sample POJO For Service     
    private String name;
    private Long id;

   
    @Override
    public Long getId() {
        return id;
    } 
	
    public void setId(Long id) {
        id = this.id;
    }

    @Override
    public String getName() {
        return name;
    }		 

    public void setName(String name) {
        this.name = name;
    }

   public Object accept(Visitor visitor){
       //visitor.visit(this);
      return null;
   }

@Override
public String getUrl() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void setUrl(String url) {
	// TODO Auto-generated method stub
	
}
}
