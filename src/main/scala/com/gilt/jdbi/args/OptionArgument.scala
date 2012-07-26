package com.gilt.jdbi.args

import org.skife.jdbi.v2.StatementContext
import org.skife.jdbi.v2.tweak.{ Argument, ArgumentFactory }

/* Bind a Scala Option to a jdbi statement
 * Note: jdbi supports only one level of argument  binding.
 *    Your option must contain an SQL compatible type.
 */

class OptionArgument(option:Option[_]) extends Argument {
  import java.sql.PreparedStatement

  def apply(position:Int, statement:PreparedStatement, context:StatementContext) {
    import java.sql.Types
    option match {
      case Some(value) => statement.setObject(position, value)
      case None => statement.setNull(position, Types.OTHER)
    }
  }
}

object OptionArgumentFactory extends ArgumentFactory[Option[_]] {
  def accepts(expectedType:Class[_], value:Object, context:StatementContext) = value.isInstanceOf[Option[_]]

  def build(expectedType:Class[_], value:Option[_], context:StatementContext) = new OptionArgument(value)
}
