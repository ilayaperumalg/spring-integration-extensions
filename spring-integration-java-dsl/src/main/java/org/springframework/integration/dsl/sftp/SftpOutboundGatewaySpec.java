/*
 * Copyright 2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.integration.dsl.sftp;

import com.jcraft.jsch.ChannelSftp;

import org.springframework.integration.dsl.file.RemoteFileOutboundGatewaySpec;
import org.springframework.integration.file.remote.gateway.AbstractRemoteFileOutboundGateway;
import org.springframework.integration.sftp.filters.SftpRegexPatternFileListFilter;
import org.springframework.integration.sftp.filters.SftpSimplePatternFileListFilter;

/**
 * @author Artem Bilan
 */
public class SftpOutboundGatewaySpec extends RemoteFileOutboundGatewaySpec<ChannelSftp.LsEntry, SftpOutboundGatewaySpec> {


	SftpOutboundGatewaySpec(AbstractRemoteFileOutboundGateway<ChannelSftp.LsEntry> outboundGateway) {
		super(outboundGateway);
	}

	@Override
	public SftpOutboundGatewaySpec patternFileNameFilter(String pattern) {
		return filter(new SftpSimplePatternFileListFilter(pattern));
	}

	@Override
	public SftpOutboundGatewaySpec regexFileNameFilter(String regex) {
		return filter(new SftpRegexPatternFileListFilter(regex));
	}
}
