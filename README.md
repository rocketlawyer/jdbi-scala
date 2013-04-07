JDBI-Scala
==========

Some handy classes for making [JDBI](http://jdbi.org) even nicer to use with Scala

Currently it allows you to:

* Bind case classes in SQL statements
* Bind simple scala.Option types to SQL statement arguments
* Return Options from SQL queries
* Use function literal syntax when running code in a DB transaction




Examples
--------



### Binding Case Classes

    import com.gilt.jdbi.BindCaseClass

    @SqlUpdate("""
      insert into doo_hickeys (id, label, widget_id)
      values (:dh.id, :dh.label, :dh.widgetId)
    """)
    def insert(@BindCaseClass("dh") dooHickey: DooHickey


### Binding Option types

In application setup code:

    import com.gilt.jdbi.args.OptionArgumentFactory
    db.registerArgumentFactory(OptionArgumentFactory)

In your DAO:

    @SqlUpdate("""
      insert into widgets (label, description)
      values (:label, :desc)
    """)
    def insert(@Bind("label") label: String, @Bind("desc") desc: Option[String])


Note that since ArgumentFactories are not recursive, your Option must
contain a type which is directly compatible with JDBC.


### Returning Options from queries

In application setup code:

    import com.gilt.jdbi.OptionContainerFactory
    db.registerContainerFactory(new OptionContainerFactory)

In your DAO:

    @SqlQuery("select * from doo_hickeys where key = :key")
    @SingleValueResult(classOf[DooHickey])
    def findByKey(@Bind("key") key: String): Option[DooHickey]


### Using function literals

    import com.gilt.jdbi.Conversions._

    db.inTransaction(
      (h: Handle, status: TransactionStatus) => {
        // transactional code
      }
    )
