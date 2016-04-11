package issues

import org.bson.types.ObjectId

class SubItem {

    ObjectId id //Mongo Compatible ID Generation

    String name

    Date dateCreated
    Date lastUpdated

    static constraints = {
    }
}
