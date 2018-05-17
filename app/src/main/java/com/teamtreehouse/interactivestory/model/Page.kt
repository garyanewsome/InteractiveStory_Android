package com.teamtreehouse.interactivestory.model

class Page {
    var imageId: Int = 0
    var textId: Int = 0
    var choice1: Choice? = null
    var choice2: Choice? = null
    var isFinalPage = false

    constructor(imageId:Int, textId:Int) {
        this.imageId = imageId
        this.textId = textId
        this.isFinalPage = true
    }

    constructor(imageId:Int, textId:Int, choice1:Choice, choice2:Choice) {
        this.imageId = imageId
        this.textId = textId
        this.choice1 = choice1
        this.choice2 = choice2
    }
}