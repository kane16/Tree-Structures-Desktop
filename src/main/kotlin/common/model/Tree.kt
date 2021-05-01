package common.model

import binarytree.model.Node

open class Tree(open val root: Node?) {
    fun getSize(): Int {
        return getSize(root)
    }

    fun getSize(node: Node?): Int {
        return when(node) {
            null -> 0
            else -> 1 + getSize(node.leftChild) + getSize(node.rightChild)
        }
    }
}
