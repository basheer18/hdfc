/*
 *  Copyright 2019 ABSA Group Limited
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
 *
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package hdfc.writer.mycomponent

import org.apache.commons.configuration2.Configuration
import org.apache.logging.log4j.LogManager
import org.apache.spark.sql.DataFrame
import org.apache.spark.sql.streaming.StreamingQuery
import za.co.absa.hyperdrive.ingestor.api.writer.{StreamWriter, StreamWriterFactory}
import za.co.absa.hyperdrive.ingestor.api.manager.OffsetManager


/**
 * This is a stub for a custom implementation of a StreamWriter
 */

private[writer] class MyStreamWriterImpl(val destination: String) extends StreamWriter(destination) {

  def write(dataFrame: DataFrame, offsetManager: OffsetManager): StreamingQuery = ???
}

object MyStreamWriterImpl extends StreamWriterFactory {
  private val logger = LogManager.getLogger

  override def apply(conf: Configuration): StreamWriter = {
    logger.info("Building MyStreamWriterImpl")
    new MyStreamWriterImpl("destination")
  }
}
