/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.rendering.internal.parser.reference.type;

import javax.inject.Named;
import javax.inject.Singleton;

import org.xwiki.component.annotation.Component;
import org.xwiki.rendering.listener.reference.ResourceReference;
import org.xwiki.rendering.listener.reference.ResourceType;
import org.xwiki.rendering.parser.ResourceReferenceTypeParser;

/**
 * Parses a resource reference to an image specified as a <a href="http://tools.ietf.org/html/rfc2397">Data URI</a>.
 *
 * @version $Id$
 * @since 5.4RC1
 */
@Component
@Named("data")
@Singleton
public class DataURIResourceReferenceTypeParser implements ResourceReferenceTypeParser
{
    @Override
    public ResourceType getType()
    {
        return ResourceType.DATA;
    }

    @Override
    public ResourceReference parse(String reference)
    {
        ResourceReference resourceReference = null;

        // We verify that the reference starts with "image/" (which is the prefix for the mime type) and otherwise we
        // return null to signify to the caller that its not a Data URI type.
        if (reference.startsWith("image/")) {
            resourceReference = new ResourceReference(reference, getType());
        }
        return resourceReference;
    }
}
