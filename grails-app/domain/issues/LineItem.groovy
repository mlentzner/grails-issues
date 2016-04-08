package issues

import org.bson.types.ObjectId

class LineItem {

    ObjectId id //Mongo Compatible ID Generation

    Date dateCreated
    Date lastUpdated

    static constraints = {
    }
}
