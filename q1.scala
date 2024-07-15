@main def main(): Unit = 
    val products=getProductList()
    printProductList(products)
    val totalProducts = getTotalProducts(products)
    print(f"Total Products : $totalProducts")

def getProductList(products:List[String] = List()):List[String] = 
    print("Enter product name or done to stop: ")
    val input = scala.io.StdIn.readLine()
    input match {
        case "done" => products
        case _ => getProductList(products :+ input)
    }

def printProductList(products:List[String], position:Int = 1):Unit = 
    val productLen = getTotalProducts(products)
    productLen match{
        case 1 => printf("%d - %s\n", position, products.head)
        case _ => {
            printf("%d - %s\n", position, products.head)
            printProductList(products.tail, position + 1)
        }
    }

def getTotalProducts(products:List[String]):Int=
    products match{
        case Nil => 0
        case _ => 1 + getTotalProducts(products.tail) 
    }