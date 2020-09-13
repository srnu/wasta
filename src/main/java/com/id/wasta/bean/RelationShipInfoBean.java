package com.id.wasta.bean;

import java.io.Serializable;

/**
 * @author ramesh.j
 *
 */
public class RelationShipInfoBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String relShip;
	private String relShipFirstName;
	private Long relShipPinKey;
	private Long relShipProfileKey;

	public String getRelShip() {
		return relShip;
	}

	public void setRelShip(String relShip) {
		this.relShip = relShip;
	}

	public String getRelShipFirstName() {
		return relShipFirstName;
	}

	public void setRelShipFirstName(String relShipFirstName) {
		this.relShipFirstName = relShipFirstName;
	}

	public Long getRelShipPinKey() {
		return relShipPinKey;
	}

	public void setRelShipPinKey(Long relShipPinKey) {
		this.relShipPinKey = relShipPinKey;
	}

	public Long getRelShipProfileKey() {
		return relShipProfileKey;
	}

	public void setRelShipProfileKey(Long relShipProfileKey) {
		this.relShipProfileKey = relShipProfileKey;
	}

}
