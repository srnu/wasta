/*
 * Created on 10 Nov 2016 ( Time 10:16:08 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.id.wasta.bean;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class TableAuditLog implements Serializable {

    private static final long serialVersionUID = 1L;

 
    private Long  tauditKeyValue; 

     @Size( max = 75 )
    private String screenName;

   
	@Size( max = 240 )
    private String insertedName;
    
	
    @NotNull
    private Date insertedOn;


     @Size( max = 240 )
    private String updatedName;


     @NotNull
    private Date updatedOn;

    
    
	


	
    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
	public String getScreenName() {
		return screenName;
	}

	public void setScreenName(String screenName) {
		this.screenName = screenName;
	}

	
	
	public Long getTauditKeyValue() {
			return tauditKeyValue;
		}

		public void setTauditKeyValue(Long tauditKeyValue) {
			this.tauditKeyValue = tauditKeyValue;
		}



	public String getInsertedName() {
		return insertedName;
	}

	public void setInsertedName(String insertedName) {
		this.insertedName = insertedName;
	}

	public String getupdatedName() {
		return updatedName;
	}

	public void setupdatedName(String updatedName) {
		this.updatedName = updatedName;
	}

	public Date getInsertedOn() {
		return insertedOn;
	}

	public void setInsertedOn(Date insertedOn) {
		this.insertedOn = insertedOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}




    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
 
        public String toString() { 
        StringBuffer sb = new StringBuffer(); 
      
        sb.append(screenName);
        sb.append("|");
        sb.append(tauditKeyValue);
        sb.append("|");
        sb.append(insertedName);
        sb.append("|");
        sb.append(insertedOn);
        sb.append("|");
        sb.append(updatedName);
        sb.append("|");
        sb.append(updatedOn);
      
        return sb.toString(); 
    } 


}
