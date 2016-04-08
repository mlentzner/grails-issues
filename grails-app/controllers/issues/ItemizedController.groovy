package issues

class ItemizedController {

    def index() {
        def itemizeds = Itemized.list()
        [itemizeds: itemizeds]
    }

    def show() {
        Itemized itemized = Itemized.get(params.id)
        [itemized: itemized]
    }

    def create() {
        Itemized itemized = new Itemized()
        [itemized: itemized]
    }

    def save()  {
        Itemized itemized = new Itemized()
        itemized.properties = params
        if (itemized.save(flush: true)) { //MongoDB Plugin issue #690 - remove flush:true and object is never created
            println "Itemized Saved: Name: ${itemized.name}"
        } else {
            println "Itemized (${itemized.name}) Not Saved"
        }
        redirect(action: 'index')
    }

    def edit() {
        Itemized itemized = Itemized.get(params.id)
        [itemized: itemized]
    }

    def update() {
        Itemized itemized = Itemized.get(params.id)
        itemized.properties = params
        if (itemized.save(flush: true)) { //MongoDB Plugin issue #690 - remove flush:true and object is never updated
            println "Itemized Updated: Name: ${itemized.name}"
        } else {
            println "Itemized (Name: ${itemized.name}) Not Updated"
        }
        redirect(action: 'index')
    }

    def delete() {
        Itemized itemized = Itemized.get(params.id)
        itemized.delete(flush: true) //MongoDB Plugin issue #690 - remove flush:true and object is never deleted
        redirect(action: 'index')
    }
}
