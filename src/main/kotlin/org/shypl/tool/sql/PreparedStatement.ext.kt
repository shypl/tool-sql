package org.shypl.tool.sql

import java.sql.PreparedStatement
import java.sql.Timestamp
import java.time.LocalDateTime
import java.time.ZonedDateTime

fun PreparedStatement.setLocalDateTime(parameterIndex: Int, x: LocalDateTime?) {
	setTimestamp(parameterIndex, if (x == null) null else Timestamp.valueOf(x))
}

fun PreparedStatement.setZonedDateTime(parameterIndex: Int, x: ZonedDateTime?) {
	setLocalDateTime(parameterIndex, x?.toLocalDateTime())
}

fun PreparedStatement.setEnum(parameterIndex: Int, x: Enum<*>?) {
	setString(parameterIndex, x?.name)
}

inline fun <E : Enum<E>> PreparedStatement.setEnum(parameterIndex: Int, x: E?, mapper: (E) -> String) {
	setString(parameterIndex, x?.let(mapper))
}
