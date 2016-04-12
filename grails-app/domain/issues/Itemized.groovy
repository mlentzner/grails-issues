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

    LineItem getLineItem(String id) {
        for (lineItem in lineItems) {
            if (lineItem.id.toString() == id) {
                return lineItem
            }
        }
        return null
    }

    def addLineItem(LineItem lineItem) {
        if (!lineItems) { lineItems = [] }
        lineItems.add(lineItem)
    }

    def removeLineItem(LineItem lineItem) {
        lineItems.remove(lineItem)
    }
}
