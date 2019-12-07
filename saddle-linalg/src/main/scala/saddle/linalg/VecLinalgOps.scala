/**
  * Copyright (c) 2019 Saddle Development Team
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
package org.saddle.linalg

import org.saddle.Vec
import annotation.implicitNotFound

@implicitNotFound(msg = "${O} not found")
trait VecBinOp[O, Res] {
  def apply(a: Vec[Double], b: O): Res
}
class VecPimp(val self: Vec[Double]) {
  type B = Vec[Double]

  def linalg = this

  def vv(other: Vec[Double])(
      implicit op: VecBinOp[Vec[Double], Double]
  ): Double = op(self, other)

}