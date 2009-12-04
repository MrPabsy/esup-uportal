/**
 * Copyright (c) 2000-2009, Jasig, Inc.
 * See license distributed with this file and available online at
 * https://www.ja-sig.org/svn/jasig-parent/tags/rel-10/license-header.txt
 */
package org.jasig.portal.tools.chanpub;

import java.io.InputStream;

import org.jasig.portal.utils.ResourceLoader;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;

/**
 * Resolves the channelDefinition.dtd
 * @author Ken Weiner, kweiner@unicon.net
 * @version $Revision$
 * @deprecated See the deprecation message on {@link ChannelPublisher}.
 */
@Deprecated
public class ChannelDefDtdResolver implements EntityResolver {

    public ChannelDefDtdResolver() {
        super();
    }

	/**
	 * Sets the input source to the channel definition dtd.
	 * @param publicId the public ID
	 * @param systemId the system ID
	 * @return an input source based on the channel definition dtd
	 */
	public InputSource resolveEntity (String publicId, String systemId) {
	    InputSource inputSource = null;

        try {
            InputStream inStream = ResourceLoader.getResourceAsStream(this.getClass(), "/dtd/channelDefinition.dtd");
            if (inStream != null) {
                inputSource =  new InputSource(inStream);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	  
	    return inputSource;            
	}
}