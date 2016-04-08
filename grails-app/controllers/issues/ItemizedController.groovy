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
        if (itemized.save(flush: true)) { //Graeme Rocher MongoDB Plugin issue #690 - remove flush:true and object is never persisted
            println "Itemized Saved: Name: ${itemized.name}"
        } else {
            println "Itemized Not Saved"
        }
        redirect(action: 'index')
    }

    def edit() { }

    def update() { }

    def delete() { }
}
