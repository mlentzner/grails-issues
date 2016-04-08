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

    LineItem getLineItem(id) {
        for (lineItem in lineItems) {
            if (lineItem.id == id) {
                return lineItem
            }
        }
        return null
    }

    def addLineItem(LineItem lineItem) {
        lineItems.add(lineItem)
    }

    def removeLineItem(LineItem lineItem) {
        lineItems.remove(lineItem)
    }
}
