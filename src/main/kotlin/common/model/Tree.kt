package common.model

import binarytree.model.Node

open class Tree(open var root: Node?) {
    fun getSize(): Int {
        return getSize(root)
    }

    fun getSize(node: Node?): Int {
        return when(node) {
            null -> 0
            else -> 1 + getSize(node.leftChild) + getSize(node.rightChild)
        }
    }

    fun findNearestNode(node: Int): Node? {
        return findNearestNode(node, root)
    }

    private fun findNearestNode(node: Int, currentNode: Node?): Node? {
        return when {
            currentNode == null -> currentNode
            node > currentNode.value && currentNode.rightChild == null -> currentNode
            node < currentNode.value && currentNode.leftChild == null -> currentNode
            node > currentNode.value && currentNode.rightChild != null -> findNearestNode(node, currentNode.rightChild)
            node < currentNode.value && currentNode.leftChild != null -> findNearestNode(node, currentNode.leftChild)
            else -> currentNode
        }
    }

    private fun printSubTree(node: Node): String {
        return when {
            node.leftChild != null && node.rightChild != null -> "${node.value}[L${printSubTree(node.leftChild!!)} R${printSubTree(node.rightChild!!)}]"
            node.leftChild != null -> "${node.value}[L${printSubTree(node.leftChild!!)}]"
            node.rightChild != null -> "${node.value}[R${printSubTree(node.rightChild!!)}]"
            else -> "${node.value}"
        }
    }

    override fun toString(): String {
        return if(root != null){
            printSubTree(root!!)
        } else {
            ""
        }
    }

}
