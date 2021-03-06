/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/**
 * Autogenerated by Thrift Compiler (0.12.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.storm.generated;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.12.0)")
public class ClusterSummary implements org.apache.thrift.TBase<ClusterSummary, ClusterSummary._Fields>, java.io.Serializable, Cloneable, Comparable<ClusterSummary> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("ClusterSummary");

  private static final org.apache.thrift.protocol.TField SUPERVISORS_FIELD_DESC = new org.apache.thrift.protocol.TField("supervisors", org.apache.thrift.protocol.TType.LIST, (short)1);
  private static final org.apache.thrift.protocol.TField NIMBUS_UPTIME_SECS_FIELD_DESC = new org.apache.thrift.protocol.TField("nimbus_uptime_secs", org.apache.thrift.protocol.TType.I32, (short)2);
  private static final org.apache.thrift.protocol.TField TOPOLOGIES_FIELD_DESC = new org.apache.thrift.protocol.TField("topologies", org.apache.thrift.protocol.TType.LIST, (short)3);
  private static final org.apache.thrift.protocol.TField NIMBUSES_FIELD_DESC = new org.apache.thrift.protocol.TField("nimbuses", org.apache.thrift.protocol.TType.LIST, (short)4);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new ClusterSummaryStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new ClusterSummaryTupleSchemeFactory();

  private @org.apache.thrift.annotation.Nullable java.util.List<SupervisorSummary> supervisors; // required
  private int nimbus_uptime_secs; // optional
  private @org.apache.thrift.annotation.Nullable java.util.List<TopologySummary> topologies; // required
  private @org.apache.thrift.annotation.Nullable java.util.List<NimbusSummary> nimbuses; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    SUPERVISORS((short)1, "supervisors"),
    NIMBUS_UPTIME_SECS((short)2, "nimbus_uptime_secs"),
    TOPOLOGIES((short)3, "topologies"),
    NIMBUSES((short)4, "nimbuses");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // SUPERVISORS
          return SUPERVISORS;
        case 2: // NIMBUS_UPTIME_SECS
          return NIMBUS_UPTIME_SECS;
        case 3: // TOPOLOGIES
          return TOPOLOGIES;
        case 4: // NIMBUSES
          return NIMBUSES;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final int __NIMBUS_UPTIME_SECS_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.NIMBUS_UPTIME_SECS};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SUPERVISORS, new org.apache.thrift.meta_data.FieldMetaData("supervisors", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, SupervisorSummary.class))));
    tmpMap.put(_Fields.NIMBUS_UPTIME_SECS, new org.apache.thrift.meta_data.FieldMetaData("nimbus_uptime_secs", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.TOPOLOGIES, new org.apache.thrift.meta_data.FieldMetaData("topologies", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TopologySummary.class))));
    tmpMap.put(_Fields.NIMBUSES, new org.apache.thrift.meta_data.FieldMetaData("nimbuses", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.ListMetaData(org.apache.thrift.protocol.TType.LIST, 
            new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, NimbusSummary.class))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(ClusterSummary.class, metaDataMap);
  }

  public ClusterSummary() {
    this.nimbus_uptime_secs = 0;

  }

  public ClusterSummary(
    java.util.List<SupervisorSummary> supervisors,
    java.util.List<TopologySummary> topologies,
    java.util.List<NimbusSummary> nimbuses)
  {
    this();
    this.supervisors = supervisors;
    this.topologies = topologies;
    this.nimbuses = nimbuses;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public ClusterSummary(ClusterSummary other) {
    __isset_bitfield = other.__isset_bitfield;
    if (other.is_set_supervisors()) {
      java.util.List<SupervisorSummary> __this__supervisors = new java.util.ArrayList<SupervisorSummary>(other.supervisors.size());
      for (SupervisorSummary other_element : other.supervisors) {
        __this__supervisors.add(new SupervisorSummary(other_element));
      }
      this.supervisors = __this__supervisors;
    }
    this.nimbus_uptime_secs = other.nimbus_uptime_secs;
    if (other.is_set_topologies()) {
      java.util.List<TopologySummary> __this__topologies = new java.util.ArrayList<TopologySummary>(other.topologies.size());
      for (TopologySummary other_element : other.topologies) {
        __this__topologies.add(new TopologySummary(other_element));
      }
      this.topologies = __this__topologies;
    }
    if (other.is_set_nimbuses()) {
      java.util.List<NimbusSummary> __this__nimbuses = new java.util.ArrayList<NimbusSummary>(other.nimbuses.size());
      for (NimbusSummary other_element : other.nimbuses) {
        __this__nimbuses.add(new NimbusSummary(other_element));
      }
      this.nimbuses = __this__nimbuses;
    }
  }

  public ClusterSummary deepCopy() {
    return new ClusterSummary(this);
  }

  @Override
  public void clear() {
    this.supervisors = null;
    this.nimbus_uptime_secs = 0;

    this.topologies = null;
    this.nimbuses = null;
  }

  public int get_supervisors_size() {
    return (this.supervisors == null) ? 0 : this.supervisors.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<SupervisorSummary> get_supervisors_iterator() {
    return (this.supervisors == null) ? null : this.supervisors.iterator();
  }

  public void add_to_supervisors(SupervisorSummary elem) {
    if (this.supervisors == null) {
      this.supervisors = new java.util.ArrayList<SupervisorSummary>();
    }
    this.supervisors.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<SupervisorSummary> get_supervisors() {
    return this.supervisors;
  }

  public void set_supervisors(@org.apache.thrift.annotation.Nullable java.util.List<SupervisorSummary> supervisors) {
    this.supervisors = supervisors;
  }

  public void unset_supervisors() {
    this.supervisors = null;
  }

  /** Returns true if field supervisors is set (has been assigned a value) and false otherwise */
  public boolean is_set_supervisors() {
    return this.supervisors != null;
  }

  public void set_supervisors_isSet(boolean value) {
    if (!value) {
      this.supervisors = null;
    }
  }

  public int get_nimbus_uptime_secs() {
    return this.nimbus_uptime_secs;
  }

  public void set_nimbus_uptime_secs(int nimbus_uptime_secs) {
    this.nimbus_uptime_secs = nimbus_uptime_secs;
    set_nimbus_uptime_secs_isSet(true);
  }

  public void unset_nimbus_uptime_secs() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __NIMBUS_UPTIME_SECS_ISSET_ID);
  }

  /** Returns true if field nimbus_uptime_secs is set (has been assigned a value) and false otherwise */
  public boolean is_set_nimbus_uptime_secs() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __NIMBUS_UPTIME_SECS_ISSET_ID);
  }

  public void set_nimbus_uptime_secs_isSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __NIMBUS_UPTIME_SECS_ISSET_ID, value);
  }

  public int get_topologies_size() {
    return (this.topologies == null) ? 0 : this.topologies.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<TopologySummary> get_topologies_iterator() {
    return (this.topologies == null) ? null : this.topologies.iterator();
  }

  public void add_to_topologies(TopologySummary elem) {
    if (this.topologies == null) {
      this.topologies = new java.util.ArrayList<TopologySummary>();
    }
    this.topologies.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<TopologySummary> get_topologies() {
    return this.topologies;
  }

  public void set_topologies(@org.apache.thrift.annotation.Nullable java.util.List<TopologySummary> topologies) {
    this.topologies = topologies;
  }

  public void unset_topologies() {
    this.topologies = null;
  }

  /** Returns true if field topologies is set (has been assigned a value) and false otherwise */
  public boolean is_set_topologies() {
    return this.topologies != null;
  }

  public void set_topologies_isSet(boolean value) {
    if (!value) {
      this.topologies = null;
    }
  }

  public int get_nimbuses_size() {
    return (this.nimbuses == null) ? 0 : this.nimbuses.size();
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Iterator<NimbusSummary> get_nimbuses_iterator() {
    return (this.nimbuses == null) ? null : this.nimbuses.iterator();
  }

  public void add_to_nimbuses(NimbusSummary elem) {
    if (this.nimbuses == null) {
      this.nimbuses = new java.util.ArrayList<NimbusSummary>();
    }
    this.nimbuses.add(elem);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.List<NimbusSummary> get_nimbuses() {
    return this.nimbuses;
  }

  public void set_nimbuses(@org.apache.thrift.annotation.Nullable java.util.List<NimbusSummary> nimbuses) {
    this.nimbuses = nimbuses;
  }

  public void unset_nimbuses() {
    this.nimbuses = null;
  }

  /** Returns true if field nimbuses is set (has been assigned a value) and false otherwise */
  public boolean is_set_nimbuses() {
    return this.nimbuses != null;
  }

  public void set_nimbuses_isSet(boolean value) {
    if (!value) {
      this.nimbuses = null;
    }
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case SUPERVISORS:
      if (value == null) {
        unset_supervisors();
      } else {
        set_supervisors((java.util.List<SupervisorSummary>)value);
      }
      break;

    case NIMBUS_UPTIME_SECS:
      if (value == null) {
        unset_nimbus_uptime_secs();
      } else {
        set_nimbus_uptime_secs((java.lang.Integer)value);
      }
      break;

    case TOPOLOGIES:
      if (value == null) {
        unset_topologies();
      } else {
        set_topologies((java.util.List<TopologySummary>)value);
      }
      break;

    case NIMBUSES:
      if (value == null) {
        unset_nimbuses();
      } else {
        set_nimbuses((java.util.List<NimbusSummary>)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case SUPERVISORS:
      return get_supervisors();

    case NIMBUS_UPTIME_SECS:
      return get_nimbus_uptime_secs();

    case TOPOLOGIES:
      return get_topologies();

    case NIMBUSES:
      return get_nimbuses();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case SUPERVISORS:
      return is_set_supervisors();
    case NIMBUS_UPTIME_SECS:
      return is_set_nimbus_uptime_secs();
    case TOPOLOGIES:
      return is_set_topologies();
    case NIMBUSES:
      return is_set_nimbuses();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof ClusterSummary)
      return this.equals((ClusterSummary)that);
    return false;
  }

  public boolean equals(ClusterSummary that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_supervisors = true && this.is_set_supervisors();
    boolean that_present_supervisors = true && that.is_set_supervisors();
    if (this_present_supervisors || that_present_supervisors) {
      if (!(this_present_supervisors && that_present_supervisors))
        return false;
      if (!this.supervisors.equals(that.supervisors))
        return false;
    }

    boolean this_present_nimbus_uptime_secs = true && this.is_set_nimbus_uptime_secs();
    boolean that_present_nimbus_uptime_secs = true && that.is_set_nimbus_uptime_secs();
    if (this_present_nimbus_uptime_secs || that_present_nimbus_uptime_secs) {
      if (!(this_present_nimbus_uptime_secs && that_present_nimbus_uptime_secs))
        return false;
      if (this.nimbus_uptime_secs != that.nimbus_uptime_secs)
        return false;
    }

    boolean this_present_topologies = true && this.is_set_topologies();
    boolean that_present_topologies = true && that.is_set_topologies();
    if (this_present_topologies || that_present_topologies) {
      if (!(this_present_topologies && that_present_topologies))
        return false;
      if (!this.topologies.equals(that.topologies))
        return false;
    }

    boolean this_present_nimbuses = true && this.is_set_nimbuses();
    boolean that_present_nimbuses = true && that.is_set_nimbuses();
    if (this_present_nimbuses || that_present_nimbuses) {
      if (!(this_present_nimbuses && that_present_nimbuses))
        return false;
      if (!this.nimbuses.equals(that.nimbuses))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((is_set_supervisors()) ? 131071 : 524287);
    if (is_set_supervisors())
      hashCode = hashCode * 8191 + supervisors.hashCode();

    hashCode = hashCode * 8191 + ((is_set_nimbus_uptime_secs()) ? 131071 : 524287);
    if (is_set_nimbus_uptime_secs())
      hashCode = hashCode * 8191 + nimbus_uptime_secs;

    hashCode = hashCode * 8191 + ((is_set_topologies()) ? 131071 : 524287);
    if (is_set_topologies())
      hashCode = hashCode * 8191 + topologies.hashCode();

    hashCode = hashCode * 8191 + ((is_set_nimbuses()) ? 131071 : 524287);
    if (is_set_nimbuses())
      hashCode = hashCode * 8191 + nimbuses.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(ClusterSummary other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(is_set_supervisors()).compareTo(other.is_set_supervisors());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (is_set_supervisors()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.supervisors, other.supervisors);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(is_set_nimbus_uptime_secs()).compareTo(other.is_set_nimbus_uptime_secs());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (is_set_nimbus_uptime_secs()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.nimbus_uptime_secs, other.nimbus_uptime_secs);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(is_set_topologies()).compareTo(other.is_set_topologies());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (is_set_topologies()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.topologies, other.topologies);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(is_set_nimbuses()).compareTo(other.is_set_nimbuses());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (is_set_nimbuses()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.nimbuses, other.nimbuses);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  @org.apache.thrift.annotation.Nullable
  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("ClusterSummary(");
    boolean first = true;

    sb.append("supervisors:");
    if (this.supervisors == null) {
      sb.append("null");
    } else {
      sb.append(this.supervisors);
    }
    first = false;
    if (is_set_nimbus_uptime_secs()) {
      if (!first) sb.append(", ");
      sb.append("nimbus_uptime_secs:");
      sb.append(this.nimbus_uptime_secs);
      first = false;
    }
    if (!first) sb.append(", ");
    sb.append("topologies:");
    if (this.topologies == null) {
      sb.append("null");
    } else {
      sb.append(this.topologies);
    }
    first = false;
    if (!first) sb.append(", ");
    sb.append("nimbuses:");
    if (this.nimbuses == null) {
      sb.append("null");
    } else {
      sb.append(this.nimbuses);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (!is_set_supervisors()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'supervisors' is unset! Struct:" + toString());
    }

    if (!is_set_topologies()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'topologies' is unset! Struct:" + toString());
    }

    if (!is_set_nimbuses()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'nimbuses' is unset! Struct:" + toString());
    }

    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class ClusterSummaryStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public ClusterSummaryStandardScheme getScheme() {
      return new ClusterSummaryStandardScheme();
    }
  }

  private static class ClusterSummaryStandardScheme extends org.apache.thrift.scheme.StandardScheme<ClusterSummary> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, ClusterSummary struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // SUPERVISORS
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list108 = iprot.readListBegin();
                struct.supervisors = new java.util.ArrayList<SupervisorSummary>(_list108.size);
                @org.apache.thrift.annotation.Nullable SupervisorSummary _elem109;
                for (int _i110 = 0; _i110 < _list108.size; ++_i110)
                {
                  _elem109 = new SupervisorSummary();
                  _elem109.read(iprot);
                  struct.supervisors.add(_elem109);
                }
                iprot.readListEnd();
              }
              struct.set_supervisors_isSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // NIMBUS_UPTIME_SECS
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.nimbus_uptime_secs = iprot.readI32();
              struct.set_nimbus_uptime_secs_isSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // TOPOLOGIES
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list111 = iprot.readListBegin();
                struct.topologies = new java.util.ArrayList<TopologySummary>(_list111.size);
                @org.apache.thrift.annotation.Nullable TopologySummary _elem112;
                for (int _i113 = 0; _i113 < _list111.size; ++_i113)
                {
                  _elem112 = new TopologySummary();
                  _elem112.read(iprot);
                  struct.topologies.add(_elem112);
                }
                iprot.readListEnd();
              }
              struct.set_topologies_isSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 4: // NIMBUSES
            if (schemeField.type == org.apache.thrift.protocol.TType.LIST) {
              {
                org.apache.thrift.protocol.TList _list114 = iprot.readListBegin();
                struct.nimbuses = new java.util.ArrayList<NimbusSummary>(_list114.size);
                @org.apache.thrift.annotation.Nullable NimbusSummary _elem115;
                for (int _i116 = 0; _i116 < _list114.size; ++_i116)
                {
                  _elem115 = new NimbusSummary();
                  _elem115.read(iprot);
                  struct.nimbuses.add(_elem115);
                }
                iprot.readListEnd();
              }
              struct.set_nimbuses_isSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, ClusterSummary struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.supervisors != null) {
        oprot.writeFieldBegin(SUPERVISORS_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.supervisors.size()));
          for (SupervisorSummary _iter117 : struct.supervisors)
          {
            _iter117.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.is_set_nimbus_uptime_secs()) {
        oprot.writeFieldBegin(NIMBUS_UPTIME_SECS_FIELD_DESC);
        oprot.writeI32(struct.nimbus_uptime_secs);
        oprot.writeFieldEnd();
      }
      if (struct.topologies != null) {
        oprot.writeFieldBegin(TOPOLOGIES_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.topologies.size()));
          for (TopologySummary _iter118 : struct.topologies)
          {
            _iter118.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      if (struct.nimbuses != null) {
        oprot.writeFieldBegin(NIMBUSES_FIELD_DESC);
        {
          oprot.writeListBegin(new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, struct.nimbuses.size()));
          for (NimbusSummary _iter119 : struct.nimbuses)
          {
            _iter119.write(oprot);
          }
          oprot.writeListEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class ClusterSummaryTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public ClusterSummaryTupleScheme getScheme() {
      return new ClusterSummaryTupleScheme();
    }
  }

  private static class ClusterSummaryTupleScheme extends org.apache.thrift.scheme.TupleScheme<ClusterSummary> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, ClusterSummary struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      {
        oprot.writeI32(struct.supervisors.size());
        for (SupervisorSummary _iter120 : struct.supervisors)
        {
          _iter120.write(oprot);
        }
      }
      {
        oprot.writeI32(struct.topologies.size());
        for (TopologySummary _iter121 : struct.topologies)
        {
          _iter121.write(oprot);
        }
      }
      {
        oprot.writeI32(struct.nimbuses.size());
        for (NimbusSummary _iter122 : struct.nimbuses)
        {
          _iter122.write(oprot);
        }
      }
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.is_set_nimbus_uptime_secs()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.is_set_nimbus_uptime_secs()) {
        oprot.writeI32(struct.nimbus_uptime_secs);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, ClusterSummary struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      {
        org.apache.thrift.protocol.TList _list123 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
        struct.supervisors = new java.util.ArrayList<SupervisorSummary>(_list123.size);
        @org.apache.thrift.annotation.Nullable SupervisorSummary _elem124;
        for (int _i125 = 0; _i125 < _list123.size; ++_i125)
        {
          _elem124 = new SupervisorSummary();
          _elem124.read(iprot);
          struct.supervisors.add(_elem124);
        }
      }
      struct.set_supervisors_isSet(true);
      {
        org.apache.thrift.protocol.TList _list126 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
        struct.topologies = new java.util.ArrayList<TopologySummary>(_list126.size);
        @org.apache.thrift.annotation.Nullable TopologySummary _elem127;
        for (int _i128 = 0; _i128 < _list126.size; ++_i128)
        {
          _elem127 = new TopologySummary();
          _elem127.read(iprot);
          struct.topologies.add(_elem127);
        }
      }
      struct.set_topologies_isSet(true);
      {
        org.apache.thrift.protocol.TList _list129 = new org.apache.thrift.protocol.TList(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
        struct.nimbuses = new java.util.ArrayList<NimbusSummary>(_list129.size);
        @org.apache.thrift.annotation.Nullable NimbusSummary _elem130;
        for (int _i131 = 0; _i131 < _list129.size; ++_i131)
        {
          _elem130 = new NimbusSummary();
          _elem130.read(iprot);
          struct.nimbuses.add(_elem130);
        }
      }
      struct.set_nimbuses_isSet(true);
      java.util.BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        struct.nimbus_uptime_secs = iprot.readI32();
        struct.set_nimbus_uptime_secs_isSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

