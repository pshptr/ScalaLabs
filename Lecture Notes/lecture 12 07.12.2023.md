## Лекция 07.12.2023

...

#### Изменим прогрмму для выбора 1000 случайных пикселей и вычисления среднего значения и стандартного отклонения.
  ```scala

	import java.awt.image.BufferedImage
	import java.io.File
	import java.imageio.ImageIO
	import scala.util.Random
	import org.apache.commons.math3.stat.descriptive.{DescriptiveStatistics, SummaryStatistics}
	
	object Main25 {
		def main(args:Array[String]): Unit = {
	 		val imagePath = "one.jpg"
	   		// Load image using ImageIO
	     		val image: BufferedImage = ImageIO.read(new File(imagePath))
	
	       		// Get the width and height of the image  // Читаем картинку в массив пикселей, после этого случайными образом отбираем 1000 пикселей. 
		 	val width = image.getWidth 		 
	   		val heigth = image.getHeight
	
	     		// Get the array of pixels from the image
	       		val pixels = Array.ofDim[Int](width * height)
		 	image.getRGB(0, 0, width, height, pixels, 0, width)
	   		val count = 1000
	     		val numbers List[Double]() // Тут случайно выбранные пиксели хранятся в списке
	       		val random = new Random()
			for(i <- 0 until count) {
	  			var j = random.nextInt(width * height)
	     			numbers = math.abs(pixels(j)) :: numbers // Номера пикселей, пиксель j мы будем добавлять в список numbers
			}
	  		
     			val stats1 = new DescriptiveStatistics() // Находим здесь среднее значение и стандартное отклонение  и дальше выводим
	    		numbers.foreach(stats.addValue) 	// здесь среднее значение и стандартное отклонение 
	      		val mean = stats1.getMean()		//
			val stdDev = math.sqrt(stats1.getStandartDeviation()) //
	
	  		println(s"Mean value: ${mean}") //  и дальше 
	    		println(s"Stdev: ${stdDev}")   // выводим
	      }
	}
  ```


Ключевая идея - чтобы распознать картинку будем сравнивать её с другой картинкой из базы данных, здесь из файла. Сравниваем среднее значение и стандартное отклонение. Выбираем картинку по максимальному устройству - используем для этого косинусную метрику, если косинус близок к 0, то картинки схожи. Для того чтобы это сделать нужно запомнить номера случайно выбранных пикселей. 

### Ключевая идея
  ```scala

	import java.awt.image.BufferedImage
	import java.io.File	
	import java.imageio.ImageIO
	import scala.util.Random
	import org.apache.commons.math3.stat.descriptive.{DescriptiveStatistics, SummaryStatistics}
	
	object Main25 {
		def main(args:Array[String]): Unit = {
	 		val imagePath = "one.jpg"
	   		// Load the image using ImageIO
	
	       		var image: BufferedImage = ImageIO.read(new File(imagePath))
			// Get the width and height of image
	  		val width = image.getWidth
	    		val height = image.getHeight
	      		// Get the array of pixels from the image
			val pixels = Array.ofDim[Int](width * height)
	     		image getRGB(0, 0, width, height, pixels, 0, width)
	       		val count = 1000
		     	val numbers List[Double]()
		       	val random = new Random()
	
	  		for(i <- 0 until count) {
	    			var j = random.nextInt(width * height)
	       			nomers = j :: nomers
		  		numbers = math.abs(pixels(j)) :: numbers
	     		}
	  
	     		val stats1 = new DescriptiveStatistics()
	       		numbers.foreach(stats1.addValue)
		 	val mean = stats1.getMean()
	   		val stdDev = math.sqrt(stats1.getStandartDeviaton())
	     		println(s"Mean value: ${mean}")
	       		printn(s"Stdev: ${StdDev}")
			val imagePath = "two.jpg"
	   		var image2: BufferedImage = ImageIO.read(new File(imagePath))
	     		val pixels2 = Array.ofDim[Int](width * height)
	       		image2.getRGB(0, 0, width, height, pixels2, 0, width)
	
	  		var numbers2 = List[Double]()
	    		for (i <- 0 until count) {
	      			numbers2 = math.abs(pixels2(nomers(i))) :: numbers2
		 	}
	     		
	       		val stats2 = new DescriptiveSatistics()
	      		numbers2.foreach(stats2.addValue)
			val mean2 = stats.getMean()
			val stdDev2 = math.sqrt(stats2.getStandartDeviation())
	 		println(s"Mean-2 value: ${mean2}") //  и дальше 
			println(s"Stdev-2: ${stdDev2}")   // выводим
		}
	}
  ```

Косинусная метрикамежду двумя векторами $X$ и $Y$ вычисляется по формулe 

$\cos (X, Y)=\frac{\sum_i x_i y_i}{\sqrt{\sum_i x_i^2 \cdot \sum_i y_i^2}}$

Чем ближе косинус к "1", тем больше значение меры сходства между векторами.
$X1$ - среднее значение, $X2$ - стандартное отклонение для одной картинки. $Y1$ и $Y2$ - это для второй картинки. Если косинус раен 1 получается одна и та жа картинка.
