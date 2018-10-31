package common

abstract class SortingSuite extends SolutionSuite {
  protected def sortMethod: Sorting

  private def testCase[A : Ordering](arr: Array[A], expect: Array[A]): Unit = {
    makeTest { sortMethod.sort(arr) should contain theSameElementsInOrderAs expect }
  }

  Seq(
    Array(1),
    Array(2, 1),
    Array(10, 1, -4),
    Array(10, 10, 10, 10),
    Array(10, 10, -4, -4),
    Array(4, 9, 0, 30, -10, 2, 0)
  ).foreach { arr =>
    testCase(arr, expect = arr.sorted)
  }
}
