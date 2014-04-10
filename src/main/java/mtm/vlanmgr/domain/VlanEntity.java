package mtm.vlanmgr.domain;

import mtm.vlanmgr.Vlan;

public class VlanEntity implements Vlan {
	
	private Integer vlanId;
	private String name;
	private String note;
	
	@Override
	public Integer getVlanId() {
		return vlanId;
	}
	
	@Override
	public void setVlanId(Integer vlanId) {
		this.vlanId = vlanId;
		
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public void setName(String name) {
		this.name = name;
		
	}
	
	@Override
	public String getNote() {
		return note;
	}
	
	@Override
	public void setNote(String note) {
		this.note = note;
		
	}
}

	
	

	

