import binarytree.model.BinaryTree
import binarytree.model.Node
import common.model.Tree
import kotlin.test.Test
import kotlin.test.assertEquals

class TreeRepresentationTest {

    @Test
    fun testCorrectRepresentation() {
        assertEquals("2", Tree(Node(2, null, null)).toString())
        assertEquals("2[L1 R3]", Tree(Node(2, Node(1, null, null), Node(3, null, null))).toString())
        assertEquals("2[L1[L0] R3[L2 R7]]",
            Tree(Node(2,
                Node(1, Node(0, null, null), null),
                Node(3, Node(2, null, null), Node(7, null, null)))).toString())
    }

    @Test
    fun testAddNode() {
        val tree = BinaryTree(null)
        assertEquals("", tree.toString())
        tree + 4
        assertEquals("4", tree.toString())
        tree + 5
        assertEquals("4[R5]", tree.toString())
        tree + 3
        assertEquals("4[L3 R5]", tree.toString())
        tree + 1
        assertEquals("4[L3[L1] R5]", tree.toString())
    }

}