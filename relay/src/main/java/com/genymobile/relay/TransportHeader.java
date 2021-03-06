/*
 * Copyright (C) 2017 Genymobile
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.genymobile.relay;

import java.nio.ByteBuffer;

public interface TransportHeader {

    int getSourcePort();

    int getDestinationPort();

    void setSourcePort(int port);

    void setDestinationPort(int port);

    int getHeaderLength();

    void setPayloadLength(int payloadLength);

    ByteBuffer getRaw();

    TransportHeader copyTo(ByteBuffer buffer);

    TransportHeader copy();

    void computeChecksum(IPv4Header ipv4Header, ByteBuffer payload);

    default void switchSourceAndDestination() {
        int tmp = getSourcePort();
        setSourcePort(getDestinationPort());
        setDestinationPort(tmp);
    }
}
