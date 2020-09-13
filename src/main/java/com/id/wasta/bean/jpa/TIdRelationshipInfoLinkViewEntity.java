package com.id.wasta.bean.jpa;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonInclude;

@Entity
@Table(name="t_id_relationship_info_link_view")
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="TIdRelationshipInfoLinkViewEntity.countAll", query="SELECT COUNT(x) FROM TIdRelationshipInfoLinkViewEntity x" )
} )
@JsonInclude(JsonInclude.Include.NON_NULL)

public class TIdRelationshipInfoLinkViewEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
		@Id
	    @Column(name="prlk_key", nullable=false)
	    private Long       prlkKey      ;
		
		@Column(name="prlk_prl_key", nullable=false)
	    private Long       prlkPrlKey      ;
	    
	    @Column(name="prlk_relation_type", nullable=false, length=1)
			
	     private String     prlkRelationType ;
	    
	    @Column(name="prlk_relationship_key", nullable=false)
	    private Long prlkRelationshipKey;
	    
	    @Column(name="prlk_relationship", nullable=false, length=1)
			
	     private String     prlkRelationship ;

	    @Column(name="prlk_from_pin_key", nullable=false)
			
	     private Long       prlkFromPinKey ;

	    @Column(name="prlk_to_pin_key")
			
	     private Long       prlkToPinKey ;

	    @Column(name="prlk_to_psc_key")
			
	     private Long       prlkToPscKey ;

	    @Column(name="prlk_contact")
	    private Long prlkContact; 
	    
	    @Column(name="active_status", nullable=false)
			
	     private String       activeStatus ;

	    @Column(name="lock_key", nullable=false)
					@Version
			
	     private Long       lockKey      ;

	    @Column(name="profile_key", nullable=false, length=75)
			
	     private Long     profileKey   ;
	    
	    @Column(name="prl_first_name")
	    private String prlFirstName;
	    
	    @Column(name="prl_last_name")
	    private String prlLirstName;
	    
	    @Column(name="pin_first_name")
	    private String pinFirstName;
	    
	    @Column(name="pin_last_name")
	    private String pinLirstName;
	    
	    public TIdRelationshipInfoLinkViewEntity() {
			super();
	    }
	    

		public Long getPrlkKey() {
			return prlkKey;
		}

		public void setPrlkKey(Long prlkKey) {
			this.prlkKey = prlkKey;
		}

		public Long getPrlkPrlKey() {
			return prlkPrlKey;
		}

		public void setPrlkPrlKey(Long prlkPrlKey) {
			this.prlkPrlKey = prlkPrlKey;
		}

		public String getPrlkRelationType() {
			return prlkRelationType;
		}

		public void setPrlkRelationType(String prlkRelationType) {
			this.prlkRelationType = prlkRelationType;
		}
		
		public Long getPrlkRelationshipKey() {
			return prlkRelationshipKey;
		}

		public void setPrlkRelationshipKey(Long prlkRelationshipKey) {
			this.prlkRelationshipKey = prlkRelationshipKey;
		}

		public String getPrlkRelationship() {
			return prlkRelationship;
		}

		public void setPrlkRelationship(String prlkRelationship) {
			this.prlkRelationship = prlkRelationship;
		}

		public Long getPrlkFromPinKey() {
			return prlkFromPinKey;
		}

		public void setPrlkFromPinKey(Long prlkFromPinKey) {
			this.prlkFromPinKey = prlkFromPinKey;
		}

		public Long getPrlkToPinKey() {
			return prlkToPinKey;
		}

		public void setPrlkToPinKey(Long prlkToPinKey) {
			this.prlkToPinKey = prlkToPinKey;
		}

		public Long getPrlkToPscKey() {
			return prlkToPscKey;
		}

		public void setPrlkToPscKey(Long prlkToPscKey) {
			this.prlkToPscKey = prlkToPscKey;
		}

		
		public Long getPrlkContact() {
			return prlkContact;
		}

		public void setPrlkContact(Long prlkContact) {
			this.prlkContact = prlkContact;
		}


		public String getActiveStatus() {
			return activeStatus;
		}

		public void setActiveStatus(String activeStatus) {
			this.activeStatus = activeStatus;
		}

		public Long getLockKey() {
			return lockKey;
		}

		public void setLockKey(Long lockKey) {
			this.lockKey = lockKey;
		}

		public Long getProfileKey() {
			return profileKey;
		}

		public void setProfileKey(Long profileKey) {
			this.profileKey = profileKey;
		}

		public String getPrlFirstName() {
			return prlFirstName;
		}

		public void setPrlFirstName(String prlFirstName) {
			this.prlFirstName = prlFirstName;
		}

		public String getPrlLirstName() {
			return prlLirstName;
		}

		public void setPrlLirstName(String prlLirstName) {
			this.prlLirstName = prlLirstName;
		}

		public String getPinFirstName() {
			return pinFirstName;
		}

		public void setPinFirstName(String pinFirstName) {
			this.pinFirstName = pinFirstName;
		}

		public String getPinLirstName() {
			return pinLirstName;
		}

		public void setPinLirstName(String pinLirstName) {
			this.pinLirstName = pinLirstName;
		}

		  public String toString() { 
		        StringBuffer sb = new StringBuffer(); 
		        sb.append(prlkKey);
		        sb.append("|");
		        sb.append(prlkRelationType);
		        sb.append("|");
		        sb.append(prlkRelationship);
		        sb.append("|");
		        sb.append(prlkRelationshipKey);
		        sb.append("|");
		        sb.append(prlkFromPinKey);
		        sb.append("|");
		        sb.append(prlkToPinKey);
		        sb.append("|");
		        sb.append(prlkToPscKey);
		        sb.append("|");
		        sb.append(prlkContact);
		        sb.append("|");
		        sb.append(activeStatus);
		        sb.append("|");
		        sb.append(lockKey);
		        sb.append("|");
		        sb.append(profileKey);
		        sb.append("|");
		        sb.append(prlFirstName);
		        sb.append("|");
		        sb.append(prlLirstName);
		        sb.append("|");
		        sb.append(pinFirstName);
		        sb.append("|");
		        sb.append(pinLirstName);
		        return sb.toString(); 
		    } 
}
