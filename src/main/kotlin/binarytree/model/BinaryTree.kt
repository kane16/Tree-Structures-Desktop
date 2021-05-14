package binarytree.model

import common.model.Tree

data class BinaryTree(override var root: Node?) : Tree(root) {

    operator fun plus(value: Int): BinaryTree {
        val node: Node? = findNearestNode(value)
        if(node == null){
            println("Node added")
            root = Node(value, null, null)
        }else if(node.value == value) {
            println("Node already exists in tree")
        }else {
            println("Node added")
            if(value > node.value && node.rightChild == null){
                node.rightChild = Node(value, null, null)
            }else {
                node.leftChild = Node(value, null, null)
            }
        }
        return this
    }

    operator fun minus(value: Int): BinaryTree {
        val node: Node? = findNearestNode(value)
        if(node == null){
            println("Cannot remove, node not existing")
        }else {
            
            println("Removed node: ${value}")
        }
        return this
    }

    override fun toString(): String {
        return super.toString()
    }

}
