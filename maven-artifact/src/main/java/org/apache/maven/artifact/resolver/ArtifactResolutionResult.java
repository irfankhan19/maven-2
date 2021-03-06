package org.apache.maven.artifact.resolver;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import java.util.LinkedHashSet;
import java.util.Set;

import org.apache.maven.artifact.Artifact;

/**
 * @author <a href="mailto:jason@maven.org">Jason van Zyl</a>
 * @version $Id$
 */
public class ArtifactResolutionResult
{
    private Set<ResolutionNode> resolutionNodes;

    // calculated.
    private Set<Artifact> artifacts;

    public ArtifactResolutionResult()
    {
    }

    public Set<Artifact> getArtifacts()
    {
        if ( artifacts == null )
        {
            artifacts = new LinkedHashSet<Artifact>();

            for ( ResolutionNode node : resolutionNodes )
            {
                artifacts.add( node.getArtifact() );
            }
        }

        return artifacts;
    }

    public Set<ResolutionNode> getArtifactResolutionNodes()
    {
        return resolutionNodes;
    }

    public void setArtifactResolutionNodes( Set<ResolutionNode> resolutionNodes )
    {
        this.resolutionNodes = resolutionNodes;

        // clear the cache
        this.artifacts = null;
    }

    public String toString()
    {
        return "Artifacts: " + this.artifacts + " Nodes: " + this.resolutionNodes;
    }
}
