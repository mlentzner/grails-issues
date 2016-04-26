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
        if (itemized.save()) {
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
        if (itemized.save()) {
            println "Itemized Updated: Name: ${itemized.name}"
        } else {
            println "Itemized (Name: ${itemized.name}) Not Updated"
        }
        redirect(action: 'index')
    }

    def delete() {
        Itemized itemized = Itemized.get(params.id)
        itemized.delete()
        redirect(action: 'index')
    }
}
