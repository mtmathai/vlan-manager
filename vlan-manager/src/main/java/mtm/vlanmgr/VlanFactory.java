package mtm.vlanmgr;

public interface VlanFactory {

  /**
   * Creates a new transient instance of {@link Vlan}.
   * @return new vlan object
   */
  Vlan newVlan();

}
