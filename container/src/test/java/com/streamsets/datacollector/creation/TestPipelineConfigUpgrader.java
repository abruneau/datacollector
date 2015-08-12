/**
 * (c) 2015 StreamSets, Inc. All rights reserved. May not
 * be copied, modified, or distributed in whole or part without
 * written consent of StreamSets, Inc.
 */
package com.streamsets.datacollector.creation;

import com.streamsets.pipeline.api.Config;
import com.streamsets.pipeline.api.ExecutionMode;
import com.streamsets.pipeline.api.StageException;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestPipelineConfigUpgrader {

  @Test
  public void testPipelineConfigUpgrader() throws StageException {
    PipelineConfigUpgrader pipelineConfigUpgrader = new PipelineConfigUpgrader();

    List<Config> upgrade = pipelineConfigUpgrader.upgrade("x", "y", "z", 1, 2, new ArrayList<Config>());
    Assert.assertEquals(1, upgrade.size());
    Assert.assertEquals("executionMode", upgrade.get(0).getName());
    Assert.assertEquals(ExecutionMode.STANDALONE, upgrade.get(0).getValue());

  }

}
