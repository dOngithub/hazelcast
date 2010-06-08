/* 
 * Copyright (c) 2008-2010, Hazel Ltd. All Rights Reserved.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at 
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.hazelcast.impl.ascii.rest;

import com.hazelcast.impl.ascii.AbstractTextCommand;

public abstract class HttpCommand extends AbstractTextCommand {
    public static final String HEADER_CONTENT_TYPE = "Content-TextCommandType: ";
    public static final String HEADER_CONTENT_LENGTH = "Content-Length: ";
    public static final String HEADER_CHUNKED = "Transfer-Encoding: chunked";

    private final String uri;

    public static final byte[] RES_200 = "HTTP/1.1 200 OK\r\n".getBytes();
    public static final byte[] RES_204 = "HTTP/1.1 204 No Content\r\n\r\n".getBytes();
    public static final byte[] RES_400 = "HTTP/1.1 400 Bad Request\r\n\r\n".getBytes();
    public static final byte[] RES_404 = "HTTP/1.1 404 Not Found\r\n\r\n".getBytes();
    public static final byte[] RES_100 = "HTTP/1.1 100 Continue\r\n\r\n".getBytes();
    public static final byte[] CONTENT_TYPE = "Content-TextCommandType: ".getBytes();
    public static final byte[] CONTENT_LENGTH = "Content-Length: ".getBytes();

    public HttpCommand(TextCommandType type, String uri) {
        super(type);
        this.uri = uri;
    }

    public boolean shouldReply() {
        return true;
    }

    @Override
    public String toString() {
        return "HttpCommand [" + type + "]{" +
                "uri='" + uri + '\'' +
                '}' + super.toString();
    }

    public String getURI() {
        return uri;
    }
}