/*
 *                         Vortex OpenSplice
 *
 *   This software and documentation are Copyright 2006 to TO_YEAR ADLINK
 *   Technology Limited, its affiliated companies and licensors. All rights
 *   reserved.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */
/**
 * Contains all data that is read and/or written in the database. 
 */
package org.opensplice.cm.data;

import org.opensplice.cm.qos.MessageQoS;

/**
 * Represents a Splice Message.
 * 
 * @date May 13, 2004
 */
public class Message {
    /**Creates a new Message.
     * 
     * @param _nodeState State of the node.
     * @param _writeTimeSec Time the message was written (seconds)
     * @param _writeTimeNanoSec Time the message was written (nanoseconds)
     * @param _qos QoS policy of the Message.
     * @param _userData Userdata in the Message.
     */
    public Message(
            State _nodeState, 
            long _writeTimeSec, 
            long _writeTimeNanoSec,
            GID _writerGid,
            GID _instanceGid,
            long _sampleSequenceNumber,
            MessageQoS _qos, 
            UserData _userData)
    {
        nodeState = _nodeState;
        writeTimeSec = _writeTimeSec;
        writeTimeNanoSec = _writeTimeNanoSec;
        writerGid = _writerGid;
        instanceGid = _instanceGid;
        sampleSequenceNumber = _sampleSequenceNumber;
        qos = _qos;
        userData = _userData;
    }
    
    /**
     * Provides access to the node state.
     * 
     * @return The node state.
     */
    public State getNodeState() {
        return nodeState;
    }

    /**
     * Provides access to the QoS policy.
     * 
     * @return The QoS policy.
     */
    public MessageQoS getQos() {
        return qos;
    }

    /**
     * Provides access to the data in the Message.
     * 
     * @return The data in this Message.
     */
    public UserData getUserData() {
        return userData;
    }

    /**
     * Provides access to the time the data was written (seconds).
     * @return The time the data was written (seconds).
     */
    public long getWriteTimeNanoSec() {
        return writeTimeNanoSec;
    }

    /**
     * Provides access to the time the data was written (nanoseconds).
     * 
     * @return The time the data was written (nanoseconds).
     */
    public long getWriteTimeSec() {
        return writeTimeSec;
    }

    /**
     * Sets the node state to the supplied parameter.
     * 
     * @param state The node state to set.
     */
    public void setNodeState(State state) {
        nodeState = state;
    }

    /**
     * Sets the QoS to the supplied parameter.
     * 
     * @param string the QoS to set.
     */
    public void setQos(MessageQoS _qos) {
        qos = _qos;
    }

    /**
     * Sets the data to the supplied parameter.
     * 
     * @param data The data to set.
     */
    public void setUserData(UserData data) {
        userData = data;
    }

    /**
     * Sets the write time (seconds) to the supplied parameter.
     * 
     * @param l the write time to set (seconds).
     */
    public void setWriteTimeNanoSec(long l) {
        writeTimeNanoSec = l;
    }

    /**
     * Sets the write time (nanoseconds) to the supplied parameter.
     * 
     * @param l the write time to set (nanoseconds).
     */
    public void setWriteTimeSec(long l) {
        writeTimeSec = l;
    }
    
    /**
     * Constructs a String representation of the message, without
     * the user data.
     * 
     * @return The String message representation.  
     */
    public String getMessageInfoString(){
        return  "Nodestate\t: " + nodeState + "\n" +
                "WriteTime\t: " + writeTimeSec + "s, " + writeTimeNanoSec + "ns\n" +
                "QoS\t: " + qos;
    }
    
    @Override
    public String toString(){
        String result;
        
        result =    "++++++++++++++\n" +
                    "+MessageInfo +\n" + 
                    "++++++++++++++\n" +
                    "+Nodestate  : " + nodeState + "\n" +
                    "+WriteTime  : " + writeTimeSec + "s, " + writeTimeNanoSec + "ns\n" +
                    "+QoS        : " + qos + "\n" +
                    "++++++++++++++\n" +
                    userData.toString();
        
        return result;
    }
    
    /**
     * Provides access to instanceGid.
     * 
     * @return Returns the instanceGid.
     */
    public GID getInstanceGid() {
        return instanceGid;
    }
    /**
     * Provides access to sampleSequenceNumber.
     * 
     * @return Returns the sampleSequenceNumber.
     */
    public long getSampleSequenceNumber() {
        return sampleSequenceNumber;
    }
    /**
     * Provides access to writerGid.
     * 
     * @return Returns the writerGid.
     */
    public GID getWriterGid() {
        return writerGid;
    }
    
    /**
     * Sets the instanceGid to the supplied value.
     *
     * @param instanceGid The instanceGid to set.
     */
    public void setInstanceGid(GID instanceGid) {
        this.instanceGid = instanceGid;
    }
    /**
     * Sets the sampleSequenceNumber to the supplied value.
     *
     * @param sampleSequenceNumber The sampleSequenceNumber to set.
     */
    public void setSampleSequenceNumber(long sampleSequenceNumber) {
        this.sampleSequenceNumber = sampleSequenceNumber;
    }
    /**
     * Sets the writerGid to the supplied value.
     *
     * @param writerGid The writerGid to set.
     */
    public void setWriterGid(GID writerGid) {
        this.writerGid = writerGid;
    }
    
    /**
     * The nodestate of the node where the data was read from.
     */
    private State nodeState;
    
    /**
     * The time the data was written in the database (seconds).
     */
    private long writeTimeSec;
    
    /**
     * The time the data was written in the database (nanoseconds).
     */
    private long writeTimeNanoSec;
    
    /**
     * The GID of the writer.
     */
    private GID writerGid;
    
    /**
     * The GID of the instance.
     */
    private GID instanceGid;
    
    /**
     * The sequence number of the Sample
     */
    private long sampleSequenceNumber;
    
    /**
     * The QoS policy of the data.
     */
    private MessageQoS qos;
    
    /**
     * The userdata in the message.
     */
    private UserData userData;
    
}
