/*******************************************************************
 * See the NOTICE file distributed with this work for additional   *
 * information regarding Copyright ownership.  The author/authors  *
 * license this file to you under the terms of the Apache License, *
 * Version 2.0 (the "License"); you may not use this file except   *
 * in compliance with the License.  You may obtain a copy of the   *
 * License at:                                                     *
 *                                                                 *
 *     http://www.apache.org/licenses/LICENSE-2.0                  *
 *                                                                 *
 * Unless required by applicable law or agreed to in writing,      *
 * software distributed under the License is distributed on an     *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY          *
 * KIND, either express or implied.  See the License for the       *
 * specific language governing permissions and limitations         *
 * under the License.                                              *
 *******************************************************************/

package codes.reactive.scalatime

import scala.util.Try

/**
 * Created by arashid on 14/07/14.
 */
private[scalatime] abstract class LocalDateFactory {


  /** Creates a new [[LocalDate]] instance by querying the current system UTC clock
    * for the current date.
    *
    * @return  a new [[LocalDate]]
    */
  def apply(): LocalDate

  /** Creates a new [[LocalDate]] instance by querying the provided clock
    * for the current date.
    *
    * @return  a new [[LocalDate]]
    */
  def apply(clock: Clock): LocalDate

  /** Queries a [[Temporal]] to obtain an [[LocalDate]] (if available)
    *
    * @param from the temporal to query
    * @throws DateTimeException - if unable to convert to an [[LocalDate]]
    */
  def from(from: TemporalAccessor): Try[LocalDate]

  /** Creates a new [[LocalDate]] instance from a year, month and day. An exception will be thrown if the day is
    * not valid for the year and month.
    *
    * @param day the day to represent
    * @param month the month to represent
    * @param year the year to represent
    * @throws DateTimeException - if the value of any field is out of range or if the day-of-month is invalid for
    *                           the month-year.
    */

  def of(year: Int, month: Int, day: Int): LocalDate

  /** Creates a new [[LocalDate]] instance from a year, month and day. An exception will be thrown if the day is
    * not valid for the year and month.
    *
    * @param day the day to represent
    * @param month the month to represent
    * @param year the year to represent
    * @throws DateTimeException - if the value of any field is out of range or if the day-of-month is invalid for
    *                           the month-year.
    */
  def of(year: Int, month: Month, day: Int): LocalDate

  /** Creates a new [[LocalDate]] instance from valid ISO-8601 extended local date formatted text, otherwise
    * throws an exception.
    *
    * @param text the text to parse such as "2007-12-03"
    * @throws DateTimeException if the text cannot be successfully parsed as an [[LocalDate]]
    */
  def parse(text: String): LocalDate

  /** Creates a new [[LocalDate]] instance from valid text formatted according to the provided `formatter`, otherwise
    * throws an exception.
    *
    * @param text the text to parse
    * @throws DateTimeException if the text cannot be successfully parsed as an [[LocalDate]]
    */
  def parse(text: String, formatter: DateTimeFormatter): LocalDate

}
