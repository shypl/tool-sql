package org.shypl.tool.sql

inline fun <E : Enum<E>> AddablePreparedStatement.addEnum(x: E?, mapper: (E) -> String) {
	setString(nextIndex(), x?.let(mapper))
}

inline fun <E> AddablePreparedStatement.addInClauses(list: Collection<E>, adder: AddablePreparedStatement.(E) -> Unit) {
	list.forEach { this.adder(it) }
}

inline fun <E> AddablePreparedStatement.addInClauses(list: Array<out E>, adder: AddablePreparedStatement.(E) -> Unit) {
	list.forEach { this.adder(it) }
}


fun AddablePreparedStatement.addInClauses(list: Array<Int>) {
	addInClauses(list, AddablePreparedStatement::addInt)
}

fun AddablePreparedStatement.addInClauses(list: Array<Long>) {
	addInClauses(list, AddablePreparedStatement::addLong)
}

fun AddablePreparedStatement.addInClauses(list: Array<String>) {
	addInClauses(list, AddablePreparedStatement::addString)
}


@JvmName("addInClausesInt")
fun AddablePreparedStatement.addInClauses(list: Collection<Int>) {
	addInClauses(list, AddablePreparedStatement::addInt)
}

@JvmName("addInClausesLong")
fun AddablePreparedStatement.addInClauses(list: Collection<Long>) {
	addInClauses(list, AddablePreparedStatement::addLong)
}

@JvmName("addInClausesString")
fun AddablePreparedStatement.addInClauses(list: Collection<String>) {
	addInClauses(list, AddablePreparedStatement::addString)
}