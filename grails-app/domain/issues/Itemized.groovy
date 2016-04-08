package issues

import org.bson.types.ObjectId

class Itemized {

    ObjectId id //Mongo Compatible ID Generation

    String name

    Date dateCreated
    Date lastUpdated

    static hasMany = [ lineItems: LineItem ]

    static embedded = ['lineItems']

    static constraints = {
    }
}
