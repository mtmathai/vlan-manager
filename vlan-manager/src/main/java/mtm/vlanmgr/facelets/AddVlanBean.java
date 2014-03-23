package mtm.vlanmgr.facelets;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped

public class AddVlanBean implements Serializable {
	
	private static final long serialVersionUID = 1543893633861762281L;
	
	private Integer vlanId;
	private String name;
	private String note;
	
	public Integer getVlanId() {
		return vlanId;
	}

	public void setVlanId(Integer vlanId) {
		this.vlanId = vlanId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}


	public String save() {
		System.out.println("Saved VLAN "+vlanId);
		return "success";
	}
	
	public String returnToAdd() {
		return "index";
	}
	
	public String add() {
		return "/add/index";
	}
	
	public String returnToList() {
		return "/index";
	}
	

}
