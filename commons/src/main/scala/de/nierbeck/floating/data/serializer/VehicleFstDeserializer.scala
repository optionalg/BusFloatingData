/*
 * Copyright 2016 Achim Nierbeck
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

package de.nierbeck.floating.data.serializer

import java.util

import de.nierbeck.floating.data.domain.Vehicle
import org.apache.kafka.common.serialization.Deserializer
import org.nustaq.serialization.FSTConfiguration

object VehicleFstDeserializer {
  val fst = FSTConfiguration.createDefaultConfiguration()
}

class VehicleFstDeserializer() extends Deserializer[Vehicle] {
  import VehicleFstDeserializer._

  override def deserialize(topic: String, data: Array[Byte]): Vehicle = {
    fst.asObject(data).asInstanceOf[Vehicle]
  }

  override def configure(configs: util.Map[String, _], isKey: Boolean): Unit = {}

  override def close(): Unit = {}

}
