package recfun

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
    def pascal(c: Int, r: Int): Int = if (c==0 || c == r) 1 else pascal(c-1, r-1) + pascal(c, r-1)
  
  /**
   * Exercise 2
   */
    def balance(chars: List[Char]): Boolean = balance_inner(chars, 0)

    def balance_inner(chars: List[Char], open: Int): Boolean = {
      if (chars.isEmpty) if (open == 0) true else false
      else if (chars.head == '(') balance_inner(chars.tail, open + 1)
      else if (chars.head == ')') if (open == 0) false else balance_inner(chars.tail, open - 1)
      else balance_inner(chars.tail, open)
    }
  
  /**
   * Exercise 3
   */
    def countChange(money: Int, coins: List[Int]): Int = {
      if (money == 0) 1
      else if (coins.isEmpty) 0
      else if (coins.head <= money) countChange(money - coins.head, coins) + countChange(money, coins.tail)
      else countChange(money, coins.tail)
    }
  }
