package issues

import org.bson.types.ObjectId

class LineItem {

    ObjectId id //Mongo Compatible ID Generation

    Date dateCreated
    Date lastUpdated

    static hasMany = [ subItems: SubItem ]

    static embedded = ['subItems']

    static constraints = {
    }

    SubItem getSubItem(String id) {
        for (subItem in subItems) {
            if (subItem.id.toString() == id) {
                return subItem
            }
        }
        return null
    }
}
