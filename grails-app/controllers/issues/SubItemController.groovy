package issues

import org.bson.types.ObjectId

class SubItemController {

    def index() { }

    def show() {}

    def create() {
        Itemized itemized = Itemized.get(params.id)
        LineItem lineItem = itemized.getLineItem(params.lineItemId)
        SubItem subItem = new SubItem()
        [itemized: itemized, lineItem: lineItem, subItem: subItem]
    }

    def save() {
        Itemized itemized = Itemized.get(params.id)
        LineItem lineItem = itemized.getLineItem(params.lineItemId)
        SubItem subItem = new SubItem()
        subItem.properties = params
        subItem.id = new ObjectId()
        lineItem.addToSubItems(subItem)
        if (itemized.save(flush: true)) {

        } else {

        }
        redirect(controller: 'Itemized', action: 'index')
    }

    def edit() {
        Itemized itemized = Itemized.get(params.id)
        LineItem lineItem = itemized.getLineItem(params.lineItemId)
        SubItem subItem = lineItem.getSubItem(params.subItemId)
        [itemized: itemized, lineItem: lineItem, subItem: subItem]
    }

    def update() {
        Itemized itemized = Itemized.get(params.id)
        LineItem lineItem = itemized.getLineItem(params.lineItemId)
        SubItem subItem = lineItem.getSubItem(params.subItemId)
        subItem.properties = params
        if (itemized.save(flush: true)) {

        } else {

        }
        redirect(controller: 'Itemized', action: 'index')
    }

    def delete() {
        Itemized itemized = Itemized.get(params.id)
        LineItem lineItem = itemized.getLineItem(params.lineItemId)
        SubItem subItem = lineItem.getSubItem(params.subItemId)
        lineItem.subitems.remove(subItem)
        itemized.save(flush: true)
        redirect(controller: 'Itemized', action: 'index')
    }
}
