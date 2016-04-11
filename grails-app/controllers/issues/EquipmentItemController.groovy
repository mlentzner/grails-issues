package issues

import org.bson.types.ObjectId

class EquipmentItemController {

    def index() { }

    def show() {}

    def create() {
        Itemized itemized = Itemized.get(params.id)
        EquipmentItem equipmentItem = new EquipmentItem()
        [itemized: itemized, equipmentItem: equipmentItem]
    }

    def save() {
        Itemized itemized = Itemized.get(params.id)
        EquipmentItem equipmentItem = new EquipmentItem()
        equipmentItem.properties = params
        equipmentItem.id = new ObjectId()
        itemized.addLineItem(equipmentItem)
        if (itemized.save(flush: true)) {

        } else {

        }
        redirect(controller: 'Itemized', action: 'index')
    }

    def edit() {
        println "Params: ${params}"
        Itemized itemized = Itemized.get(params.id)
        EquipmentItem equipmentItem = itemized.getLineItem(params.equipmentItemId)
        [itemized: itemized, equipmentItem: equipmentItem]
    }

    def update() {
        Itemized itemized = Itemized.get(params.id)
        EquipmentItem equipmentItem = itemized.getLineItem(params.equipmentItemId)
        equipmentItem.properties = params
        if (itemized.save(flush: true)) {

        } else {

        }
        redirect(controller: 'Itemized', action: 'index')
    }

    def delete() {
        Itemized itemized = Itemized.get(params.id)
        EquipmentItem equipmentItem = itemized.getLineItem(params.equipmentItemId)
        itemized.removeLineItem(equipmentItem)
        if (itemized.save(flush: true)) {

        } else {

        }
        redirect(controller: 'Itemized', action: 'index')
    }

}
