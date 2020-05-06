package subtask6

class FullBinaryTrees {

    // всевозможные сочетания 0 и 1 длиной n
    fun makeAllCombination(count: Int) : MutableList<String> {
        var n = count - 4
        var tree: MutableList<String> = mutableListOf("0","1")
        while (n > 0) {
            var root = tree
            tree = mutableListOf()
            for (elem in root) {
                var newElem = elem
                tree.add(newElem + "0")
                tree.add(newElem + "1")
            }
            n -= 1
        }
        return tree
    }

    // удаление деревьев с недостаточным кол-вом вершин
    fun removeTrees(tree: MutableList<String>, count: Int) : MutableList<String>
    {
        var n = (count-1)/2 - 1
        var root : MutableList<String> = mutableListOf()
        for (elem in tree) {
            val vertex = elem.chars().filter { ch: Int -> ch == '1'.toInt() }.count()
            if (vertex.compareTo(n) == 0) {
                var endNull = ""
                var ind = n
                while (ind > 0)
                {
                    endNull += '0'
                    ind -= 1
                }
                if (elem.indexOf(endNull)<=1) {
                    if ((elem[elem.length - 1] != '0') || (elem[elem.length - 2] != '0')) {
                        root.add(elem + '1')
                    }
                }
            }
        }
        return root
    }

    // преобразование полученных комбинаций 0 и 1 в бинарное дерево
    fun convertToTree(tree: MutableList<String>, count: Int) : String
    {
        var treeString = "["
        for (elem in tree) {
            var newTree = "[0,"
            for (i: Int in 0 .. elem.length - 1)
            {
                if (elem[elem.length - 1 - i] == '0')
                    newTree +=  "null,null,"
                else
                    newTree +=  "0,0,"
            }
            // убираем конечные вершины
            var lastVertex = newTree.substring(newTree.length-10, newTree.length-1)
            while (lastVertex == "null,null") {
                newTree = newTree.substring(0, newTree.length - 10)
                lastVertex = newTree.substring(newTree.length-10, newTree.length-1)
            }

            newTree = newTree.substring(0, newTree.length-1)
            newTree += "], "
            treeString += newTree + " "
        }
        treeString = treeString.substring(0, treeString.length-3)
        treeString += "]"
        return treeString
    }

    // TODO: Complete the following function
    fun stringForNodeCount(count: Int): String {
        // длч чётного n невозможно построить бинарное дерево
        if (count % 2 == 0)
            return "[]"
        if (count == 1)
            return "[[0]]"
        val treeList = makeAllCombination(count)
        var newTreeList = removeTrees(treeList, count)
        val res = convertToTree(newTreeList, count)
        return res
    }
}


fun main(args: Array<String>) {
    val fbt = FullBinaryTrees()
    val n = 7
    var treeList = fbt.makeAllCombination(n)
    var newTreeList = fbt.removeTrees(treeList, n)
    val res = fbt.convertToTree(newTreeList, n)
    print(res)
}
//print(res)
