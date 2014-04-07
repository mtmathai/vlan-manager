package mtm.vlanmgr.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

import mtm.vlanmgr.Vlan;

@Entity
@Table(name = "vlan")
public class VlanEntity implements Vlan {

  @Id
  @GeneratedValue
  private Long id;

  @Version
  private Long version;
  
  @Column(name = "vlan_id", nullable = false, unique = true)
  private Integer vlanId;
  
  @Column(nullable = false, unique = true)
  private String name;
  
  @Column
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
