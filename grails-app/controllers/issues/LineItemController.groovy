package issues

import org.bson.types.ObjectId

class LineItemController {

    static responseFormats = ['json', 'xml']

    def index() {
        def lineItems = []
        Collection itemizeds = Itemized.findAll() {}

        for (itemized in itemizeds) {
            lineItems.addAll(itemized.lineItems)
        }

        [lineItems: lineItems]
    }

    def show() {
        Itemized itemized = Itemized.get(params.id)
        if (!itemized) { throw new IllegalStateException('Itemized DO could not be found') }

        LineItem lineItem = itemized.getLineItem(params.lineItemId)
        [lineItem: lineItem]
    }
}