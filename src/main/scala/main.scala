object PostConditions 
  opaque type Wrap[T] = T
  def result[T] (given r: Wrap[T]): T = r
  def [T] (x: T) ensuring (cond: (given Wrap[T]) => Boolean) : T = 
    assert(cond(given x))
    x
  

object Test
  import PostConditions.{result, ensuring}

  def main(args: Array[String]): Unit = 
    val x: String | Null = null
    List(1, 2, 3).sum.ensuring(result == 6)
